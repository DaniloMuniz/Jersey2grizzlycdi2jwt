/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.resource;

import br.com.danilowrm.Jersey2grizzly.model.Book;
import br.com.danilowrm.Jersey2grizzly.service.BookService;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.ok;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.created;
import static javax.ws.rs.core.Response.noContent;
import static javax.ws.rs.core.Response.serverError;
import static javax.ws.rs.core.Response.status;

import com.google.common.flogger.FluentLogger;
import static com.google.common.flogger.StackSize.SMALL;

/**
 *
 * @author washington-muniz
 */
@RequestScoped
public class BookResourceImpl implements BookResource {

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    @Inject
    BookService bookService;

    @Override
    public Response get(Integer id) {
        logger.atInfo().log("book resource impl begin.");
        List<Book> books = new ArrayList<>();
        try {
            if (id != null) {
                Book book = bookService.getById(id);
                if (book == null) {
                    return noContent().build();
                }
                return ok().entity(book).build();
            }

            books = bookService.getAll();
            if (books == null) {
                return noContent().build();
            }
        } catch (Exception ex) {
            logger.atSevere().withStackTrace(SMALL).log("Fail in service");
            return serverError().entity("Fail in service").build();
        }
        return ok().entity(books).build();

    }

    @Override
    public Response create(Book book) {
        int idBook = 0;
        try {
            idBook = bookService.add(book);
            if (idBook <= 0) {
                return status(BAD_REQUEST).entity("Fail in service").build();
            }
        } catch (Exception ex) {
            logger.atSevere().withStackTrace(SMALL).log("Fail in service");
            return serverError().entity("Fail in service").build();
        }
        URI location = URI.create("/books/" + idBook);
        return created(location).build();
    }

    @Override
    public Response update(Integer id, Book book) {
        try {
            bookService.update(book);
        } catch (Exception ex) {
            logger.atSevere().withStackTrace(SMALL).log("Fail in service");
            return serverError().entity("Fail in service").build();
        }
        return ok().build();
    }

    @Override
    public Response delete(Integer id) {
        try {
            bookService.delete(id);
        } catch (Exception ex) {
            logger.atSevere().withStackTrace(SMALL).log("Fail in service");
            return serverError().entity("Fail in service").build();
        }
        return noContent().build();
    }

}
