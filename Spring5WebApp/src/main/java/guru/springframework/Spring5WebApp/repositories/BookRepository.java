package guru.springframework.Spring5WebApp.repositories;

import guru.springframework.Spring5WebApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
