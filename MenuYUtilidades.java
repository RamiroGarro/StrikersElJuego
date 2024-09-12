import java.util.Scanner;

public abstract class MenuYUtilidades {

    //MÉTODOS  ---------------------------------------------------------------------------------------------------------
    public static void menuPrincipal(Equipo e1, Equipo e2){
        int numeroElegido = 0;

        while (numeroElegido != 1){
            System.out.println("\nMenú principal\n1. Jugar\n" +
                    "2. Tácticas equipo "+e1.getNombre()+"\n" +
                    "3. Tácticas equipo "+e2.getNombre()+"\n" +
                    "4. Salir\n"
            );
            numeroElegido = limitadorMenu(1,4);

            switch (numeroElegido) {
                case 1 -> {
                    if (e1.getArquerosEnCancha() != 1 || e1.getJugadoresEnCancha() != 4 || e2.getArquerosEnCancha() != 1 || e2.getJugadoresEnCancha() != 4) {
                        numeroElegido = 0;
                        System.out.println("\nLa cantidad de jugadores en las alineaciones titulares es incorrecta. Cada equipo debe ingresar 1 arquero y 4 jugadores de campo.");
                    } else {
                        System.out.println("\nComienza el partido!!!");
                    }
                }
                case 2 -> e1.menuEquipos();
                case 3 -> e2.menuEquipos();
                case 4 -> {
                    System.out.println("\nSe cerrará el programa.");
                    System.exit(0);
                }
            }
        }


    }

    public static int obtenerAleatorioEntero(int min, int max){
        return (int)(Math.random()*((max-min)+1))+min;
    }

    public static int limitadorMenu (int min, int max) {
        String numeroEnTexto = null;
        boolean validado = false;
        Scanner sc = new Scanner(System.in);
        
        while (!validado){
            numeroEnTexto = sc.nextLine();
            if (esEntero(numeroEnTexto)){

                if (Integer.parseInt(numeroEnTexto) >= min && Integer.parseInt(numeroEnTexto) < max+1){
                    validado = true;
                } else {
                    System.out.println("Lo ingresado no es parte de las opciones de menú");
                }
            } else {
                System.out.println("Lo ingresado no es un número entero");
            }

            System.out.println(devolverColor("rojo")+
                    "---------------------------------------------------------------------------------------------------------------------------------------------------------------"
                    +devolverColor("reset")
            );

        }

        return Integer.parseInt(numeroEnTexto);
    }

    public static boolean esEntero (String numeroEnTexto) {
        try {
            Integer.parseInt(numeroEnTexto);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static String devolverColor(String nombreColor){
        return switch (nombreColor) {
            case "negro" -> "\u001B[30m";
            case "rojo" -> "\u001B[31m";
            case "amarillo" -> "\u001B[32m";
            case "azul" -> "\u001B[33m";
            case "purpura" -> "\u001B[34m";
            case "cian" -> "\u001B[35m";
            case "blanco" -> "\u001B[36m";
            default -> "\u001B[0m";
        };
    }

}


