package com.example.FormularioInscripcion.repositorios;

import com.example.FormularioInscripcion.modelos.TipoDeIdentificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDeIdentificacionRepositorio extends JpaRepository<TipoDeIdentificacion,Integer> {
}
