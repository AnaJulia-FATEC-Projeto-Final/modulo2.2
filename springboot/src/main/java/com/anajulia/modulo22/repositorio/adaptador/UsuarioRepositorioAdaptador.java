package com.anajulia.modulo22.repositorio.adaptador;

import com.anajulia.entidades.Usuario;
import com.anajulia.modulo22.repositorio.orm.UsuarioOrm;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UsuarioRepositorioAdaptador {
    private UsuarioRepositorioAdaptador() {
    }

    public static Usuario cast(UsuarioOrm orm, PasswordEncoder passwordEncoder) {
        return new Usuario(
                orm.id(),
                orm.usuario(),
                passwordEncoder.encode(orm.senha())
        );
    }

    public static UsuarioOrm cast(Usuario user) {
        return new UsuarioOrm(
                user.id(),
                user.usuario(),
                user.senha()
        );
    }
}