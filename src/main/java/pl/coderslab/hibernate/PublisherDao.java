package pl.coderslab.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    private EntityManager entityManager;
    public void save(Publisher publisher) {
        entityManager.persist(publisher);
    }
    public List<Publisher> findAll() {
        return entityManager.createQuery("select b from Publisher b", Publisher.class).getResultList();
    }
    public Publisher findById(Long id) {
        return entityManager.find(Publisher.class, id);
    }
}
