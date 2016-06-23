/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import streaming.entity.Serie;

/**
 *
 * @author tom
 */
public class SerieDAO {
    
    public List<Serie> listerTous(){
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        return em.createQuery("SELECT s FROM Serie s").getResultList();
    }
    
    public Serie rechercherId(long id) {
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        return em.find(Serie.class, id);
        }
        
    public void enregistrerFilm(Serie s) {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
  
        em.persist(s);
        em.getTransaction().commit();

    }
    
    public void supprimerSerie(long id) {
    EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
    Serie s = em.find(Serie.class, id);
    em.remove(s);
    }
    
    public void modifierFilm(Serie serie) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.merge(serie);
        em.getTransaction().commit();
    }
}
