package com.anajulia.excecoes;

public class NotFoundExcecao extends RuntimeException {
    public NotFoundExcecao() {
    }

    public NotFoundExcecao(String message) {
        super(message);
    }

    public NotFoundExcecao(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundExcecao(Throwable cause) {
        super(cause);
    }
}
