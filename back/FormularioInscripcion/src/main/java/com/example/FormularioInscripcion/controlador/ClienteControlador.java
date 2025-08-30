package com.example.FormularioInscripcion.controladores;

import com.example.FormularioInscripcion.modelos.Cliente;
import com.example.FormularioInscripcion.servicios.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControlador {

    @Autowired
    private ClienteService servicio;

    public static class CrearClienteRequest {
        public Integer tipoIdentificacionId;
        public String  numeroIdentificacion;
        public String  nombres;
        public String  apellidos;
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        public LocalDate fechaNacimiento;
        public String  direccion;
        public Integer paisId;
        public Integer departamentoId;
        public Integer ciudadId;
        public Integer marcaId;
    }

    public static class ClienteResponse {
        public Integer id;
        public String numeroIdentificacion;
        public String nombres;
        public String apellidos;
        public LocalDate fechaNacimiento;
        public String direccion;
        public Integer tipoIdentificacionId;
        public Integer paisId;
        public Integer departamentoId;
        public Integer ciudadId;

        public ClienteResponse(Cliente c) {
            this.id = c.getId();
            this.numeroIdentificacion = c.getNumeroIdentificacion();
            this.nombres = c.getNombres();
            this.apellidos = c.getApellidos();
            this.fechaNacimiento = c.getFechaNacimiento();
            this.direccion = c.getDireccion();
            this.tipoIdentificacionId = c.getTipoDeIdentificacion().getId();
            this.paisId = c.getPais().getId();
            this.departamentoId = c.getDepartamento().getId();
            this.ciudadId = c.getCiudad().getId();
        }
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody CrearClienteRequest r) {
        try {
            Cliente creado = servicio.registrarCliente(
                    r.tipoIdentificacionId,
                    r.numeroIdentificacion,
                    r.nombres,
                    r.apellidos,
                    r.fechaNacimiento,
                    r.direccion,
                    r.paisId,
                    r.departamentoId,
                    r.ciudadId,
                    r.marcaId
            );
            return ResponseEntity.ok(new ClienteResponse(creado));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

