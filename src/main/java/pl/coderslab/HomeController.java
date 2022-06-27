package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private final BookService bookService;

    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }


    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        bookService.save(book);
        System.out.println(book.getId());
        return "Hello world 123";
    }
}