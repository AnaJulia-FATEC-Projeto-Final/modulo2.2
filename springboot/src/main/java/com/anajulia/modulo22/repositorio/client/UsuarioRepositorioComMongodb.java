package com.anajulia.modulo22.repositorio.client;

import com.anajulia.modulo22.repositorio.orm.UsuarioOrm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepositorioComMongodb extends MongoRepository<UsuarioOrm, String> {
    Optional<UsuarioOrm> findByUsuario(String usuario);
}
