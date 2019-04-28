package pl.sda.booksrestexample;

import org.springframework.web.bind.annotation.*;

@RestController                                 // adnotacja oznaczająca klasę jako kontroler
@RequestMapping("/books")                       // w adnotacji podajemy pod jakim linkiem znajdują się ciała klas,
                                                // czyli wszystkie metody kontrolera zaczynaja się od /books
public class BookController {
    //private BooksService booksService;

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository =authorRepository;
    }

    /**
     * Metoda zwracająca wszystkie obiekty naszego repozytorium/ bazy danych
     */
    @GetMapping                         // adnotacja informuje, że metoda obsługuje żądanie odpowiedzi HTTP GET
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    @PostMapping            // przy postach,patchach,putach uzywac request body czyli ciało ktore zostanie wyslane
    public Book addBook(@RequestBody Book book){
        return bookRepository.save(book);

    }

    @PostMapping("/add_book")
    public Book createBook(@RequestBody Book book){
        /**
         * funkcja findOne jest nie altualna można zastąpic ja wyrażeniem
         * findById(id).orElse(null)
         */
        Author autor = authorRepository.findAuthorByName("Adam");
        autor.setBooks(book);
        book.setAuthor(autor);
        authorRepository.save(autor);
        return bookRepository.save(book);
    }

}
