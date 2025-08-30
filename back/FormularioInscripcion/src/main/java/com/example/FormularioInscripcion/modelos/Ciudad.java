package com.example.FormularioInscripcion.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Ciudad")
public class Ciudad {

    @Id
    @Column(name = "Id_Ciudad")
    private Integer id;

    @Column(name = "Ciudad", nullable = false, length = 100)
    private String ciudad;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Departamento", referencedColumnName = "Id_Departamento", nullable = false)
    private Departamento departamento;

    public Ciudad() { }

    public Ciudad(Integer id, String ciudad, Departamento departamento) {
        this.id = id;
        this.ciudad = ciudad;
        this.departamento = departamento;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public Departamento getDepartamento() { return departamento; }
    public void setDepartamento(Departamento departamento) { this.departamento = departamento; }
}

