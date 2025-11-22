package com.anajulia.excecoes;

public class InternalServerExcecao extends RuntimeException {
    public InternalServerExcecao() {
    }

    public InternalServerExcecao(String message) {
        super(message);
    }

    public InternalServerExcecao(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalServerExcecao(Throwable cause) {
        super(cause);
    }
}
