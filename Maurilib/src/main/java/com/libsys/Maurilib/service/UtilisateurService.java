package com.libsys.Maurilib.service;

import java.util.List;

import com.libsys.Maurilib.model.Utilisateur;

public interface UtilisateurService {
	
	List<Utilisateur> getAllUtilisateur();
	Utilisateur addUser(Utilisateur user);
	Utilisateur getUtilisateurById(long id);
	void SupprimerUtilisateurById(long id);
	Utilisateur validateEmail(String email);
	Utilisateur validateEmailAndPassword(String email,String password);
}
