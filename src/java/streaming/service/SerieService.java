/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.SerieDAO;
import streaming.entity.Serie;

/**
 *
 * @author admin
 */
public class SerieService {
    
    public List<Serie> lister() {
        
        SerieDAO dao = new SerieDAO();
        
        return dao.listerTous();
        
    }
    
    public Serie rechercherId(long id) {
        
        SerieDAO dao = new SerieDAO();
        
        return dao.rechercherId(id);
    }
    
    public void enregistrerSerie(Serie s) {
        
        SerieDAO dao = new SerieDAO();
        
        dao.enregistrerFilm(s);
    }

    public void supprimerSerie(long id) {
        new SerieDAO().supprimerSerie(id);
    }

    public void modifier(Serie s) {
        new SerieDAO().modifierFilm(s);
    }
}
