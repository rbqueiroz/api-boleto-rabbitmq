package br.com.renequeiroz.api.pedidos.exceptions;

public class ErrorAoSalvarException extends BusinessException {

    private static final String mensagemPadrao = "Error ao salvar";

    public ErrorAoSalvarException() {
        super(mensagemPadrao);
    }

    public ErrorAoSalvarException(String message) {
        super(message);
    }

    public ErrorAoSalvarException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorAoSalvarException(Throwable cause) {
        super(mensagemPadrao, cause);
    }
}