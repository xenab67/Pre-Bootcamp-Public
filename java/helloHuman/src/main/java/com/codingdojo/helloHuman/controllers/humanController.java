package com.codingdojo.helloHuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class humanController {

	@RequestMapping("/")
	public String index(@RequestParam(value="name", required=false, defaultValue="Human") String name, Model model) {
		model.addAttribute("name", name);
		System.out.println(name);
		return "index.jsp";
	}
}
