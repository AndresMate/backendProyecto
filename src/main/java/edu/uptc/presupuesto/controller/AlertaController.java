package edu.uptc.presupuesto.controller;

import edu.uptc.presupuesto.dto.AlertaDTO;
import edu.uptc.presupuesto.handling.ResponseHandler;
import edu.uptc.presupuesto.service.AlertaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Object> crearAlerta(@RequestBody AlertaDTO dto) {
        try {
            AlertaDTO nuevaAlerta = service.crearAlerta(dto);
            return ResponseHandler.generateResponse("Alerta creada con éxito", HttpStatus.OK, nuevaAlerta);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @GetMapping("/asignacion/{asignacionId}")
    @Operation(summary = "Obtener alertas por asignación")
    public ResponseEntity<Object> obtenerAlertasPorAsignacion(@PathVariable Long asignacionId) {
        try {
            List<AlertaDTO> alertas = service.obtenerAlertasPorAsignacion(asignacionId);
            return ResponseHandler.generateResponse("Alertas obtenidas con éxito", HttpStatus.OK, alertas);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.CONFLICT, e.getMessage());
        }
    }
}