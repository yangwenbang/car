package com.car.dto;

import java.io.Serializable;
import java.util.List;

import com.car.vo.AdvertisementVO;
import com.car.vo.CategoryVO;
import com.car.vo.CourseVO;
import com.car.vo.NewMsgVO;

public class LearnPageInfoDTO implements Serializable {

	private static final long serialVersionUID = -5636596232225893088L;

	private List<CourseVO> lastViedoCourses;
	private List<CourseVO> lastExercises;
	private List<CourseVO> dailyExercises;
	
	public LearnPageInfoDTO() {}
	
	public LearnPageInfoDTO(List<CourseVO> lastViedoCourses, List<CourseVO> lastExercises,
			List<CourseVO> dailyExercises) {
		super();
		this.lastViedoCourses = lastViedoCourses;
		this.lastExercises = lastExercises;
		this.dailyExercises = dailyExercises;
	}



	public List<CourseVO> getLastViedoCourses() {
		return lastViedoCourses;
	}

	public void setLastViedoCourses(List<CourseVO> lastViedoCourses) {
		this.lastViedoCourses = lastViedoCourses;
	}

	public List<CourseVO> getLastExercises() {
		return lastExercises;
	}

	public void setLastExercises(List<CourseVO> lastExercises) {
		this.lastExercises = lastExercises;
	}

	public List<CourseVO> getDailyExercises() {
		return dailyExercises;
	}

	public void setDailyExercises(List<CourseVO> dailyExercises) {
		this.dailyExercises = dailyExercises;
	}

}
