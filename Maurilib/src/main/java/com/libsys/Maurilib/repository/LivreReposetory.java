package com.libsys.Maurilib.repository;

import com.libsys.Maurilib.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivreReposetory extends JpaRepository<Livre,Long> {
    @Query(value = "SELECT * FROM livres WHERE titre LIKE %?1% Or categorie LIKE %?1% ",nativeQuery = true)
    List<Livre> getSearchedLivreBD(String cle);

    //

    @Query(value = "SELECT * FROM livres WHERE categorie = ?1 ",nativeQuery = true)
    List<Livre> getSearchedLivreCategorie(String categorie);
}
