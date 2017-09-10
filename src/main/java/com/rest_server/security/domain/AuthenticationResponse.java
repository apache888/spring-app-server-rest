package com.rest_server.security.domain;

/**
 * Created on 27.08.2017
 *
 * @author Roman Hayda
 */
public class AuthenticationResponse {
    private String token;

    public AuthenticationResponse(){}
    public AuthenticationResponse(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
