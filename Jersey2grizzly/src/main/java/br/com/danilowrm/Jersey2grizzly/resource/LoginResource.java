/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.resource;

import br.com.danilowrm.Jersey2grizzly.model.User;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author washington-muniz
 */
@Path("v1/login")
public interface LoginResource {

    @POST
    @Consumes({MediaType.APPLICATION_JSON + "; chaset=utf8", MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    Response login(User user);

    @GET
    @Path("reflesh")
    @Produces({MediaType.APPLICATION_JSON + "; chaset=utf8", MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    Response reflesh(@Context HttpServletRequest httpServletRequest);

}
