package com.example.test_cors.middleware;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
public class JwtAuthFilter implements Filter {
    @Override
    public void doFilter(
            @NonNull ServletRequest servletRequest,
            @NonNull ServletResponse servletResponse,
            @NonNull FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        final String authHeader = request.getHeader("Authorization");

        log.info("authHeader: {}", authHeader);

        if (authHeader == null || !authHeader.startsWith("Bearer ")){
            response.setContentType("application/json");
            response.getWriter().print("{\"error\":\"Invalid token\"}");
            return;
        }
        String jwtToken = authHeader.replace("Bearer ", "");
        log.info("jwtToken: {}", jwtToken);
        filterChain.doFilter(request, response);
    }
//    @Override
//    protected void doFilterInternal(
//            @NonNull HttpServletRequest request,
//            @NonNull HttpServletResponse response,
//            @NonNull FilterChain filterChain) throws ServletException, IOException {
//        final String authHeader = request.getHeader("Authorization");
//
//        if (authHeader == null || !authHeader.startsWith("Bearer ")){
//            response.setContentType("application/json");
//            response.getWriter().print("{\"error\":\"Invalid token\"}");
//            return;
//        }
//
//        filterChain.doFilter(request, response);
//    }
}
