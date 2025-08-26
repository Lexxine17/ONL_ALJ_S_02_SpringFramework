//package pl.coderslab.da4;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//@Repository
//@Transactional
//public class BookDao {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public void saveBook(Book book) {
//        entityManager.persist(book);
//    }
//
//    public Book findById(Long id) {
//        return entityManager.find(Book.class, id);
//    }
//
//    public Book edit(Book book) {
//        return entityManager.merge(book);
//    }
//
//    public void remove(Book book) {
//        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
//    }
//
//}
