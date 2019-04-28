package pl.sda.booksrestexample.dto;

import lombok.Data;
import lombok.Getter;

/**
 * Adnotacja ta łączy w sobie kilka innych: @Getter, @Setter, @HashCodeAndEquals,
 * @RequiredArgsConstructor oraz @ToString
 */
@Data
@Getter
public class CreateBookDto {
    private String title;
    private String noWydania;
    private String publicationDate;
    private String tags;
    private String authorName;
    private String authorSurname;
}