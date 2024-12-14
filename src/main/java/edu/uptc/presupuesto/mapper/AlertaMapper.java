package edu.uptc.presupuesto.mapper;

import edu.uptc.presupuesto.dto.AlertaDTO;
import edu.uptc.presupuesto.model.Alerta;
import org.springframework.stereotype.Component;

@Component
public class AlertaMapper {
    public AlertaDTO toDTO(Alerta alerta) {
        AlertaDTO dto = new AlertaDTO();
        dto.setId(alerta.getId());
        dto.setAsignacionId(alerta.getAsignacion().getId());
        dto.setTipoAlerta(alerta.getTipoAlerta());
        dto.setDescripcion(alerta.getDescripcion());
        dto.setFechaCreacion(alerta.getFechaCreacion());
        dto.setLeida(alerta.isLeida());
        return dto;
    }

    public Alerta toEntity(AlertaDTO dto) {
        Alerta alerta = new Alerta();
        alerta.setId(dto.getId());
        alerta.setTipoAlerta(dto.getTipoAlerta());
        alerta.setDescripcion(dto.getDescripcion());
        alerta.setFechaCreacion(dto.getFechaCreacion());
        alerta.setLeida(dto.isLeida());
        return alerta;
    }
}