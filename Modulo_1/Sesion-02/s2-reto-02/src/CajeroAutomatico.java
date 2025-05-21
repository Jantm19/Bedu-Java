/**
 * CajeroAutomatico
 * Simula un cajero automático básico con opciones para consultar saldo,
 * depositar, retirar dinero y salir del programa.
 * Después de cada operación, permite elegir volver al menú o salir.
 */

import java.util.Scanner;

public class CajeroAutomatico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldo = 1000.0;
        int opcion;
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nBienvenido al cajero automático");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("❌ Opción inválida. Ingresa un número del 1 al 4.");
                scanner.next();
                System.out.print("Elige una opción: ");
            }

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("✅ Tu saldo actual es: $" + saldo);
                    break;
                case 2:
                    System.out.print("💰 Ingresa el monto a depositar: ");
                    double deposito = scanner.nextDouble();
                    scanner.nextLine();
                    if (deposito <= 0) {
                        System.out.println("❌ Monto inválido. Debe ser mayor a cero.");
                        break;
                    }
                    saldo += deposito;
                    System.out.println("✅ Depósito exitoso. Nuevo saldo: $" + saldo);
                    break;
                case 3:
                    System.out.print("💸 Ingresa el monto a retirar: ");
                    double retiro = scanner.nextDouble();
                    scanner.nextLine();
                    if (retiro <= 0) {
                        System.out.println("❌ Monto inválido. Debe ser mayor a cero.");
                        break;
                    }
                    if (retiro > saldo) {
                        System.out.println("⚠️ Fondos insuficientes. Tu saldo es: $" + saldo);
                        break;
                    }
                    saldo -= retiro;
                    System.out.println("✅ Retiro exitoso. Nuevo saldo: $" + saldo);
                    break;
                case 4:
                    System.out.println("👋 Gracias por usar el cajero. ¡Hasta pronto!");
                    continuar = false;
                    break;
                default:
                    System.out.println("❌ Opción inválida. Por favor elige entre 1 y 4.");
                    break;
            }

            if (opcion != 4 && continuar) {
                System.out.println("\n¿Deseas regresar al menú principal o salir?");
                System.out.println("1. Menú principal");
                System.out.println("2. Salir");
                System.out.print("Elige una opción: ");

                int respuesta = scanner.nextInt();
                scanner.nextLine();
                if (respuesta == 2) {
                    System.out.println("👋 Gracias por usar el cajero. ¡Hasta pronto!");
                    continuar = false;
                }
            }
        }

        scanner.close();
    }
}
