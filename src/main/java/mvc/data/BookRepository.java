package mvc.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import mvc.domain.Book;
import mvc.domain.Books;

@Repository
public class BookRepository {
    private Map<String, Book> books = new HashMap<String, Book>();

    public BookRepository() {
        books.put("123", new Book("123", "Book 1", 20.95, "James Brown"));
        books.put("124", new Book("124", "Book 2", 20.95, "Mary Jones"));
    }

    public Book getBook(String isbn) {
        Book book = books.get(isbn);
        return book;
    }

    public void deleteBook(@PathVariable String isbn) {
        books.remove(isbn);
    }

    public Book addBook(Book book) {
        books.put(book.getIsbn(), book);
        return book;
    }

    public Book updateBook(String isbn, Book book) {
        return books.put(isbn, book);
    }

    public Books getAllBooks() {
        Books allbooks = new Books();
        allbooks.setBooks(books.values());
        return allbooks;
    }

    public Books getBooksByAuthor(String author) {
        Books allbooks = new Books();
        String authorName = author.substring(1, author.length() - 1); // remove quotes form the name
        List<Book> booklist = books.values().stream().filter(b -> b.getAuthor().equals(authorName))
                .collect(Collectors.toList());
        allbooks.setBooks(booklist);
        return allbooks;
    }

}
