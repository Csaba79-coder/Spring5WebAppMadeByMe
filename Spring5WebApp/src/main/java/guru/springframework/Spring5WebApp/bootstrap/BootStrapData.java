package guru.springframework.Spring5WebApp.bootstrap;

import guru.springframework.Spring5WebApp.domain.Author;
import guru.springframework.Spring5WebApp.domain.Book;
import guru.springframework.Spring5WebApp.domain.Publisher;
import guru.springframework.Spring5WebApp.module.CopyRight;
import guru.springframework.Spring5WebApp.repositories.AuthorRepository;
import guru.springframework.Spring5WebApp.repositories.BookRepository;
import guru.springframework.Spring5WebApp.repositories.PublisherRepository;
import guru.springframework.Spring5WebApp.util.Print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
// CommandLineRunner is an interface we would like to implement!
// that reason I have to implement the method not to show error!

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        new Print().printString(new CopyRight().addingCopyright());


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

        // Wrox Press Ltd. Arden House 1102 Warwick Road Acock's Green Birmingham; United Kingdom
        // 1102 Warwick Road, Acocks Green, Birmingham, B27 6BH
        Publisher wroxPress = new Publisher("Wrox Press Ltd.", "Arden House - 1102 Warwick Road",
                "Acock's Green", "Birmingham", " B27 6BH", "UK");

        // Addison-Wesley Professional, 75 Arlington Street Suite 300, Boston MA 02116 USA
        Publisher publisherDDD = new Publisher();
        publisherDDD.setName("Addison-Wesley Professional");
        publisherDDD.setAddressLine1("75 Arlington Street Suite 300");
        publisherDDD.setCity("Boston");
        publisherDDD.setState("MA, Massachusetts");
        publisherDDD.setZipCode("02116");
        publisherDDD.setCountry("USA");

        publisherRepository.save(wroxPress);
        publisherRepository.save(publisherDDD);

        System.out.println(wroxPress);
        System.out.println(publisherDDD);
        System.out.println("Publisher count: " + publisherRepository.count());

        ddd.setPublisher(publisherDDD);
        publisherDDD.getBooks().add(ddd);

        noEJB.setPublisher(wroxPress);
        wroxPress.getBooks().add(noEJB);

        publisherRepository.save(publisherDDD);
        bookRepository.save(ddd);
        publisherRepository.save(wroxPress);
        bookRepository.save(noEJB);

        System.out.println("Publisher DDD number of books: " + publisherDDD.getBooks().size());
        System.out.println("Publisher Wrox Press has books: " + wroxPress.getBooks().size());
        System.out.println("The two publisher has all together: "
                + (publisherDDD.getBooks().size() + wroxPress.getBooks().size()) + " books");
    }
}
