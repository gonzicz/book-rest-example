package pl.sda.booksrestexample.service;

import org.springframework.stereotype.Service;
import pl.sda.booksrestexample.Author;
import pl.sda.booksrestexample.dto.CreateAuthorDTO;
import pl.sda.booksrestexample.mappers.AuthorMapper;
import pl.sda.booksrestexample.myInterface.AuthorRepository;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;
    private AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    public Iterable<Author> findAll()
    {
        return authorRepository.findAll();
    }

    public Author createAuthor(CreateAuthorDTO command) {
        return authorRepository.save(authorMapper.add(command));

    }
}
