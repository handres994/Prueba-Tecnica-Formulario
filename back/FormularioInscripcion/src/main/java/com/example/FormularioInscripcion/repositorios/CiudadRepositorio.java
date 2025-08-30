package com.example.FormularioInscripcion.repositorios;

import com.example.FormularioInscripcion.modelos.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CiudadRepositorio extends JpaRepository<Ciudad,Integer> {
    List<Ciudad> findByDepartamento_Id(Integer departamentoId);
}
