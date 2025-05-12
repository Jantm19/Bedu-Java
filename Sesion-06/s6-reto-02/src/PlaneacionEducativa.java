/**
 * Programa que gestiona una lista concurrente de temas educativos
 * y un repositorio concurrente de recursos compartidos.
 * Ordena los temas por título y por prioridad usando Comparable y Comparator.
 */
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.Comparator;

public class PlaneacionEducativa {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Tema> temas = new CopyOnWriteArrayList<>();
        temas.add(new Tema("Lectura comprensiva", 2));
        temas.add(new Tema("Matemáticas básicas", 1));
        temas.add(new Tema("Cuidado del medio ambiente", 3));

        ConcurrentHashMap<String, String> recursos = new ConcurrentHashMap<>();
        recursos.put("Lectura comprensiva", "https://recursos.edu/lectura");
        recursos.put("Matemáticas básicas", "https://recursos.edu/mate");
        recursos.put("Cuidado del medio ambiente", "https://recursos.edu/medioambiente");

        Collections.sort(temas);
        System.out.println("📚 Temas ordenados alfabéticamente:");
        for (Tema tema : temas) {
            System.out.println("- " + tema);
        }

        temas.sort(Comparator.comparingInt(Tema::getPrioridad));
        System.out.println("\n📊 Temas ordenados por prioridad:");
        for (Tema tema : temas) {
            System.out.println("- " + tema);
        }

        System.out.println("\n📦 Repositorio de recursos compartidos:");
        for (String titulo : recursos.keySet()) {
            System.out.println(titulo + " → " + recursos.get(titulo));
        }
    }
}
