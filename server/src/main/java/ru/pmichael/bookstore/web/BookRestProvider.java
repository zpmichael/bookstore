package ru.pmichael.bookstore.web;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

import ru.pmichael.bookstore.domain.Book;
import ru.pmichael.bookstore.services.is.IBookService;

@Path("/book")
@Component
public class BookRestProvider {

    private final IBookService bookService;

    public BookRestProvider(IBookService bookService) {
        this.bookService = bookService;
    }

    @GET
    @Produces("application/json")
    public List<Book> listBooks() {
        return bookService.listBooks();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Book getBook(@PathParam("id") Integer id) {
        return bookService.findBookById(id);
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Book createBook(Book book) {
        return bookService.createBook(book);
    }
}
