package com.devsenior.cotiza.cliente;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteResponse crear(ClienteRequest request) {
        String telefono = request.telefono();

        if (clienteRepository.existsByTelefono(telefono)) {
            throw new ClienteDuplicadoException(telefono);
        }

        Cliente cliente = new Cliente(request.nombre(), telefono, request.correo());
        Cliente guardado = clienteRepository.save(cliente);
        return ClienteResponse.fromEntity(guardado);
    }

    public List<ClienteResponse> listar() {
        return clienteRepository.findAll().stream()
                .map(ClienteResponse::fromEntity)
                .toList();
    }

    public ClienteResponse buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));
        return ClienteResponse.fromEntity(cliente);
    }
}
