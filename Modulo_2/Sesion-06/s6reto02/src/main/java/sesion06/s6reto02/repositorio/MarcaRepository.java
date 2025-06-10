package sesion06.s6reto02.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sesion06.s6reto02.modelo.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
