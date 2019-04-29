package pl.sda.booksrestexample;

import org.springframework.web.bind.annotation.*;
import pl.sda.booksrestexample.dto.CreateAuthorDTO;
import pl.sda.booksrestexample.service.AuthorService;

@RestController                     // adnotacja oznaczająca klasę jako kontroler
@RequestMapping("/author")          // w adnotacji podajemy pod jakim linkiem znajdują się ciała klas,
                                    // czyli wszystkie metody kontrolera zaczynaja się od /author
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    /**
     * Metoda zwracająca wszystkie obiekty naszego repozytorium/ bazy danych
     * adnotacja #GetMapping informuje, że metoda obsługuje żądanie odpowiedzi HTTP GET
     */
    @GetMapping
    public Iterable<Author> getAllAuthor(){
        return authorService.findAll();
    }

    @PostMapping("/add_author")
    public Author addAuthor(@RequestBody CreateAuthorDTO command)
    {
        return authorService.createAuthor(command);
    }


}
