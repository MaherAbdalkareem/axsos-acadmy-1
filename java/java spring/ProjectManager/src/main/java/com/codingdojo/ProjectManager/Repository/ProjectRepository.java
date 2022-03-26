package com.codingdojo.ProjectManager.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ProjectManager.model.Project;
import com.codingdojo.ProjectManager.model.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
	
	List<Project> findAll();
	List<Project> findByMyUsersNotContains(User user);
}
