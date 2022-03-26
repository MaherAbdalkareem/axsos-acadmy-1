package com.codingdojo.ProjectManager.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.ProjectManager.Service.ProjectService;
import com.codingdojo.ProjectManager.Service.UserService;
import com.codingdojo.ProjectManager.model.Project;
import com.codingdojo.ProjectManager.model.User;


@Controller
public class ProjectController {
	@Autowired
	UserService userService;
	@Autowired
	ProjectService projectService;
	@GetMapping("/dashboord")
	public String showProject(HttpSession session,Model model) {
		Long user_Id=(Long) session.getAttribute("user_id");
		User user= userService.findUser(user_Id);
		List<Project> allProjects=projectService.findByUser(user);
		model.addAttribute("user", user);
		model.addAttribute("projects", allProjects);
		return "projects.jsp";
	}
	@GetMapping("/projects/new")
	public String createProject(@ModelAttribute("newProject")Project project) {
		return "newproject.jsp";
	}
	@PostMapping("/new/project")
	public String createProject(@Valid @ModelAttribute("newProject")Project project,BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			return "newproject.jsp";
		}
		else {
		Long user_Id=(Long) session.getAttribute("user_id");
		User user= userService.findUser(user_Id);
		user.getMyProjects().add(project);
		project.setUser(user);
		projectService.saveProject(project);
		return "redirect:/dashboord";}
	}
	@GetMapping("projects/{id}")
	public String detalis(@PathVariable("id")Long id,Model model) {
		Project project=projectService.findProject(id);
		model.addAttribute("project", project);
		return "details.jsp";
		}
	@GetMapping("/edit/{id}")
	public String showEditProject(@PathVariable("id")Long id,Model model) {
		Project project= projectService.findProject(id);
		model.addAttribute("project", project);
		return "editproject.jsp";
	}
	@PostMapping("/edit/project/{id}")
	public String editProject(@Valid @ModelAttribute("project")Project project,BindingResult result,@PathVariable("id")Long id) {
		Project myProject=projectService.findProject(id);
		myProject.setDate(project.getDate());
		myProject.setDescription(project.getDescription());
		myProject.setTitle(project.getTitle());
		projectService.saveProject(myProject);
		return "redirect:/dashboord";
	}
	@GetMapping("/join/{id}")
	public String joinProject(@PathVariable("id")Long id,HttpSession session) {
		Project project= projectService.findProject(id);
		Long user_Id=(Long) session.getAttribute("user_id");
		User user= userService.findUser(user_Id);
		user.getMyProjects().add(project);
		userService.saveUser(user);
		return "redirect:/dashboord";
		
	}
	@GetMapping("/leave/{id}")
	public String leaveProject(@PathVariable("id")Long id,HttpSession session) {
		Project project= projectService.findProject(id);
		Long user_Id=(Long) session.getAttribute("user_id");
		User user= userService.findUser(user_Id);
		user.getMyProjects().remove(project);
		userService.saveUser(user);
		return "redirect:/dashboord";
		
	}
//	@RequestMapping("/projects/{id}/tasks")
//	public String taskProject(@PathVariable("id")Long id,@ModelAttribute("newTask")Tasks task,HttpSession session,Model model) {
//		Project project= projectService.findProject(id);
//		Long user_Id=(Long) session.getAttribute("user_id");
//		User user= userService.findUser(user_Id);
//		model.addAttribute("project", project);
//		model.addAttribute("user", user);
//		return "task.jsp";
//	}
}
