package com.libsys.Maurilib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libsys.Maurilib.model.Favoris;
import com.libsys.Maurilib.repository.FavorisReposetory;

@RestController
@RequestMapping("/lib/")
@CrossOrigin(origins = "http://localhost:4200")
public class FavorisController {
	
	@Autowired
	private FavorisReposetory favorisRepo;
	
	@PostMapping("/favoris")
	public void favoris(@RequestBody Favoris favoris) {
		favorisRepo.save(favoris);
	}
	
	@GetMapping("/favorisList")
	public List<Favoris> getFavoris(){
		return favorisRepo.findAll();
	}
	
	@DeleteMapping("/defavoris/{id}")
	public void defavoris(@PathVariable Long id) {
		Favoris favoris = favorisRepo.findById(id).orElseThrow();
		favorisRepo.delete(favoris);
		System.out.println(id);
	}

}
