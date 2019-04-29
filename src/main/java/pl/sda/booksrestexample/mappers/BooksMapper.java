package pl.sda.booksrestexample.mappers;


import org.springframework.stereotype.Service;
import pl.sda.booksrestexample.Author;
import pl.sda.booksrestexample.Book;
import pl.sda.booksrestexample.dto.BookDTO;
import pl.sda.booksrestexample.dto.CreateBookDTO;
import pl.sda.booksrestexample.dto.UpdateBookDTO;
import pl.sda.booksrestexample.myInterface.AuthorRepository;
import pl.sda.booksrestexample.myInterface.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksMapper {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public BooksMapper(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Book toModel(CreateBookDTO dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setIsbnNumber(dto.getISBNno());
        book.setPublicationDate(dto.getPublicationDate());
        book.setTags(dto.getTags());
        Author autor = authorRepository.findAuthorByNameAndSurname(dto.getAuthorName(), dto.getAuthorSurname());
        if (autor == null) {
            book.setAuthor(null);
        } else {
            autor.setBooks(book);
            book.setAuthor(autor);
            authorRepository.save(autor);
        }
        return book;
    }

    public Book changeOfBookDate(Long id, UpdateBookDTO dto) {
        // zastosowanie findById(ID).orElse(null) zwraca nam Book a nie Optionala
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            System.out.println("NIE MA TEKIEJ KSIĄZKI!!!!!!");
        }else{
            book.setTitle(dto.getTitle());
            book.setTags(dto.getTags());
            book.setPublicationDate(dto.getPublicationDate());
            Author autor = authorRepository.findAuthorByNameAndSurname(dto.getAuthorName(), dto.getAuthorSurname());
            if (autor == null) {
                book.setAuthor(null);
            } else {
                autor.setBooks(book);
                book.setAuthor(autor);
                authorRepository.save(autor);
            }
            return book;
        }
        return null;
    }

    public BookDTO findByTitle(Book book) {
        List<BookDTO> books = new ArrayList<>();
        bookRepository.findByTitle(title)
        BookDTO bookByTitle = new BookDTO();

    }BookDTO
}
