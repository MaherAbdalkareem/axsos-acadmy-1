package com.codingdojo.SaveTravel.TravelRepositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.SaveTravel.model.Travel;

@Repository
public interface TravelRepositories extends CrudRepository<Travel, Long> {
	
	List<Travel> findAll();

}
