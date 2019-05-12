package com.car.controller;


import static com.car.ApiConstants.DATA;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.annotation.Login;
import com.car.common.utils.R;
import com.car.dto.ExerciseContentDTO;
import com.car.dto.LearnPageInfoDTO;
import com.car.exception.DAOException;
import com.car.form.ExerciseAnswerForm;
import com.car.form.UserExerciseAnswerForm;
import com.car.redis.ExerciseContentRedis;
import com.car.service.ChapterService;
import com.car.service.CourseService;
import com.car.service.ExerciseContentService;
import com.car.service.SectionService;
import com.car.service.UserCoursePlanService;
import com.car.service.UserExerciseAnswerService;
import com.car.vo.ChapterAndSectionVO;
import com.car.vo.ChapterVO;
import com.car.vo.CourseVO;
import com.car.vo.ExerciseContentVO;
import com.car.vo.SectionVO;
import com.car.vo.SubjectAndCourseVO;
import com.car.vo.UserCoursePlanVO;

import net.sf.json.JSONObject;

/**
 * 讲堂接口
 *
 * @author wind
 */
@RestController
@RequestMapping("/api/learn")
public class ApiLearnController {
	private static final Logger log = LoggerFactory.getLogger(ApiLearnController.class);

    @Autowired
    private CourseService courseService;
    @Autowired
    private ChapterService chapterService;
    @Autowired
    private SectionService sectionService;
    @Autowired
    private UserCoursePlanService userCoursePlanService;
    @Autowired
    private ExerciseContentService exerciseContentService;
    @Autowired
    private UserExerciseAnswerService userExerciseAnswerService;
    
    @Autowired
    private ExerciseContentRedis exerciseContentRedis;
    
    @Login
    @GetMapping("learnPageInfos")
	public R getHomePageInfo(@RequestParam("userId") long userId,
			@RequestParam("projectId") long projectId, 
			@RequestParam("categoryId") long categoryId) throws DAOException {
    	
    	if (userId == 0 || projectId == 0 || categoryId == 0) {
    		throw new DAOException("project or categoryId is null");
    	}
    	
    	LearnPageInfoDTO pageInfo = null;
    	try {
	    	// 视频课程
	    	List<CourseVO> lastViedoCourses = courseService.getLastCoursesByProjectAndCategory(userId, projectId, categoryId, 1);
	    	
	    	// 题库
	    	List<CourseVO> lastExercises = courseService.getLastCoursesByProjectAndCategory(userId, projectId, categoryId, 2);
	    	
	    	// 每日一练
	    	List<CourseVO> dailyExercises = courseService.getLastCoursesByProjectAndCategory(userId, projectId, -1, 4);
	    	
	    	pageInfo = new LearnPageInfoDTO(lastViedoCourses, lastExercises, dailyExercises);
    	} catch (DAOException e) {
    		log.error("get CoursePageInfoDTO occur errors . ", e);
    		return R.error();
    	}
		
    	return R.ok().put(DATA, pageInfo);
    }
    
    @Login
    @GetMapping("subjectCourses")
	public R getSubjectCourses(@RequestParam("userId") long userId,
			@RequestParam("projectId") long projectId,
			@RequestParam("categoryId") long categoryId,
			@RequestParam("courseType") int courseType) throws DAOException {
    	
    	if (userId == 0 || projectId == 0 || categoryId == 0) {
    		throw new DAOException("userId or projectId or categoryId is null");
    	}
    	
    	List<SubjectAndCourseVO> subjectCourses = new ArrayList<>();
    	try {
    		
	    	
    		List<CourseVO> courses = courseService.getAllCoursesByCondition(userId, projectId, categoryId, courseType);
    		if (CollectionUtils.isEmpty(courses)) {
    			return R.ok().put(DATA, subjectCourses);
    		}
    		
    		// 组学科-课程
    		List<CourseVO> tmpCourses = null;
    		Map<String, List<CourseVO>> courseMap = new LinkedHashMap<>();
    		for (CourseVO course : courses) {
    			String key = course.getSubjectId() + "_" + course.getSubjectName();
    			if (courseMap.containsKey(key)) {
    				courseMap.get(key).add(course);
    			} else {
    				tmpCourses = new ArrayList<>();
    				tmpCourses.add(course);
    				courseMap.put(key, tmpCourses);
    			}
    		}
    		
    		subjectCourses = getSubjectAndCourses(courseMap);
    		
    	} catch (DAOException e) {
    		log.error("get exerciseContents occur errors . ", e);
    		return R.error();
    	}
		
    	return R.ok().put(DATA, subjectCourses);
    }
    
    @Login
    @GetMapping("dailyExercises")
	public R getDailyExercises(@RequestParam("userId") long userId,
			@RequestParam("projectId") long projectId,
			@RequestParam("pageId") int pageId) throws DAOException {
    	
    	if (userId == 0 || projectId == 0) {
    		throw new DAOException("userId or projectId is null");
    	}
    	
    	List<SectionVO> dailyExercises = new ArrayList<>();
    	try {
	    	
//    		dailyExercise = courseService.getDailyExercisesByCondition(userId, projectId, 4, pageId);
    		
    		dailyExercises = sectionService.getSectionsByCondition(projectId, 4, pageId);
    		
    	} catch (DAOException e) {
    		log.error("get dailyExercises occur errors . ", e);
    		return R.error();
    	}
		
    	return R.ok().put(DATA, dailyExercises);
    }
    
    @Deprecated
    @Login
    @GetMapping("exerciseDetail")
	public R getExerciseDetail(@RequestParam("userId") long userId,
			@RequestParam("courseId") long courseId) throws DAOException {
    	if (userId == 0 || courseId == 0) {
    		throw new DAOException("userId or courseId is null");
    	}
    	
    	ChapterAndSectionVO chapterAndSectionVO = new ChapterAndSectionVO();
//    	List<ChapterAndSectionVO> chapterAndSections = new LinkedList<ChapterAndSectionVO>();
    	try {
    		
			// 学习进度.
			List<Long> readSectionIds = new ArrayList<>();
			List<UserCoursePlanVO> planVOs = userCoursePlanService.getUserCoursePlansByCondition(userId, courseId);
//			learnCourseVO.setUserCoursePlans(planVOs);
			
			if (!planVOs.isEmpty()) { 
				for (UserCoursePlanVO plan : planVOs) {
					readSectionIds.add(plan.getSectionId());
				}
			}
			
			// 章-节
			chapterAndSectionVO = getChapterAndSectionInfo(courseId, chapterAndSectionVO, readSectionIds);
	    	
    	} catch (DAOException e) {
    		log.error("get chapterAndSections occur errors . ", e);
    		return R.error();
    	}
		
    	return R.ok().put(DATA, chapterAndSectionVO);
    }
    
    @Login
    @GetMapping("/v2/exerciseDetail")
	public R getExerciseDetail2(@RequestParam("userId") long userId,
			@RequestParam("courseId") long courseId) throws DAOException {
    	if (userId == 0 || courseId == 0) {
    		throw new DAOException("userId or courseId is null");
    	}
    	
    	List<ChapterAndSectionVO> chapterAndSections = new LinkedList<ChapterAndSectionVO>();
    	try {
    		
			// 学习进度.
			List<Long> readSectionIds = new ArrayList<>();
			List<UserCoursePlanVO> planVOs = userCoursePlanService.getUserCoursePlansByCondition(userId, courseId);
//			learnCourseVO.setUserCoursePlans(planVOs);
			
			if (!planVOs.isEmpty()) { 
				for (UserCoursePlanVO plan : planVOs) {
					readSectionIds.add(plan.getSectionId());
				}
			}
			
			// 章-节
			chapterAndSections = getChapterAndSectionInfo(courseId, readSectionIds);
	    	
    	} catch (DAOException e) {
    		log.error("get chapterAndSections occur errors . ", e);
    		return R.error();
    	}
		
    	return R.ok().put(DATA, chapterAndSections);
    }

    @Deprecated
    @Login
    @GetMapping("exerciseContents")
	public R getHomePageInfo(@RequestParam("sectionId") long sectionId) throws DAOException {
    	
    	if (sectionId == 0) {
    		throw new DAOException("sectionId is null");
    	}
    	
    	List<ExerciseContentVO> exerciseContents = new ArrayList<>();
    	try {
	    	
    		exerciseContents = exerciseContentService.getExerciseContentsBySection(sectionId);
    		
    	} catch (DAOException e) {
    		log.error("get exerciseContents occur errors . ", e);
    		return R.error();
    	}
    	
    	return R.ok().put(DATA, exerciseContents);
    }
    
    @Login
    @GetMapping("/v2/exerciseContents")
	public R getHomePageInfo2(@RequestParam("sectionId") long sectionId) throws DAOException {
    	
    	if (sectionId == 0) {
    		throw new DAOException("sectionId is null");
    	}
    	
    	List<ExerciseContentDTO> contents = new ArrayList<>();
    	try {
	    	
//    		List<ExerciseContentVO> exerciseContents = exerciseContentService.getExerciseContentsBySection(sectionId);
//    		
//    		// 组题型-内容
//    		List<ExerciseContentVO> tempContents = null;
//    		Map<String, List<ExerciseContentVO>> contentMap = new HashMap<>();
//    		for (ExerciseContentVO content : exerciseContents) {
//    			String key = content.getExerciseTypeId() + "_" + 
//    					content.getExerciseType() + "_" +
//    					content.getExerciseName() + "_" +
//    					content.getDescription();
//    			if (contentMap.containsKey(key)) {
//    				contentMap.get(key).add(content);
//    			} else {
//    				tempContents = new ArrayList<>();
//    				tempContents.add(content);
//    				contentMap.put(key, tempContents);
//    			}
//    		}
//    		
//    		contents = getExerciseAndContents(contentMap);
    		
    		contents = exerciseContentRedis.getExerciseContents(sectionId, exerciseContentService);
    		
    	} catch (DAOException e) {
    		log.error("get exerciseContents occur errors . ", e);
    		return R.error();
    	}
		
    	return R.ok().put(DATA, contents);
    }
    
//    public static void main(String[] args) {
//    	UserExerciseAnswerForm form = new UserExerciseAnswerForm();
//    	List<ExerciseAnswerForm> ef = new ArrayList();
//    	form.setScore(Double.valueOf("20"));
//    	form.setSpendTime(10);
//    	ef.add(new ExerciseAnswerForm(Long.valueOf("1"), "A"));
//    	ef.add(new ExerciseAnswerForm(Long.valueOf("2"), "C"));
//    	form.setExerciseAnswers(ef);
//    	System.out.println(JSONObject.fromObject(form));
//    	
//	}
    
    @Login
    @PostMapping("saveUserExerciseAnswer")
    public R saveUserExerciseAnswer(@ModelAttribute UserExerciseAnswerForm userExerciseAnswerForm) throws DAOException {
    	
    	if (userExerciseAnswerForm == null) {
    		throw new DAOException("userExerciseAnswerForm is null");
    	}
    	
    	long userId = userExerciseAnswerForm.getUserId();
    	if (userId == 0) {
    		throw new DAOException("usreId is null");
    	}

		try {
			
			userExerciseAnswerService.saveUserExerciseAnswer(userExerciseAnswerForm);		
			
		} catch (DAOException e) {
			log.error("save userExerciseAnswer occur error ", e);
			return R.error();
		}

        return R.ok();
    }
    
    private static List<SubjectAndCourseVO> getSubjectAndCourses(Map<String, List<CourseVO>> courseMap) {
		Set<Entry<String, List<CourseVO>>> entrySet = courseMap.entrySet();
		
		SubjectAndCourseVO subAndCourVO = null;
		List<SubjectAndCourseVO> courses = new LinkedList<SubjectAndCourseVO>();
		for (Entry<String, List<CourseVO>> entry : entrySet) {
			
			String key = entry.getKey();
			
			long subjectId = Long.valueOf(key.substring(0, key.indexOf("_")));
			
			String subjectName = key.substring(key.indexOf("_") + 1);
			
			subAndCourVO = new SubjectAndCourseVO(subjectId, subjectName, entry.getValue());
			courses.add(subAndCourVO);
			subAndCourVO = null;
			
		}
		
		return courses;
	}
    
    private static List<ExerciseContentDTO> getExerciseAndContents(Map<String, List<ExerciseContentVO>> contentMap) {
		Set<Entry<String, List<ExerciseContentVO>>> entrySet = contentMap.entrySet();
		
		ExerciseContentDTO exerciseContent = null;
		List<ExerciseContentDTO> contents = new LinkedList<>();
		for (Entry<String, List<ExerciseContentVO>> entry : entrySet) {
			
			String key = entry.getKey();
			
			long exerciseTypeId = 0;
			int exerciseType = 0;
			String exerciseName = "";
			String description = "";
			String[] exerciseTypes = key.split("_");
			if (exerciseTypes != null && exerciseTypes.length > 0) {
				exerciseTypeId = Long.parseLong(exerciseTypes[0]);
				exerciseType = Integer.parseInt(exerciseTypes[1]);
				exerciseName = exerciseTypes[2];
				description = exerciseTypes[3];
			}
			
			exerciseContent = new ExerciseContentDTO(exerciseTypeId, exerciseType, exerciseName, 
					description, entry.getValue());
			contents.add(exerciseContent);
			exerciseContent = null;
			
		}
		
		return contents;
	}
    
    private ChapterAndSectionVO getChapterAndSectionInfo(long courseId, ChapterAndSectionVO chapterAndSectionVO,
			 List<Long> readSectionIds) throws DAOException {
    	
    	// 章.
		Map<Long, ChapterVO> chapterMap = new LinkedHashMap<Long, ChapterVO>();
		List<ChapterVO> chapterVOs = chapterService.getChaptersByCourse(courseId);
		if (!chapterVOs.isEmpty()) {
			for (ChapterVO vo : chapterVOs) {
				chapterMap.put(vo.getChapterId(), vo);
			}
		}
    	
		// 节
		long chapterId = 0;
		List<SectionVO> tempVOs = null;
		Map<Long, List<SectionVO>> sectionMap = new LinkedHashMap<Long, List<SectionVO>>();
		List<SectionVO> sectionVOs = sectionService.getSectionsByCourse(courseId);
		if (!sectionVOs.isEmpty()) {
			for (SectionVO vo : sectionVOs) {
				if (readSectionIds.contains(vo.getSectionId())) {
					vo.setReadStatus(1);
				}
				
				chapterId = vo.getChapterId();
				if (sectionMap.containsKey(chapterId)) {
					sectionMap.get(chapterId).add(vo);
				} else {
					tempVOs = new LinkedList<SectionVO>();
					tempVOs.add(vo);
					sectionMap.put(chapterId, tempVOs);
				}
			}
		}
		
		// 数组.
//			ChapterAndSectionVO chapterAndSectionVO = null;
		if (!chapterMap.isEmpty()) {
			Set<Entry<Long, ChapterVO>> entrySet = chapterMap.entrySet();
			for (Entry<Long, ChapterVO> entry : entrySet) {
				ChapterVO chapter = entry.getValue();
				chapterAndSectionVO = new ChapterAndSectionVO(chapter.getChapterName(), sectionMap.get(entry.getKey()));
//					chapterAndSections.add(chapterAndSectionVO);
			}
		}
		return chapterAndSectionVO;
	}
    
    private List<ChapterAndSectionVO> getChapterAndSectionInfo(long courseId,
			 List<Long> readSectionIds) throws DAOException {
    	
    	List<ChapterAndSectionVO> chapterAndSections = new ArrayList<>();
   	
    	// 章.
		Map<Long, ChapterVO> chapterMap = new LinkedHashMap<Long, ChapterVO>();
		List<ChapterVO> chapterVOs = chapterService.getChaptersByCourse(courseId);
		if (!chapterVOs.isEmpty()) {
			for (ChapterVO vo : chapterVOs) {
				chapterMap.put(vo.getChapterId(), vo);
			}
		}
   	
		// 节
		long chapterId = 0;
		List<SectionVO> tempVOs = null;
		Map<Long, List<SectionVO>> sectionMap = new LinkedHashMap<Long, List<SectionVO>>();
		List<SectionVO> sectionVOs = sectionService.getSectionsByCourse(courseId);
		if (!sectionVOs.isEmpty()) {
			for (SectionVO vo : sectionVOs) {
				if (readSectionIds.contains(vo.getSectionId())) {
					vo.setReadStatus(1);
				}
				
				chapterId = vo.getChapterId();
				if (sectionMap.containsKey(chapterId)) {
					sectionMap.get(chapterId).add(vo);
				} else {
					tempVOs = new LinkedList<SectionVO>();
					tempVOs.add(vo);
					sectionMap.put(chapterId, tempVOs);
				}
			}
		}
		
		// 数组.
			ChapterAndSectionVO chapterAndSectionVO = null;
		if (!chapterMap.isEmpty()) {
			Set<Entry<Long, ChapterVO>> entrySet = chapterMap.entrySet();
			for (Entry<Long, ChapterVO> entry : entrySet) {
				ChapterVO chapter = entry.getValue();
				chapterAndSectionVO = new ChapterAndSectionVO(chapter.getChapterName(), sectionMap.get(entry.getKey()));
					chapterAndSections.add(chapterAndSectionVO);
			}
		}
		return chapterAndSections;
	}

}
