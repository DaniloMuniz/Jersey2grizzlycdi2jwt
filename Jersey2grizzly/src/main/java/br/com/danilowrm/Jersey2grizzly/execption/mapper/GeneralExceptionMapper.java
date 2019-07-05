/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.execption.mapper;

import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author washington-muniz
 */
@Provider
public class GeneralExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {

        return Response
                .status(INTERNAL_SERVER_ERROR)
                .type("application/text")
                .entity(exception.getMessage())
                .build();

    }

}
