package com.example.FormularioInscripcion.servicios;

import com.example.FormularioInscripcion.modelos.*;
import com.example.FormularioInscripcion.repositorios.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class ClienteService {

    private final ClienteRepositorio clienteRepo;
    private final TipoDeIdentificacionRepositorio tipoRepo;
    private final PaisRepositorio paisRepo;
    private final DepartamentoRepositorio deptoRepo;
    private final CiudadRepositorio ciudadRepo;
    private final MarcaRepositorio marcaRepo;
    private final ClientesPorMarcaRepositorio cpmRepo;

    public ClienteService(ClienteRepositorio clienteRepo,
                          TipoDeIdentificacionRepositorio tipoRepo,
                          PaisRepositorio paisRepo,
                          DepartamentoRepositorio deptoRepo,
                          CiudadRepositorio ciudadRepo,
                          MarcaRepositorio marcaRepo,
                          ClientesPorMarcaRepositorio cpmRepo) {
        this.clienteRepo = clienteRepo;
        this.tipoRepo = tipoRepo;
        this.paisRepo = paisRepo;
        this.deptoRepo = deptoRepo;
        this.ciudadRepo = ciudadRepo;
        this.marcaRepo = marcaRepo;
        this.cpmRepo = cpmRepo;
    }

    @Transactional
    public Cliente registrarCliente(Integer tipoId,
                                    String numeroIdentificacion,
                                    String nombres,
                                    String apellidos,
                                    LocalDate fechaNacimiento,
                                    String direccion,
                                    Integer paisId,
                                    Integer departamentoId,
                                    Integer ciudadId,
                                    Integer marcaId) {

        TipoDeIdentificacion tipo = tipoRepo.getReferenceById(tipoId);
        Pais pais = paisRepo.getReferenceById(paisId);
        Departamento departamento = deptoRepo.getReferenceById(departamentoId);
        Ciudad ciudad = ciudadRepo.getReferenceById(ciudadId);
        Marca marca = marcaRepo.getReferenceById(marcaId);

        Cliente cliente = clienteRepo
                .findByTipoDeIdentificacion_IdAndNumeroIdentificacion(tipoId, numeroIdentificacion)
                .orElse(null);

        if (cliente == null) {
            cliente = new Cliente();
            cliente.setTipoDeIdentificacion(tipo);
            cliente.setNumeroIdentificacion(numeroIdentificacion);
            cliente.setNombres(nombres);
            cliente.setApellidos(apellidos);
            cliente.setFechaNacimiento(fechaNacimiento);
            cliente.setDireccion(direccion);
            cliente.setPais(pais);
            cliente.setDepartamento(departamento);
            cliente.setCiudad(ciudad);
            cliente = clienteRepo.save(cliente);
        }

        boolean yaFidelizado = cpmRepo.existsByCliente_IdAndMarca_Id(cliente.getId(), marcaId);
        if (!yaFidelizado) {
            ClientesPorMarca relacion = new ClientesPorMarca(cliente, marca);
            cpmRepo.save(relacion);
        }

        return cliente;
    }

}

