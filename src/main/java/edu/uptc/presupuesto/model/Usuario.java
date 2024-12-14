package edu.uptc.presupuesto.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username es obligatorio")
    @Column(unique = true)
    private String username;

    @NotBlank(message = "Password es obligatorio")
    private String password;

    @Email(message = "Email debe ser válido")
    @NotBlank(message = "Email es obligatorio")
    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    private boolean activo;

    private LocalDateTime ultimoAcceso;

    public enum Rol {
        ADMINISTRADOR, FINANCIERO, CONSULTA
    }
}
