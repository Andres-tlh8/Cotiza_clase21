package com.devsenior.cotiza.cliente;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByTelefono(String telefono);

    boolean existsByTelefono(String telefono);
}
