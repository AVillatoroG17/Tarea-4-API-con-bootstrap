package com.gestionacademica.api_gestion_academica.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  id;
    
    @Column(name = "codigo_curso", nullable = false, unique = true, length = 20)
    private String codigoCurso;
    
    @Column(nullable = false, length = 150)
    private String nombre;
    
    @Column(nullable = false)
    private Integer creditos;
    
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    
    @Column(name = "horas_semanales", nullable = false)
    private Integer horasSemanales;
    
    @Column(name = "puntuacion_minima", precision = 3, scale = 2)
    private BigDecimal puntuacionMinima = BigDecimal.valueOf(60.00);
    
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;
    
    @Column(columnDefinition = "boolean default true")
    private Boolean activo = true;

    public Curso() {}

    public Integer  getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getCodigoCurso() { return codigoCurso; }
    public void setCodigoCurso(String codigoCurso) { this.codigoCurso = codigoCurso; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Integer getCreditos() { return creditos; }
    public void setCreditos(Integer creditos) { this.creditos = creditos; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Integer getHorasSemanales() { return horasSemanales; }
    public void setHorasSemanales(Integer horasSemanales) { this.horasSemanales = horasSemanales; }
    public BigDecimal getPuntuacionMinima() { return puntuacionMinima; }
    public void setPuntuacionMinima(BigDecimal puntuacionMinima) { this.puntuacionMinima = puntuacionMinima; }
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
}