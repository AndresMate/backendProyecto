package edu.uptc.presupuesto.controller;

import edu.uptc.presupuesto.dto.AlertaDTO;
import edu.uptc.presupuesto.service.AlertaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alertas")
@Tag(name = "Gestión de Alertas")
public class AlertaController {
    @Autowired
    private AlertaService service;

    @PostMapping
    @Operation(summary = "Crear una nueva alerta")
    public ResponseEntity<AlertaDTO> crearAlerta(@RequestBody AlertaDTO dto) {
        return ResponseEntity.ok(service.crearAlerta(dto));
    }

    @GetMapping("/asignacion/{asignacionId}")
    @Operation(summary = "Obtener alertas por asignación")
    public List<AlertaDTO> obtenerAlertasPorAsignacion(@PathVariable Long asignacionId) {
        return service.obtenerAlertasPorAsignacion(asignacionId);
    }
}