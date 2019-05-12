package com.car.redis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.car.common.utils.RedisApiKeys;
import com.car.common.utils.RedisUtils;
import com.car.dto.ExerciseContentDTO;
import com.car.exception.DAOException;
import com.car.service.ExerciseContentService;
import com.car.vo.ExerciseContentVO;

@Component
public class ExerciseContentRedis {
	
	private static final Logger log = LoggerFactory.getLogger(ExerciseContentRedis.class);

	@Autowired
	private RedisUtils redisUtils;
	
	private Lock lock = new ReentrantLock();
	
	public List<ExerciseContentDTO> getExerciseContents(long sectionId, ExerciseContentService exerciseContentService) throws DAOException {
		List<ExerciseContentDTO> exerciseContents = new ArrayList<>();
		
		String key = RedisApiKeys.getExerciseContentKey(sectionId);
		
		String exerciseContentJson = redisUtils.get(key);
		
		if (StringUtils.isNotEmpty(exerciseContentJson)) {
			log.info("get data from cache1-------");

			exerciseContents = JSONObject.parseArray(exerciseContentJson, ExerciseContentDTO.class);
			
			return exerciseContents;
					
		}
		
		lock.lock();
		
		try {
			
//			exerciseContentJson = redisUtils.get(key);
			
			exerciseContents = redisUtils.getList(key, ExerciseContentDTO.class);
			
			if (CollectionUtils.isNotEmpty(exerciseContents)) {
				log.info("get data from cache2-------");
				
//				exerciseContents = JSONObject.parseArray(exerciseContentJson, ExerciseContentDTO.class);
				
				return exerciseContents;
						
			}
			log.info("get data from db-------");
			
			List<ExerciseContentVO> exerciseContentVOs = exerciseContentService.getExerciseContentsBySection(sectionId);
    		
    		// 组题型-内容
    		List<ExerciseContentVO> tempContents = null;
    		Map<String, List<ExerciseContentVO>> contentMap = new HashMap<>();
    		for (ExerciseContentVO content : exerciseContentVOs) {
    			String contentKey = content.getExerciseTypeId() + "_" + 
    					content.getExerciseType() + "_" +
    					content.getExerciseName() + "_" +
    					content.getDescription();
    			if (contentMap.containsKey(contentKey)) {
    				contentMap.get(contentKey).add(content);
    			} else {
    				tempContents = new ArrayList<>();
    				tempContents.add(content);
    				contentMap.put(contentKey, tempContents);
    			}
    		}
    		
    		exerciseContents = getExerciseAndContents(contentMap);
			
			if (CollectionUtils.isNotEmpty(exerciseContents)) {
				redisUtils.set(key, exerciseContents);
			}
		} finally {
			
			lock.unlock();
			
		}
		
		return exerciseContents;
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

}
