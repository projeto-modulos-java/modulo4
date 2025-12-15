package com.projetos.pedido.services.exceptions;

public class PedidoException extends Exception {
    private final String message;

    public PedidoException(String message) {
        this.message = message;
    }

    public PedidoException(String arg0, String message) {
        super(arg0);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
