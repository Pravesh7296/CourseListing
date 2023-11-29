package com.Course.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Course.Entity.CourseDetails;


@Repository
public interface CourseRepo extends JpaRepository<CourseDetails,Integer>{

}
