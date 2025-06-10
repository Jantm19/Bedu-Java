package sesion06.s6reto01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sesion06.s6reto01.modelo.Producto;
import sesion06.s6reto01.repositorio.ProductoRepository;

/**
 * Clase principal que ejecuta la aplicación Spring Boot.
 * Realiza pruebas de consultas personalizadas sobre productos registrados.
 */
@SpringBootApplication
public class InventarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventarioApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ProductoRepository repo) {
        return args -> {
            repo.save(new Producto("Laptop Lenovo", "Laptop de alto rendimiento", 12500));
            repo.save(new Producto("Mouse Logitech", "Mouse inalámbrico", 350));
            repo.save(new Producto("Teclado Mecánico", "Teclado retroiluminado", 950));
            repo.save(new Producto("Monitor", "Monitor Full HD", 3200));

            System.out.println("📦 Productos con precio mayor a 500:");
            repo.findByPrecioGreaterThan(500).forEach(System.out::println);

            System.out.println("\n🔍 Productos que contienen 'lap':");
            repo.findByNombreContainingIgnoreCase("lap").forEach(System.out::println);

            System.out.println("\n🎯 Productos con precio entre 400 y 1000:");
            repo.findByPrecioBetween(400, 1000).forEach(System.out::println);

            System.out.println("\n📘 Productos cuyo nombre empieza con 'm':");
            repo.findByNombreStartingWithIgnoreCase("m").forEach(System.out::println);
        };
    }
}
