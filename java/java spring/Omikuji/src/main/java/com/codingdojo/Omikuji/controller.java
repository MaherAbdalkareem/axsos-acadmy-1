package com.codingdojo.Omikuji;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controller {
	@RequestMapping("/")
	public String show() {
		return "Home.jsp";
	
	}
	
	@RequestMapping(value="/send", method = RequestMethod.POST)
	public String save(HttpSession session,@RequestParam(value="myNumber") int num,
			@RequestParam(value="city") String city,@RequestParam(value="person") String person,
			@RequestParam(value="hoppy") String hoppy,@RequestParam(value="living") String living,
			@RequestParam(value="desc") String desc) {
		session.setAttribute("desc",  desc);
		session.setAttribute("living", living );
		session.setAttribute("person", person);
		session.setAttribute("hoppy", hoppy);
		session.setAttribute("city", city);
		session.setAttribute("myNumber", num);
		return "redirect:/display";
	}
	
	@RequestMapping("/display")
	public String shwo(Model model,HttpSession session) {
		model.addAttribute("desc", session.getAttribute("desc"));
		model.addAttribute("living", session.getAttribute("living"));
		model.addAttribute("person", session.getAttribute("person"));
		model.addAttribute("hoppy", session.getAttribute("hoppy"));
		model.addAttribute("city", session.getAttribute("city"));
		model.addAttribute("myNumber", session.getAttribute("myNumber"));
		return "display.jsp";
	}
}
