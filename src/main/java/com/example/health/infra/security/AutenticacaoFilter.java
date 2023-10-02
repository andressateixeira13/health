package com.example.health.infra.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class AutenticacaoFilter extends OncePerRequestFilter {

    private final TokenServiceJWT tokenServiceJWT;
    private final AutenticacaoSerivce autenticacaoSerivce;
    public AutenticacaoFilter(TokenServiceJWT tokenServiceJWT, AutenticacaoSerivce autenticacaoSerivce){
        this.tokenServiceJWT = tokenServiceJWT;
        this.autenticacaoSerivce = autenticacaoSerivce;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println("Filtro para autenticação e autorização");

        String tokenJWT = recuperarToken(request);
        System.out.println("tokenJWT:"+tokenJWT);
        //Se não existir token na requisição o SecurityConfig deverá bloquear
        if(tokenJWT != null){
            String subject = this.tokenServiceJWT.getSubject(tokenJWT);
            System.out.println("Login da req. "+subject);

            UserDetails userDetails = this.autenticacaoSerivce.loadUserByUsername(subject);
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(request, response);
    }
    private String recuperarToken(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if(token != null){
            return token.replace("Bearer","").trim();
        }
        return null;
    }
}
