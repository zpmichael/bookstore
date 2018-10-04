package ru.pmichael.bookstore;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import ru.pmichael.bookstore.web.BookRestProvider;

@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(BookRestProvider.class);
    }
}
