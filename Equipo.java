import java.util.ArrayList;

public class Equipo {

    //ATRIBUTOS --------------------------------------------------------------------------------------------------------
    private final String  nombre;
    private final int numeroDeEquipo;
    private int jugadoresEnCancha = 0;
    private int arquerosEnCancha = 0;
    private int tacticasUsadas = 0;
    private final ArrayList<Jugador> suplentes = new ArrayList<>();
    private Arquero arquero;
    private final ArrayList<Jugador> defensores = new ArrayList<>();
    private final ArrayList<Jugador> mediocampistasDefensivos = new ArrayList<>();
    private final ArrayList<Jugador> mediocampistas = new ArrayList<>();
    private final ArrayList<Jugador> mediocampistasOfensivos = new ArrayList<>();
    private final ArrayList<Jugador> delanteros = new ArrayList<>();


    //MÉTODOS ----------------------------------------------------------------------------------------------------------
    public void agregarJugadoresAlEquipo () {
        suplentes.add(new Arquero(this));
        suplentes.add(new Arquero(this));
        for (int i=0;i<5;i++){
            suplentes.add(new JugadorDeCampo(this));
        }
        arquero = new Arquero(this);
        defensores.add(new JugadorDeCampo(this));
        mediocampistas.add(new JugadorDeCampo(this));
        mediocampistas.add(new JugadorDeCampo(this));
        delanteros.add(new JugadorDeCampo(this));
        arquerosEnCancha++;
        jugadoresEnCancha+=4;

    }

    public void menuEquipos(){
        int numeroElegido = 0;

        while (numeroElegido != 9) {

            System.out.println("\nTácticas de equipo "+nombre+"\n" +
                    "1. Ver suplentes\n" +
                    "2. Ver arquero\n" +
                    "3. Ver defensores\n" +
                    "4. Ver mediocampistas defensivos\n" +
                    "5. Ver mediocampistas centrales\n" +
                    "6. Ver mediocampistas ofensivos\n" +
                    "7. Ver delanteros\n" +
                    "8. Mover jugador de posición\n" +
                    "9. Volver\n"
            );
            numeroElegido = MenuYUtilidades.limitadorMenu(1,9);

            switch (numeroElegido) {
                case 1, 2, 3, 4, 5, 6, 7 -> verLista(numeroElegido);
                case 8 -> {
                    System.out.println("Cantidad de suplentes: " + devolverArrayListIndicada(1).size());
                    System.out.println("Cantidad de arqueros: " + devolverArrayListIndicada(2).size());
                    System.out.println("Cantidad de defensores: " + devolverArrayListIndicada(3).size());
                    System.out.println("Cantidad de mediocampistas defensivos: " + devolverArrayListIndicada(4).size());
                    System.out.println("Cantidad de mediocampistas centrales: " + devolverArrayListIndicada(5).size());
                    System.out.println("Cantidad de mediocampistas ofensivos: " + devolverArrayListIndicada(6).size());
                    System.out.println("Cantidad de delanteros: " + devolverArrayListIndicada(7).size());

                    int numeroDestino, numeroOrigen, numeroJugador;

                    System.out.println("""

                            Ingrese lista de origen:
                            1. Suplentes
                            2. Arquero
                            3. Defensores
                            4. Mediocampistas defensivos
                            5. Mediocampistas centrales
                            6. Mediocampistas ofensivos
                            7. Delanteros
                            """
                    );

                    numeroOrigen = MenuYUtilidades.limitadorMenu(1, 7);

                    verLista(numeroOrigen);

                    if (devolverArrayListIndicada(numeroOrigen).size() > 0) {
                        System.out.println("\nElija el número de jugador a trasladar:");

                        numeroJugador = MenuYUtilidades.limitadorMenu(1, devolverArrayListIndicada(numeroOrigen).size());

                        System.out.println("""

                                Ingrese lista de destino:
                                1. Suplentes
                                2. Arquero
                                3. Defensores
                                4. Mediocampistas defensivos
                                5. Mediocampistas centrales
                                6. Mediocampistas ofensivos
                                7. Delanteros
                                """
                        );

                        numeroDestino = MenuYUtilidades.limitadorMenu(1, 7);

                        cambiarDePosicion(numeroOrigen, numeroDestino, numeroJugador);
                    }

                }
                case 9 -> System.out.println("\nVolviendo...");
            }

        }



    }

    public ArrayList<Jugador> devolverArrayListIndicada(int numero){
        switch (numero) {
            case 1 -> {
                return suplentes;
            }
            case 2 -> {
                ArrayList<Jugador> arqueros = new ArrayList<>();
                arqueros.add(arquero);
                return arqueros;
            }
            case 3 -> {
                return defensores;
            }
            case 4 -> {
                return mediocampistasDefensivos;
            }
            case 5 -> {
                return mediocampistas;
            }
            case 6 -> {
                return mediocampistasOfensivos;
            }
            case 7 -> {
                return delanteros;
            }
            default -> {
                System.out.println("Número equivocado");
                return null;
            }
        }
    }

    public void verLista(int numeroLista){

        ArrayList<Jugador> lista = new ArrayList<>();

        switch (numeroLista) {
            case 1 -> {
                System.out.println("\nLista de suplentes de " + nombre);
                lista = suplentes;
            }
            case 2 -> {
                System.out.println("\nLista de arqueros de " + nombre);
                lista.add(arquero);
            }
            case 3 -> {
                System.out.println("\nLista de defensores de " + nombre);
                lista = defensores;
            }
            case 4 -> {
                System.out.println("\nLista de mediocampistas defensivos de " + nombre);
                lista = mediocampistasDefensivos;
            }
            case 5 -> {
                System.out.println("\nLista de mediocampistas de " + nombre);
                lista = mediocampistas;
            }
            case 6 -> {
                System.out.println("\nLista de mediocampistas ofensivos de " + nombre);
                lista = mediocampistasOfensivos;
            }
            case 7 -> {
                System.out.println("\nLista de delanteros de " + nombre);
                lista = delanteros;
            }
            default -> System.out.println("Te has equivocado en la elección de listas");
        }

        if(lista.size()>=1){
            for(int i = 0 ; i < lista.size() ; i++ ){
                System.out.println();
                if (!lista.get(i).esArquero){
                    System.out.println("Jugador "+(i+1)+" - Jugador de campo");
                }else{
                    System.out.println("Jugador "+(i+1)+" - Arquero");
                }
                lista.get(i).imprimirEstadisticas();
            }
        }else{
            System.out.println("\nNo se encuentran jugadores en esta lista");
        }

    }

    public void cambiarDePosicion(int numeroOrigen, int numeroDestino, int numeroJugador){
        boolean error = false;

        if ((numeroDestino == 2) && !(devolverArrayListIndicada(numeroOrigen).get(numeroJugador - 1).esArquero)){
            System.out.println("\nNo puedes ingresar como arquero a un jugador de campo.");
            error = true;
        }
        if (!(numeroDestino == 2 || numeroDestino == 1 ) && (devolverArrayListIndicada(numeroOrigen).get(numeroJugador-1).esArquero)){
            System.out.println("\nNo puedes ingresar como jugador de campo a un arquero.");
            error = true;
        }
        if (numeroDestino == numeroOrigen){
            System.out.println("Estás trasladando dentro de la misma lista");
            error = true;
        }

        if (!error) {
            switch (numeroDestino) {
                case 3, 4, 5, 6, 7 -> {
                    int jugadoresHabilitados = 4;
                    if (jugadoresEnCancha >= jugadoresHabilitados && numeroOrigen == 1) {
                        System.out.println("\nNo puedes ingresar más de 4 jugadores de campo.");
                    } else {
                        if (numeroOrigen == 1) {
                            jugadoresEnCancha++;
                        }
                        devolverArrayListIndicada(numeroDestino).add(devolverArrayListIndicada(numeroOrigen).get(numeroJugador - 1));
                        devolverArrayListIndicada(numeroOrigen).remove(numeroJugador - 1);
                        System.out.println("\nSe trasladó el jugador");
                    }
                }
                case 2 -> {
                    int arquerosHabilitados = 1;
                    if (arquerosEnCancha >= arquerosHabilitados) {
                        System.out.println("\nNo puedes ingresar más de 1 arquero.");
                    } else {
                        arquerosEnCancha++;
                        setArquero((Arquero) devolverArrayListIndicada(numeroOrigen).get(numeroJugador - 1));
                        devolverArrayListIndicada(numeroOrigen).remove(numeroJugador - 1);
                        System.out.println("\nSe trasladó el jugador");
                    }
                }
                case 1 -> {
                    if (numeroOrigen == 2) {
                        devolverArrayListIndicada(numeroDestino).add(devolverArrayListIndicada(numeroOrigen).get(numeroJugador - 1));
                        setArquero(null);
                        arquerosEnCancha--;
                    } else if (numeroOrigen > 2) {
                        devolverArrayListIndicada(numeroDestino).add(devolverArrayListIndicada(numeroOrigen).get(numeroJugador - 1));
                        devolverArrayListIndicada(numeroOrigen).remove(numeroJugador - 1);
                        jugadoresEnCancha--;
                    }
                    System.out.println("\nSe trasladó el jugador");
                }
                default -> System.out.println("Te has equivocado en la elección de listas");
            }

            System.out.println("Jugadores en alineación: "+jugadoresEnCancha);
            System.out.println("Arqueros en alineación: "+arquerosEnCancha);

        }

    }

    public ArrayList<JugadorDeCampo> devolverJugadoresEntreZonas (int zonaInicio, int zonaFinal){
        ArrayList<JugadorDeCampo> jugadoresEntreZonas = new ArrayList<>();
        for (int i = 3; i < 8; i++) {
            if (devolverArrayListIndicada(i).size() >= 1) {
                for (int j = 0; j < devolverArrayListIndicada(i).size(); j++) {
                    int posicionActual = devolverArrayListIndicada(i).get(j).getPosicionActual();
                    if (zonaInicio-1 < posicionActual && posicionActual < zonaFinal+1) {
                        jugadoresEntreZonas.add((JugadorDeCampo) devolverArrayListIndicada(i).get(j));
                    }
                }
            }
        }
        return jugadoresEntreZonas;
    }

    public JugadorDeCampo devolverJugadorConPelota (){
        JugadorDeCampo jugadorConPelota = null;
        for (int i = 3; i < 8; i++) {
            for (int j = 0; j < devolverArrayListIndicada(i).size(); j++) {
                if (devolverArrayListIndicada(i).get(j).isTieneLaPelota()) {
                    jugadorConPelota = (JugadorDeCampo) devolverArrayListIndicada(i).get(j);
                }
            }
        }
        return jugadorConPelota;
    }

    public JugadorDeCampo devolverJugadorConNombre (String nombre){
        for (int i = 3; i < 8; i++) {
            for (int j = 0; j < devolverArrayListIndicada(i).size(); j++) {
                if (nombre.equals(devolverArrayListIndicada(i).get(j).getNombre())) {
                    return (JugadorDeCampo) devolverArrayListIndicada(i).get(j);
                }
            }
        }
        return null;
    }

    public void darlePelotaAJugadorConNombre (String nombre){
        for (int i = 3; i < 8; i++) {
            for (int j = 0; j < devolverArrayListIndicada(i).size(); j++) {
                if (nombre.equals(devolverArrayListIndicada(i).get(j).getNombre())) {
                    devolverArrayListIndicada(i).get(j).obtieneLaPelota();
                }
            }
        }
    }

    public void quitarlePelotaAJugadorQueLaTiene (){
        for (int i = 3; i < 8; i++) {
            for (int j = 0; j < devolverArrayListIndicada(i).size(); j++) {
                if (devolverArrayListIndicada(i).get(j).isTieneLaPelota()) {
                    devolverArrayListIndicada(i).get(j).yaNoTieneLaPelota();
                }
            }
        }
    }

    public void moverJugadorConNombre (int movimientosARealizar, String nombre){
        for (int i = 3; i < 8; i++) {
            for (int j = 0; j < devolverArrayListIndicada(i).size(); j++) {
                if (nombre.equals(devolverArrayListIndicada(i).get(j).getNombre())) {
                    devolverArrayListIndicada(i).get(j).moverPosicion(movimientosARealizar);
                }
            }
        }
    }

    //CONSTRUCTOR ------------------------------------------------------------------------------------------------------
    public Equipo(String nombre, int numeroDeEquipo) {
        this.nombre = nombre;
        this.numeroDeEquipo = numeroDeEquipo;
    }


    //GETTERS Y SETTERS ------------------------------------------------------------------------------------------------
    public String getNombre() {
        return nombre;
    }

    public int getNumeroDeEquipo() {
        return numeroDeEquipo;
    }

    public int getTacticasUsadas() {
        return tacticasUsadas;
    }

    public int getTacticasPosibles() {
        return 10;
    }

    public void aumentarTacticasUsadas(){
        tacticasUsadas++;
    }

    public int getJugadoresEnCancha() {
        return jugadoresEnCancha;
    }

    public int getArquerosEnCancha() {
        return arquerosEnCancha;
    }

    public Arquero getArquero() {
        return arquero;
    }

    public void setArquero(Arquero arquero) {
        this.arquero = arquero;
    }
}
