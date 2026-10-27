package com.devsenior.cotiza.cliente;

import java.time.LocalDateTime;

public record ClienteResponse(
        Long id,
        String nombre,
        String telefono,
        String correo,
        LocalDateTime fechaCreacion
) {
    public static ClienteResponse fromEntity(Cliente cliente) {
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getTelefono(),
                cliente.getCorreo(),
                cliente.getFechaCreacion()
        );
    }
}
