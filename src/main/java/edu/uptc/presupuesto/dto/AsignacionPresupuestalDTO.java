package edu.uptc.presupuesto.dto;

import edu.uptc.presupuesto.model.AsignacionPresupuestal.EstadoAsignacion;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AsignacionPresupuestalDTO {
    private Long id;
    private Long rubroId;
    private BigDecimal montoTotal;
    private BigDecimal montoUtilizado;
    private BigDecimal montoDisponible;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private EstadoAsignacion estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRubroId() {
        return rubroId;
    }

    public void setRubroId(Long rubroId) {
        this.rubroId = rubroId;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    public BigDecimal getMontoUtilizado() {
        return montoUtilizado;
    }

    public void setMontoUtilizado(BigDecimal montoUtilizado) {
        this.montoUtilizado = montoUtilizado;
    }

    public BigDecimal getMontoDisponible() {
        return montoDisponible;
    }

    public void setMontoDisponible(BigDecimal montoDisponible) {
        this.montoDisponible = montoDisponible;
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

    public EstadoAsignacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoAsignacion estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "AsignacionPresupuestalDTO{" +
                "id=" + id +
                ", rubroId=" + rubroId +
                ", montoTotal=" + montoTotal +
                ", montoUtilizado=" + montoUtilizado +
                ", montoDisponible=" + montoDisponible +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", estado=" + estado +
                '}';
    }
}