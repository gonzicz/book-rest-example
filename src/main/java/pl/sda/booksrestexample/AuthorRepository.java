package pl.sda.booksrestexample;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author findAuthorByName(String name);
//    @Query("Select e from Employee e WHERE e.name like 'P%'")
//    List<Employee> myOwnQuery();


}
