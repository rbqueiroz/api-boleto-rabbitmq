package br.com.renequeiroz.api.pedidos.exceptions;

import java.io.Serial;

public class ClienteNaoEncontradoException extends BusinessException {

    private static final String mensagemPadrao = "Cliente não encontrado";

    public ClienteNaoEncontradoException() {
        super(mensagemPadrao);
    }

    public ClienteNaoEncontradoException(String message) {
        super(message);
    }

    public ClienteNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClienteNaoEncontradoException(Throwable cause) {
        super(mensagemPadrao, cause);
    }
}