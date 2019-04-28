package pl.sda.booksrestexample;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @PostMapping
    public Author addAuthor(@RequestBody Author author)
    {
        return authorRepository.save(author);
    }

    @GetMapping
    public Iterable<Author> getAllAuthor(){
        return authorRepository.findAll();
    }
}
