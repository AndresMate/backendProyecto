package edu.uptc.presupuesto.model;


import jakarta.persistence.*;
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
@Table(name = "reporte")
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private TipoReporte tipoReporte;

    private LocalDateTime fechaGeneracion;

    private String rutaArchivo;

    public enum TipoReporte {
        RESUMEN_PRESUPUESTAL,
        GASTOS_POR_RUBRO,
        PROYECCION_PRESUPUESTAL,
        ALERTAS_GENERADAS
    }
}