package ru.pmichael.bookstore.services.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ru.pmichael.bookstore.domain.Book;
import ru.pmichael.bookstore.services.is.IBookRestService;

@Service
public class BookRestService implements IBookRestService {

    private final String resourceURL = "http://localhost:8080/book";
    private final RestTemplate restTemplate;

    public BookRestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Book> listBooks() {
        ResponseEntity<List<Book>> response = restTemplate.exchange(resourceURL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {});
        return response.getBody();
    }

    @Override
    public Book getBook(Integer id) {
        ResponseEntity<Book> response = restTemplate.exchange(resourceURL + "/{id}", HttpMethod.GET, null, new ParameterizedTypeReference<Book>() {}, id);
        return response.getBody();
    }

    @Override
    public Book createBook(Book book) {
        return restTemplate.postForObject(resourceURL, book, Book.class);
    }
}
