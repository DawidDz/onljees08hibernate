package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private final  BookDao bookDao;
    private final PublisherDao publisherDao;

    private final AuthorDao authorDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        Book byId = bookDao.findById(1l);
        byId.setTitle(" Other book about java");
        bookDao.update(byId);
        return "test";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(){
        Publisher publisher = new Publisher();
        publisher.setName("Helion");
        publisherDao.save(publisher);

        Book book = new Book();
        book.setPublisher(publisher);
        book.setTitle("Java 2 podstawy");
        book.setRating(5);
        bookDao.save(book);

        return "add";
    }

    @RequestMapping("/joined")
    @ResponseBody
    public String joined(){
        Book book = new Book();
        book.setTitle("Java 2 podstawy");
        Author author1 = authorDao.findById(1);
        Author author2 = authorDao.findById(2);
        List<Author> newList = new ArrayList<>();
        newList.add(author1);
        newList.add(author2);
        book.setAuthor(newList);
        bookDao.save(book);

        return "joined";
    }

}