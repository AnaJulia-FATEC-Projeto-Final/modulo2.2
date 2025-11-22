package com.anajulia.modulo22.repositorio;

import com.anajulia.entidades.Usuario;
import com.anajulia.excecoes.NotFoundExcecao;
import com.anajulia.modulo22.repositorio.adaptador.UsuarioRepositorioAdaptador;
import com.anajulia.modulo22.repositorio.client.UsuarioRepositorioComMongodb;
import com.anajulia.modulo22.repositorio.orm.UsuarioOrm;
import com.anajulia.repositorios.UsuarioRepositorio;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UsuarioRepositorioImpl implements UsuarioRepositorio {
    private final PasswordEncoder encoder;
    private final UsuarioRepositorioComMongodb repositorio;

    public UsuarioRepositorioImpl(
            PasswordEncoder encoder,
            UsuarioRepositorioComMongodb repositorio
    ) {
        this.encoder = encoder;
        this.repositorio = repositorio;
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        try {
            UsuarioOrm orm = repositorio.save(UsuarioRepositorioAdaptador.cast(usuario));

            return UsuarioRepositorioAdaptador.cast(orm, encoder);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Usuario procurarPorUsuario(String usuarioString) {
        try {
            Optional<UsuarioOrm> usuario = repositorio.findByUsuario(usuarioString);

            if (usuario.isEmpty()) {
                throw new NotFoundExcecao("Usuario e/ou senha invalidos");
            }

            return UsuarioRepositorioAdaptador.cast(usuario.get(), encoder);
        } catch (NotFoundExcecao ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
