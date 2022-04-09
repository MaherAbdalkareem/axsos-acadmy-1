package com.codingdojo.YogaCourse.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.YogaCourse.model.Course;

@Repository
public interface YogaRepository extends CrudRepository<Course, Long> {
	List<Course> findAll();
	
}
