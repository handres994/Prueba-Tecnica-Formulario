package com.example.FormularioInscripcion.controlador;

import com.example.FormularioInscripcion.modelos.Ciudad;
import com.example.FormularioInscripcion.modelos.Departamento;
import com.example.FormularioInscripcion.modelos.Marca;
import com.example.FormularioInscripcion.modelos.Pais;
import com.example.FormularioInscripcion.modelos.TipoDeIdentificacion;
import com.example.FormularioInscripcion.servicios.CatalogoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalogos")
public class CatalogoControlador {

    private final CatalogoService service;

    public CatalogoControlador(CatalogoService service) {
        this.service = service;
    }

    @GetMapping("/tipos-identificacion")
    public List<TipoDeIdentificacion> tiposIdentificacion() {
        return service.tipos();
    }

    @GetMapping("/paises")
    public List<Pais> paises() {
        return service.paises();
    }

    @GetMapping("/departamentos")
    public List<Departamento> departamentos(@RequestParam(required = false) Integer paisId) {
        return service.departamentos(paisId);
    }

    @GetMapping("/ciudades")
    public List<Ciudad> ciudades(@RequestParam(name = "departamentoId", required = false) Integer departamentoId) {
        return service.ciudades(departamentoId);
    }

    @GetMapping("/marcas")
    public List<Marca> marcas() {
        return service.marcas();
    }
}
