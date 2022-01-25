package com.codingdojo.dojoSurveyTwo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.dojoSurveyTwo.models.Survey;

@Controller
public class surveyController {

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/survey")
	public String survey(@RequestParam(value="name")String name, 
			@RequestParam(value="location")String location, 
			@RequestParam(value="language")String language,
			@RequestParam(value="comment", required=false)String comment, Model userModel) {
		userModel.addAttribute("name", name);
		userModel.addAttribute("location", location);
		userModel.addAttribute("language",language);
		userModel.addAttribute("comment",comment);
		return "survey.jsp";
	}
}
