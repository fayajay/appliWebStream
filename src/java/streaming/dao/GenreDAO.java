/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import streaming.entity.Genre;

/**
 *
 * @author admin
 */
public class GenreDAO {
    
    public List<Genre> lister() {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.createQuery("SELECT g FROM Genre g").getResultList();
    }
   public Genre rechercherParId(long genreId) {
       EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
       return em.find(Genre.class, genreId);
   } 
   public void enregistrerGenre (Genre g) {
       EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
       em.getTransaction().begin();
       em.persist(g);
       em.getTransaction().commit();
   }
   public void supprimeGenre(long id) {
       EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
       em.getTransaction().begin();
       Genre g = em.find(Genre.class, id);
       em.remove(g);
       em.getTransaction().commit();
   }
   public void modifierGenre (Genre genre) {
       EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
       em.getTransaction().begin();
       em.merge(genre);
       em.getTransaction().commit();
   }
}
