/**
 * Servicio que gestiona la lógica de negocio para empleados.
 */

package com.pamtech.s7reto01.service;

import com.pamtech.s7reto01.model.Empleado;
import com.pamtech.s7reto01.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> obtenerTodos() {
        return empleadoRepository.findAll();
    }

    public List<Empleado> buscarPorPuesto(String puesto) {
        return empleadoRepository.findByPuestoIgnoreCase(puesto);
    }

    public void eliminarEmpleado(Long id) {
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        empleado.ifPresentOrElse(
            empleadoRepository::delete,
            () -> { throw new RuntimeException("Empleado no encontrado con ID: " + id); }
        );
    }

    // Método para guardar un nuevo empleado
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }
}

