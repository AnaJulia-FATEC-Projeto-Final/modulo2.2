package com.anajulia.modulo22.controlador.resposta;

import java.time.LocalDateTime;

public record ErroResposta(
        LocalDateTime date,
        String path,
        Integer status,
        String error,
        String message
) {
}
