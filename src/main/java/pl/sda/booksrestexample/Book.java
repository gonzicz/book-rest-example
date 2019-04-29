package pl.sda.booksrestexample;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

// localhost:8080/h2-console
// JDBC URL: jdbc:h2.mem:testdb
/**
 *  Klasa, którą adnotujemy za pomocą @Entity, musi mieć publiczne gettery i settery dla każdego pola.
 *  Adnotacja, która mówi o tym, że ta klasa jest zarządzana przez JPA i odpowiada tabeli w bazie danych,
 *  adnotacja oznacza, że jest encja czyli klasa którą będziemy mapować
 */
@Entity
public class Book {
    @Id
    @GeneratedValue         // automatycznie generuje nam ID
    private long id;
    private String title;
    private String isbnNumber;
    private String publicationDate;
    private String tags;

    /**
     * Relacja wiele do jednego, wiele książek może byc napisane przez jednego autora
     */
    @ManyToOne
    private Author author;

    public Book() {
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return null;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getPublicationDate() {
        return this.publicationDate;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}
