package com.anajulia.modulo22.controlador.advice;

import com.anajulia.excecoes.BadRequestExcecao;
import com.anajulia.excecoes.InternalServerExcecao;
import com.anajulia.excecoes.NotFoundExcecao;
import com.anajulia.modulo22.controlador.resposta.ErroResposta;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class RestExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ResponseBody
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler({InternalServerExcecao.class, Exception.class})
    public ErroResposta handleInternalServerError(
            Exception exception,
            HttpServletRequest request
    ) {
        LOG.error("500: ", exception);

        return new ErroResposta(
                LocalDateTime.now(),
                request.getServletPath(),
                INTERNAL_SERVER_ERROR.value(),
                INTERNAL_SERVER_ERROR.getReasonPhrase(),
                exception.getMessage()
        );
    }

    @ResponseBody
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler({NotFoundExcecao.class, NoResourceFoundException.class})
    public ErroResposta handleNotFoundError(
            NotFoundExcecao exception,
            HttpServletRequest request
    ) {
        LOG.error("404: ", exception);

        return new ErroResposta(
                LocalDateTime.now(),
                request.getServletPath(),
                NOT_FOUND.value(),
                NOT_FOUND.getReasonPhrase(),
                exception.getMessage()
        );
    }

    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({BadRequestExcecao.class, MethodArgumentNotValidException.class})
    public ErroResposta handleBadRequest(
            BadRequestExcecao exception,
            HttpServletRequest request
    ) {
        LOG.error("400: ", exception);

        return new ErroResposta(
                LocalDateTime.now(),
                request.getServletPath(),
                BAD_REQUEST.value(),
                BAD_REQUEST.getReasonPhrase(),
                exception.getMessage()
        );
    }
}