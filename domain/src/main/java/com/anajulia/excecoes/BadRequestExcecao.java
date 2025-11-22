package com.anajulia.excecoes;

public class BadRequestExcecao extends RuntimeException {
    public BadRequestExcecao() {
    }

    public BadRequestExcecao(String message) {
        super(message);
    }

    public BadRequestExcecao(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestExcecao(Throwable cause) {
        super(cause);
    }
}
