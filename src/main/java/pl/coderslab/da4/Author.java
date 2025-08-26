//package pl.coderslab.da4;
//
//import jakarta.persistence.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//public class Author {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String firstNAme;
//    private String lastName;
//
// import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.transaction.Transactional;
//import org.springframework.stereotype.Repository;
//
//@Repository
//@Transactional
//public class AuthorDao {
//    @PersistenceContext
//    private EntityManager entityManager;
//    public void saveAuthor(Author author) {
//        entityManager.persist(author);
//    }
//
//    public Author findById(long id) {
//        return entityManager.find(Author.class, id);
//    }
//    public void update(Author author) {
//        entityManager.merge(author);
//    }
//
//    public void delete(Author author) {
//        entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author));
//    }
//}
//    public Author(Long id, String firstNAme, String lastName) {
//        this.id = id;
//        this.firstNAme = firstNAme;
//        this.lastName = lastName;
//    }
//
//    public Author() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFirstNAme() {
//        return firstNAme;
//    }
//
//    public void setFirstNAme(String firstNAme) {
//        this.firstNAme = firstNAme;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//}
