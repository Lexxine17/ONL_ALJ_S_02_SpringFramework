package pl.coderslab.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class DaoPersonDetails {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(PersonDetails person) {
        entityManager.persist(person);
    }

    public PersonDetails findById(Long id) {
        return entityManager.find(PersonDetails.class, id);
    }

    public void update(PersonDetails person) {
        entityManager.merge(person);
    }

    public void delete(PersonDetails person) {
        entityManager.remove(entityManager.contains(person) ? person : entityManager.merge(person));
    }
}
