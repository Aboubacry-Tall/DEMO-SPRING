package com.libsys.Maurilib.controller;

import com.libsys.Maurilib.model.Livre;
import com.libsys.Maurilib.service.LivreForm;
import com.libsys.Maurilib.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.Part;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class LivreController {
    public static String upLoadDir= System.getProperty("user.dir");


    @Autowired
    private LivreService livreservice;

    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/imagedata";


    /**
     * Afficher la description d'une livre
     */
    @GetMapping("/Livre/{id}")
    public String getLivre(@PathVariable(value = "id") long id, Model model)
    {
        Livre livre = livreservice.getLivreByIdDB(id);

        model.addAttribute("livre",livre);
        return "livre";
    }

    /**
     * retourne une formulaire pour modifier les caracteristique d'une lire
     */
    @GetMapping("/LivreModifierForm/{id}")
    public String upDateLivre(@PathVariable(value = "id") long id, Model model)
    {
        LivreForm form = new LivreForm();
        model.addAttribute("gestion", form);

        Livre livre = livreservice.getLivreByIdDB(id);

        model.addAttribute("livre",livre);
        return "livreUpdateForm";
    }


    /**
     * Affiche le formulaire pour ajouter une livre
     */
    @GetMapping("/Livre/nouveau")
    public String LivreForm(Model model, Livre livre)
    {
        LivreForm form = new LivreForm();
        model.addAttribute("gestion", form);
        model.addAttribute("livre",livre);
        return "livreForm";
    }


    /**
     * Recuperer les donnees du formulaire livreForm pour ajouter une livre dans la base
     */
    @PostMapping("/Livre/updateLivre")
    public String updateLivre(@RequestParam("filedoc") MultipartFile filedoc,@RequestParam("file") MultipartFile file,@ModelAttribute("livre") Livre livre) throws IOException {
        LivreForm form = new LivreForm();
        Livre livre1 = livreservice.getLivreByIdDB(livre.getId());
        String couv  = livre1.getCouverture();
        String doc = livre1.getDocument();
        String filename=file.getOriginalFilename();
        String filenamedoc=filedoc.getOriginalFilename();

        if(!filename.isEmpty()){
            livre.setCouverture(filename);
            livreservice.fileuploader("img",file);
        }else{
            livre.setCouverture(couv);
        }

        if (!filenamedoc.isEmpty()){
            livre.setDocument(filenamedoc);
            livreservice.fileuploader("doc",filedoc);
        }else{
            livre.setDocument(doc);
        }

        System.out.println(couv +" || "+livre.getDocument());
        System.out.println(System.getProperty("user.dir"));


        livreservice.addLivreDB(livre);

        return "redirect:/Livres";
    }

    @PostMapping("/Livre/saveLivre")
    public String saveLivre(@RequestParam("filedoc") MultipartFile filedoc,@RequestParam("file") MultipartFile file,@ModelAttribute("livre") Livre livre) throws IOException {
        LivreForm form = new LivreForm();

        String filename=file.getOriginalFilename();
        String filenamedoc=filedoc.getOriginalFilename();

            livre.setCouverture(filename);
            livreservice.fileuploader("img",file);

            livre.setDocument(filenamedoc);
            livreservice.fileuploader("doc",filedoc);


        System.out.println("" +" || "+livre.getDocument());
        System.out.println(System.getProperty("user.dir"));


        livreservice.addLivreDB(livre);

        return "redirect:/Livres";
    }
/*
    @PostMapping("/Livre/updateLivre")
    public String updateLivre(@ModelAttribute("livre") Livre livre) {

        livreservice.addLivreDB(livre);
        return "redirect:/Livres";
    }  */

    /**
     *
     * recuperer l'id d'une livre pour le supprimer
     */
    @GetMapping("/LivreSupprimer/{id}")
    public String deleteLivre(@PathVariable(value = "id") long id) {

        livreservice.deleteLivreByIdBD(id);
        return "redirect:/Livres";
    }

    /**
     *  Renvoie le resultat du recherche effectuer
     */
    @PostMapping("/recherche")
    public String searchLivre(@RequestParam("cle") String cle,Model model)
    {
        model.addAttribute("rechertche",livreservice.getSearchedLivreBykeyBD(cle));
        System.out.println(livreservice.getSearchedLivreBykeyBD(cle));
    return "livresearch";
    }
}
