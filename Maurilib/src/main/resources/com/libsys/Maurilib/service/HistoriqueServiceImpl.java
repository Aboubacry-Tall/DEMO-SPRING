package com.libsys.Maurilib.service;

import com.libsys.Maurilib.model.Historique;
import com.libsys.Maurilib.repository.HistoriqueReposetory;
import com.libsys.Maurilib.repository.LivreReposetory;
import org.springframework.beans.factory.annotation.Autowired;

public class HistoriqueServiceImpl implements HistoriqueService{

    @Autowired
    private HistoriqueReposetory livrerepoHis;

    @Override
    public void addLivreHistoriqueDB(Historique historique) {

    }
}
