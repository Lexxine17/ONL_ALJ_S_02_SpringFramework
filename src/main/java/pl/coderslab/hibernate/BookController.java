package pl.coderslab.hibernate;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;
    private final BookRepository bookRepository;
    private final CategoryDao categoryDao;
    private final DaoPerson daoPerson;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao, BookRepository bookRepository, DaoPerson daoPerson, CategoryDao categoryDao, PublisherRepository publisherRepository, AuthorRepository authorRepository) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
        this.bookRepository = bookRepository;
        this.daoPerson = daoPerson;
        this.categoryDao = categoryDao;
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping("/create")
    public String createWithAuthors() {
        Author a1 = authorDao.findById(1L);
        Author a2 = authorDao.findById(2L);
        if (a1 == null || a2 == null) {
            return "Brakuje autora o id 1 lub 2";
        }

        Publisher publisher = new Publisher();
        publisher.setName("Some publisher");
        publisherDao.save(publisher);

        Book book = new Book();
        book.setTitle("Harry Potter 1");
        book.setRating(10);
        book.setPublisher(publisher);

        book.getAuthors().add(a1);
        book.getAuthors().add(a2);

        bookDao.saveBook(book);
        return "Dodano książkę id=" + book.getId();
    }

    @GetMapping("/read")
    public String readBook() {
        Book book = bookDao.findById(1);
        return book.toString();
    }

    @GetMapping("/update")
    public String updateBook() {
        Book book = bookDao.findById(1);
        book.setTitle("Thinking in Java - 2nd Edition");
        book.setRating(5);
        bookDao.update(book);
        return "Zaktualizowano książkę: " + book.toString();
    }

    @GetMapping("/delete")
    public String deleteBook() {
        Book book = bookDao.findById(1);
        bookDao.delete(book);
        return "Usunięto książkę: " + book.toString();
    }

    @RequestMapping("/allBooks")
    public String allBooks() {
        return bookDao.findAll().toString();
    }


    @RequestMapping("find/byRating")
    public String findByRating() {
        return bookDao.findByRating(10).toString();
    }

    @RequestMapping("find/withPublisher")
    public String findWithPublisher() {
        return bookDao.findAllWithPublisher().toString();
    }

    @RequestMapping("find/byPublisher/{id}")
    public String findByPublisher(@PathVariable("id") Long id) {
        return bookDao.findAllByPublisher(id).toString();
    }

    @RequestMapping("find/byAuthor/{id}")
    public String findByAuthor(@PathVariable("id") Long id) {
        return bookDao.findAllByAuthor(id).toString();

    }

    @GetMapping("/author/{id}")
    public String getBookByAuthor(@PathVariable("id") Long id) {
        Author author = authorDao.findById(id);

        if (author == null) {
            return List.of().toString();
        }
        return bookRepository.findAllByAuthors(author).toString();
    }

    @GetMapping("/publisher/{id}")
    public String getBookByPublisher(@PathVariable("id") Long id) {
        Publisher publisher = publisherDao.findById(id);

        if (publisher == null) {
            return List.of().toString();
        }
        return bookRepository.findAllByPublisher(publisher).toString();
    }

    @GetMapping("/rating/{rating}")
    public String getBookByRating(@PathVariable("rating") int rating) {
        return bookRepository.findByRating(rating).toString();
    }

    @GetMapping("/category/{id}")
    public String getBookByCategory(@PathVariable("id") Long id) {
        Category category = categoryDao.findById(id);
        if (category == null) {
            return List.of().toString();
        }
        return bookRepository.findFirstByCategoryOrderByTitleAsc(category).toString();
    }

    @GetMapping("/nip/{nip}")
    public String getPublisherByNip(@PathVariable("nip") String nip) {

        return publisherRepository.findByNip(nip).toString();
    }

    @GetMapping("/regon/{regon}")
    public String getPublisherByRegon(@PathVariable("regon") String regon) {

        return publisherRepository.findByRegon(regon).toString();
    }
    @GetMapping("/mail/{email}")
    public String getPublisherByEmail(@PathVariable("email") String email) {

        return authorRepository.findByEmail(email).toString();
    }
    @GetMapping("/pesel/{pesel}")
    public String getPublisherByPesel(@PathVariable("pesel") String pesel) {

        return authorRepository.findByPesel(pesel).toString();
    }

    @GetMapping("/lastName/{lastName}")
    public String getPublisherByLastName(@PathVariable("lastName") String lastName) {

        return authorRepository.findByLastName(lastName).toString();
    }

}

