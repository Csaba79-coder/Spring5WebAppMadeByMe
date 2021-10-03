package guru.springframework.Spring5WebApp.repositories;

import guru.springframework.Spring5WebApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
