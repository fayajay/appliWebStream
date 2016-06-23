/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import streaming.entity.Utilisateur;
import streaming.entity.Utilisateur.EtatUtil;

/**
 *
 * @author admin
 */
public class UtilisateurDAO {
    
    public Utilisateur connexion(String identifiant, String login) {
    
    EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
    
    Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.identifiant=:monIdentifiant AND u.login=:monLogin AND u.etatUtil=:VALIDE");
    
    query.setParameter("monIdentifiant", identifiant);
    query.setParameter("monLogin", login);
    query.setParameter("VALIDE", EtatUtil.VALIDE);
    
    return (Utilisateur) query.getSingleResult();
    
    }
    
    public List<Utilisateur> rechercherParLogin(String login) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        return em.createQuery("SELECT u FROM Utilisateur u WHERE u.login=:login").setParameter("login", login).getResultList();
    }
    
    public List<Utilisateur> rechercherParMail (String email) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        return em.createQuery("SELECT u FROM Utilisateur u WHERE u.email=:email").setParameter("email", email).getResultList();
    }

    public void ajouterUtilisateur(Utilisateur util) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        em.getTransaction().begin();
        em.persist(util);
        em.getTransaction().commit();
    }
}

