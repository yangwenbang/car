package com.car.dto;

import java.io.Serializable;
import java.util.List;

import com.car.vo.AdvertisementVO;
import com.car.vo.CategoryVO;
import com.car.vo.CourseVO;
import com.car.vo.NewMsgVO;

public class HomePageInfoDTO implements Serializable {

	private static final long serialVersionUID = -5636596232225893088L;

	private List<AdvertisementVO> advertisements;
	private List<NewMsgVO> newMsgs;
	private List<CourseVO> bestViedoCourses;
	private List<CourseVO> bestPublicCourses;
	private List<CourseVO> bestExercises;
	
	public HomePageInfoDTO() {}

	public HomePageInfoDTO(List<AdvertisementVO> advertisements, List<NewMsgVO> newMsgs,
			List<CourseVO> bestViedoCourses, List<CourseVO> bestPublicCourses,
			List<CourseVO> bestExercises) {
		this.advertisements = advertisements;
		this.newMsgs = newMsgs;
		this.bestViedoCourses = bestViedoCourses;
		this.bestPublicCourses = bestPublicCourses;
		this.bestExercises = bestExercises;
	}

	public List<AdvertisementVO> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(List<AdvertisementVO> advertisements) {
		this.advertisements = advertisements;
	}

	public List<NewMsgVO> getNewMsgs() {
		return newMsgs;
	}

	public void setNewMsgs(List<NewMsgVO> newMsgs) {
		this.newMsgs = newMsgs;
	}

	public List<CourseVO> getBestViedoCourses() {
		return bestViedoCourses;
	}

	public void setBestViedoCourses(List<CourseVO> bestViedoCourses) {
		this.bestViedoCourses = bestViedoCourses;
	}

	public List<CourseVO> getBestPublicCourses() {
		return bestPublicCourses;
	}

	public void setBestPublicCourses(List<CourseVO> bestPublicCourses) {
		this.bestPublicCourses = bestPublicCourses;
	}

	public List<CourseVO> getBestExercises() {
		return bestExercises;
	}

	public void setBestExercises(List<CourseVO> bestExercises) {
		this.bestExercises = bestExercises;
	}
}
