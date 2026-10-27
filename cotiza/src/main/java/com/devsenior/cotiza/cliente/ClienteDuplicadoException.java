package com.devsenior.cotiza.cliente;

public class ClienteDuplicadoException extends RuntimeException {

    public ClienteDuplicadoException(String telefono) {
        super("El teléfono " + telefono + " ya está registrado");
    }
}
