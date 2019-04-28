package pl.sda.booksrestexample;

import org.springframework.data.repository.CrudRepository;

/**
 * interfejs, który rozszerza klasę CrudRepository.
 * Rozszerzając CrudRepository musimy podać typ obiektu oraz typ klucza głównego obiektu (tego pola, które ma adnotację @Id)
 * dzięki tej klasie możemy używać takich metod jak: findAll(), save(), findById() - patrz BookController
 */
public interface BookRepository extends CrudRepository <Book, Long> {
}
