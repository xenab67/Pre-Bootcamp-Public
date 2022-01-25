package com.codingdojo.routing.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dojo")
public class DojoController {
	@RequestMapping("")
	public String index() {
		return "The dojo is awesome!";
	}
	@RequestMapping("/burbank")
	public String dojo() {
		return "Burbank Dojo is located in Southern California";
	}
	@RequestMapping("san-jose")
	public String san() {
		return "SJ Dojo is the headquarters.";
	}
}
