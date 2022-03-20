package com.codingdojo.DojoandNinjas.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.DojoandNinjas.Service.DojoService;
import com.codingdojo.DojoandNinjas.Service.NinjaService;
import com.codingdojo.DojoandNinjas.models.Dojo;
import com.codingdojo.DojoandNinjas.models.Ninja;

@Controller
public class NinjaController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	public NinjaController(NinjaService ninjaService,DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService =dojoService;
	}
	@RequestMapping("/ninjas/new")
	public String createNinja(@ModelAttribute("ninja")Ninja ninja,Model model) {
		List<Dojo> dojos=dojoService.allDojo();
		model.addAttribute("dojos", dojos);
		return "ninjas.jsp";
	}
	@RequestMapping(value="/new/ninja" , method = RequestMethod.POST)
	public String newNinja(@Valid @ModelAttribute("ninja")Ninja ninja,BindingResult result) {
		if (result.hasErrors()) {
            return "ninjas.jsp";
        } else {
		ninjaService.createNinja(ninja);
		return "redirect:/ninjas/new";}
	}
}
