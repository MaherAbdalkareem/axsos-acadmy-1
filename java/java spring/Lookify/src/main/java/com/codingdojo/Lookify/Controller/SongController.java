package com.codingdojo.Lookify.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.Lookify.Service.songService;
import com.codingdojo.Lookify.models.song;

@Controller
public class SongController {
	private final songService songServ;
	
	
	public SongController(songService songServ) {
		this.songServ = songServ;
	}

	@RequestMapping("/")
	public String welcome() {
		return "welcome.jsp";
	}
	@RequestMapping("/dashbord")
	public String dispaly(Model model) {
		List<song> allSongs= songServ.findSong();
		model.addAttribute("allSongs", allSongs);
		return "dashbord.jsp";
	}
	
	@RequestMapping(value = "/search",method = RequestMethod.POST)
	public String searchSong(@RequestParam(value = "search")String name) {
		List<song> mySong= songServ.searchSong(name);
		if(mySong.size()>0) {
			String arti=mySong.get(0).getArtist();
			return "redirect:/search/"+arti;
		}
		else {
			return "redirect:/dashbord";
		}
	}
	@RequestMapping("/search/{name}")
	public String artistSong(@PathVariable("name")String name,Model model) {
		List<song> mySong=songServ.searchSong(name);
		model.addAttribute("mySong", mySong);
		return "search.jsp";
	}
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song")song song) {
		return "newsong.jsp";
	}
	@RequestMapping(value = "/new",method = RequestMethod.POST)
	public String creatSong(@Valid @ModelAttribute("song")song song, BindingResult result) {
		 if (result.hasErrors()) {
	            return "newsong.jsp";
	        } else {
		songServ.crateSong(song);
		return "redirect:/dashbord";
	}
	}
	@RequestMapping("/search/topten")
	public String topSong(Model model) {
		List<song> songs=songServ.topSong();
		model.addAttribute("songs", songs);
		return "topten.jsp";
	}
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public String deleteSong(@PathVariable("id")Long id) {
		songServ.deleteSong(id);
		return "redirect:/dashbord";
	}
	@RequestMapping("songs/{id}")
	public String detailSong(@PathVariable("id")Long id,Model model) {
		Optional<song> mySong1=songServ.findMySong(id);
		song mySong=mySong1.get();
		model.addAttribute("mySong", mySong);
		return "details.jsp";
	}
}
