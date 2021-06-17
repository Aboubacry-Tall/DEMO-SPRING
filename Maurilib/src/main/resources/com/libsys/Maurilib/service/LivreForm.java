package com.libsys.Maurilib.service;

import com.libsys.Maurilib.model.Livre;

import java.util.HashMap;
import java.util.Map;

public class LivreForm {

    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();


    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Boolean valideForm(Livre livre){

        if(App.valideText(livre.getTitre())) {
            if(App.valideText(livre.getCategorie())) {
                if(App.valideText(livre.getPrix())) {
                    if(App.valideText(livre.getIsbn())) {
                        if(App.valideText(livre.getAuteur())) {
                            if(App.valideText(livre.getEditeur())) {
                                if(App.valideText("")) {
                                    if(App.valideText("")) {
                                        erreurs.clear();
                                    }else {
                                        //fileName1 = "maurilivre.png";
                                    }
                                }else {
                                    erreurs.put("document", "Merci de choisir un document valide");
                                }
                            }else {
                                erreurs.put("editeur", "Merci de saisir un editeur valide");
                            }
                        }else {
                            erreurs.put("auteur", "Merci de saisir un nom d\'auteur valide");
                        }
                    }else {
                        erreurs.put("isbn", "Merci de saisir un isbn valide");
                    }
                }else {
                    erreurs.put("prix", "Merci de saisir un prix valide");
                }
            }else {
                erreurs.put("categorie", "Merci de saisir une categorie valide");
            }
        }else {
            erreurs.put("titre", "Merci de saisir un titre valide");
        }

        if (erreurs.isEmpty())
        {
            return true;
        }
        else
            return false;

    }
}
