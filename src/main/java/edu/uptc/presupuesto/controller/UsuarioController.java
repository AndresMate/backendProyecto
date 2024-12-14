package edu.uptc.presupuesto.controller;

import edu.uptc.presupuesto.dto.UsuarioDTO;
import edu.uptc.presupuesto.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Gestión de Usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @PostMapping
    @Operation(summary = "Crear un nuevo usuario")
    public ResponseEntity<UsuarioDTO> crearUsuario(@RequestBody UsuarioDTO dto) {
        return ResponseEntity.ok(service.crearUsuario(dto));
    }

    @GetMapping("/username/{username}")
    @Operation(summary = "Obtener usuario por username")
    public ResponseEntity<UsuarioDTO> obtenerUsuarioPorUsername(@PathVariable String username) {
        return ResponseEntity.ok(service.obtenerUsuarioPorUsername(username));
    }
    @GetMapping("/users")
    @Operation(summary = "Obtener todos los usuarios")
    public ResponseEntity<Iterable<UsuarioDTO>> obtenerUsuarios() {
        return ResponseEntity.ok(service.obtenerUsuarios());
    }

}