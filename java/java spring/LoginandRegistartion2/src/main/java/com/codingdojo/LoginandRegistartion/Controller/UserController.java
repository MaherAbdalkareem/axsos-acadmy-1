package com.codingdojo.LoginandRegistartion.Controller;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.LoginandRegistartion.Service.UserService;
import com.codingdojo.LoginandRegistartion.model.LoginUser;
import com.codingdojo.LoginandRegistartion.model.User;


@Controller
public class UserController {
private final UserService userService;

public UserController(UserService userService) {
	this.userService = userService;
}

@GetMapping("/")
public String showForm(Model model) {
	model.addAttribute("newUser",new User());
	model.addAttribute("newLogin",new LoginUser());
	return "loginandregistration.jsp";
}
@PostMapping("/registration")
public String creatUser(@Valid @ModelAttribute("newUser") User user,BindingResult result,Model model,HttpSession session) {
	userService.register(user, result);
	if (result.hasErrors()) {
		model.addAttribute("newLogin",new LoginUser());
		return "loginandregistration.jsp";
	}
	else {
		session.setAttribute("user_id", user.getId());
		return "redirect:/home";
	}
}
@PostMapping("/login")
public String login(@Valid@ModelAttribute("newLogin") LoginUser newLogin,BindingResult result,Model model,HttpSession session) {
	User user =userService.login(newLogin, result);
	
	if(result.hasErrors()) {
		model.addAttribute("newUser",new User());
		return "loginandregistration.jsp";
	}
	else {
		session.setAttribute("user_id", user.getId());
		return "redirect:/home";
	}
	
}

@GetMapping("/home")
public String home(Model model,HttpSession session) {
	Long userId = (Long)session.getAttribute("user_id");
	Optional<User> possibleUser = userService.findUser(userId);
	if(!possibleUser.isPresent()) {
		return "redirect:/";
	}
	User thisUser = possibleUser.get();
	model.addAttribute("thisUser", thisUser);
	return "welcome.jsp";
}
@GetMapping("/logout")
public String logout(HttpSession session) {
	session.invalidate();
	return "redirect:/";
}
}