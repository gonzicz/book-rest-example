package pl.sda.booksrestexample.myInterface;

import org.springframework.data.repository.CrudRepository;
import pl.sda.booksrestexample.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    Author findAuthorByNameAndSurname(String name, String surname);


}
