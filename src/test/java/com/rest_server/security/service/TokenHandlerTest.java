package com.rest_server.security.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.HashSet;

/**
 * Created on 17.08.2017
 *
 * @author Roman Hayda
 */
public class TokenHandlerTest {
    @Autowired
    UserDetailsService userDetailsService;
    @Test
    public void generateAdminToken() {
        TokenHandler tokenHandler = new TokenHandler();
        HashSet<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        UserDetails userDetails = new User(
                "admin",
                "admin",
                true, true, true,true,
                authorities
        );
        String token = tokenHandler.generateToken(userDetails);
        System.out.println(token);

        String username = tokenHandler.getUsernameFromToken(token);
        System.out.println(username);
    }

    @Test
    public void generateUserToken() {
        TokenHandler tokenHandler = new TokenHandler();
        HashSet<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        UserDetails userDetails = new User(
                "user",
                "pass",
                true, true, true,true,
                authorities
        );
        String token = tokenHandler.generateToken(userDetails);
        System.out.println(token);

        String username = tokenHandler.getUsernameFromToken(token);
        System.out.println(username);
    }

}