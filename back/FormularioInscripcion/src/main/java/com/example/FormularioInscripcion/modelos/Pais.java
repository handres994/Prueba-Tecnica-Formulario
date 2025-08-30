package com.example.FormularioInscripcion.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Pais")
public class Pais {

    @Id
    @Column(name = "Id_Pais")
    private Integer id;

    @Column(name = "Pais", nullable = false, length = 100)
    private String pais;

    public Pais() { }

    public Pais(Integer id, String pais) {
        this.id = id;
        this.pais = pais;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
}
