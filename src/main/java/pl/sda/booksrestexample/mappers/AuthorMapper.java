package pl.sda.booksrestexample.mappers;

import org.springframework.stereotype.Service;
import pl.sda.booksrestexample.Author;
import pl.sda.booksrestexample.dto.CreateAuthorDTO;

@Service
public class AuthorMapper {
    public Author add(CreateAuthorDTO dto) {
        Author author = new Author();
        author.setName(dto.getName());
        author.setSurname(dto.getSurName());
        return author;
    }
}
