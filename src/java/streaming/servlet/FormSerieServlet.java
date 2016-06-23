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
import streaming.entity.Serie;
import streaming.service.FilmService;
import streaming.service.GenreService;
import streaming.service.SerieService;

/**
 *
 * @author tom
 */
@WebServlet(name = "FormSerieServlet", urlPatterns = {"/form_serie"})
public class FormSerieServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        long genreId = Long.parseLong(req.getParameter("genre"));
        Genre genre = new GenreService().rechercherParId(genreId);
        
        Serie s = new Serie();
        s.setTitre(req.getParameter("titre")); 
        s.setSynopsis(req.getParameter("synopsis"));
        
        genre.getSeries().add(s);
        s.setGenre(genre);
        
        SerieService serv = new SerieService();
        serv.enregistrerSerie(s);
        
        resp.sendRedirect("serie_lister");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List<Genre>mesGenres = new GenreService().lister();
        req.setAttribute("genre", mesGenres);
 
        // Renvoyer vers JSP "form.jsp"
        req.getRequestDispatcher("form_serie.jsp").forward(req, resp);
    }

    
    
}
