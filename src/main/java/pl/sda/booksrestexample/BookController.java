package pl.sda.booksrestexample;

import org.springframework.web.bind.annotation.*;
import pl.sda.booksrestexample.dto.BookDTO;
import pl.sda.booksrestexample.dto.CreateBookDTO;
import pl.sda.booksrestexample.dto.UpdateBookDTO;
import pl.sda.booksrestexample.service.BooksService;

@RestController                                 // adnotacja oznaczająca klasę jako kontroler
@RequestMapping("/books")                       // w adnotacji podajemy pod jakim linkiem znajdują się ciała klas,
                                                // czyli wszystkie metody kontrolera zaczynaja się od /books
public class BookController {
    private BooksService booksService;

    public BookController(BooksService booksService) {
        this.booksService = booksService;
    }

    /**
     * Metoda zwracająca wszystkie obiekty naszego repozytorium/ bazy danych
     * adnotacja #GetMapping informuje, że metoda obsługuje żądanie odpowiedzi HTTP GET
     */
    @GetMapping
    public Iterable<Book> getAllBooks() {
        return booksService.findAll();
    }

    /**
     * przy postach,patchach,putach uzywac request body czyli ciało ktore zostanie wyslane
     */
    @PostMapping("/add_book")
    public Book addBook(@RequestBody CreateBookDTO command) {
        return booksService.createBook(command);

    }

    /**
     * BookRepository ma kolejna gotową metodę  deleteById() czyli usuwa obiekt o danym id
     * @param id id ksiązki którą chcemy usunąć
     */
    @DeleteMapping("/delete_book/{id}")
    public void removeOne(@PathVariable Long id){
        booksService.removeBook(id);
    }

    /**
     * Adnotacja wykonuje żądanie POST, ale do naszego adresu /books dodajemy /{id}, czyli będzie
     * dostępny pod /books/{id}; id jest w klamrach ponieważ jest to zmienna którą  będziemy pobierać
     * z argumentu metody.
     * Adnotacja @PathVariable oznacza że /{id} w ścieżce to id podane w argumencie metody
     * bookRepository ma też gotową metode findById() ktora zwraca obiekt o danym id
     */
    @PostMapping("/update_book/{id}")
    public Book changeOfBookData(@PathVariable Long id, @RequestBody UpdateBookDTO command) {
        return booksService.updateBook(id,command);
    }

    @PostMapping("/find_book_by_title/{title}")
    public BookDTO findByTitle(@PathVariable String title){
        return booksService.findByTitle(title);
    }
}
