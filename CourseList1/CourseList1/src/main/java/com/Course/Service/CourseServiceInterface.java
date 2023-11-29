package com.Course.Service;




import java.util.List;

import com.Course.Entity.CourseDetails;
import com.Course.Exception.CourseNotFound;

public interface CourseServiceInterface {
        public String addCourse(CourseDetails cd);
        public String deleteCourse(int courseId) throws CourseNotFound;
        public List<CourseDetails> viewAllCourses();
        public CourseDetails viewCourse(int courseTitle)throws CourseNotFound;
        public List<CourseDetails> SortByPrice(int max,int min);
}
