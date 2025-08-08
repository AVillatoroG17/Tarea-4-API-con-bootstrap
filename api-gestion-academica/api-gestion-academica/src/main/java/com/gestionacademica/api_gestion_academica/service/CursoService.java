package com.gestionacademica.api_gestion_academica.service;

import com.gestionacademica.api_gestion_academica.entity.Curso;
import com.gestionacademica.api_gestion_academica.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> obtenerTodos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> obtenerPorId(Long id) {
        return cursoRepository.findById(id);
    }

    public Curso crear(Curso curso) {
        curso.setFechaRegistro(LocalDateTime.now());
        return cursoRepository.save(curso);
    }

    public Curso actualizar(Long id, Curso cursoActualizado) {
        return cursoRepository.findById(id)
            .map(curso -> {
                curso.setCodigoCurso(cursoActualizado.getCodigoCurso());
                curso.setNombre(cursoActualizado.getNombre());
                curso.setCreditos(cursoActualizado.getCreditos());
                curso.setDescripcion(cursoActualizado.getDescripcion());
                curso.setHorasSemanales(cursoActualizado.getHorasSemanales());
                curso.setPuntuacionMinima(cursoActualizado.getPuntuacionMinima());
                curso.setActivo(cursoActualizado.getActivo());
                return cursoRepository.save(curso);
            }).orElse(null);
    }

    public boolean eliminar(Long id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}