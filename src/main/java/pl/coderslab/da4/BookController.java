//package pl.coderslab.da4;
//
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class BookController {
//    private final BookDao bookDao;
//
//    public BookController(BookDao bookDao) {
//        this.bookDao = bookDao;
//    }
//
//    @RequestMapping("/book/add")
//    public String add() {
//        Book book = new Book();
//        book.setTitle("Duma i uprzedzenie");
//        book.setDescription("Kostiumowy");
//        book.setRating(10);
//        bookDao.saveBook(book);
//        return "Id dodanej książki to:"
//                + book.getId();
//    }
//
//    @RequestMapping("/find/{id}")
//    public String findById(@PathVariable("id") Long id) {
//       Book book =  bookDao.findById(id);
//       return book.toString();
//    }
//
//    @RequestMapping("/edit/{id}/{title}/{description}/{rating}")
//    public String updateBook(@PathVariable("id") long id, @PathVariable("title") String title, @PathVariable("description") String description, @PathVariable("rating") int rating) {
//        Book book = bookDao.findById(id);
//        book.setTitle(title);
//        book.setDescription(description);
//        book.setRating(rating);
//        bookDao.edit(book);
//        return book.toString();
//    }
//
//    @RequestMapping("/delete/{id}")
//    public String delete(@PathVariable("id") Long id) {
//        Book book = bookDao.findById(id);
//        bookDao.remove(book);
//        return "Book deleted";
//    }
//}
