package com.libsys.Maurilib.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.libsys.Maurilib.domaine.Response;
import com.libsys.Maurilib.exception.RessourceNotFound;
import com.libsys.Maurilib.model.Livre;
import com.libsys.Maurilib.repository.LivreReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lib/")
@CrossOrigin(origins = "http://localhost:4200")
public class LivreController {
    @Autowired
    private LivreReposetory livrerepo ;

    @Autowired
    ServletContext context;

    String Home = System.getProperty("user.dir");
    Path path = Paths.get(Home).getParent().getParent();


    @GetMapping("/livres")
    public List<Livre> getLivres()
    {
        return livrerepo.findAll();
    }

    @PostMapping("/livres")
    public Livre addLivre(@RequestBody Livre livre){
        return livrerepo.save(livre);
    }

    @GetMapping("/livres/{id}")
    public ResponseEntity<Livre> getLivre(@PathVariable("id") Long id){
        Livre livre = livrerepo.findById(id).orElseThrow(() -> new RessourceNotFound("Livre non trouvé # id :"+id));
        return ResponseEntity.ok(livre);
    }

    @GetMapping("/livres/Categories/{categorie}")
    public List<Livre> searchCategorieLivre(@PathVariable("categorie") String categorie)
    {
        List<Livre> livres = livrerepo.getSearchedLivreCategorie(categorie);

        return livres;
    }

    @GetMapping("/livres/Recherches/")
    public List<Livre> searchedLivre(@RequestParam("key") String key)
    {
        List<Livre> livres = livrerepo.getSearchedLivreBD(key);

        return livres;
    }

    @PutMapping("/livres/{id}")
    public ResponseEntity<Livre> updateLivre(@PathVariable Long id,@RequestBody Livre livre0){

        Livre livre = livrerepo.findById(id).orElseThrow(() -> new RessourceNotFound("Livre non trouvé # id :"+id));

        livre.setTitre(livre0.getTitre());
        livre.setAuteur(livre0.getAuteur());
        livre.setCategorie(livre0.getCategorie());
        livre.setEditeur(livre0.getEditeur());
        livre.setIsbn(livre0.getIsbn());
        livre.setPrix(livre0.getPrix());
        livre.setResume(livre0.getResume());

        Livre updatedLivre = livrerepo.save(livre);

        return ResponseEntity.ok(updatedLivre);
    }

    @DeleteMapping("/livres/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteLivre(@PathVariable Long id){
        Livre livre = livrerepo.findById(id).orElseThrow(() -> new RessourceNotFound("Livre non trouvé # id :"+id));
        livrerepo.delete(livre);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Success",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/livreupload")
    public ResponseEntity<Response> createLivre(@RequestParam("img") MultipartFile fileImg, @RequestParam("doc") MultipartFile fileDoc,
                                                @RequestParam("livre") String livre) throws JsonParseException, JsonMappingException, Exception{

        System.out.println("Ok .............");
        Livre livre0 = new ObjectMapper().readValue(livre, Livre.class);

        String filenameImg = fileImg.getOriginalFilename();
        String filenameDoc = fileDoc.getOriginalFilename();
        livre0.setCouverture(filenameImg);
        livre0.setDocument(filenameDoc);

        System.out.println(filenameImg);
        System.out.println(filenameDoc);
        this.fileuploader("img",fileImg);
        this.fileuploader("doc",fileDoc);


        Livre savedLivre = livrerepo.save(livre0);

        if (savedLivre != null)
        {
            return new ResponseEntity<Response>(new Response (""), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Response>(new Response ("Article not saved"),HttpStatus.BAD_REQUEST);
        }
    }

    private void fileuploader(String type ,MultipartFile file) {


        String directoryPath = path.toString()+"\\DEMO-ANGULAR\\crud-app\\src\\assets";
        File directory=new File(directoryPath+"\\"+type);

        boolean isExist = directory.exists() && directory.isDirectory();
        if(!isExist){
            directory.mkdir();
        }
        try {
            file.transferTo(new File(directoryPath+"\\"+type+"\\"+file.getOriginalFilename()));
            System.out.println("transfert okkkk");
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @PutMapping("/livreupload/{id}")
    public ResponseEntity<Livre> modifierLivre(@PathVariable Long id,@RequestParam("img") MultipartFile fileImg,@RequestParam("doc") MultipartFile fileDoc,@RequestParam("livre") String livre0)throws JsonParseException, JsonMappingException, Exception{

        System.out.println("okkkk ........");
        Livre livre1 = new ObjectMapper().readValue(livre0, Livre.class);
        String filenameImg = fileImg.getOriginalFilename();
        String filenameDoc = fileDoc.getOriginalFilename();
        livre1.setCouverture(filenameImg);
        livre1.setDocument(filenameDoc);

        Livre livre = livrerepo.findById(id).orElseThrow(() -> new RessourceNotFound("Livre non trouvé # id :"+id));
        String couv  = livre.getCouverture();
        String doc = livre.getDocument();

        livre.setTitre(livre1.getTitre());
        livre.setAuteur(livre1.getAuteur());
        livre.setCategorie(livre1.getCategorie());
        livre.setEditeur(livre1.getEditeur());
        livre.setIsbn(livre1.getIsbn());
        livre.setPrix(livre1.getPrix());
        livre.setResume(livre1.getResume());

        if(!filenameImg.isEmpty()){
            livre.setCouverture(filenameImg);
            this.fileuploader("img",fileImg);
        }else{
            livre.setCouverture(couv);
        }

        if (!filenameDoc.isEmpty()){
            livre.setDocument(filenameDoc);
            this.fileuploader("doc",fileDoc);
        }else{
            livre.setDocument(doc);
        }


        Livre updatedLivre = livrerepo.save(livre);

        return ResponseEntity.ok(updatedLivre);
    }


}
