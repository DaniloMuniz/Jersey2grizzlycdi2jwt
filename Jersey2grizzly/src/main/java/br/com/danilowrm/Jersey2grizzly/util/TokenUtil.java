/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author washington-muniz
 */
@ApplicationScoped
public class TokenUtil {

    private static final String KEY = "SECRET_TOKEN";

    public static final String TOKEN_HEADER = "Authentication";

    //sete dias...
    public static final long EXPIRATION_TIME = 605000000;

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String HEADER_STRING = "Authorization";

    public static String create(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, KEY)
                .compact();
    }

    public static String decode(String token) {
        return Jwts.parser()
                .setSigningKey(KEY)
                .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                .getBody()
                .getSubject();
    }

}
