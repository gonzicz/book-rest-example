package pl.sda.booksrestexample.dto;

public class UpdateBookDTO {
    private String title;                   // tytuł
    private String publicationDate;         // data publikacji
    private String tags;                    // tags
    private String authorName;              // imię autora
    private String authorSurname;           // nazwiskoautora

    public String getTitle() {
        return title;
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
}
