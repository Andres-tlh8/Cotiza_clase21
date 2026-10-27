package com.devsenior.cotiza.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ClienteRequest(
        @NotBlank(message = "El nombre es obligatorio")
        @Size(max = 120, message = "El nombre no puede exceder 120 caracteres")
        String nombre,

        @NotBlank(message = "El teléfono es obligatorio")
        @Pattern(regexp = "^[0-9]{10}$", message = "El teléfono debe tener 10 dígitos")
        String telefono,

        @Email(message = "El correo no es válido")
        @Size(max = 120, message = "El correo no puede exceder 120 caracteres")
        String correo
) {
    public ClienteRequest {
        if (nombre != null) {
            nombre = nombre.trim();
        }
        if (telefono != null) {
            telefono = telefono.trim();
        }
        if (correo != null) {
            correo = correo.trim();
        }
    }
}
