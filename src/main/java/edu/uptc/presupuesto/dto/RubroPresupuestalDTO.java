package edu.uptc.presupuesto.dto;

import edu.uptc.presupuesto.model.RubroPresupuestal.EstadoRubro;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class RubroPresupuestalDTO {
    private Long id;

    @NotNull(message = "El nombre es obligatorio")
    private String nombre;

    @NotNull(message = "El presupuesto total es obligatorio")
    private BigDecimal presupuestoTotal;

    private BigDecimal presupuestoEjecutado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private EstadoRubro estado;
    private BigDecimal porcentajeEjecucion;

    // Constructors
    public RubroPresupuestalDTO() {}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPresupuestoTotal() {
        return presupuestoTotal;
    }

    public void setPresupuestoTotal(BigDecimal presupuestoTotal) {
        this.presupuestoTotal = presupuestoTotal;
    }

    public BigDecimal getPresupuestoEjecutado() {
        return presupuestoEjecutado;
    }

    public void setPresupuestoEjecutado(BigDecimal presupuestoEjecutado) {
        this.presupuestoEjecutado = presupuestoEjecutado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public EstadoRubro getEstado() {
        return estado;
    }

    public void setEstado(EstadoRubro estado) {
        this.estado = estado;
    }

    public BigDecimal getPorcentajeEjecucion() {
        return porcentajeEjecucion;
    }

    public void setPorcentajeEjecucion(BigDecimal porcentajeEjecucion) {
        this.porcentajeEjecucion = porcentajeEjecucion;
    }

    // toString method
    @Override
    public String toString() {
        return "RubroPresupuestalDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", presupuestoTotal=" + presupuestoTotal +
                ", presupuestoEjecutado=" + presupuestoEjecutado +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", estado=" + estado +
                ", porcentajeEjecucion=" + porcentajeEjecucion +
                '}';
    }
}