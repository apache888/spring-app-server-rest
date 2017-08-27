package com.example.controller;

import com.example.security.domain.AuthenticationRequest;
import com.example.security.domain.AuthenticationResponse;
import com.example.security.domain.User;
import com.example.security.service.TokenHandler;
import com.example.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 25.08.2017
 *
 * @author Roman Hayda
 */
@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private TokenHandler tokenHandler;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> authenticateRequest(@RequestBody AuthenticationRequest authenticationRequest){

        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDetails, authenticationRequest.getPassword(), userDetails.getAuthorities()
                )
        );
        if(authentication.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        String token = tokenHandler.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

    @PostMapping(value = "/registration", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity registration(@RequestBody AuthenticationRequest authenticationRequest){
        User user = new User();
        user.setUsername(authenticationRequest.getUsername());
        user.setPassword(authenticationRequest.getPassword());
        userService.save(user);
        //
        System.out.println(user);
        System.out.println(userService.findByUsername(user.getUsername()));
        return ResponseEntity.ok().build();
    }
}
