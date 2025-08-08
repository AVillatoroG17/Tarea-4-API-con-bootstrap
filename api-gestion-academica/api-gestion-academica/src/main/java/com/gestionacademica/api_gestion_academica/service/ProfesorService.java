package com.gestionacademica.api_gestion_academica.service;

import com.gestionacademica.api_gestion_academica.entity.Profesor;
import com.gestionacademica.api_gestion_academica.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;

    public List<Profesor> obtenerTodos() {
        return profesorRepository.findAll();
    }

    public Optional<Profesor> obtenerPorId(Long id) {
        return profesorRepository.findById(id);
    }

    public Profesor crear(Profesor profesor) {
        profesor.setFechaRegistro(LocalDateTime.now());
        return profesorRepository.save(profesor);
    }

    public Profesor actualizar(Long id, Profesor profesorActualizado) {
        return profesorRepository.findById(id)
            .map(profesor -> {
                profesor.setCodigoProfesor(profesorActualizado.getCodigoProfesor());
                profesor.setNombre(profesorActualizado.getNombre());
                profesor.setApellido(profesorActualizado.getApellido());
                profesor.setEmail(profesorActualizado.getEmail());
                profesor.setTelefono(profesorActualizado.getTelefono());
                profesor.setEspecialidad(profesorActualizado.getEspecialidad());
                profesor.setFechaContratacion(profesorActualizado.getFechaContratacion());
                profesor.setActivo(profesorActualizado.getActivo());
                return profesorRepository.save(profesor);
            }).orElse(null);
    }

    public boolean eliminar(Long id) {
        if (profesorRepository.existsById(id)) {
            profesorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}