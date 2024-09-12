import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Se crea un escaner para ingresar información por consola.
        Scanner sc = new Scanner(System.in);

        //Carteles de bienvenida
        System.out.println("Bienvenido a Strikers, el juego");
        System.out.println("En este videojuego, disputarás un encuentro de fútbol entre dos equipos, en el cual, dependiendo de las decisiones que tomes y de las estrategias que utilices, se dará un resultado u otro.");
        System.out.println("Para empezar, ingresa el nombre del primer equipo que disputará el partido:");

        //Se declaran variables que almacenarán los nombres de los equipos y se las inicializa.
        // Luego se declaran e inicializan los equipos.

        String nombre1;
        String nombre2;

        do {
            nombre1 = sc.nextLine();
        } while (nombre1.equals(""));

        Equipo e1=new Equipo(nombre1,1);

        System.out.println("A continuación, ingresa el nombre del segundo equipo que disputará el partido:");

        do {
            nombre2 = sc.nextLine();
        } while (nombre2.equals(""));

        Equipo e2=new Equipo(nombre2,2);

        //Se llena el array de nombres para los jugadores.
        Jugador.llenarArrayNombres();
        //Se agregan jugadores a ambos equipos.
        e1.agregarJugadoresAlEquipo();
        e2.agregarJugadoresAlEquipo();

        System.out.println("Ya están creados los equipos.");

        //Se inicia el menú principal con las opciones de este.
        MenuYUtilidades.menuPrincipal(e1,e2);

        //Se declara e inicializa el partido
        Partido p1 = new Partido(e1,e2);

        //Empezará el partido y no terminará hasta que se cumplan los minutos que correspondan.
        while (p1.getMinutos() <= p1.getMinutoFinal()) {
            //Si hay jugadas se realizarán determinadas acciones, sino solo aumentarán minutos.
            if (p1.decidirSiHayJugada()) {
                //Si hay jugada se elegirá que equipo ataca y que equipo defiende.
                p1.elegirEquipoAtacanteYDefensor();
                //Se decidirá en que posiciones de la cancha estará cada jugador.
                p1.decidirPosicionesActuales();
                //Se mostrará en que posiciones está cada jugador.
                p1.mostrarPosicionesActuales();
                //Se decidirá quien es el jugador de ese equipo que tiene la pelota.
                p1.sortearLaPelota();
                //Se abrirá un menú para que el equipo decida que jugada intentará y
                //en base a eso realizar las acciones correspondientes.
                p1.menuJugada();
            }
            //Se aumentan minutos.
            p1.aumentarMinutos();
            //Si estamos llegando a los minutos finales se agregarán una serie de minutos.
            p1.agregarMinutos();
        }

        System.out.println(MenuYUtilidades.devolverColor("rojo")+"\nFinaaaaaaaaaaaaaal del partido");
        System.out.println("Resultado final: "+p1.getEquipo1().getNombre()+" "+p1.getGolesEquipo1()+" - "+p1.getEquipo2().getNombre()+" "+p1.getGolesEquipo2());



    }


}

