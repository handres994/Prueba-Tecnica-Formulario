package com.example.FormularioInscripcion.repositorios;

import com.example.FormularioInscripcion.modelos.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepositorio extends JpaRepository<Marca,Integer> {
}
