package pl.coderslab;

import org.springframework.stereotype.Controller;

@Controller
public class AuthorController {
    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public void create(Author author){
        authorDao.save(author);
    }
    public Author read(Author author){
        return authorDao.findById(author.getId());
    }
    public void update(Author author){
        authorDao.update(author);
    }
    public void delete(Author author){
        authorDao.delete(author);
    }
}