/**
 * Repositorio JPA para acceso a datos de empleados.
 */

package com.pamtech.s7reto01.repository;

import com.pamtech.s7reto01.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findByPuestoIgnoreCase(String puesto);
}
