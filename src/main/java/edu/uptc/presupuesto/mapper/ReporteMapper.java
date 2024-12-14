package edu.uptc.presupuesto.mapper;

import edu.uptc.presupuesto.dto.ReporteDTO;
import edu.uptc.presupuesto.model.Reporte;
import org.springframework.stereotype.Component;

@Component
public class ReporteMapper {
    public ReporteDTO toDTO(Reporte reporte) {
        ReporteDTO dto = new ReporteDTO();
        dto.setId(reporte.getId());
        dto.setUsuarioId(reporte.getUsuario().getId());
        dto.setTipoReporte(reporte.getTipoReporte());
        dto.setFechaGeneracion(reporte.getFechaGeneracion());
        dto.setRutaArchivo(reporte.getRutaArchivo());
        return dto;
    }

    public Reporte toEntity(ReporteDTO dto) {
        Reporte reporte = new Reporte();
        reporte.setId(dto.getId());
        reporte.setTipoReporte(dto.getTipoReporte());
        reporte.setFechaGeneracion(dto.getFechaGeneracion());
        reporte.setRutaArchivo(dto.getRutaArchivo());
        return reporte;
    }
}