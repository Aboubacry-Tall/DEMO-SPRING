package com.libsys.Maurilib.controller;

import com.libsys.Maurilib.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private LivreService livreservice;

    @GetMapping("/")
    public String HomePage(Model model)
    {
        model.addAttribute("livres",livreservice.getLivresDB());
        return "index";
    }

}
