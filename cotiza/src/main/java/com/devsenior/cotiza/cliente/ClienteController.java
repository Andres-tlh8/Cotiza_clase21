package com.devsenior.cotiza.cliente;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/clientes")
    public ResponseEntity<ClienteResponse> crearCliente(@Valid @RequestBody ClienteRequest request) {
        ClienteResponse response = clienteService.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/clientes")
    public List<ClienteResponse> listarClientes() {
        return clienteService.listar();
    }

    @GetMapping("/clientes/{id}")
    public ClienteResponse buscarCliente(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    @ExceptionHandler(ClienteDuplicadoException.class)
    public ResponseEntity<Map<String, String>> manejarClienteDuplicado(ClienteDuplicadoException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("mensaje", exception.getMessage()));
    }
}
