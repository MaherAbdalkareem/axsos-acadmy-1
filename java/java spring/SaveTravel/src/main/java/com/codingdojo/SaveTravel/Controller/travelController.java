package com.codingdojo.SaveTravel.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.SaveTravel.Travelservice.travelService;
import com.codingdojo.SaveTravel.model.Travel;

@Controller
public class travelController {
	private final travelService expenService ;
	
	public travelController(travelService expenService) {
		this.expenService = expenService;
	}

	@RequestMapping("/expenses")
	public String expense(@ModelAttribute("expense")Travel expense,Model model) {
		List<Travel> expenses= expenService.allExpense();
		model.addAttribute("expenses", expenses);
		return "Travel.jsp";
	}
	
	@RequestMapping(value = "/expenses" ,method = RequestMethod.POST)
	public String createExpense(@Valid @ModelAttribute("expense")Travel expense,BindingResult result) {
		if (result.hasErrors()) {
			return "Travel.jsp";
		}
		else {
			expenService.newExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	@RequestMapping("/edit/{id}")
	public String showEdit(@PathVariable("id") Long id,Model model) {
		Travel expense1 = expenService.findExpense(id);
		model.addAttribute("expense", expense1);
		return "edit.jsp";
	}
	@RequestMapping(value="/edit/{id}", method=RequestMethod.PUT)
	public String editExpnse(@PathVariable("id") Long id,@Valid @ModelAttribute("expense")Travel expense,BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			expenService.editExpense(expense,id);
			return "redirect:/expenses";
	}
 }
	@RequestMapping(value = "delete/{id}")
	public String deleteExpense(@PathVariable("id")Long id) {
		expenService.deleteExpense(id);
		return "redirect:/expenses";
	}
}
