/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.LienDAO;
import streaming.entity.Lien;

/**
 *
 * @author admin
 */
public class LienService {
    
    public List<Lien> lister() {
        return new LienDAO().lister();
    }

    public Lien rechercherParId(long id) {
        return new LienDAO().rechercherParId(id);
    }

    public void enregistrerLien(Lien lien) {
        new LienDAO().enregistrerLien(lien);
    }

    public void supprimerLien(long id) {
        new LienDAO().supprimerLien(id);
    }

    public void modifierLien(Lien l) {
        new LienDAO().modifierLien(l);
    }
}
