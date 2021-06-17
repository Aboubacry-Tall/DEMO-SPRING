package com.libsys.Maurilib.controller;

import com.libsys.Maurilib.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LivresController {
    @Autowired
    private LivreService livreservice;

    /**
     * Afficher la liste de toute les livres (pour l'admin)
     */
    @GetMapping("/Livres")
    public String getLivres(Model model)
    {
        model.addAttribute("livres",livreservice.getLivresDB());
        return "livres";
    }


}
