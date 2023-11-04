package mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mvc.data.BookRepository;
import mvc.domain.Book;
import mvc.domain.Books;

@Service
public class BookServiceImpl {

    @Autowired
    BookRepository bookRepository;

    public Book getBook(String isbn) {
        Book book = bookRepository.getBook(isbn);

        return book;
    }

    public void deleteBook(String isbn) {
        bookRepository.deleteBook(isbn);
    }

    public Book addBook(Book book) {
        return bookRepository.addBook(book);
    }

    public Book updateBook(String isbn, Book book) {
        return bookRepository.updateBook(null, book);
    }

    public Books searchBooks(String author) {
        if (author == null) { // get all books
            return bookRepository.getAllBooks();
        } else { // get books from an certain author
            return bookRepository.getBooksByAuthor(author);
        }
    }

}
