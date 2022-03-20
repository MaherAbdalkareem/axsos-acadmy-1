package com.codingdojo.DojoandNinjas.Controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.DojoandNinjas.Service.DojoService;
import com.codingdojo.DojoandNinjas.models.Dojo;

@Controller
public class DojoController {
	private final DojoService dojoService;
	
	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	@RequestMapping("/dojos/new")
	public String createDojo(@ModelAttribute("dojo")Dojo dojo){
		return "dojo.jsp";
	}
	@RequestMapping(value = "/new/dojo",method = RequestMethod.POST)
	public String newDojo(@Valid @ModelAttribute("dojo")Dojo dojo,BindingResult result) {
		if (result.hasErrors()) {
            return "dojo.jsp";
        } else {
		dojoService.createDojo(dojo);
		return "redirect:/dojos/new";}
	}
	@RequestMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id")Long id,Model model) {
	Dojo myDojo=dojoService.findDojo(id);
		model.addAttribute("myDojo", myDojo);
		return "showdojo.jsp";
	}
}
