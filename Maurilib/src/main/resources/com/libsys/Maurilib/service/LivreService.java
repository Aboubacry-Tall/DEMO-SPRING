package com.libsys.Maurilib.service;

import com.libsys.Maurilib.model.Livre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface LivreService {
    List<Livre> getLivresDB();
    Livre getLivreByIdDB(long id);
    void addLivreDB(Livre livre);
    void updateLivreDB(Livre livre);
    void deleteLivreByIdBD(long id);
    void fileuploader(String type,MultipartFile file);
    public List<Livre> getSearchedLivreBykeyBD(String cle);

}
