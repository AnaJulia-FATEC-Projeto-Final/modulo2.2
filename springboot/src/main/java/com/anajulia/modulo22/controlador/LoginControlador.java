package com.anajulia.modulo22.controlador;

import com.anajulia.entidades.Token;
import com.anajulia.modulo22.controlador.adaptador.UsuarioControladorAdaptador;
import com.anajulia.modulo22.controlador.requisicao.LoginRequisicao;
import com.anajulia.modulo22.controlador.resposta.LoginResposta;
import com.anajulia.modulo22.seguranca.TokenSeguranca;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/anajulia/modulo2.2/v1")
public class LoginControlador {
    private final TokenSeguranca tokenSecurity;

    public LoginControlador(
            TokenSeguranca tokenSecurity
    ) {
        this.tokenSecurity = tokenSecurity;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public LoginResposta login(@RequestBody LoginRequisicao request) {
        Token token = tokenSecurity.generateToken(UsuarioControladorAdaptador.cast(request));
        return new LoginResposta(token.value());
    }
}