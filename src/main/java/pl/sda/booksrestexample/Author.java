package pl.sda.booksrestexample;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Klasa, którą adnotujemy za pomocą @Entity, musi mieć publiczne gettery i settery dla każdego pola
 */
@Entity
public class Author {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String surname;

    /**
     * relacja jeden do wielu, jeden autor może napisac wiele ksiązęk
     */
    @OneToMany(mappedBy = "author")
    Set<Book> books = new HashSet<>();


    public Author() {
    }

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<String> getBooks() {
        List<String> booksTitles = new ArrayList<>();
        if (books.size()==0){
            return null;
        }else{
            for(Book book : books){
                booksTitles.add(book.getTitle());
            }
            return booksTitles;
        }

    }

    public void setBooks(Book book) {
        this.books.add(book);
    }


}
