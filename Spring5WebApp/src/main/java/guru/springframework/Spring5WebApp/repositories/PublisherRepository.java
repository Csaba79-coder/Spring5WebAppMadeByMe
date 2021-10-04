package guru.springframework.Spring5WebApp.repositories;

import guru.springframework.Spring5WebApp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
