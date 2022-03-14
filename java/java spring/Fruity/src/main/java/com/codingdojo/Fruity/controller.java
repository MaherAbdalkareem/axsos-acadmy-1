package com.codingdojo.Fruity;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {
	@RequestMapping("/")
	public String fruity(Model model) {
		ArrayList<item> fruits =new ArrayList<item>();
		fruits.add(new item("Kiwi", 1.5));
        fruits.add(new item("Mango", 2.0));
        fruits.add(new item("Goji Berries", 4.0));
        fruits.add(new item("Guava", .75));
        model.addAttribute("myFruits", fruits);
        return "Fruity.jsp";
	}

}
