/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import streaming.entity.Serie;
import streaming.service.SerieService;

/**
 *
 * @author admin
 */
@WebServlet(name = "SerieDetailServlet", urlPatterns = {"/serie_detail"})
public class SerieDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // recup ID
        long idSerie = Long.parseLong(req.getParameter("id"));

        // recup film à partir de l'idFilm
        
        Serie f = new SerieService().rechercherId(idSerie);
        
        // set attribut film
        
        req.setAttribute("serie", f);
        
        // forward vers JSP
        
        req.getRequestDispatcher("serie_detail.jsp").forward(req, resp);

}
}
