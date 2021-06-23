package com.libsys.Maurilib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libsys.Maurilib.model.Utilisateur;
import com.libsys.Maurilib.service.UtilisateurService;

@CrossOrigin(origins = "http://localhost:4200",maxAge=3600)
@RestController
@RequestMapping("/lib/")
public class UtilisateurController {
	 
	@Autowired
	private UtilisateurService userService;
	
	@GetMapping("/users")
	public List<Utilisateur> getAllUtilisateur() {
		
		return userService.getAllUtilisateur();
	}
	
	//ajout du utilisateur
	@PostMapping("/user")
	public Utilisateur addUser(@RequestBody Utilisateur user) throws Exception{
		
		String tempEmail = user.getEmail();
		if(tempEmail !=null && !"".equals(tempEmail)) {
			Utilisateur tempuser = userService.findByEmail(tempEmail);
			
			if(tempuser !=null) {
				throw new  Exception("L'utilisateur "+tempEmail+" existe deja");
			}
		}
		user.setStatut("Active");
		return userService.addUser(user);
	}
	@PostMapping("/login")
	public boolean Login(@RequestBody Utilisateur user) {

        String tempEmail= user.getEmail();
        String mdp = user.getCode();
        Utilisateur tempUser = null;
        
        if("admin@gmail.com".equals(tempEmail) && "1234".equals(mdp)) {

        	return true;
        }
        
        if(tempEmail !=null && mdp !=null) {
        	tempUser=userService.findByEmailAndPassword(tempEmail,mdp);
	    	if(tempUser==null) {
	    		return false;
	    	}else return true;
        }
		return false;
        
     }
	
	
	//connexion
	@PostMapping("/connexion")
	public Utilisateur Connexion(@RequestBody Utilisateur user) throws Exception {

        String tempEmail= user.getEmail();
        String mdp = user.getCode();
        Utilisateur tempUser = null;
        
        if("admin@gmail.com".equals(tempEmail) && "1234".equals(mdp)) {
        	Utilisateur utilisateur=new Utilisateur();
        	utilisateur.setEmail(tempEmail);
        	utilisateur.setCode(mdp);
        	utilisateur.setStatut("Active");
        	return utilisateur;
        }
        
        if(tempEmail !=null && mdp !=null) {
        	tempUser=userService.findByEmailAndPassword(tempEmail,mdp);
        }
        
    	if(tempUser==null) {
    		throw new Exception("Email ou mot de passe incorrect");
    	}
       
        return tempUser;
        }
	
	//chercher un utilisateur par id
	@GetMapping("/find/{id}")
	public ResponseEntity<Utilisateur> getUser(@PathVariable long id) throws Exception {
		
		Utilisateur user =userService.getUtilisateurById(id);
		if(user!=null) {
			return ResponseEntity.ok(user);
		}else{
			 throw new Exception("l'utilisateur n'existe pas");
		}	
	}
	
	//chercher un utilisateur par nom ou email ou telephoen
	@GetMapping("/findUser/{cle}")
	public List<Utilisateur> chercherUser(@PathVariable String cle) {
		
		return userService.findUser(cle);
	}
	
	//modifier un utilisateur
	@PutMapping("/user/{id}")
	public ResponseEntity<Utilisateur> updateUser(@PathVariable long id,@RequestBody Utilisateur userdetail) throws Exception{
		
		Utilisateur user =userService.getUtilisateurById(id);
		if(user!=null) {
			
			if(userdetail.getCode() != null) {
				user.setCode(userdetail.getCode());
			}
			
			user.setNom(userdetail.getNom());
			user.setEmail(userdetail.getEmail());
			user.setTelephone(userdetail.getTelephone());
			user.setDomicile(userdetail.getDomicile());
			Utilisateur userUpdated =userService.addUser(user);
			
			return ResponseEntity.ok(userUpdated);
		}else{
			 throw new Exception("l'utilisateur n'existe pas");
		}
	}	
	
	//activer utilisateur
	@PutMapping("/active/{id}")
	public ResponseEntity<Utilisateur> Activer(@PathVariable long id) throws Exception{
		
		Utilisateur user =userService.getUtilisateurById(id);
		if(user!=null) {
			user.setStatut("Active");
			
			Utilisateur userUpdated =userService.addUser(user);
			return ResponseEntity.ok(userUpdated);
		}else{
			 throw new Exception("l'utilisateur n'existe pas");
		}
	}	
	
	//suspendre un utilisateur
	@PutMapping("/suspendre/{id}")
	public ResponseEntity<Utilisateur> Suspendre(@PathVariable long id) throws Exception{
		
		Utilisateur user =userService.getUtilisateurById(id);
		if(user!=null) {
			user.setStatut("Suspendu");
			
			Utilisateur userUpdated =userService.addUser(user);
			return ResponseEntity.ok(userUpdated);
		}else{
			 throw new Exception("l'utilisateur n'existe pas");
		}
	}
	
}

	
