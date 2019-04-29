package pl.sda.booksrestexample.service;

import org.springframework.stereotype.Service;
import pl.sda.booksrestexample.Book;
import pl.sda.booksrestexample.dto.BookDTO;
import pl.sda.booksrestexample.dto.CreateBookDTO;
import pl.sda.booksrestexample.dto.UpdateBookDTO;
import pl.sda.booksrestexample.mappers.BooksMapper;
import pl.sda.booksrestexample.myInterface.BookRepository;

/**
 * @Service – dedykowana klasom, które dostarczają usługi
 * @Service — wskazuje serwis w warstwie logiki biznesowej
 */
@Service
public class BooksService {
    private BookRepository repository;
    private BooksMapper mapper;

    public BooksService(BookRepository bookRepository, BooksMapper booksMapper) {
        /**
         *  obiekt naszego interfejsu BookRepository, udostępnia mam metody do zapisywania,
         *  znajdiwania, usuwania i wiele innych gotowych metod
         */
        this.repository = bookRepository;
        this.mapper = booksMapper;
    }
    public Iterable<Book> findAll(){
        return repository.findAll();
    }

    public Book createBook(CreateBookDTO command) {
        return repository.save(mapper.toModel(command));
    }

    public Book updateBook(Long id, UpdateBookDTO command){
        return repository.save(mapper.changeOfBookDate(id, command));
    }

    public void removeBook(Long id) {
        repository.deleteById(id);
    }

    public BookDTO findByTitle(String title) {
        return mapper.findByTitle(repository.findByTitle(title));
    }
}
