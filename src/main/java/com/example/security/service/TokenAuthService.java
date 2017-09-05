package com.example.security.service;

import com.example.security.UserAuthentication;
import com.example.security.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 17.08.2017
 *
 * @author Roman Hayda
 */
@Component
public class TokenAuthService {
    private static final String AUTH_HEADER_NAME = "X-Auth-Token";

    @Autowired
    private TokenHandler tokenHandler;
    @Autowired
    private UserService userService;

    public Authentication getAuthentication(HttpServletRequest request) {
        try {
            String token = request.getHeader(AUTH_HEADER_NAME);
            String username = tokenHandler.getUsernameFromToken(token);
            User user = userService.findByUsername(username);
            if (user != null) {
                return new UserAuthentication(user);
            }
            return  null;
        } catch (Exception e) {
            return null;
        }
    }
}
