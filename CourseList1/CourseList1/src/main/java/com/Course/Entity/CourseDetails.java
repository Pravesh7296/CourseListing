package com.Course.Entity;

import java.util.List;


import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data

@AllArgsConstructor
 
public class CourseDetails {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int CourseId ;
	
	private String Title;
	
	private String ImageUrl;
	
	private int price;

	public CourseDetails() {
		super();
	}
	
	
	
}
