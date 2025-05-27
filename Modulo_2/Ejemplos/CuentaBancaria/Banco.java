import java.util.List;

public class Banco{

    // ? Significa cualquier tipo ( similar a poner T,X,etc)
    // Se utiliza cuando el codigo no usa nada especifico de la clase objetivo

    public static void verCuentas(List<?> cuentas){
        for(Object o : cuentas){
            //System.out.println(o.toString());
            System.out.println(o);
        }
    }

    //List<CuentaBancaria> != List<CuentaDebito>
    //extends se utiliza unicamente para la escritura
    // Entonces la lista puede ser de cuentabancaria, cuenta debito, o cuenta credito
    public static void verTitulares(List<? extends CuentaBancaria> cuentas){
        for(CuentaBancaria o : cuentas){
            System.out.println(o.getTitular());
        }
    }

    public static void depositarACuentas (List<? super CuentaDebito> cuentas){
        
    }
}