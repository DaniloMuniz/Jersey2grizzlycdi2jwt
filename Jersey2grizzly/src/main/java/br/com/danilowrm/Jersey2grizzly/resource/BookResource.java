/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.resource;

import br.com.danilowrm.Jersey2grizzly.model.Book;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author washington-muniz
 */
@Path("v1/books")
public interface BookResource {

    @GET
    @Produces({MediaType.APPLICATION_JSON + "; chaset=utf8", MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    @Path("{id}")
    Response get(@PathParam("id") Integer id);

    @POST
    @Consumes({MediaType.APPLICATION_JSON + "; chaset=utf8", MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    Response create(Book book);

    @PUT
    @Produces({MediaType.APPLICATION_JSON + "; chaset=utf8", MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    @Path("{id}")
    Response update(@PathParam("id") Integer id, Book book);

    @DELETE
    @Path("{id}")
    Response delete(@PathParam("id") Integer id);

}
