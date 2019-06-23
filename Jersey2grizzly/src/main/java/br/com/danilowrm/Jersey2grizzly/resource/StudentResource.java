/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.resource;

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
@Path("v1/students")
public interface StudentResource {

    @GET
    @Produces({MediaType.APPLICATION_JSON + "; chaset=utf8", MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    @Consumes({MediaType.APPLICATION_JSON + "; chaset=utf8", MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    Response get(@PathParam("id") Integer id);

    @POST
    @Consumes({MediaType.APPLICATION_JSON + "; chaset=utf8", MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    Response create();

    @PUT
    @Produces({MediaType.APPLICATION_JSON + "; chaset=utf8", MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    Response update(@PathParam("name") String name);

    @DELETE
    Response delete();

}
