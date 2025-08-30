package com.example.FormularioInscripcion.modelos;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Cliente", uniqueConstraints = @UniqueConstraint(columnNames = {"Tipo_Identificacion","Numero_Identificacion"}))
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Cliente")
    private Integer id;

    @Column(name = "Numero_Identificacion", nullable = false, length = 30)
    private String numeroIdentificacion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Tipo_Identificacion", referencedColumnName = "Id_Identificacion", nullable = false)
    private TipoDeIdentificacion tipoDeIdentificacion;

    @Column(name = "Nombres", nullable = false, length = 100)
    private String nombres;

    @Column(name = "Apellidos", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "Fecha_Nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "Direccion", nullable = false, length = 200)
    private String direccion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Pais", referencedColumnName = "Id_Pais", nullable = false)
    private Pais pais;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Departamento", referencedColumnName = "Id_Departamento", nullable = false)
    private Departamento departamento;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Ciudad", referencedColumnName = "Id_Ciudad", nullable = false)
    private Ciudad ciudad;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ClientesPorMarca> clienteMarcas = new HashSet<>();

    public Cliente() {
    }

    public Cliente(Integer id, String numeroIdentificacion, TipoDeIdentificacion tipoDeIdentificacion, String nombres, String apellidos, LocalDate fechaNacimiento, String direccion, Pais pais, Departamento departamento, Ciudad ciudad, Set<ClientesPorMarca> clienteMarcas) {
        this.id = id;
        this.numeroIdentificacion = numeroIdentificacion;
        this.tipoDeIdentificacion = tipoDeIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.pais = pais;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.clienteMarcas = clienteMarcas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public TipoDeIdentificacion getTipoDeIdentificacion() {
        return tipoDeIdentificacion;
    }

    public void setTipoDeIdentificacion(TipoDeIdentificacion tipoDeIdentificacion) {
        this.tipoDeIdentificacion = tipoDeIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Set<ClientesPorMarca> getClienteMarcas() {
        return clienteMarcas;
    }

    public void setClienteMarcas(Set<ClientesPorMarca> clienteMarcas) {
        this.clienteMarcas = clienteMarcas;
    }
}
