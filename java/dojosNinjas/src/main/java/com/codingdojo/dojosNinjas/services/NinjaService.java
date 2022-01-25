package com.codingdojo.dojosNinjas.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojosNinjas.models.Ninja;
import com.codingdojo.dojosNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository nRepo;
	
	public Ninja createNinja(Ninja ninja) {
		return this.nRepo.save(ninja);
	}
	public List<Ninja> getAllNinjas(){
		return this.nRepo.findAll();
	}
}
