package Principal;

import Control.Conversion;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        //Maneja la API de ExchangeRate
        Conversion conversion = new Conversion();

        int opcion;
        double cantidad;
        Boolean flag = true;
        boolean salir = false;
        int intentos = 0;
        Scanner in = new Scanner(System.in);

        System.out.println("\n\033[1;33m¡Convierte tus monedas con facilidad!\033[0m");
        System.out.println("\nBienvenido al Conversor de Monedas de Marcelo.");
        System.out.println("Tasas de cambio actualizadas en tiempo real.");
        System.out.println("Conversión rápida y sencilla.\n");
        do{
            intentos++;
            System.out.println("\n\033[1;33mMenú de Conversión de Monedas\033[0m\n");
            System.out.println("\033[1mConversiones USD\033[0m");
            System.out.println("1. Dólar (USD) --> Peso argentino (ARS)");
            System.out.println("2. Peso argentino (ARS) --> Dólar (USD)");
            System.out.println("\033[1mConversiones BRL\033[0m");
            System.out.println("3. Dólar (USD) --> Real brasileño (BRL)");
            System.out.println("4. Real brasileño (BRL) --> Dólar (USD)");
            System.out.println("\033[1mConversiones ARS\033[0m");
            System.out.println("5. Real brasileño (BRL) --> Peso argentino (ARS)");
            System.out.println("6. Peso argentino (ARS) --> Real brasileño (BRL)");
            System.out.println("7. Salir");

            System.out.print("\nElija una opción: ");
            opcion = in.nextInt();

            if(opcion >= 1 && opcion <=6){
                System.out.println(" ");
                System.out.print("Ingrese cantidad a convertir: ");
                cantidad = in.nextDouble();

                switch (opcion){
                    case 1:
                        conversion.calcularTotal(cantidad, "USD", "ARS");
                        break;
                    case 2:
                        conversion.calcularTotal(cantidad,"ARS", "USD");
                        break;
                    case 3:
                        conversion.calcularTotal(cantidad,"USD", "BRL");
                        break;
                    case 4:
                        conversion.calcularTotal(cantidad,"BRL", "USD");
                        break;
                    case 5:
                        conversion.calcularTotal(cantidad,"BRL", "ARS");
                        break;
                    case 6:
                        conversion.calcularTotal(cantidad,"ARS", "BRL");
                        break;
                }
            } else if (opcion == 7) {
                System.out.println("Hasta luego!");
                salir = true;
            } else if (intentos >= 3) { // Límite de intentos alcanzado
                System.out.println("Demasiados intentos fallidos. Saliendo...");
                salir = true;
            } else {
                System.out.println("Opción no válida. Inténtalo de nuevo.");
            }

        }while(!salir);
    }
}
