package com.example.FormularioInscripcion.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Departamento")
public class Departamento {

    @Id
    @Column(name = "Id_Departamento")
    private Integer id;

    @Column(name = "Departamento", nullable = false, length = 100)
    private String departamento;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Pais", referencedColumnName = "Id_Pais", nullable = false)
    private Pais pais;

    public Departamento() { }

    public Departamento(Integer id, String departamento, Pais pais) {
        this.id = id;
        this.departamento = departamento;
        this.pais = pais;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    public Pais getPais() { return pais; }
    public void setPais(Pais pais) { this.pais = pais; }
}
