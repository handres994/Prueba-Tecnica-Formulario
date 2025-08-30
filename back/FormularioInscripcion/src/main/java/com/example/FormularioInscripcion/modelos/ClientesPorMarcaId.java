package com.example.FormularioInscripcion.modelos;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClientesPorMarcaId implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer cliente;
    private Integer marca;

    public ClientesPorMarcaId() {}

    public ClientesPorMarcaId(Integer cliente, Integer marca) {
        this.cliente = cliente;
        this.marca = marca;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public Integer getMarca() {
        return marca;
    }

    public void setMarca(Integer marca) {
        this.marca = marca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientesPorMarcaId)) return false;
        ClientesPorMarcaId that = (ClientesPorMarcaId) o;
        return Objects.equals(cliente, that.cliente) &&
                Objects.equals(marca, that.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente, marca);
    }
}


