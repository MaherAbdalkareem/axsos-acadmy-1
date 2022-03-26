package com.codingdojo.ProjectManager.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.ProjectManager.Repository.ProjectRepository;
import com.codingdojo.ProjectManager.model.Project;
import com.codingdojo.ProjectManager.model.User;

@Service
public class ProjectService {
	@Autowired
	ProjectRepository projectRepository;
	
	//find all projects
	public List<Project> allProject(){
		return projectRepository.findAll();
	}
	//save project
	public Project saveProject(Project project) {
		return projectRepository.save(project);
	}
	//find by id
	public Project findProject(Long id) {
		Optional <Project> optionalProject=projectRepository.findById(id);
		if(optionalProject.isPresent()) {
			return optionalProject.get();
		}
		else {return null;
		}
	}
	// find by user
	public List<Project> findByUser(User user){
		return projectRepository.findByMyUsersNotContains(user);
	}
}
