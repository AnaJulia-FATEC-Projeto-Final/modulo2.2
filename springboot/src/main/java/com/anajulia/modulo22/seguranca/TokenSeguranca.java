package com.anajulia.modulo22.seguranca;

import com.anajulia.entidades.Token;
import com.anajulia.entidades.Usuario;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class TokenSeguranca {
    private final JwtSeguranca jwtSecurity;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;

    public TokenSeguranca(
            JwtSeguranca jwtSecurity,
            UserDetailsService userDetailsService,
            AuthenticationManager authenticationManager
    ) {
        this.jwtSecurity = jwtSecurity;
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
    }

    public Token generateToken(Usuario usuario) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                usuario.usuario(), usuario.senha()
        );
        authenticationManager.authenticate(authToken);
        UserDetails userDetails = userDetailsService.loadUserByUsername(usuario.usuario());

        return new Token(jwtSecurity.generateToken(userDetails));
    }
}