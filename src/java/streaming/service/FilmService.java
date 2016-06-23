/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.FilmDAO;
import streaming.entity.Film;

/**
 *
 * @author tom
 */
public class FilmService {

    public List<Film> lister() {

        FilmDAO dao = new FilmDAO();

        return dao.listerTous();
    }

    public Film rechercherId(long id) {

        FilmDAO dao = new FilmDAO();

        return dao.rechercherId(id);
    }

    public void enregistrerFilm(Film f) {

        FilmDAO dao = new FilmDAO();

        dao.enregistrerFilm(f);
    }

    public void supprimerFilm(long id) {
        new FilmDAO().supprimerFilm(id);
    }

    public void modifierFilm(Film f) {
        new FilmDAO().modifierFilm(f);
    }
}
