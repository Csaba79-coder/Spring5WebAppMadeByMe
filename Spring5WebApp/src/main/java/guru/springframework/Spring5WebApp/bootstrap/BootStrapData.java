package guru.springframework.Spring5WebApp.bootstrap;

import guru.springframework.Spring5WebApp.domain.Author;
import guru.springframework.Spring5WebApp.domain.Book;
import guru.springframework.Spring5WebApp.repositories.AuthorRepository;
import guru.springframework.Spring5WebApp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
// CommandLineRunner is an interface we would like to implement!
// that reason I have to implement the method not to show error!

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "9780321125217");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        // this one saves into the H2 database
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "9780764558313");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("The number of books: " + bookRepository.count());
    }
}
