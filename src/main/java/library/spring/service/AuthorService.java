package library.spring.service;

import java.util.List;
import library.spring.entity.Author;

public interface AuthorService {
    void addAuthor(Author author);

    List<Author> getAllAuthors();

    List<Author> findByName(String name);

    List<Author> findByNameAndSurname(String name, String surname);
}
