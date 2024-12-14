package edu.uptc.presupuesto.dto;

import edu.uptc.presupuesto.model.Alerta.TipoAlerta;
import java.time.LocalDateTime;

public class AlertaDTO {
    private Long id;
    private Long asignacionId;
    private TipoAlerta tipoAlerta;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private boolean leida;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAsignacionId() {
        return asignacionId;
    }

    public void setAsignacionId(Long asignacionId) {
        this.asignacionId = asignacionId;
    }

    public TipoAlerta getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(TipoAlerta tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isLeida() {
        return leida;
    }

    public void setLeida(boolean leida) {
        this.leida = leida;
    }

    @Override
    public String toString() {
        return "AlertaDTO{" +
                "id=" + id +
                ", asignacionId=" + asignacionId +
                ", tipoAlerta=" + tipoAlerta +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", leida=" + leida +
                '}';
    }
}