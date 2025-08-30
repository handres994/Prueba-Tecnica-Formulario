package com.example.FormularioInscripcion.servicios;

import com.example.FormularioInscripcion.modelos.*;
import com.example.FormularioInscripcion.repositorios.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogoService {

    private final TipoDeIdentificacionRepositorio tipoRepo;
    private final PaisRepositorio paisRepo;
    private final DepartamentoRepositorio deptoRepo;
    private final CiudadRepositorio ciudadRepo;
    private final MarcaRepositorio marcaRepo;

    public CatalogoService(TipoDeIdentificacionRepositorio tipoRepo,
                           PaisRepositorio paisRepo,
                           DepartamentoRepositorio deptoRepo,
                           CiudadRepositorio ciudadRepo,
                           MarcaRepositorio marcaRepo) {
        this.tipoRepo = tipoRepo;
        this.paisRepo = paisRepo;
        this.deptoRepo = deptoRepo;
        this.ciudadRepo = ciudadRepo;
        this.marcaRepo = marcaRepo;
    }

    public List<TipoDeIdentificacion> tipos() { return tipoRepo.findAll(); }
    public List<Pais> paises() { return paisRepo.findAll(); }
    public List<Marca> marcas() { return marcaRepo.findAll(); }

    public List<Departamento> departamentos(Integer paisId) {
        return (paisId == null) ? deptoRepo.findAll() : deptoRepo.findByPais_Id(paisId);
    }

    public List<Ciudad> ciudades(Integer departamentoId) {
        return (departamentoId == null) ? ciudadRepo.findAll() : ciudadRepo.findByDepartamento_Id(departamentoId);
    }
}
