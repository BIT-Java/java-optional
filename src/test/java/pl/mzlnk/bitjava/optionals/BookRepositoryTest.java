package pl.mzlnk.bitjava.optionals;

import org.junit.Before;
import org.junit.Test;

public class BookRepositoryTest {

    private BookRepository bookRepository;

    @Before
    public void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    public void findBookByIdTest() {
        Book defaultBook = new Book("D0", "Empty title", null, -1, null);

        Book book1 = bookRepository.findById("A1").orElse(defaultBook);
        Book book2 = bookRepository.findById("oou").orElse(defaultBook);

        System.out.println(book1.toString());
        System.out.println(book2.toString());
    }

    @Test(expected = BookNotFoundException.class)
    public void optionalOrElseThrowTest() throws BookNotFoundException {
        Book book1 = bookRepository.findById("A5").orElseThrow(BookNotFoundException::new);
        System.out.println(book1.toString());

        Book book2 = bookRepository.findById("23").orElseThrow(BookNotFoundException::new);
        System.out.println(book1.toString());
    }

    @Test
    public void optionalIsPresentTest() {
        boolean isPresent = bookRepository.findById("A1").isPresent();

        System.out.println("Book is " + (isPresent ? "present" : "not present"));
    }

    @Test
    public void optionalIfPresentTest() {
        bookRepository.findById("A2").ifPresent(book -> {
            System.out.println("book " + book.getTitle() + " written in " + book.getYear());
        });
    }

    @Test
    public void optionalIfPresentOrElseTest() {
        bookRepository.findById("82").ifPresentOrElse(book -> {
            System.out.println("book " + book.getTitle() + " written in " + book.getYear());
        }, () -> System.out.println("Book with given ID not found!"));
    }

    @Test(expected = BookNotFoundException.class)
    public void optionalIfPresentOrElseThrowTest() throws BookNotFoundException {
        Book book = bookRepository.findById("98").orElseThrow(BookNotFoundException::new);
    }

    @Test
    public void optionalMapTest() {
        String author = bookRepository.findById("A4")
                .map(Book::getAuthor)
                .orElse("no author");

        System.out.println("Author: " + author);
    }

}