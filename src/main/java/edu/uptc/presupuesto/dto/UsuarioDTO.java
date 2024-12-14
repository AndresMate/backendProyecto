package edu.uptc.presupuesto.dto;

import edu.uptc.presupuesto.model.Usuario.Rol;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class UsuarioDTO {
    @NotNull(message = "El ID es obligatorio")
    private Long id;

    @NotBlank(message = "El nombre de usuario es obligatorio")
    private String username;

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El correo electrónico no es válido")
    private String email;

    @NotNull(message = "El rol es obligatorio")
    private Rol rol;

    @NotNull(message = "El estado de activación es obligatorio")
    private boolean activo;

    @NotNull(message = "La fecha de último acceso es obligatoria")
    private LocalDateTime ultimoAcceso;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public LocalDateTime getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(LocalDateTime ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", rol=" + rol +
                ", activo=" + activo +
                ", ultimoAcceso=" + ultimoAcceso +
                '}';
    }
}