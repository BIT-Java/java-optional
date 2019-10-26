package pl.mzlnk.bitjava.optionals;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BookRepository {

    private Map<String, Book> books = new HashMap<>();

    public BookRepository() {
        books.put("A1", new Book("A1", "Title 1", BookCategory.CLASSIC, 1879, "A. Williams"));
        books.put("A2", new Book("A2", "Title 2", BookCategory.DRAMA, 1902, "J. Smiths"));
        books.put("A3", new Book("A3", "Title 3", BookCategory.DRAMA, 1903, "J. Smiths"));
        books.put("A4", new Book("A4", "Title 4", BookCategory.FANTASY, 1949, null));
        books.put("A5", new Book("A5", "Title 5", BookCategory.ROMANCE, 1949, "W. Brown"));
    }

    public Optional<Book> findById(String id) {
        return Optional.ofNullable(books.get(id));
    }

}
