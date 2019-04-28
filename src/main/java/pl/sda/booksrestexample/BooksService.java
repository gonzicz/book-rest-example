package pl.sda.booksrestexample;

import org.springframework.stereotype.Service;
import pl.sda.booksrestexample.dto.CreateBookDto;

/**
 * @Service – dedykowana klasom, które dostarczają usługi
 * @Service — wskazuje serwis w warstwie logiki biznesowej
 */
@Service
public class BooksService {
//    private BookRepository repository;
//    private BooksMapper mapper;
//
//    public BooksService(BookRepository bookRepository, BooksMapper booksMapper) {
//        /**
//         *  obiekt naszego interfejsu BookRepository, udostępnia mam metody do zapisywania,
//         *  znajdiwania, usuwania i wiele innych gotowych metod
//         */
//        this.repository = bookRepository;
//        this.mapper = booksMapper;
//    }
//    public Iterable<Book> findAll(){
//        return repository.findAll();
//    }
//
//    public Book createBook(CreateBookDto command) {
//        return repository.save(mapper.toModel(command));
//    }

}
