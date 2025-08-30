package com.example.FormularioInscripcion.repositorios;

import com.example.FormularioInscripcion.modelos.ClientesPorMarca;
import com.example.FormularioInscripcion.modelos.ClientesPorMarcaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesPorMarcaRepositorio extends JpaRepository<ClientesPorMarca, ClientesPorMarcaId> {
    boolean existsByCliente_IdAndMarca_Id(Integer clienteId, Integer marcaId);
}


