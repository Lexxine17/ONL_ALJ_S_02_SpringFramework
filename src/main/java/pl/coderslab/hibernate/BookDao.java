package pl.coderslab.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
    }

    public List<Book> findAll() {
        return entityManager.createQuery("select b from Book b", Book.class).getResultList();
    }

    public List<Book> findByRating(int rating) {
        Query queryp = entityManager.
                createQuery("SELECT b FROM Book b WHERE b.rating = :rating", Book.class);
        queryp.setParameter("rating", rating);
        return queryp.getResultList();
    }

    public List<Book> findAllWithPublisher() {
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.publisher IS NOT NULL", Book.class);
        return query.getResultList();
    }

    public List<Book> findAllByPublisher(Long publisherId) {
        Query queryp = entityManager.
                createQuery("SELECT b FROM Book b WHERE b.publisher.id = :publisher", Book.class);
        queryp.setParameter("publisher", publisherId);
        return queryp.getResultList();
    }

    public List<Book> findAllByAuthor(Long authorId) {
        Query queryp = entityManager.
                createQuery("SELECT b FROM Book b JOIN b.authors a WHERE a.id = :author", Book.class);
        queryp.setParameter("author", authorId);
        return queryp.getResultList();
    }
}