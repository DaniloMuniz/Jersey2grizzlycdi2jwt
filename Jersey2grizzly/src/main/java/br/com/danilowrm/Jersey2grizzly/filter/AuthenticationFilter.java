/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.filter;

import br.com.danilowrm.Jersey2grizzly.util.TokenUtil;
import com.google.common.flogger.FluentLogger;
import java.io.IOException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.server.ContainerRequest;

/**
 *
 * @author washington-muniz
 */
@Provider
public class AuthenticationFilter implements ContainerRequestFilter {

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String method = requestContext.getMethod().toLowerCase();
        String path = ((ContainerRequest) requestContext).getPath(true).toLowerCase();

        if (path.contains("application.wadl") || path.contains("login")) {
            return;
        }

        String authorizationHeader = ((ContainerRequest) requestContext).getHeaderString("authorization");
        if (authorizationHeader == null || (!authorizationHeader.contains("Bearer "))) {
            throw new WebApplicationException(UNAUTHORIZED);
        }

        String subject = TokenUtil.decode(authorizationHeader);
        if (subject == null || (subject.isEmpty())) {
            logger.atInfo().log(subject);
            throw new WebApplicationException(UNAUTHORIZED);
        }
    }

}
