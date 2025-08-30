package com.example.FormularioInscripcion.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Tipo_Identificacion")
public class TipoDeIdentificacion {

    @Id
    @Column(name = "Id_Identificacion")
    private Integer id;

    @Column(name = "Tipo", nullable = false, length = 50)
    private String tipo;

    public TipoDeIdentificacion() { }

    public TipoDeIdentificacion(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
