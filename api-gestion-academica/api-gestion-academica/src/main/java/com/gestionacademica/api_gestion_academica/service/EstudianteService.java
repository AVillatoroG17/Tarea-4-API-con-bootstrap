package com.gestionacademica.api_gestion_academica.service;

import com.gestionacademica.api_gestion_academica.entity.Estudiante;
import com.gestionacademica.api_gestion_academica.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> obtenerTodos() {
        return estudianteRepository.findAll();
    }

    public Optional<Estudiante> obtenerPorId(Long id) {
        return estudianteRepository.findById(id);
    }

    public Estudiante crear(Estudiante estudiante) {
        estudiante.setFechaRegistro(LocalDateTime.now());
        return estudianteRepository.save(estudiante);
    }

    public Estudiante actualizar(Long id, Estudiante estudianteActualizado) {
        return estudianteRepository.findById(id)
            .map(estudiante -> {
                estudiante.setCodigoEstudiante(estudianteActualizado.getCodigoEstudiante());
                estudiante.setNombre(estudianteActualizado.getNombre());
                estudiante.setApellido(estudianteActualizado.getApellido());
                estudiante.setEmail(estudianteActualizado.getEmail());
                estudiante.setTelefono(estudianteActualizado.getTelefono());
                estudiante.setFechaNacimiento(estudianteActualizado.getFechaNacimiento());
                estudiante.setCarrera(estudianteActualizado.getCarrera());
                estudiante.setEstado(estudianteActualizado.getEstado());
                return estudianteRepository.save(estudiante);
            }).orElse(null);
    }

    public boolean eliminar(Long id) {
        if (estudianteRepository.existsById(id)) {
            estudianteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}