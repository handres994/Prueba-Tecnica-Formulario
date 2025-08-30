package com.example.FormularioInscripcion.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "Clientes_PorMarca")
public class ClientesPorMarca {

    @EmbeddedId
    private ClientesPorMarcaId id;

    @ManyToOne
    @MapsId("cliente")
    @JoinColumn(name = "Cliente", referencedColumnName = "Id_Cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @MapsId("marca")
    @JoinColumn(name = "Marca", referencedColumnName = "Id_Marca", nullable = false)
    private Marca marca;

    public ClientesPorMarca() {}

    public ClientesPorMarca(Cliente cliente, Marca marca) {
        this.cliente = cliente;
        this.marca = marca;
        this.id = new ClientesPorMarcaId(cliente.getId(), marca.getId());
    }

    public ClientesPorMarcaId getId() {
        return id;
    }

    public void setId(ClientesPorMarcaId id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
