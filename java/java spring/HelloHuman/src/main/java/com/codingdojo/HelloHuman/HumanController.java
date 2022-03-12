package com.codingdojo.HelloHuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HumanController {
	
	@RequestMapping("")
	public String hello(@RequestParam(value ="name", required=false) String myName ,@RequestParam(value ="last_name", required=false) String lastName) {
		
		if(myName == null) {
		return "Hello Human";
		}
		
		else if(lastName == null) {
			return "Hello " + myName;}
			else {
				return "hello "+myName+lastName;
			}
		}
	
}


