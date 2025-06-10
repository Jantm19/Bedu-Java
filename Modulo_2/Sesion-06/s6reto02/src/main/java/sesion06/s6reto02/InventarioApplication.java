package sesion06.s6reto02;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sesion06.s6reto02.modelo.Marca;
import sesion06.s6reto02.modelo.Producto;
import sesion06.s6reto02.repositorio.MarcaRepository;
import sesion06.s6reto02.repositorio.ProductoRepository;

@SpringBootApplication
public class InventarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventarioApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(MarcaRepository marcaRepo, ProductoRepository productoRepo) {
        return args -> {
            Marca apple = new Marca("Apple");
            Marca samsung = new Marca("Samsung");
            marcaRepo.save(apple);
            marcaRepo.save(samsung);

            Producto p1 = new Producto("iPhone 15", "Smartphone Apple", 15000.0, apple);
            Producto p2 = new Producto("iPad Pro", "Tablet Apple", 18000.0, apple);
            Producto p3 = new Producto("Galaxy S23", "Smartphone Samsung", 14000.0, samsung);
            Producto p4 = new Producto("Smart TV", "Televisor Samsung", 12000.0, samsung);

            productoRepo.save(p1);
            productoRepo.save(p2);
            productoRepo.save(p3);
            productoRepo.save(p4);

            System.out.println("📚 Productos por marca:");
            marcaRepo.findAll().forEach(marca -> {
                System.out.println("🏷️ " + marca.getNombre() + ":");
                productoRepo.findAll().stream()
                    .filter(p -> p.getMarca() != null && p.getMarca().getId().equals(marca.getId()))
                    .forEach(p -> System.out.println("   - " + p.getNombre()));
            });
        };
    }
}
