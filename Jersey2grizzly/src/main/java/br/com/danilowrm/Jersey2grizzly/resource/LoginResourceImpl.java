/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.resource;

import br.com.danilowrm.Jersey2grizzly.model.User;
import br.com.danilowrm.Jersey2grizzly.util.TokenUtil;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;
import static javax.ws.rs.core.Response.ok;
import static javax.ws.rs.core.Response.status;

/**
 *
 * @author washington-muniz
 */
public class LoginResourceImpl implements LoginResource {
    
    @Context 
    private HttpServletRequest httpServletRequest;

    @Override
    public Response login(User user) {
        if (user.getUsername().equals("test") && user.getPassword().equals("123abcde")) {
            Map<String, Object> token = new HashMap<>();
            token.put("token", TokenUtil.create(user.getUsername()));
            return ok().entity(token).build();
        }
        throw new NotAuthorizedException(status(UNAUTHORIZED).build());
    }

    @Override
    public Response reflesh(HttpServletRequest httpServletRequest) {
        String paramResquestToken = httpServletRequest.getHeader(TokenUtil.TOKEN_HEADER);
        String subject = TokenUtil.decode(paramResquestToken);
        if (subject != null && !subject.isEmpty()) {
            return status(UNAUTHORIZED).build();
        }
        Map<String, Object> token = new HashMap<>();
        token.put("token", TokenUtil.create(subject));
        return ok().entity(token).build();
    }

}
