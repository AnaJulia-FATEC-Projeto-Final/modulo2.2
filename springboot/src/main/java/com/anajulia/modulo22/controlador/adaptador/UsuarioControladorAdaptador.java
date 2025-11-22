package com.anajulia.modulo22.controlador.adaptador;

import com.anajulia.entidades.Usuario;
import com.anajulia.modulo22.controlador.requisicao.LoginRequisicao;
import java.util.UUID;

public class UsuarioControladorAdaptador {
    private UsuarioControladorAdaptador() {
    }

    public static Usuario cast(LoginRequisicao request) {
        return new Usuario(
                UUID.randomUUID().toString(),
                request.usuario(),
                request.senha()
        );
    }
}