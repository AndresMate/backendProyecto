package edu.uptc.presupuesto.controller;

import edu.uptc.presupuesto.model.RubroPresupuestal;
import edu.uptc.presupuesto.service.RubroPresupuestalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/rubros")
@Tag(name = "Gestión de Rubros Presupuestales")
public class RubroPresupuestalController {
    @Autowired
    private RubroPresupuestalService service;

    @PostMapping
    @Operation(summary = "Crear un nuevo rubro presupuestal")
    public ResponseEntity<RubroPresupuestal> crearRubro(@RequestBody RubroPresupuestal rubro) {
        return ResponseEntity.ok(service.crearRubro(rubro));
    }

    @GetMapping("/proximosVencer")
    @Operation(summary = "Obtener rubros próximos a vencer")
    public List<RubroPresupuestal> getRubrosProximosAVencer() {
        return service.obtenerRubrosProximosAVencer();
    }

    @GetMapping("/casiAgotados")
    @Operation(summary = "Obtener rubros casi agotados")
    public List<RubroPresupuestal> getRubrosCasiAgotados() {
        return service.obtenerRubrosCasiAgotados();
    }

    @PutMapping("/{rubroId}/ejecutar")
    @Operation(summary = "Actualizar ejecución presupuestal de un rubro")
    public ResponseEntity<Void> actualizarEjecucion(
            @PathVariable Long rubroId,
            @RequestParam BigDecimal montoEjecutado
    ) {
        service.actualizarEjecucionPresupuestal(rubroId, montoEjecutado);
        return ResponseEntity.ok().build();
    }
}