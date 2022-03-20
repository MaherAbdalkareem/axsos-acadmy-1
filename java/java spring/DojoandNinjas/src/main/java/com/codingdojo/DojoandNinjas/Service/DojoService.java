package com.codingdojo.DojoandNinjas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.DojoandNinjas.Repository.DojoRepository;
import com.codingdojo.DojoandNinjas.models.Dojo;

@Service
public class DojoService {
	
	private final DojoRepository dojoRepo;

	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	//create dojo
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	//All dojos
	public List<Dojo> allDojo(){
		return dojoRepo.findAll();
	}
	//find by id 
	public Dojo findDojo(Long id){
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}

	
}
