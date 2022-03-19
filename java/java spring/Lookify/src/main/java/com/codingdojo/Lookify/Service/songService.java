package com.codingdojo.Lookify.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.Lookify.Repository.songRepository;
import com.codingdojo.Lookify.models.song;

@Service
public class songService {
	private final songRepository songRepo;

	public songService(songRepository songRepo) {
		this.songRepo = songRepo;
	}
	//find all song
	public List<song> findSong(){
		return songRepo.findAll();
	}
	//crate new song 
	public song crateSong(song mySong) {
		return songRepo.save(mySong);
	}
	
	//delete song
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}
	
	//top ten
	public List<song> topSong(){
		List<song> topSongs=songRepo.findTop10ByOrderByRatingDesc();
		return topSongs;
	}
	
	//search 
	public List<song> searchSong(String name) {
		List<song> mySong= songRepo.findByArtistContaining(name);
			return mySong;
	}
	//find by id
	public Optional<song> findMySong(Long id) {
		Optional<song> mySong= songRepo.findById(id);
		if(mySong.isPresent()) {
			return mySong;
		}
		else {
			return null;
		}
	}
}
