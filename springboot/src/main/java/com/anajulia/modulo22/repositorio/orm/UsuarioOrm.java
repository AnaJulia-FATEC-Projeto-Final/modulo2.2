package com.anajulia.modulo22.repositorio.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuario")
public record UsuarioOrm(
        @Id
        String id,
        @Indexed
        String usuario,
        String senha
) {
}
