package com.libsys.Maurilib.service;

import java.util.List;

import com.libsys.Maurilib.model.Utilisateur;

public interface UtilisateurService {
	
	List<Utilisateur> getAllUtilisateur();
	void ajoutUtilisateur(Utilisateur user);
	Utilisateur getUtilisateurById(long id);
	void SupprimerUtilisateurById(long id);
}
