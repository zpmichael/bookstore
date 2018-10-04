package ru.pmichael.bookstore.services.is;

import java.util.List;

import ru.pmichael.bookstore.domain.Book;

public interface IBookService {

    List<Book> listBooks();

    Book findBookById(Integer id);

    Book createBook(Book book);
}
