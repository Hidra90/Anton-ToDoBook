package library.database;

import library.Book;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabaseImpl implements Database {


    private Long nextId = 1L;
    private List<Book> books = new ArrayList<>();

    @Override
    public void save(Book book) {
        book.setId(nextId);
        nextId++;
        books.add(book);
    }

    @Override
    public void deleteById(Long id) {
        books.stream().filter(book -> book.getId().equals(id))
                .findFirst()
                .ifPresent(book -> books.remove(book));
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }
}
