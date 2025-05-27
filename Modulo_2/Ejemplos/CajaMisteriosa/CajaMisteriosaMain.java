public class CajaMisteriosaMain {

    public static void main(String ... args) {

        // Crear una caja que guardará Strings
        // IMPORTANTE: usar <> para especificar el tipo genérico y evitar errores
        CajaMisteriosa<String> cajita = new CajaMisteriosa<>(); 

        // Guardamos el String "Hola Mundo" en la caja
        cajita.guardar("Hola Mundo");

        // Sacamos el valor guardado en la caja y lo asignamos a una variable String
        String valor = cajita.sacar();

        // Imprimimos el valor obtenido
        System.out.println("El valor de la caja es => " + valor);

        // Crear una caja que guardará Integer (números enteros)
        CajaMisteriosa<Integer> cajitaNumeros = new CajaMisteriosa<>();

        // Guardamos el número 1 en la caja
        cajitaNumeros.guardar(1);
    }
}

/*
    Explicación importante sobre tipos y herencia:

    Herencia es la especialización, por ejemplo:
        Animal -> Mamífero -> Canino -> Perro

    Polimorfismo permite usar una clase base para referenciar un objeto de clase derivada:
        Animal a = new Gato(); // Válido
        Gato g = new Animal(); // NO válido, no siempre un Animal es un Gato

    Similarmente con Object y String:
        Object o = new String(); // Válido porque String es un Object
        String s = new Object(); // NO válido porque un Object no siempre es String
*/
