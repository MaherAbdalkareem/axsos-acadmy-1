package com.codingdojo.YogaCourse.Controller;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

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

import com.codingdojo.YogaCourse.Service.UserService;
import com.codingdojo.YogaCourse.Service.YogaService;
import com.codingdojo.YogaCourse.model.Course;
import com.codingdojo.YogaCourse.model.User;

@Controller
public class YogaController {
	@Autowired
	UserService userService;
	@Autowired
	YogaService yogaService;
	
	@GetMapping("/classes")
	public String home(Model model,HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Optional<User> possibleUser = userService.findUser(userId);
		if(!possibleUser.isPresent()) {
			return "redirect:/";
		}
		User thisUser = possibleUser.get();
		List<Course> allCourses=yogaService.findAllCourse();
		model.addAttribute("courses", allCourses);
		model.addAttribute("thisUser", thisUser);
		return "classes.jsp";
	}
	@GetMapping("/classes/new")
	public String newCourse(@ModelAttribute("course")Course course) {
		return "newcourse.jsp";
	}
	@PostMapping("/new/course")
	public String addCourse(@Valid @ModelAttribute("course")Course course,BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			return "newcourse.jsp";
		}
		else {
		Long userId = (Long)session.getAttribute("user_id");
		Optional<User> possibleUser = userService.findUser(userId);
		if(!possibleUser.isPresent()) {
			return "redirect:/";
		}
		User thisUser = possibleUser.get();
		course.setUser(thisUser);
		yogaService.saveCourse(course);
		return "redirect:/classes";
	}
	}
	@GetMapping("/classes/{id}/edit")
	public String showEdit(Model model,HttpSession session,@PathVariable("id")Long id) {
		Course course=yogaService.findCourse(id);
		model.addAttribute("course", course);
		return "edit.jsp";
	}
	@PostMapping("/edit/{id}")
	public String editCourse(@Valid @ModelAttribute("course")Course course,BindingResult result,@PathVariable("id")Long id) {
		if(result.hasErrors()) {
			return "newcourse.jsp";
		}
		else {
		Course myCourse=yogaService.findCourse(id);
		myCourse.setDay(course.getDay());
		myCourse.setDescription(course.getDescription());
		myCourse.setPrice(course.getPrice());
		myCourse.setUserName(course.getUserName());
		yogaService.saveCourse(myCourse);
		return "redirect:/classes";
	}}
	@GetMapping("/classes/delete/{id}")
	public String deleteCourse(@PathVariable("id")Long id) {
		yogaService.deleteCourse(id);
		return "redirect:/classes";
	}
	@GetMapping("/classes/{id}")
	public String detalis(@PathVariable("id")Long id,Model model) {
		Course course=yogaService.findCourse(id);
		model.addAttribute("course", course);
		return "details.jsp";
	}
}
