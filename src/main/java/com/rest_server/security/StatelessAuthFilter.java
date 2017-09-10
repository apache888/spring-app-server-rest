package com.rest_server.security;

import com.rest_server.security.service.TokenAuthService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created on 17.08.2017
 *
 * @author Roman Hayda
 */
public class StatelessAuthFilter extends GenericFilterBean {
    private final TokenAuthService tokenAuthService;

    public StatelessAuthFilter(TokenAuthService tokenAuthService) {
        this.tokenAuthService = tokenAuthService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(
                tokenAuthService.getAuthentication((HttpServletRequest) servletRequest));

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
