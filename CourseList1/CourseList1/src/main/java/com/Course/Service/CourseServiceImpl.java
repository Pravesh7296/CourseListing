package com.Course.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Course.Entity.CourseDetails;
import com.Course.Exception.CourseNotFound;
import com.Course.Repository.CourseRepo;

@Service
public class CourseServiceImpl implements CourseServiceInterface{
   
   @Autowired(required=true)
  private  CourseRepo courseRepo;

@Override
public String addCourse(CourseDetails cd) {
	courseRepo.save(cd);
	return "Course Added Successfully"; 
}

@Override
public String deleteCourse(int courseId) throws CourseNotFound {
Optional<CourseDetails>	 op = courseRepo.findById(courseId);
if(op.get()!=null) {
	courseRepo.delete(op.get());
	return "Course Deleted Successfully";
}else {
	throw new CourseNotFound("Course Not Found !");
}
	
}

@Override
public List<CourseDetails> viewAllCourses() {
	
	return courseRepo.findAll();
}

@Override
public CourseDetails viewCourse(int CourseId) throws CourseNotFound {
	Optional<CourseDetails> cd = courseRepo.findById(CourseId);
	if(cd.get()!=null) {
		return cd.get();
	}else {
		throw new CourseNotFound("Course Not Found !");
	}
	
}

@Override
public List<CourseDetails> SortByPrice(int max, int min) {
	
	return courseRepo.findAll().stream().filter(t->t.getPrice()<=max && t.getPrice()>=min).toList();
}

	

}
