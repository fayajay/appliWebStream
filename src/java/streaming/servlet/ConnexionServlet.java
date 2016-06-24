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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import streaming.entity.Utilisateur;
import streaming.service.UtilisateurService;

/**
 *
 * @author admin
 */
@WebServlet(name = "ConnexionServlet", urlPatterns = {"/connexion"})
public class ConnexionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getRequestDispatcher("connexion.jsp").forward(req, resp);
    }
    
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String identifiant = req.getParameter("identifiant");
        String login = req.getParameter("login");
        
        Utilisateur u = new UtilisateurService().connexion(identifiant, login);
        
        // je suis logué correctement
        req.getSession().setAttribute("utilConnecte", u);
        
        
        
        
        
        
        // redirection vers ecran de listage films
        resp.sendRedirect("films_lister");
    }

}
