package com.example.FormularioInscripcion.repositorios;

import com.example.FormularioInscripcion.modelos.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepositorio extends JpaRepository<Pais,Integer> {
}
