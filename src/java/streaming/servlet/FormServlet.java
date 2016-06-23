/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import streaming.entity.Film;
import streaming.entity.Genre;
import streaming.service.FilmService;
import streaming.service.GenreService;

/**
 *
 * @author tom
 */
@WebServlet(name = "FormServlet", urlPatterns = {"/form"})
public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //recupere genre
        long genreId = Long.parseLong(req.getParameter("genre")); 
        Genre genre = new GenreService().rechercherParId(genreId);
        
        // consruit le film
        Film f = new Film();
        f.setTitre(req.getParameter("titre")); 
        f.setAnnee(Integer.parseInt(req.getParameter("anneeProd")));
        f.setSynopsis(req.getParameter("synopsis"));
        
        genre.getFilms().add(f);
        f.setGenre(genre);
        // persist
        FilmService serv = new FilmService();
        serv.enregistrerFilm(f);
        
        // forward vers liste films
        resp.sendRedirect("films_lister");
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 

        
        List<Genre>mesGenres = new GenreService().lister();
        req.setAttribute("genre", mesGenres);      
        
            // Renvoyer vers JSP "form.jsp"
        req.getRequestDispatcher("form.jsp").forward(req, resp);
    }

    
    
}
