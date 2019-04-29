package pl.sda.booksrestexample.dto;

import java.util.Random;

/**
 * DTO - Data Transfer Object
 */

public class CreateBookDTO {
    private String title;                   // tytuł
    private String noWydania;               // nr wydania
    private String publicationDate;         // data publikacji
    private String tags;                    // tags
    private String authorName;              // imię autora
    private String authorSurname;           // nazwiskoautora
    private String ISBNno;
    private int Csum;                       // suma kontrolna


    public String getCsum() {
        Random generator = new Random();
        Csum = generator.nextInt(10);
        return Integer.toString(Csum);
    }

    public String getTitle() {
        return title;
    }

    public String getNoWydania() {
        return noWydania;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getTags() {
        return tags;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public String getISBNno() {
        ISBNno = "";
        ISBNno = "978-83-777-" + noWydania + "-" + getCsum();
        return ISBNno;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNoWydania(String noWydania) {
        this.noWydania = noWydania;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }
}