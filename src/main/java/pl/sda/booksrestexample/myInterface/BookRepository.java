package pl.sda.booksrestexample.myInterface;

import org.springframework.data.repository.CrudRepository;
import pl.sda.booksrestexample.Book;

/**
 * interfejs, który rozszerza klasę CrudRepository.
 * Rozszerzając CrudRepository musimy podać typ obiektu oraz typ klucza głównego obiektu (tego pola, które ma adnotację @Id)
 * dzięki tej klasie możemy używać takich metod jak: findAll(), save(), findById() - patrz BookController
 */
public interface BookRepository extends CrudRepository <Book, Long> {
    public Book findByTitle(String title);
}
