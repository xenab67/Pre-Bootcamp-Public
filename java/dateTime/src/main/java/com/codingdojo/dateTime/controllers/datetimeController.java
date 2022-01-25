package com.codingdojo.dateTime.controllers;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class datetimeController {

	@RequestMapping("/")
	public String index() {
		Date thisDate= new Date();
		SimpleDateFormat dateForm= new SimpleDateFormat("EEEE, 'the' dd 'of', MMMM, YYYY");
		System.out.println(dateForm.format(thisDate));
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date() {
		return"date.jsp";
	}
	
	@RequestMapping("/time")
	public String time() {
		return "time.jsp";
	}
}
