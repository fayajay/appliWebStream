
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import static java.util.Collections.list;
import java.util.List;
import streaming.dao.UtilisateurDAO;
import streaming.entity.Utilisateur;

/**
 *
 * @author admin
 */
public class UtilisateurService {

    public Utilisateur connexion(String identifiant, String login) {

        UtilisateurDAO dao = new UtilisateurDAO();

        return dao.connexion(identifiant, login);

    }

    public void inscription(Utilisateur util) {

        UtilisateurDAO dao = new UtilisateurDAO();
        // VALIDATION
        // Throw exception si login existe
        List<Utilisateur> listeUtilAvecCeLogin = dao.rechercherParLogin(util.getLogin());
        List<Utilisateur> listeUtilAvecCeMail = dao.rechercherParMail(util.getEmail());

        if (listeUtilAvecCeLogin.size() > 0) {
            throw new RuntimeException("Ce login existe déjà");
        }

        if (listeUtilAvecCeMail.size() > 0) {
            throw new RuntimeException("Ce mail existe déjà");
        }

        // l'util à l'état NORMAL
        util.setUtilType(Utilisateur.UtilType.NORMAL);
        // passe l'util à l'état NON VALIDE
        util.setEtatUtil(Utilisateur.EtatUtil.VALIDE);

        // persiste
        dao.ajouterUtilisateur(util);

        // envoie mail de validation
        new MailService().envoyerMail(util.getEmail(), "Inscription réussi", "Veuillez valider");
    }
}
