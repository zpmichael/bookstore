package ru.pmichael.bookstore.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import ru.pmichael.bookstore.domain.Book;
import ru.pmichael.bookstore.services.is.IBookService;

@Service
public class BookService implements IBookService {

    private final List<Book> bookStore;

    public BookService() {
        this.bookStore = new ArrayList<Book>() {{
            add(new Book(1, "Qwerty-1"));
            add(new Book(2, "Qwerty-2"));
            add(new Book(3, "Qwerty-3"));
        }};
    }

    @Override
    public List<Book> listBooks() {
        return this.bookStore;
    }

    @Override
    public Book findBookById(Integer id) {
        for (Book book : this.bookStore) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public Book createBook(Book book) {
        Book newBook = new Book(book.getName());
        newBook.setId(ThreadLocalRandom.current().nextInt(3, Integer.MAX_VALUE));
        this.bookStore.add(newBook);
        return newBook;
    }
}
