package com.libsys.Maurilib.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libsys.Maurilib.model.Utilisateur;
import com.libsys.Maurilib.repository.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{
	
	@Autowired
	private UtilisateurRepository userRepository;

	@Override
	public List<Utilisateur> getAllUtilisateur() {
		
		return userRepository.findAll();
	}

	@Override
	public void ajoutUtilisateur(Utilisateur user) {

		this.userRepository.save(user);
		
	}

	@Override
	public Utilisateur getUtilisateurById(long id) {
		Optional<Utilisateur> optional = userRepository.findById(id);
		Utilisateur user = null;
		if(optional.isPresent()) {
			user =optional.get();
		}else {
			throw new RuntimeException("Utilisateur non trouve");
		}
		return user;
	}

	@Override
	public void SupprimerUtilisateurById(long id) {

		this.userRepository.deleteById(id);
		
	}
	
	

}
