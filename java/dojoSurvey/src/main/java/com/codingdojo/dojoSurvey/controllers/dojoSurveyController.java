package com.codingdojo.dojoSurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class dojoSurveyController {
	
	@RequestMapping("/")
	public String index() {
		return "hello";
	}
	
}
