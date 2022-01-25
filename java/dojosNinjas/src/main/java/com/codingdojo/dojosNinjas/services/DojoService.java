package com.codingdojo.dojosNinjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosNinjas.models.Dojo;
import com.codingdojo.dojosNinjas.repositories.DojoRepository;

@Service
public class DojoService {
	private DojoRepository dRepo;
	
	public DojoService(DojoRepository repo) {
		this.dRepo= repo;
	}
	//Get all
	public List<Dojo> getAllDojos(){
		return this.dRepo.findAll();
	}
	//Get one
	public Dojo getOneDojo(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	//Create
	public Dojo createDojo(Dojo newDojo) {
		return this.dRepo.save(newDojo);
	}
	//Update
	public Dojo updateDojo(Dojo dojo) {
		return this.dRepo.save(dojo);
	}
	//Delete
	public void deleteDojo(Long id) {
		this.dRepo.deleteById(id);
	}
}
