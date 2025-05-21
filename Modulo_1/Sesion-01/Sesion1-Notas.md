### 1. Introducción a Java y primeros pasos

**Java** es un lenguaje de programación orientado a objetos ampliamente utilizado en la industria. En esta sesión, exploraremos sus conceptos básicos y cómo escribir nuestro primer programa en Java.

#### Conceptos clave de Java

- **Lenguaje de programación moderno, robusto y multiplataforma**.
- **Orientado a objetos (POO)**: todo en Java gira alrededor de clases y objetos.

#### Estructura básica de un programa en Java

Todo programa en Java debe tener al menos una clase con un método `main` (punto de entrada).

**Ejemplo 1: Programa HolaMundo**
```java
public class HolaMundo {
    public static void main(String[] args) {
        System.out.println("¡Hola, Java!");
    }
}
```

* **`public class HolaMundo`**: Define una clase pública llamada `HolaMundo`. El nombre del archivo debe ser `HolaMundo.java`.
* **`public static void main(String[] args)`**: Método principal.
    * `public`: Accesible desde cualquier lugar.
    * `static`: Pertenece a la clase, no a una instancia específica.
    * `void`: No devuelve ningún valor.
    * `main`: Nombre del método principal.
    * `String[] args`: Array de argumentos de línea de comandos.
* **`System.out.println(...)`**: Imprime un mensaje en la consola.

## 2. Compilación y Ejecución
- **Compilación:** Convierte el código fuente `.java` en bytecode `.class`.
  
  ```bash
  javac HolaMundo.java
  ```

- **Ejecución:** La JVM ejecuta el bytecode.

  ```bash
  java HolaMundo
  ```


## 3. Fundamentos de la Programación Orientada a Objetos (POO)
- Java implementa **POO** con 4 principios clave:
  1. **Encapsulación:** Ocultar los detalles internos y controlar el acceso a los datos.
  2. **Herencia:** Crear nuevas clases basadas en otras existentes, heredando atributos y métodos.
  3. **Polimorfismo:** Los objetos pueden comportarse de diversas maneras.
  4. **Abstracción:** Solo mostrar la información esencial de los objetos.

### Ejemplo de POO:
```java
public class Estudiante {
    String nombre;
    int edad;

    public void saludar() {
        System.out.println("Hola, mi nombre es " + nombre + " y tengo " + edad + " años.");
    }
}
```
```java
public class Principal {
    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante();
        estudiante1.nombre = "Ana";
        estudiante1.edad = 20;
        estudiante1.saludar();
    }
}
```

## 4. Clases, Objetos y Constructores
- **Clases** son plantillas para crear **objetos** con atributos y métodos.
- **Constructor:** Método especial para inicializar un objeto al momento de su creación.
  
### Ejemplo de Constructor:
```java
public class Producto {
    String nombre;
    double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public void mostrarInformacion() {
        System.out.println("Producto: " + nombre + " - Precio: $" + precio);
    }
}
```

### Modificadores de acceso:
| Modificador | Acceso desde la misma clase | Acceso desde otras clases | Acceso desde otras clases en otro paquete |
| :---------- | :-------------------------- | :---------------------- | :--------------------------------------- |
| `public`    | ✅                          | ✅                      | ✅                                       |
| `private`   | ✅                          | ❌                      | ❌                                       |
| `protected` | ✅                          | ✅ (si es subclase)      | ✅ (si es subclase y mismo paquete)       |
| (sin)       | ✅                          | ✅                      | ❌                                       |

## 5. Características Avanzadas de Java
- **Record:** Clase inmutable con sintaxis concisa, introducida en Java 14 y estable en Java 16.
  
  Ejemplo de `record`:
  ```java
  public record Producto(String nombre, double precio) { }
  ```
  
- **Sealed Classes:** Permiten restringir qué clases pueden heredar de una clase, mejorando la seguridad.

  Ejemplo de `sealed class`:
  ```java
  public sealed class Vehiculo permits Auto, Camion { }
  final class Auto extends Vehiculo { }
  final class Camion extends Vehiculo { }
  
  // class Moto extends Vehiculo { } // Error: Moto no está permitido extender Vehiculo
  ```

## 6. Conclusiones
- Java es un lenguaje potente y flexible para la programación orientada a objetos.
- Las nuevas características como los **records** y **sealed classes** promueven un código más **seguro**, **conciso** y **mantenible**.
```
