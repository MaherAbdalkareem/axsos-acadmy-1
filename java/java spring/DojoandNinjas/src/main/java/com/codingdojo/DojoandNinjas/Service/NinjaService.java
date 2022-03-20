package com.codingdojo.DojoandNinjas.Service;

import org.springframework.stereotype.Service;

import com.codingdojo.DojoandNinjas.Repository.DojoRepository;
import com.codingdojo.DojoandNinjas.Repository.NinjaRepository;
import com.codingdojo.DojoandNinjas.models.Ninja;

@Service
public class NinjaService {
	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;
	public NinjaService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	//create ninja
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
}
