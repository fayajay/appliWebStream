/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.servlet;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import streaming.entity.Film;
import streaming.service.FilmService;

/**
 *
 * @author admin
 */
@WebServlet(name = "FilmDetailServlet", urlPatterns = {"/film_detail"})
public class FilmDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // recup ID
        long idFilm = Long.parseLong(req.getParameter("id"));

        // recup film à partir de l'idFilm
        Film f = new FilmService().rechercherId(idFilm);

        // set attribut film
        req.setAttribute("film", f);

        // forward vers JSP
        req.getRequestDispatcher("film_detail.jsp").forward(req, resp);

    }

}
