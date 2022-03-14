package com.codingdojo.Counter;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {
	
	@RequestMapping("/")
	public String welcome(HttpSession session, Model model) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count",0);
		}
		else {
			Integer visiter=(Integer)session.getAttribute("count");
			visiter++;
			session.setAttribute("count", visiter);
			
		}
		return "welcome.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		int count= (int) session.getAttribute("count");
		model.addAttribute("myCount",count);
		return "counter.jsp";
	}
}
