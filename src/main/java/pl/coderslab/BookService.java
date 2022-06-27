

package pl.coderslab;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void save(Book book){
        bookDao.save(book);
    }
}