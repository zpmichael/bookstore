package ru.pmichael.bookstore.services.is;

import java.util.List;

import ru.pmichael.bookstore.domain.Book;

public interface IBookRestService {

    List<Book> listBooks();

    Book getBook(Integer id);

    Book createBook(Book book);
}
