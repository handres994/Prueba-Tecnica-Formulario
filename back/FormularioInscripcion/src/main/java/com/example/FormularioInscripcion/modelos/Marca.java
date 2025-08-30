package com.example.FormularioInscripcion.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Marca")
public class Marca {

    @Id
    @Column(name = "Id_Marca")
    private Integer id;

    @Column(name = "Marca", nullable = false, length = 100)
    private String marca;

    public Marca() { }

    public Marca(Integer id, String marca) {
        this.id = id;
        this.marca = marca;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
}
