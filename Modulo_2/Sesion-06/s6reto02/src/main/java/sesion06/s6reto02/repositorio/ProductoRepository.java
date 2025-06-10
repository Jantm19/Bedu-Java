package sesion06.s6reto02.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sesion06.s6reto02.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
