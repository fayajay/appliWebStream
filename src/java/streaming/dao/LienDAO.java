/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import streaming.entity.Lien;

/**
 *
 * @author admin
 */
public class LienDAO {
    
    public List<Lien> lister() {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.createQuery("SELECT l FROM Lien l").getResultList();
    }
    public Lien rechercherParId(long id) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.find(Lien.class, id);
    }
    public void enregistrerLien(Lien l) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();
    }
    public void supprimerLien(long id) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        Lien l = em.find(Lien.class, id);
        em.remove(l);
        em.getTransaction().commit();
    }
    public void modifierLien (Lien lien) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.merge(lien);
        em.getTransaction().commit();
    }
}
