package com.codingdojo.NinjaGoldGame;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controller {
	
	@RequestMapping("/")
	public String gold(Model model,HttpSession session) {
		if(session.getAttribute("gold")!= null) {
		int myGold=(int) session.getAttribute("gold");
		ArrayList<String> myActivitie=new ArrayList<String>();
		myActivitie=(ArrayList<String>) session.getAttribute("activitie");
		model.addAttribute("myGold", myGold);
		model.addAttribute("myActivitie", myActivitie);}
		return "NINJA.jsp";
	}
	
	@RequestMapping(value = "/process_money", method = RequestMethod.POST)
	public String money( HttpSession session,@RequestParam(value = "which_form") String place) {
		ArrayList<String> activitie = new ArrayList<String>();
		if(session.getAttribute("gold")==null) {
		session.setAttribute("gold", 0);}
		if(session.getAttribute("activitie")==null) {
		session.setAttribute("activitie", activitie);}
		if(place.equals("farm")) {
			Random r = new Random();
			int low = 10;
			int high = 20;
			int result = r.nextInt(high-low) + low;
			int count=(int)session.getAttribute("gold");
			count+=result;
			session.setAttribute("gold", count);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date date = new Date(); 
			String myAction="You entered a farm and earned " + result + "gold ."+formatter.format(date) ;
			activitie=(ArrayList<String>) session.getAttribute("activitie");
			activitie.add(myAction);
		}
		else if(place.equals("cave")) {
			Random r = new Random();
			int low = 10;
			int high = 20;
			int result = r.nextInt(high-low) + low;
			int count=(int)session.getAttribute("gold");
			count+=result;
			session.setAttribute("gold", count);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date date = new Date(); 
			String myAction="You entered a cave and earned " + result + "gold ."+formatter.format(date) ;
			activitie=(ArrayList<String>) session.getAttribute("activitie");
			activitie.add(myAction);
		}
		else if(place.equals("house")) {
			Random r = new Random();
			int low = 10;
			int high = 20;
			int result = r.nextInt(high-low) + low;
			int count=(int)session.getAttribute("gold");
			count+=result;
			session.setAttribute("gold", count);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date date = new Date(); 
			String myAction="You entered a house and earned " + result + "gold ."+formatter.format(date) ;
			activitie=(ArrayList<String>) session.getAttribute("activitie");
			activitie.add(myAction);
		}
		else if(place.equals("casino")) {
			Random r = new Random();
			int low = -50;
			int high = 50;
			int result = r.nextInt(high-low) + low;
			int count=(int)session.getAttribute("gold");
			count+=result;
			session.setAttribute("gold", count);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date date = new Date(); 
		    if(result>0) {
			String myAction="You entered a casino and earned " + result + "gold ."+formatter.format(date) ;
			activitie=(ArrayList<String>) session.getAttribute("activitie");
			activitie.add(myAction);}
		    else {
		    	String myAction="You entered a casino and lost " + result + "gold ."+formatter.format(date) ;
		    	activitie=(ArrayList<String>) session.getAttribute("activitie");
		    	activitie.add(myAction);
		    }
		}
		return "redirect:/";
	}
}
