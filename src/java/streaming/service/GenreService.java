/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.GenreDAO;
import streaming.entity.Genre;

/**
 *
 * @author admin
 */
public class GenreService {
    
    public List<Genre> lister() {
        return new GenreDAO().lister();
    }
    
    public Genre rechercherParId(long genreId) {
        return new GenreDAO().rechercherParId(genreId);
    }
    
    public void enregistrerGenre(Genre g) {
        new GenreDAO().enregistrerGenre(g);
    }

    public void supprimerGenre(long id) {
        new GenreDAO().supprimeGenre(id);
    }

    public void modifierGenre(Genre g) {
        new GenreDAO().modifierGenre(g);
    }
    
}
