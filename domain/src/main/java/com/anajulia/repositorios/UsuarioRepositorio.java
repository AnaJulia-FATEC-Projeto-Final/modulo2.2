package com.anajulia.repositorios;

import com.anajulia.entidades.Usuario;

public interface UsuarioRepositorio {
    Usuario salvar(Usuario usuario);

    Usuario procurarPorUsuario(String usuarioString);
}
