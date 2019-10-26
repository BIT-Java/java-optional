package pl.mzlnk.bitjava.optionals;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@Getter
@AllArgsConstructor
public class Book {

    private static final String PATTERN = "Book no.{id}: {title}, {author}, {year}, {category}";

    private String id;
    private String title;
    private BookCategory category;
    private int year;
    private String author;

    public Optional<String> findAuthor() {
        return Optional.ofNullable(author);
    }

    public void setCheckedOut() {
        // magic code here
    }

    @Override
    public String toString() {
        return PATTERN
                .replace("{id}", id)
                .replace("{title}", title)
                .replace("{category}", Optional.ofNullable(category)
                        .map(BookCategory::name)
                        .orElse("-"))
                .replace("{author}", Optional.ofNullable(author).orElse("-"))
                .replace("{year}", String.valueOf(year));
    }

}
