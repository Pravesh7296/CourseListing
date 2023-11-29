package com.Course.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Course.Entity.CourseDetails;
import com.Course.Exception.CourseNotFound;
import com.Course.Service.CourseServiceImpl;

@RestController("/Courses")
public class CourseController {
    @Autowired
    private CourseServiceImpl courseService;
	
    @PostMapping("/addCourse")
	public ResponseEntity<String> addCourse(@RequestBody CourseDetails cd){
		String str = courseService.addCourse(cd);
		return new ResponseEntity<String>(str,HttpStatus.ACCEPTED);
	}
    
    @GetMapping("/getCourse/{id}")
	public ResponseEntity<CourseDetails> getCourse(@PathVariable int id) throws CourseNotFound{
		CourseDetails cd = courseService.viewCourse(id);
		return new ResponseEntity<CourseDetails>(cd,HttpStatus.FOUND);
	}
    @GetMapping("/viewAllCourse")
	public ResponseEntity<List<CourseDetails>> viewAllCourse(){
		List<CourseDetails> cd = courseService.viewAllCourses();
		return new ResponseEntity<List<CourseDetails>>(cd,HttpStatus.FOUND);
	}
    @GetMapping("/SortByPrice/{max}/{min}")
	public ResponseEntity<List<CourseDetails>> SortByPrice(@PathVariable int max , @PathVariable int min){
		List<CourseDetails> cd = courseService.SortByPrice(max, min);
		return new ResponseEntity<List<CourseDetails>>(cd,HttpStatus.FOUND);
	}
    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id) throws CourseNotFound{
		String str = courseService.deleteCourse(id);
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}
    
}
