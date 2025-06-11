/**
 * Controlador REST que expone los endpoints para empleados.
 */
package com.pamtech.s7reto01.controller;

import com.pamtech.s7reto01.model.Empleado;
import com.pamtech.s7reto01.service.EmpleadoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public List<Empleado> obtenerTodos() {
        return empleadoService.obtenerTodos();
    }

    @GetMapping("/puesto/{puesto}")
    public List<Empleado> buscarPorPuesto(@PathVariable String puesto) {
        return empleadoService.buscarPorPuesto(puesto);
    }

    @PostMapping
    public Empleado crearEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.guardarEmpleado(empleado);
    }

    @DeleteMapping("/{id}")
    public String eliminarPorId(@PathVariable Long id) {
        try {
            empleadoService.eliminarEmpleado(id);
            return "✅ Empleado con ID " + id + " eliminado correctamente.";
        } catch (RuntimeException e) {
            return "❌ " + e.getMessage();
        }
    }
}
