//package pl.coderslab.da4;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//@Repository
//@Transactional
//public class AuthorDao {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public void saveAuthor(Author author) {
//        entityManager.persist(author);
//    }
//
//    public Author findById(Long id) {
//        return entityManager.find(Author.class, id);
//    }
//
//    public Author edit(Author author) {
//        return entityManager.merge(author);
//    }
//
//    public void remove(Author author) {
//        entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author));
//    }
//
//}
