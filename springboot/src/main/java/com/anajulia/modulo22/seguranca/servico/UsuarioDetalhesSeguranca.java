package com.anajulia.modulo22.seguranca.servico;

import com.anajulia.entidades.Usuario;
import com.anajulia.modulo22.seguranca.dto.AutenticacaoUsuarioDetalhes;
import com.anajulia.repositorios.UsuarioRepositorio;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetalhesSeguranca implements UserDetailsService {
    private final UsuarioRepositorio repositorio;

    public UsuarioDetalhesSeguranca(UsuarioRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public UserDetails loadUserByUsername(String usuarioString) throws UsernameNotFoundException {
        Usuario usuario = repositorio.procurarPorUsuario(usuarioString);

        return new AutenticacaoUsuarioDetalhes(usuario);
    }
}
