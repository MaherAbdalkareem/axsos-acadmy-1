package com.codingdojo.YogaCourse.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.YogaCourse.Repository.YogaRepository;
import com.codingdojo.YogaCourse.model.Course;

@Service
public class YogaService {
	@Autowired
	YogaRepository yogaRepository;
	//find all course
	public List<Course> findAllCourse(){
		return yogaRepository.findAll();
	}
	//save course
	public Course saveCourse(Course course) {
		return yogaRepository.save(course);
	}
	//find by id
	public Course findCourse(Long id) {
		Optional<Course> course=yogaRepository.findById(id);
		if(course.isPresent()) {
			return course.get();
		}
		else {return null;}
	}
	//delete
	public void deleteCourse(Long id) {
		yogaRepository.deleteById(id);
	}
}
