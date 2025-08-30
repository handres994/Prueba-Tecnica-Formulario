package com.example.FormularioInscripcion.repositorios;

import com.example.FormularioInscripcion.modelos.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByTipoDeIdentificacion_IdAndNumeroIdentificacion(Integer tipoId, String numero);
}
