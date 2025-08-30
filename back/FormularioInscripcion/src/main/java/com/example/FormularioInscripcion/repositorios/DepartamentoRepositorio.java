package com.example.FormularioInscripcion.repositorios;

import com.example.FormularioInscripcion.modelos.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DepartamentoRepositorio extends JpaRepository<Departamento,Integer>{
    List<Departamento> findByPais_Id(Integer paisId);
}
