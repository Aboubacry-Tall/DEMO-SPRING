package com.libsys.Maurilib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libsys.Maurilib.model.Buy;
import com.libsys.Maurilib.repository.BuyReposetory;

@RestController
@RequestMapping("/lib/")
@CrossOrigin(origins = "http://localhost:4200")
public class BuyController {
	@Autowired
	private BuyReposetory buyRepo;
	
	@PostMapping("/buy")
	public void buy(@RequestBody Buy buy) {
		buyRepo.save(buy);
	}
	
	@GetMapping("/buys")
	public List<Buy> buys() {
		return buyRepo.findAll();
	}
}