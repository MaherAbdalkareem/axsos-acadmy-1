package com.codingdojo.DisplayDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {
	@RequestMapping("/")
	public String display() {
		return "main.jsp";
	}
	
	@RequestMapping("/date")
	public String date() {
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		LocalDateTime myDateObj = LocalDateTime.now(); 
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm");
		String formattedDate = myDateObj.format(myFormatObj);
		model.addAttribute("time", formattedDate);
		return "time.jsp";
	}
}
