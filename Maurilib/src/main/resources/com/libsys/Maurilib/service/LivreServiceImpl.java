package com.libsys.Maurilib.service;

import com.libsys.Maurilib.model.Historique;
import com.libsys.Maurilib.model.Livre;
import com.libsys.Maurilib.repository.HistoriqueReposetory;
import com.libsys.Maurilib.repository.LivreReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class LivreServiceImpl implements LivreService{

    @Autowired
    private LivreReposetory livrerepo;

    public static String upLoadDir= System.getProperty("user.dir");

    @Autowired
    private HistoriqueReposetory historiqueRepo;

    @Override
    public List<Livre> getLivresDB() {

        return livrerepo.findAll();
    }

    @Override
    public Livre getLivreByIdDB(long id) {
        Optional<Livre> option = livrerepo.findById(id);
        Livre livre = null;
        if (option.isPresent())
                livre = option.get();
        else
            throw new RuntimeException("Livre non trouvé :: "+id);

        return livre;
    }

    @Override
    public void addLivreDB(Livre livre) {
        this.livrerepo.save(livre);
    }

    @Override
    public void updateLivreDB(Livre livre) {
        Long id = livre.getId();
        livrerepo.deleteById(livre.getId());
        livrerepo.save(livre);
    }

    @Override
    public void deleteLivreByIdBD(long id) {

        Livre livre = getLivreByIdDB(id);
        Historique histo = new Historique();
        histo.setId(livre.getId());
        histo.setTitre(livre.getTitre());
        histo.setStatut(livre.getStatut());
        histo.setCouverture(livre.getCouverture());
        histo.setAuteur(livre.getAuteur());
        histo.setCategorie(livre.getCategorie());
        histo.setDates(livre.getDates());
        histo.setDocument(livre.getDocument());
        histo.setEditeur(livre.getEditeur());
        histo.setEtat(livre.getEtat());
        histo.setIsbn(livre.getIsbn());
        histo.setPrix(livre.getPrix());
        histo.setResume(livre.getResume());

        historiqueRepo.save(histo);
        livrerepo.deleteById(id);

    }

    @Override
    public void fileuploader(String type ,MultipartFile file) {

               try {
                   file.transferTo(new File(upLoadDir+"\\src\\main\\resources\\static\\"+type+"\\"+file.getOriginalFilename()));
               } catch (IllegalStateException e) {
                   // TODO Auto-generated catch block
                   e.printStackTrace();
               } catch (IOException e) {
                   // TODO Auto-generated catch block
                   e.printStackTrace();
               }

        }


    public List<Livre> getSearchedLivreBykeyBD(String cle) {

        return livrerepo.getSearchedLivreBD(cle);
    }


}
