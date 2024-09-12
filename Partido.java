import java.util.ArrayList;

public class Partido {
    //ATRIBUTOS---------------------------------------------------------------------------------------------------------
    private int minutos = 1;
    private int golesEquipo1 = 0;
    private int golesEquipo2 = 0;
    private final Equipo equipo1;
    private final Equipo equipo2;
    private Equipo equipoAtacante;
    private Equipo equipoDefensor;
    private int turno = 1;
    private int minutoFinal = 90;
    private int ubicacionPelota = 0;
    private String nombreJugadorConPelota = "";

    //CONSTRUCTOR ------------------------------------------------------------------------------------------------------
    public Partido(Equipo equipo1, Equipo equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }


    //METODOS ----------------------------------------------------------------------------------------------------------
    public boolean decidirSiHayJugada () {
        if (MenuYUtilidades.obtenerAleatorioEntero(1,100) > 75) {
            System.out.println("\nHay jugada al minuto "+minutos);
            return true;
        } else {
            System.out.println("\nNo hay jugada al minuto "+minutos);
            return false;
        }
    }

    public void elegirEquipoAtacanteYDefensor () {
        int puntosDePosesion1= equipo1.devolverArrayListIndicada(4).size() + equipo1.devolverArrayListIndicada(6).size() + equipo1.devolverArrayListIndicada(5).size()*2;
        int puntosDePosesion2= equipo2.devolverArrayListIndicada(4).size() + equipo2.devolverArrayListIndicada(6).size() + equipo2.devolverArrayListIndicada(5).size()*2;

        if(puntosDePosesion1 + MenuYUtilidades.obtenerAleatorioEntero(1,10) > puntosDePosesion2 + MenuYUtilidades.obtenerAleatorioEntero(1,10)) {
            equipoAtacante = equipo1;
            equipoDefensor = equipo2;
            System.out.println("\nAtaca el equipo "+equipo1.getNombre());
        } else {
            equipoAtacante = equipo2;
            equipoDefensor = equipo1;
            System.out.println("\nAtaca el equipo "+equipo2.getNombre());
        }
    }

    public void decidirPosicionesActuales () {
        //EQUIPO ATACANTE
        for (int i = 1; i < 8; i++){
            if(equipoAtacante.devolverArrayListIndicada(i).size()>=1) {
                for (int j = 0; j < equipoAtacante.devolverArrayListIndicada(i).size() ; j++) {
                    int numeroAleatorio = MenuYUtilidades.obtenerAleatorioEntero(1,100);
                    switch (i) {
                        case 1, 2 -> equipoAtacante.devolverArrayListIndicada(i).get(j).setPosicionActual(0);
                        case 3 -> {
                            if (numeroAleatorio <= 50) {
                                equipoAtacante.devolverArrayListIndicada(i).get(j).setPosicionActual(1);
                            } else if (numeroAleatorio <= 80) {
                                equipoAtacante.devolverArrayListIndicada(i).get(j).setPosicionActual(2);
                            } else if (numeroAleatorio <= 90) {
                                equipoAtacante.devolverArrayListIndicada(i).get(j).setPosicionActual(3);
                            } else if (numeroAleatorio <= 97) {
                                equipoAtacante.devolverArrayListIndicada(i).get(j).setPosicionActual(4);
                            } else {
                                equipoAtacante.devolverArrayListIndicada(i).get(j).setPosicionActual(5);
                            }
                        }
                        case 4 -> {
                            if (numeroAleatorio <= 20) {
                                equipoAtacante.devolverArrayListIndicada(i).get(j).setPosicionActual(1);
                            } else if (numeroAleatorio <= 65) {
                                equipoAtacante.devolverArrayListIndicada(i).get(j).setPosicionActual(2);
                            } else if (numeroAleatorio <= 85) {
                                equipoAtacante.devolverArrayListIndicada(i).get(j).setPosicionActual(3);
                            } else if (numeroAleatorio <= 95) {
                                equipoAtacante.devolverArrayListIndicada(i).get(j).setPosicionActual(4);
                            } else {
                                equipoAtacante.devolverArrayListIndicada(i).get(j).setPosicionActual(5);
                            }
                        }
                        case 5 -> {
                            if (numeroAleatorio <= 5) {
                                equipoAtacante.devolverArrayListIndicada(i).get(j).setPosicionActual(1);
                            } else if (numeroAleatorio <= 25) {
                                equipoAtacante.devolverArrayListIndicada(i).get(j).setPosicionActual(2);
                            } else if (numeroAleatorio <= 75) {
                                equipoAtacante.devolverArrayListIndicada(i).get(j).setPosicionActual(3);
                            } else if (numeroAleatorio <= 95) {
                                equipoAtacante.devolverArrayListIndicada(i).get(j).setPosicionActual(4);
                            } else {
                                equipoAtacante.devolverArrayListIndicada(i).get(j).setPosicionActual(5);
                            }
                        }
                        case 6 -> {
                            if (numeroAleatorio <= 5) {
                                equipoAtacante.devolverArrayListIndicada(i).get(j).setPosicionActual(1);
                            } else if (numeroAleatorio <= 15) {
                                equipoAtacante.devolverArrayListIndicada(i).get(j).setPosicionActual(2);
                            } else if (numeroAleatorio <= 35) {
                                equipoAtacante.devolverArrayListIndicada(i).get(j).setPosicionActual(3);
                            } else if (numeroAleatorio <= 80) {
                                equipoAtacante.devolverArrayListIndicada(i).get(j).setPosicionActual(4);
                            } else {
                                equipoAtacante.devolverArrayListIndicada(i).get(j).setPosicionActual(5);
                            }
                        }
                        case 7 -> {
                            if (numeroAleatorio <= 3) {
                                equipoAtacante.devolverArrayListIndicada(i).get(j).setPosicionActual(1);
                            } else if (numeroAleatorio <= 10) {
                                equipoAtacante.devolverArrayListIndicada(i).get(j).setPosicionActual(2);
                            } else if (numeroAleatorio <= 20) {
                                equipoAtacante.devolverArrayListIndicada(i).get(j).setPosicionActual(3);
                            } else if (numeroAleatorio <= 50) {
                                equipoAtacante.devolverArrayListIndicada(i).get(j).setPosicionActual(4);
                            } else {
                                equipoAtacante.devolverArrayListIndicada(i).get(j).setPosicionActual(5);
                            }
                        }
                    }

                }
            }
        }

        //EQUIPO DEFENSOR
        for (int i = 1; i < 8; i++){
            if(equipoDefensor.devolverArrayListIndicada(i).size()>=1) {
                for (int j = 0; j < equipoDefensor.devolverArrayListIndicada(i).size() ; j++) {
                    int numeroAleatorio = MenuYUtilidades.obtenerAleatorioEntero(1,100);
                    switch (i) {
                        case 1, 2 -> equipoDefensor.devolverArrayListIndicada(i).get(j).setPosicionActual(0);
                        case 3 -> {
                            if (numeroAleatorio <= 50) {
                                equipoDefensor.devolverArrayListIndicada(i).get(j).setPosicionActual(5);
                            } else if (numeroAleatorio <= 80) {
                                equipoDefensor.devolverArrayListIndicada(i).get(j).setPosicionActual(4);
                            } else if (numeroAleatorio <= 90) {
                                equipoDefensor.devolverArrayListIndicada(i).get(j).setPosicionActual(3);
                            } else if (numeroAleatorio <= 97) {
                                equipoDefensor.devolverArrayListIndicada(i).get(j).setPosicionActual(2);
                            } else {
                                equipoDefensor.devolverArrayListIndicada(i).get(j).setPosicionActual(1);
                            }
                        }
                        case 4 -> {
                            if (numeroAleatorio <= 20) {
                                equipoDefensor.devolverArrayListIndicada(i).get(j).setPosicionActual(5);
                            } else if (numeroAleatorio <= 65) {
                                equipoDefensor.devolverArrayListIndicada(i).get(j).setPosicionActual(4);
                            } else if (numeroAleatorio <= 85) {
                                equipoDefensor.devolverArrayListIndicada(i).get(j).setPosicionActual(3);
                            } else if (numeroAleatorio <= 95) {
                                equipoDefensor.devolverArrayListIndicada(i).get(j).setPosicionActual(2);
                            } else {
                                equipoDefensor.devolverArrayListIndicada(i).get(j).setPosicionActual(1);
                            }
                        }
                        case 5 -> {
                            if (numeroAleatorio <= 5) {
                                equipoDefensor.devolverArrayListIndicada(i).get(j).setPosicionActual(5);
                            } else if (numeroAleatorio <= 25) {
                                equipoDefensor.devolverArrayListIndicada(i).get(j).setPosicionActual(4);
                            } else if (numeroAleatorio <= 75) {
                                equipoDefensor.devolverArrayListIndicada(i).get(j).setPosicionActual(3);
                            } else if (numeroAleatorio <= 95) {
                                equipoDefensor.devolverArrayListIndicada(i).get(j).setPosicionActual(2);
                            } else {
                                equipoDefensor.devolverArrayListIndicada(i).get(j).setPosicionActual(1);
                            }
                        }
                        case 6 -> {
                            if (numeroAleatorio <= 5) {
                                equipoDefensor.devolverArrayListIndicada(i).get(j).setPosicionActual(5);
                            } else if (numeroAleatorio <= 15) {
                                equipoDefensor.devolverArrayListIndicada(i).get(j).setPosicionActual(4);
                            } else if (numeroAleatorio <= 35) {
                                equipoDefensor.devolverArrayListIndicada(i).get(j).setPosicionActual(3);
                            } else if (numeroAleatorio <= 80) {
                                equipoDefensor.devolverArrayListIndicada(i).get(j).setPosicionActual(2);
                            } else {
                                equipoDefensor.devolverArrayListIndicada(i).get(j).setPosicionActual(1);
                            }
                        }
                        case 7 -> {
                            if (numeroAleatorio <= 3) {
                                equipoDefensor.devolverArrayListIndicada(i).get(j).setPosicionActual(5);
                            } else if (numeroAleatorio <= 10) {
                                equipoDefensor.devolverArrayListIndicada(i).get(j).setPosicionActual(4);
                            } else if (numeroAleatorio <= 20) {
                                equipoDefensor.devolverArrayListIndicada(i).get(j).setPosicionActual(3);
                            } else if (numeroAleatorio <= 50) {
                                equipoDefensor.devolverArrayListIndicada(i).get(j).setPosicionActual(2);
                            } else {
                                equipoDefensor.devolverArrayListIndicada(i).get(j).setPosicionActual(1);
                            }
                        }
                    }

                }
            }
        }
    }

    public void mostrarPosicionesActuales () {
        System.out.println("\nPosiciones jugadores de " + equipoAtacante.getNombre());
        for (int i = 3; i < 8; i++) {
            if (equipoAtacante.devolverArrayListIndicada(i).size() >= 1) {
                for (int j = 0; j < equipoAtacante.devolverArrayListIndicada(i).size(); j++) {
                    int posicionActual = equipoAtacante.devolverArrayListIndicada(i).get(j).getPosicionActual();
                    switch (posicionActual) {
                        case 1 -> System.out.println(equipoAtacante.devolverArrayListIndicada(i).get(j).getNombre() + " se encuentra como defensor");
                        case 2 -> System.out.println(equipoAtacante.devolverArrayListIndicada(i).get(j).getNombre() + " se encuentra como mediocampista defensivo");
                        case 3 -> System.out.println(equipoAtacante.devolverArrayListIndicada(i).get(j).getNombre() + " se encuentra como mediocampista");
                        case 4 -> System.out.println(equipoAtacante.devolverArrayListIndicada(i).get(j).getNombre() + " se encuentra como mediocampista ofensivo");
                        case 5 -> System.out.println(equipoAtacante.devolverArrayListIndicada(i).get(j).getNombre() + " se encuentra como delantero");
                        default -> System.out.println("Error");
                    }
                }
            }
        }

        System.out.println("\nPosiciones jugadores de " + equipoDefensor.getNombre());
        for (int i = 3; i < 8; i++) {
            if (equipoDefensor.devolverArrayListIndicada(i).size() >= 1) {
                for (int j = 0; j < equipoDefensor.devolverArrayListIndicada(i).size(); j++) {
                    int posicionActual = equipoDefensor.devolverArrayListIndicada(i).get(j).getPosicionActual();
                    switch (posicionActual) {
                        case 1 -> System.out.println(equipoDefensor.devolverArrayListIndicada(i).get(j).getNombre() + " se encuentra como delantero");
                        case 2 -> System.out.println(equipoDefensor.devolverArrayListIndicada(i).get(j).getNombre() + " se encuentra como mediocampista ofensivo");
                        case 3 -> System.out.println(equipoDefensor.devolverArrayListIndicada(i).get(j).getNombre() + " se encuentra como mediocampista");
                        case 4 -> System.out.println(equipoDefensor.devolverArrayListIndicada(i).get(j).getNombre() + " se encuentra como mediocampista defensivo");
                        case 5 -> System.out.println(equipoDefensor.devolverArrayListIndicada(i).get(j).getNombre() + " se encuentra como defensor");
                        default -> System.out.println("Error");
                    }
                }
            }
        }

    }

    public void sortearLaPelota () {
        ArrayList<Jugador> jugadoresPosibles = new ArrayList<>();
        Jugador jugadorQueTieneElBalon;

        for (int i = 3; i < 8; i++) {
            if (equipoAtacante.devolverArrayListIndicada(i).size() >= 1) {
                for (int j = 0; j < equipoAtacante.devolverArrayListIndicada(i).size(); j++) {
                    int posicionActual = equipoAtacante.devolverArrayListIndicada(i).get(j).getPosicionActual();
                    switch (posicionActual) {
                        case 0 -> {
                        }
                        case 1 -> jugadoresPosibles.add(equipoAtacante.devolverArrayListIndicada(i).get(j));
                        case 2, 5 -> {
                            jugadoresPosibles.add(equipoAtacante.devolverArrayListIndicada(i).get(j));
                            jugadoresPosibles.add(equipoAtacante.devolverArrayListIndicada(i).get(j));
                        }
                        case 3, 4 -> {
                            jugadoresPosibles.add(equipoAtacante.devolverArrayListIndicada(i).get(j));
                            jugadoresPosibles.add(equipoAtacante.devolverArrayListIndicada(i).get(j));
                            jugadoresPosibles.add(equipoAtacante.devolverArrayListIndicada(i).get(j));
                        }
                    }
                }
            }
        }

        jugadorQueTieneElBalon = jugadoresPosibles.get(MenuYUtilidades.obtenerAleatorioEntero(0, jugadoresPosibles.size() - 1));
        nombreJugadorConPelota = jugadorQueTieneElBalon.getNombre();
        equipoAtacante.darlePelotaAJugadorConNombre(nombreJugadorConPelota);
        ubicacionPelota = equipoAtacante.devolverJugadorConPelota().getPosicionActual();

        System.out.println("\n"+nombreJugadorConPelota+" obtiene la pelota.");
    }

    public void aumentarMinutos () {
        minutos++;
        turno=1;
    }

    public void menuJugada () {
        boolean finalizaLaJugada = false;
        int numeroElegido;
        ArrayList<JugadorDeCampo> todosLosJugadoresEnCampo;

        while (!finalizaLaJugada) {

            if(turno % 3 != 0){
                System.out.println("\nLe toca al equipo atacante: "+ equipoAtacante.getNombre());
                System.out.println("""

                        Decida que acción quiere realizar.
                        1. Tácticas
                        2. Regatear
                        3. Realizar pase
                        4. Mover jugador
                        5. Disparar al arco
                        6. Pasar el turno
                        7. Finalizar la jugada
                        8. Estadísticas jugadores en cancha
                        """
                );
                numeroElegido = MenuYUtilidades.limitadorMenu(1,8);

                switch (numeroElegido) {

                    //TÁCTICAS
                    case 1 -> {
                        int numeroDeEquipo = equipoAtacante.getNumeroDeEquipo();

                        switch (numeroDeEquipo) {
                            case 1 -> {
                                if (equipo1.getTacticasUsadas() < equipo1.getTacticasPosibles()) {
                                    equipo1.menuEquipos();
                                    equipo1.aumentarTacticasUsadas();
                                    System.out.println("\nTácticas restantes: " + (equipo1.getTacticasPosibles() - equipo1.getTacticasUsadas()));
                                } else {
                                    System.out.println("No quedan tácticas restantes.");
                                }
                            }
                            case 2 -> {
                                if (equipo2.getTacticasUsadas() < equipo2.getTacticasPosibles()) {
                                    equipo2.menuEquipos();
                                    equipo2.aumentarTacticasUsadas();
                                    System.out.println("\nTácticas restantes: " + (equipo2.getTacticasPosibles() - equipo2.getTacticasUsadas()));
                                } else {
                                    System.out.println("No quedan tácticas restantes.");
                                }
                            }
                        }

                    }


                    //REGATE
                    case 2 -> {
                        System.out.println("Se intenta regatear:");
                        ArrayList<JugadorDeCampo> listaJugadoresAtacantesParaRegatear = equipoAtacante.devolverJugadoresEntreZonas(ubicacionPelota, ubicacionPelota);
                        ArrayList<JugadorDeCampo> listaJugadoresDefensoresParaRegatear = equipoDefensor.devolverJugadoresEntreZonas(ubicacionPelota, ubicacionPelota);
                        int modificadorAtacantesParaRegatear, modificadorDefensoresParaRegatear, aleatorioDefensivo, aleatorioOfensivo;
                        modificadorAtacantesParaRegatear = 0;
                        modificadorDefensoresParaRegatear = 0;

                        if (listaJugadoresDefensoresParaRegatear.size() < 1) {
                            System.out.println("No hay defensores que puedan quitarle la pelota.");
                            System.out.println(nombreJugadorConPelota + " consiguió regatear con éxito");
                            equipoAtacante.moverJugadorConNombre(1, nombreJugadorConPelota);
                            ubicacionPelota = equipoAtacante.devolverJugadorConPelota().getPosicionActual();
                            if (ubicacionPelota > 5) {
                                System.out.println("Hay situación de mano a mano entre el jugador " +
                                        nombreJugadorConPelota + " con " + equipoAtacante.devolverJugadorConPelota().getDisparoCorto() +
                                        " y el arquero " + equipoDefensor.getArquero().getNombre() + " con " + equipoDefensor.getArquero().getCortaDistancia()
                                );
                                aleatorioDefensivo = MenuYUtilidades.obtenerAleatorioEntero(1, 10);
                                aleatorioOfensivo = MenuYUtilidades.obtenerAleatorioEntero(1, 10);
                                System.out.println("La tirada de dados ofensiva es de " + aleatorioOfensivo);
                                System.out.println("La tirada de dados defensiva es de " + aleatorioDefensivo);
                                if (equipoAtacante.devolverJugadorConPelota().getDisparoCorto() + aleatorioOfensivo >= equipoDefensor.getArquero().getCortaDistancia() + aleatorioDefensivo) {
                                    System.out.println("¡GOOOOOOOOOOOOOOOOOL!");
                                    if (equipoAtacante.getNumeroDeEquipo() == 1) {
                                        golesEquipo1++;
                                    } else if (equipoAtacante.getNumeroDeEquipo() == 2) {
                                        golesEquipo2++;
                                    }
                                    System.out.println(equipo1.getNombre() + " " + golesEquipo1 + " - " + equipo2.getNombre() + " " + golesEquipo2);
                                } else {
                                    System.out.println("Ataja el arquero!!!");
                                }
                                finalizaLaJugada = true;
                            } else {
                                turno++;
                            }
                            break;
                        }

                        for (JugadorDeCampo jugadoresAtacantesParaRegatear : listaJugadoresAtacantesParaRegatear) {
                            if (jugadoresAtacantesParaRegatear.getNombre().equals(nombreJugadorConPelota)) {
                                System.out.println("Intentará regatear " + nombreJugadorConPelota + " con " + equipoAtacante.devolverJugadorConPelota().getRegates());
                                modificadorAtacantesParaRegatear += equipoAtacante.devolverJugadorConPelota().getRegates();
                            } else {
                                System.out.println("Apoyará ofensivamente " + jugadoresAtacantesParaRegatear.getNombre() + " con " + jugadoresAtacantesParaRegatear.getApoyoOfensivo());
                                modificadorAtacantesParaRegatear += jugadoresAtacantesParaRegatear.getApoyoOfensivo();
                            }
                        }

                        for (int i = 0; i < listaJugadoresDefensoresParaRegatear.size(); i++) {
                            int jugadorDefensor;
                            jugadorDefensor = MenuYUtilidades.obtenerAleatorioEntero(0, listaJugadoresDefensoresParaRegatear.size() - 1);
                            if (i == jugadorDefensor) {
                                System.out.println("Intentará conseguir el balón " + listaJugadoresDefensoresParaRegatear.get(i).getNombre() + " con " + listaJugadoresDefensoresParaRegatear.get(i).getEntradas());
                                modificadorDefensoresParaRegatear += listaJugadoresDefensoresParaRegatear.get(i).getEntradas();
                            } else {
                                System.out.println("Apoyará defensivamente " + listaJugadoresDefensoresParaRegatear.get(i).getNombre() + " con " + listaJugadoresDefensoresParaRegatear.get(i).getApoyoDefensivo());
                                modificadorDefensoresParaRegatear += listaJugadoresDefensoresParaRegatear.get(i).getApoyoDefensivo();
                            }
                        }

                        System.out.println("Los modificadores son: ○ Atacante " + modificadorAtacantesParaRegatear + " ○ Defensivo " + modificadorDefensoresParaRegatear);
                        aleatorioDefensivo = MenuYUtilidades.obtenerAleatorioEntero(1, 10);
                        aleatorioOfensivo = MenuYUtilidades.obtenerAleatorioEntero(1, 10);
                        System.out.println("La tirada de dados ofensiva es de " + aleatorioOfensivo);
                        System.out.println("La tirada de dados defensiva es de " + aleatorioDefensivo);
                        if (modificadorAtacantesParaRegatear + aleatorioOfensivo >= modificadorDefensoresParaRegatear + aleatorioDefensivo) {
                            System.out.println(nombreJugadorConPelota + " consiguió regatear con éxito");
                            equipoAtacante.moverJugadorConNombre(1, nombreJugadorConPelota);
                            ubicacionPelota = equipoAtacante.devolverJugadorConPelota().getPosicionActual();
                            if (ubicacionPelota > 5) {
                                System.out.println("Hay situación de mano a mano entre el jugador " +
                                        nombreJugadorConPelota + " con " + equipoAtacante.devolverJugadorConPelota().getDisparoCorto() +
                                        " y el arquero " + equipoDefensor.getArquero().getNombre() + " con " + equipoDefensor.getArquero().getCortaDistancia()
                                );
                                aleatorioDefensivo = MenuYUtilidades.obtenerAleatorioEntero(1, 10);
                                aleatorioOfensivo = MenuYUtilidades.obtenerAleatorioEntero(1, 10);
                                System.out.println("La tirada de dados ofensiva es de " + aleatorioOfensivo);
                                System.out.println("La tirada de dados defensiva es de " + aleatorioDefensivo);
                                if (equipoAtacante.devolverJugadorConPelota().getDisparoCorto() + aleatorioOfensivo >= equipoDefensor.getArquero().getCortaDistancia() + aleatorioDefensivo) {
                                    System.out.println("¡GOOOOOOOOOOOOOOOOOL!");
                                    if (equipoAtacante.getNumeroDeEquipo() == 1) {
                                        golesEquipo1++;
                                    } else if (equipoAtacante.getNumeroDeEquipo() == 2) {
                                        golesEquipo2++;
                                    }
                                    System.out.println(equipo1.getNombre() + " " + golesEquipo1 + " - " + equipo2.getNombre() + " " + golesEquipo2);
                                } else {
                                    System.out.println("Ataja el arquero!!!");
                                }
                                finalizaLaJugada = true;
                            }
                        } else {
                            System.out.println(nombreJugadorConPelota + " no consiguió regatear con éxito. \nFinalizó la jugada.");
                            finalizaLaJugada = true;
                        }

                        turno++;
                    }
                    case 3 -> {
                        int destinoDelPase;
                        String nombreJugadorDestinoDelPase;
                        int movimientosARealizar;
                        int posicionDestinoDelPase;

                        System.out.println("\nSe intenta realizar un pase");
                        System.out.println("Elija el destino del pase:");
                        todosLosJugadoresEnCampo = equipoAtacante.devolverJugadoresEntreZonas(1, 5);

                        for (int i = 0; i < todosLosJugadoresEnCampo.size(); i++) {
                            if (nombreJugadorConPelota.equals(todosLosJugadoresEnCampo.get(i).getNombre())) {
                                todosLosJugadoresEnCampo.remove(i);
                                break;
                            }
                        }

                        for (int i = 0; i < todosLosJugadoresEnCampo.size(); i++) {
                            System.out.println((i + 1) + ". " + todosLosJugadoresEnCampo.get(i).getNombre());
                        }

                        destinoDelPase = (MenuYUtilidades.limitadorMenu(1, todosLosJugadoresEnCampo.size())) - 1;
                        nombreJugadorDestinoDelPase = todosLosJugadoresEnCampo.get(destinoDelPase).getNombre();
                        posicionDestinoDelPase = equipoAtacante.devolverJugadorConNombre(nombreJugadorDestinoDelPase).getPosicionActual();
                        movimientosARealizar = ubicacionPelota - posicionDestinoDelPase;

                        int posicionMayor, posicionMenor;
                        posicionMayor = Math.max(ubicacionPelota, posicionDestinoDelPase);
                        posicionMenor = Math.min(ubicacionPelota, posicionDestinoDelPase);

                        ArrayList<JugadorDeCampo> listaJugadoresAtacantesParaPase = equipoAtacante.devolverJugadoresEntreZonas(posicionMenor, posicionMayor);
                        ArrayList<JugadorDeCampo> listaJugadoresDefensoresParaPase = equipoDefensor.devolverJugadoresEntreZonas(posicionMenor, posicionMayor);
                        ArrayList<JugadorDeCampo> listaJugadoresDefensoresConEntradasParaPase = equipoDefensor.devolverJugadoresEntreZonas(ubicacionPelota, ubicacionPelota);
                        ArrayList<JugadorDeCampo> listaJugadoresDefensoresConMarcajeParaPase = equipoDefensor.devolverJugadoresEntreZonas(posicionDestinoDelPase, posicionDestinoDelPase);
                        int modificadorAtacantesParaPase, modificadorDefensoresParaPase, modificadorPorDistanciaDelPase, aleatorioDefensivo, aleatorioOfensivo, entradasAlPase, marcaAlPase;
                        String nombreEntradasAlPase, nombreMarcaAlPase;
                        modificadorAtacantesParaPase = 0;
                        modificadorDefensoresParaPase = 0;
                        modificadorPorDistanciaDelPase = 0;
                        nombreEntradasAlPase = "";
                        nombreMarcaAlPase = "";


                        for (JugadorDeCampo jugadoresAtacantesParaPase : listaJugadoresAtacantesParaPase) {
                            if (jugadoresAtacantesParaPase.getNombre().equals(nombreJugadorConPelota)) {
                                System.out.println("Intentará realizar el pase " + nombreJugadorConPelota + " con " + equipoAtacante.devolverJugadorConPelota().getPase());
                                modificadorAtacantesParaPase += equipoAtacante.devolverJugadorConPelota().getPase();
                            } else if (jugadoresAtacantesParaPase.getNombre().equals(nombreJugadorDestinoDelPase)) {
                                System.out.println("Intentará recibir el pase " + nombreJugadorDestinoDelPase + " con " + jugadoresAtacantesParaPase.getUbicacion());
                                modificadorAtacantesParaPase += jugadoresAtacantesParaPase.getUbicacion();
                            } else {
                                System.out.println("Apoyará ofensivamente " + jugadoresAtacantesParaPase.getNombre() + " con " + jugadoresAtacantesParaPase.getApoyoOfensivo());
                                modificadorAtacantesParaPase += jugadoresAtacantesParaPase.getApoyoOfensivo();
                            }
                        }

                        if (listaJugadoresDefensoresConEntradasParaPase.size() > 0) {
                            entradasAlPase = MenuYUtilidades.obtenerAleatorioEntero(0, listaJugadoresDefensoresConEntradasParaPase.size() - 1);
                            nombreEntradasAlPase = listaJugadoresDefensoresConEntradasParaPase.get(entradasAlPase).getNombre();
                            System.out.println("Intentará quitar la pelota " + nombreEntradasAlPase + " con " + listaJugadoresDefensoresConEntradasParaPase.get(entradasAlPase).getEntradas());
                            modificadorDefensoresParaPase += listaJugadoresDefensoresConEntradasParaPase.get(entradasAlPase).getEntradas();
                        }

                        for (int i = 0; i < listaJugadoresDefensoresConMarcajeParaPase.size(); i++) {
                            if (nombreEntradasAlPase.equals(listaJugadoresDefensoresConMarcajeParaPase.get(i).getNombre())) {
                                listaJugadoresDefensoresConMarcajeParaPase.remove(i);
                                break;
                            }
                        }

                        if (listaJugadoresDefensoresConMarcajeParaPase.size() > 0) {
                            marcaAlPase = MenuYUtilidades.obtenerAleatorioEntero(0, listaJugadoresDefensoresConMarcajeParaPase.size() - 1);
                            nombreMarcaAlPase = listaJugadoresDefensoresConMarcajeParaPase.get(marcaAlPase).getNombre();
                            System.out.println("Intentará interceptar la pelota " + nombreMarcaAlPase + " con " + listaJugadoresDefensoresConMarcajeParaPase.get(marcaAlPase).getMarcaje());
                            modificadorDefensoresParaPase += listaJugadoresDefensoresConMarcajeParaPase.get(marcaAlPase).getMarcaje();
                        }

                        for (JugadorDeCampo jugadoresDefensoresParaPase : listaJugadoresDefensoresParaPase) {
                            if (!jugadoresDefensoresParaPase.getNombre().equals(nombreEntradasAlPase) && !jugadoresDefensoresParaPase.getNombre().equals(nombreMarcaAlPase)) {
                                System.out.println("Apoyará defensivamente " + jugadoresDefensoresParaPase.getNombre() + " con " + jugadoresDefensoresParaPase.getApoyoDefensivo());
                                modificadorDefensoresParaPase += jugadoresDefensoresParaPase.getApoyoDefensivo();
                            }
                        }

                        modificadorPorDistanciaDelPase = switch (Math.abs(movimientosARealizar)) {
                            case 0 -> 0;
                            case 1 -> 2;
                            case 2 -> 4;
                            case 3 -> 7;
                            case 4 -> 9;
                            default -> modificadorPorDistanciaDelPase;
                        };

                        System.out.println("Los modificadores son: ○ Atacante " + modificadorAtacantesParaPase + " ○ Defensivo " + modificadorDefensoresParaPase + " ○ Por distancia " + modificadorPorDistanciaDelPase);
                        aleatorioDefensivo = MenuYUtilidades.obtenerAleatorioEntero(1, 10);
                        aleatorioOfensivo = MenuYUtilidades.obtenerAleatorioEntero(1, 10);
                        System.out.println("La tirada de dados ofensiva es de " + aleatorioOfensivo);
                        System.out.println("La tirada de dados defensiva es de " + aleatorioDefensivo);
                        if (modificadorAtacantesParaPase + aleatorioOfensivo >= modificadorDefensoresParaPase + aleatorioDefensivo + modificadorPorDistanciaDelPase) {
                            System.out.println("\nPase exitoso...");
                            equipoAtacante.quitarlePelotaAJugadorQueLaTiene();
                            equipoAtacante.darlePelotaAJugadorConNombre(nombreJugadorDestinoDelPase);
                            nombreJugadorConPelota = nombreJugadorDestinoDelPase;
                            ubicacionPelota = equipoAtacante.devolverJugadorConPelota().getPosicionActual();
                            turno++;
                        } else {
                            System.out.println("\nPase erroneo. Finaliza la jugada.");
                            finalizaLaJugada = true;
                        }

                    }


                    //MOVER
                    case 4 -> {
                        int jugadorAMover;
                        String nombreJugadorAMover;
                        int movimientosARealizar = 0;

                        System.out.println("\nSe moverá un jugador");
                        System.out.println("Elija el jugador que quiere mover:");
                        todosLosJugadoresEnCampo = equipoAtacante.devolverJugadoresEntreZonas(1, 5);

                        for (int i = 0; i < todosLosJugadoresEnCampo.size(); i++) {
                            if (nombreJugadorConPelota.equals(todosLosJugadoresEnCampo.get(i).getNombre())) {
                                todosLosJugadoresEnCampo.remove(i);
                                break;
                            }
                        }

                        for (int i = 0; i < todosLosJugadoresEnCampo.size(); i++) {
                            System.out.println((i + 1) + ". " + todosLosJugadoresEnCampo.get(i).getNombre());
                        }

                        jugadorAMover = (MenuYUtilidades.limitadorMenu(1, todosLosJugadoresEnCampo.size())) - 1;
                        nombreJugadorAMover = todosLosJugadoresEnCampo.get(jugadorAMover).getNombre();

                        if (todosLosJugadoresEnCampo.get(jugadorAMover).getVelocidad() == 2) {
                            System.out.println("""
                                    Decida como quiere mover el jugador, ingresando:
                                     • -2 para retroceder dos posiciones
                                     • -1 para retroceder una posición
                                     • 1 para avanzar una posición
                                     • 2 para avanzar dos posiciones
                                    \s"""
                            );
                            movimientosARealizar = MenuYUtilidades.limitadorMenu(-2, 2);
                        } else if (todosLosJugadoresEnCampo.get(jugadorAMover).getVelocidad() == 1) {
                            System.out.println("""
                                    Decida como quiere mover el jugador, ingresando:
                                     • -1 para retroceder una posición
                                     • 1 para avanzar una posición
                                    \s"""
                            );
                            movimientosARealizar = MenuYUtilidades.limitadorMenu(-1, 1);
                        }

                        if (equipoAtacante.devolverJugadorConNombre(nombreJugadorAMover).getPosicionActual() + movimientosARealizar > 5 ||
                                equipoAtacante.devolverJugadorConNombre(nombreJugadorAMover).getPosicionActual() + movimientosARealizar < 1) {
                            System.out.println("No puedes moverte hacia esa posición.");
                        } else if (movimientosARealizar == 0) {
                            System.out.println("No puedes moverte 0 posiciones.");
                        } else {
                            equipoAtacante.moverJugadorConNombre(movimientosARealizar, nombreJugadorAMover);
                            System.out.println("El jugador " + nombreJugadorAMover + " se ha movido con éxito.");
                            turno++;
                        }

                    }


                    //DISPARO
                    case 5 -> {
                        System.out.println("Se intenta disparar a puerta:");
                        ArrayList<JugadorDeCampo> listaJugadoresAtacantesParaDisparar = equipoAtacante.devolverJugadoresEntreZonas(ubicacionPelota, 5);
                        ArrayList<JugadorDeCampo> listaJugadoresDefensoresParaDisparar = equipoDefensor.devolverJugadoresEntreZonas(ubicacionPelota, 5);
                        int modificadorAtacantesParaDisparar, modificadorDefensoresParaDisparar, modificadorPorDistanciaDelArco, aleatorioDefensivo, aleatorioOfensivo;
                        modificadorAtacantesParaDisparar = 0;
                        modificadorDefensoresParaDisparar = 0;
                        modificadorPorDistanciaDelArco = 0;

                        for (JugadorDeCampo jugadoresAtacantesParaDisparar : listaJugadoresAtacantesParaDisparar) {
                            if (jugadoresAtacantesParaDisparar.getNombre().equals(nombreJugadorConPelota)) {
                                if (equipoAtacante.devolverJugadorConPelota().getPosicionActual() < 5) {
                                    System.out.println("Intentará anotar el gol " + nombreJugadorConPelota + " con " + equipoAtacante.devolverJugadorConPelota().getDisparoLargo());
                                    modificadorAtacantesParaDisparar += equipoAtacante.devolverJugadorConPelota().getDisparoLargo();
                                } else {
                                    System.out.println("Intentará anotar el gol " + nombreJugadorConPelota + " con " + equipoAtacante.devolverJugadorConPelota().getDisparoCorto());
                                    modificadorAtacantesParaDisparar += equipoAtacante.devolverJugadorConPelota().getDisparoCorto();
                                }
                            } else {
                                System.out.println("Apoyará ofensivamente " + jugadoresAtacantesParaDisparar.getNombre() + " con " + jugadoresAtacantesParaDisparar.getApoyoOfensivo());
                                modificadorAtacantesParaDisparar += jugadoresAtacantesParaDisparar.getApoyoOfensivo();
                            }
                        }

                        if (equipoAtacante.devolverJugadorConPelota().getPosicionActual() < 5) {
                            System.out.println("Intentará atajar el disparo " + equipoDefensor.getArquero().getNombre() + " con " + equipoDefensor.getArquero().getMediaDistancia());
                            modificadorDefensoresParaDisparar += equipoDefensor.getArquero().getMediaDistancia();
                        } else {
                            System.out.println("Intentará atajar el disparo " + equipoDefensor.getArquero().getNombre() + " con " + equipoDefensor.getArquero().getCortaDistancia());
                            modificadorDefensoresParaDisparar += equipoDefensor.getArquero().getCortaDistancia();
                        }
                        for (JugadorDeCampo jugadoresDefensoresParaDisparar : listaJugadoresDefensoresParaDisparar) {
                            System.out.println("Apoyará defensivamente " + jugadoresDefensoresParaDisparar.getNombre() + " con " + jugadoresDefensoresParaDisparar.getApoyoDefensivo());
                            modificadorDefensoresParaDisparar += jugadoresDefensoresParaDisparar.getApoyoDefensivo();
                        }

                        modificadorPorDistanciaDelArco = switch (equipoAtacante.devolverJugadorConPelota().getPosicionActual()) {
                            case 1 -> 9;
                            case 2 -> 8;
                            case 3 -> 7;
                            case 4 -> 4;
                            case 5 -> 2;
                            default -> modificadorPorDistanciaDelArco;
                        };

                        System.out.println("Los modificadores son: ○ Atacante " + modificadorAtacantesParaDisparar + " ○ Defensivo " + modificadorDefensoresParaDisparar + " ○ Por distancia " + modificadorPorDistanciaDelArco);
                        aleatorioDefensivo = MenuYUtilidades.obtenerAleatorioEntero(1, 10);
                        aleatorioOfensivo = MenuYUtilidades.obtenerAleatorioEntero(1, 10);
                        System.out.println("La tirada de dados ofensiva es de " + aleatorioOfensivo);
                        System.out.println("La tirada de dados defensiva es de " + aleatorioDefensivo);
                        if (modificadorAtacantesParaDisparar + aleatorioOfensivo >= modificadorDefensoresParaDisparar + aleatorioDefensivo + modificadorPorDistanciaDelArco) {
                            System.out.println("¡GOOOOOOOOOOOOOOOOOL!");
                            if (equipoAtacante.getNumeroDeEquipo() == 1) {
                                golesEquipo1++;
                            } else if (equipoAtacante.getNumeroDeEquipo() == 2) {
                                golesEquipo2++;
                            }
                            System.out.println(equipo1.getNombre() + " " + golesEquipo1 + " - " + equipo2.getNombre() + " " + golesEquipo2);
                        } else {
                            System.out.println("Ataja el arquero!!!");
                        }

                        finalizaLaJugada = true;
                    }


                    //PASAR
                    case 6 -> {
                        System.out.println("Pasando el turno");
                        turno++;
                    }


                    //FINALIZAR
                    case 7 -> {
                        System.out.println("Finalizando jugada...");
                        finalizaLaJugada = true;
                    }


                    //ESTADÍSTICAS
                    case 8 -> {
                        System.out.println("\nLos jugadores de tu equipo tienen las siguientes estadísticas: ");
                        todosLosJugadoresEnCampo = equipoAtacante.devolverJugadoresEntreZonas(1, 5);
                        for (JugadorDeCampo jugadorEnCampo : todosLosJugadoresEnCampo) {
                            System.out.println();
                            jugadorEnCampo.imprimirEstadisticas();
                        }
                        System.out.println();
                        equipoAtacante.devolverArrayListIndicada(2).get(0).imprimirEstadisticas();
                    }
                }

            } else {
                System.out.println("\nLe toca al equipo defensor: "+ equipoDefensor.getNombre());

                System.out.println("""

                        Decida que acción quiere realizar.
                        1. Tácticas
                        2. Quitar el balón
                        3. Mover jugador
                        4. Pasar el turno
                        5. Estadísticas jugadores en cancha"""
                );
                numeroElegido = MenuYUtilidades.limitadorMenu(1,5);

                switch (numeroElegido) {
                    //TÁCTICAS
                    case 1 -> {
                        int numeroDeEquipo = equipoDefensor.getNumeroDeEquipo();

                        switch (numeroDeEquipo) {
                            case 1 -> {
                                if (equipo1.getTacticasUsadas() < equipo1.getTacticasPosibles()) {
                                    equipo1.menuEquipos();
                                    equipo1.aumentarTacticasUsadas();
                                    System.out.println("\nTácticas restantes: " + (equipo1.getTacticasPosibles() - equipo1.getTacticasUsadas()));
                                } else {
                                    System.out.println("No quedan tácticas restantes.");
                                }
                            }
                            case 2 -> {
                                if (equipo2.getTacticasUsadas() < equipo2.getTacticasPosibles()) {
                                    equipo2.menuEquipos();
                                    equipo2.aumentarTacticasUsadas();
                                    System.out.println("\nTácticas restantes: " + (equipo2.getTacticasPosibles() - equipo2.getTacticasUsadas()));
                                } else {
                                    System.out.println("No quedan tácticas restantes.");
                                }
                            }
                        }

                    }


                    //QUITAR BALON
                    case 2 -> {
                        System.out.println("Se intenta quitar el balón:");
                        ArrayList<JugadorDeCampo> listaJugadoresAtacantesParaQuite = equipoAtacante.devolverJugadoresEntreZonas(ubicacionPelota, ubicacionPelota);
                        ArrayList<JugadorDeCampo> listaJugadoresDefensoresParaQuite = equipoDefensor.devolverJugadoresEntreZonas(ubicacionPelota, ubicacionPelota);
                        int modificadorAtacantesParaQuite, modificadorDefensoresParaQuite, aleatorioDefensivo, aleatorioOfensivo;
                        modificadorAtacantesParaQuite = 0;
                        modificadorDefensoresParaQuite = 0;

                        if (listaJugadoresDefensoresParaQuite.size() < 1) {
                            System.out.println("No tienes jugadores en la zona donde está la pelota para intentar quitarla.");
                            break;
                        }

                        for (JugadorDeCampo jugadoresAtacantesParaQuite : listaJugadoresAtacantesParaQuite) {
                            if (jugadoresAtacantesParaQuite.getNombre().equals(nombreJugadorConPelota)) {
                                System.out.println("Intentará mantener la pelota " + nombreJugadorConPelota + " con " + equipoAtacante.devolverJugadorConPelota().getRegates());
                                modificadorAtacantesParaQuite += equipoAtacante.devolverJugadorConPelota().getRegates();
                            } else {
                                System.out.println("Apoyará ofensivamente " + jugadoresAtacantesParaQuite.getNombre() + " con " + jugadoresAtacantesParaQuite.getApoyoOfensivo());
                                modificadorAtacantesParaQuite += jugadoresAtacantesParaQuite.getApoyoOfensivo();
                            }
                        }

                        System.out.println("Elija el jugador que quiere que quite la pelota:");

                        for (int i = 0; i < listaJugadoresDefensoresParaQuite.size(); i++) {
                            System.out.println((i + 1) + ". " + listaJugadoresDefensoresParaQuite.get(i).getNombre());
                        }

                        int jugadorQueQuita;
                        String nombreJugadorQueQuita;
                        jugadorQueQuita = (MenuYUtilidades.limitadorMenu(1, listaJugadoresDefensoresParaQuite.size())) - 1;
                        nombreJugadorQueQuita = listaJugadoresDefensoresParaQuite.get(jugadorQueQuita).getNombre();

                        for (JugadorDeCampo jugadoresDefensoresParaQuite : listaJugadoresDefensoresParaQuite) {
                            if (nombreJugadorQueQuita.equals(jugadoresDefensoresParaQuite.getNombre())) {
                                System.out.println("Intentará conseguir el balón " + nombreJugadorQueQuita + " con " + jugadoresDefensoresParaQuite.getEntradas());
                                modificadorDefensoresParaQuite += jugadoresDefensoresParaQuite.getEntradas();
                            } else {
                                System.out.println("Apoyará defensivamente " + jugadoresDefensoresParaQuite.getNombre() + " con " + jugadoresDefensoresParaQuite.getApoyoDefensivo());
                                modificadorDefensoresParaQuite += jugadoresDefensoresParaQuite.getApoyoDefensivo();
                            }
                        }

                        System.out.println("Los modificadores son: ○ Atacante " + modificadorAtacantesParaQuite + " ○ Defensivo " + modificadorDefensoresParaQuite);
                        aleatorioDefensivo = MenuYUtilidades.obtenerAleatorioEntero(1, 10);
                        aleatorioOfensivo = MenuYUtilidades.obtenerAleatorioEntero(1, 10);
                        System.out.println("La tirada de dados ofensiva es de " + aleatorioOfensivo);
                        System.out.println("La tirada de dados defensiva es de " + aleatorioDefensivo);
                        if (modificadorAtacantesParaQuite + aleatorioOfensivo > modificadorDefensoresParaQuite + aleatorioDefensivo) {
                            System.out.println(nombreJugadorConPelota + " consiguió mantenerse con la pelota frente al jugador " + nombreJugadorQueQuita);
                            turno++;
                        } else {
                            System.out.println(nombreJugadorConPelota + " perdió la pelota frente al jugador " + nombreJugadorQueQuita + "\nFinalizó la jugada.");
                            finalizaLaJugada = true;
                        }

                    }


                    //MOVER
                    case 3 -> {
                        int jugadorAMover;
                        String nombreJugadorAMover;
                        int movimientosARealizar = 0;

                        System.out.println("\nSe moverá un jugador");
                        System.out.println("Elija el jugador que quiere mover:");
                        todosLosJugadoresEnCampo = equipoDefensor.devolverJugadoresEntreZonas(1, 5);

                        for (int i = 0; i < todosLosJugadoresEnCampo.size(); i++) {
                            System.out.println((i + 1) + ". " + todosLosJugadoresEnCampo.get(i).getNombre());
                        }

                        jugadorAMover = (MenuYUtilidades.limitadorMenu(1, todosLosJugadoresEnCampo.size())) - 1;
                        nombreJugadorAMover = todosLosJugadoresEnCampo.get(jugadorAMover).getNombre();

                        if (todosLosJugadoresEnCampo.get(jugadorAMover).getVelocidad() == 2) {
                            System.out.println("""
                                    Decida como quiere mover el jugador, ingresando:
                                     • -2 para retroceder dos posiciones
                                     • -1 para retroceder una posición
                                     • 1 para avanzar una posición
                                     • 2 para avanzar dos posiciones
                                    \s"""
                            );
                            movimientosARealizar = MenuYUtilidades.limitadorMenu(-2, 2);
                        } else if (todosLosJugadoresEnCampo.get(jugadorAMover).getVelocidad() == 1) {
                            System.out.println("""
                                    Decida como quiere mover el jugador, ingresando:
                                     • -1 para retroceder una posición
                                     • 1 para avanzar una posición
                                    \s"""
                            );
                            movimientosARealizar = MenuYUtilidades.limitadorMenu(-1, 1);
                        }

                        if (equipoDefensor.devolverJugadorConNombre(nombreJugadorAMover).getPosicionActual() - movimientosARealizar > 5 ||
                                equipoDefensor.devolverJugadorConNombre(nombreJugadorAMover).getPosicionActual() - movimientosARealizar < 1) {
                            System.out.println("No puedes moverte hacia esa posición.");
                        } else if (movimientosARealizar == 0) {
                            System.out.println("No puedes moverte 0 posiciones.");
                        } else {
                            equipoDefensor.moverJugadorConNombre(-movimientosARealizar,nombreJugadorAMover);
                            System.out.println("El jugador " + nombreJugadorAMover + " se ha movido con éxito.");
                            turno++;
                        }


                    }


                    //PASAR
                    case 4 -> {
                        System.out.println("Se pasó el turno.");
                        turno++;
                    }


                    //ESTADÍSTICAS
                    case 5 -> {
                        System.out.println("\nLos jugadores de tu equipo tienen las siguientes estadísticas: ");
                        todosLosJugadoresEnCampo = equipoDefensor.devolverJugadoresEntreZonas(1, 5);
                        for (JugadorDeCampo jugadorEnCampo : todosLosJugadoresEnCampo) {
                            System.out.println();
                            jugadorEnCampo.imprimirEstadisticas();
                        }
                        System.out.println();
                        equipoDefensor.devolverArrayListIndicada(2).get(0).imprimirEstadisticas();
                    }
                }
            }

            if (!nombreJugadorConPelota.equals("") && !finalizaLaJugada) {
                mostrarPosicionesActuales();
                System.out.println("\n"+nombreJugadorConPelota+" se encuentra en posesión de la pelota.");
            }

        }

        terminaLaJugada();

    }

    public void terminaLaJugada (){
        ubicacionPelota = 0;
        nombreJugadorConPelota = "";
        equipoAtacante.quitarlePelotaAJugadorQueLaTiene();
    }

    public void agregarMinutos () {
        if (minutos == 90) {
            int minutosAgregados = MenuYUtilidades.obtenerAleatorioEntero(1,10);
            minutoFinal += minutosAgregados;
            System.out.println("\nSe han agregado "+minutosAgregados+" minutos.");
        }
    }


    //GETTERS Y SETTERS ------------------------------------------------------------------------------------------------
    public int getMinutos() {
        return minutos;
    }

    public int getMinutoFinal() {
        return minutoFinal;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }


}
