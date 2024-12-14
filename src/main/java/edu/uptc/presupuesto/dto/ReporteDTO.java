package edu.uptc.presupuesto.dto;

import edu.uptc.presupuesto.model.Reporte.TipoReporte;
import java.time.LocalDateTime;

public class ReporteDTO {
    private Long id;
    private Long usuarioId;
    private TipoReporte tipoReporte;
    private LocalDateTime fechaGeneracion;
    private String rutaArchivo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public TipoReporte getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(TipoReporte tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public LocalDateTime getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDateTime fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public String toString() {
        return "ReporteDTO{" +
                "id=" + id +
                ", usuarioId=" + usuarioId +
                ", tipoReporte=" + tipoReporte +
                ", fechaGeneracion=" + fechaGeneracion +
                ", rutaArchivo='" + rutaArchivo + '\'' +
                '}';
    }
}