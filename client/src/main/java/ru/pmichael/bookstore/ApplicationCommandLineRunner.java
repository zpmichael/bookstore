package ru.pmichael.bookstore;

import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ru.pmichael.bookstore.domain.Book;
import ru.pmichael.bookstore.services.is.IBookRestService;

@Component
public class ApplicationCommandLineRunner implements CommandLineRunner {

    private final IBookRestService bookRestService;

    public ApplicationCommandLineRunner(IBookRestService bookRestService) {
        this.bookRestService = bookRestService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length > 0) {
            String command = args[0];
            switch (command) {
                case "list": {
                    for (Book book : bookRestService.listBooks()) {
                        System.out.println(book);
                    }
                    break;
                }
                case "get": {
                    Integer bookId = Integer.valueOf(args[1]);
                    Book book = bookRestService.getBook(bookId);
                    System.out.println(book);
                    break;
                }
                case "save": {
                    String bookName = StringUtils.join(Arrays.copyOfRange(args, 1, args.length), " ");
                    Book created = bookRestService.createBook(new Book(bookName));
                    System.out.println(created);
                    break;
                }
            }
        }
    }
}
