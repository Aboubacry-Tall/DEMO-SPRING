package com.libsys.Maurilib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.libsys.Maurilib.model.Utilisateur;
import com.libsys.Maurilib.repository.UtilisateurRepository;
import com.libsys.Maurilib.service.UtilisateurService;

@Controller
public class UtilisateurController {
	@Autowired
	private UtilisateurService userService;
	@Autowired
	private UtilisateurRepository userRepository;
	
	@GetMapping("/Gestion_users")
	public String HomePage(Model model) {
		
		model.addAttribute("listUtilisateur", userService.getAllUtilisateur());
		return "utilisateurs";
	}
	
	@GetMapping("/UtilisateurForm")
	public String UtilisateurForm(Model model) {
		
		Utilisateur user = new Utilisateur();
		model.addAttribute("user", user);
		return "inscription";
	}
	
	@PostMapping("/ajoutUtilisateur")
	public String ajoutUtilisateur(@ModelAttribute("user") Utilisateur user) {
		
		userService.ajoutUtilisateur(user);
		return "redirect:/Gestion_users";
	}
	
	@GetMapping("/UpdateForm/{id}")
	public String UpdateUtilisateur(@PathVariable (value ="id") long id,Model model) {
		
		Utilisateur user =userService.getUtilisateurById(id);
		
		model.addAttribute("user", user);
		return "update_user";
	}
	
	@GetMapping("/SupprimeUtilisateur/{id}")
	public String SupprimeUtilisateur(@PathVariable (value = "id") long id)
	{
		this.userService.SupprimerUtilisateurById(id);
		return "redirect:/Gestion_users";
	}
	
	@GetMapping("/login")
	public String connexion(Model model) {
		Utilisateur user = new Utilisateur();
		model.addAttribute("user", user);
		return "connexion";
	}
	
	@PostMapping("/connexion")
	public String Connexion(@ModelAttribute("user") Utilisateur user,Model model) {

        String email_f = user.getEmail();
        String mdp = user.getCode();
        if("admin@gmail.com".equals(email_f) && "admin1234".equals(mdp)) {
        	return "redirect:/admin";
        }else {
        	Utilisateur utilisateur =null;
        	try {
        		utilisateur = userRepository.findByEmail(email_f);
        		String code =utilisateur.getCode();
        		if(code.equals(mdp)) {
        			return "redirect:/";
        		}
        		
        	}catch (Exception e){
        		
        	}
    	String resultat ="email ou mot de passe incorrect";
        System.out.println(resultat);
        model.addAttribute("resultat", "email ou mot de passe incorrect");
        return "connexion";
        }
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	@GetMapping("/admin_index")
	public String index() {
		return "indexadmin";
	}

	
}
