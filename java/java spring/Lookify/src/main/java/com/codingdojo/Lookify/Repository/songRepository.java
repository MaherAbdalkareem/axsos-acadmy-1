package com.codingdojo.Lookify.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Lookify.models.song;

@Repository
public interface songRepository extends CrudRepository<song, Long>{
	
	List<song> findAll();
	List<song> findTop10ByOrderByRatingDesc();
	List<song> findByArtistContaining(String search);
	
}
