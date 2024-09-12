import java.util.ArrayList;

public abstract class Jugador {
     //ATRIBUTOS--------------------------------------------------------------------------------------------------------
    protected String nombre;
    protected Equipo equipo;
    protected int posicionActual = 0;
    protected boolean tieneLaPelota = false;
    protected boolean esArquero;
    protected static ArrayList<String> listaDeNombres =  new ArrayList<>();


    //CONSTRUCTOR-------------------------------------------------------------------------------------------------------
    public Jugador(Equipo equipo) {
        this.nombre = Jugador.nombreAleatorio();
        this.equipo = equipo;
    }

    //METODOS-----------------------------------------------------------------------------------------------------------
    public static void llenarArrayNombres () {
        listaDeNombres.add("Juan Perez");
        listaDeNombres.add("Nacho Souto");
        listaDeNombres.add("Driss Cantero");
        listaDeNombres.add("Miquel Centeno");
        listaDeNombres.add("José Sempere");
        listaDeNombres.add("Rogelio Campos");
        listaDeNombres.add("Israel Cerda");
        listaDeNombres.add("George Pizarro");
        listaDeNombres.add("Francisco Mestre");
        listaDeNombres.add("Fernando Mosquera");
        listaDeNombres.add("Ángel Cabeza");
        listaDeNombres.add("Jairo Marí");
        listaDeNombres.add("Gonzalo Quero");
        listaDeNombres.add("Antonio Baez");
        listaDeNombres.add("Paul del Valle");
        listaDeNombres.add("Javier Taboada");
        listaDeNombres.add("Antonio Espada");
        listaDeNombres.add("Nabil Esteve");
        listaDeNombres.add("Jose Marrero");
        listaDeNombres.add("Pelayo Mir");
        listaDeNombres.add("Cristobal Matheu");
        listaDeNombres.add("Pedro Almagro");
        listaDeNombres.add("Ezequiel Becerra");
        listaDeNombres.add("Miguel Flores");
        listaDeNombres.add("Mauro Cabello");
        listaDeNombres.add("Valentino Aviles");
        listaDeNombres.add("Manuel Castilla");
        listaDeNombres.add("Ramiro Tudela");
        listaDeNombres.add("Lionel Garrido");
        listaDeNombres.add("David Izquierdo");
        listaDeNombres.add("Mauro Fonseca");
        listaDeNombres.add("Franco Chavez");
        listaDeNombres.add("Mateo Zamora");
        listaDeNombres.add("Ignacio Gabarri");
        listaDeNombres.add("Tomás Gomis");
        listaDeNombres.add("Jeremias Espinoza");
        listaDeNombres.add("Matias Rivera");
        listaDeNombres.add("Carlos Candela");
        listaDeNombres.add("Roger Sepúlveda");
        listaDeNombres.add("Marcelino Arias");
        listaDeNombres.add("Axel Sevilla");
        listaDeNombres.add("Nestor Diaz");
        listaDeNombres.add("Blas Pereyra");
        listaDeNombres.add("Alfonso Cañas");
        listaDeNombres.add("Facundo Quesada");
        listaDeNombres.add("Matias Simón");
        listaDeNombres.add("Dylan Seco");
        listaDeNombres.add("Santiago Frutos");
        listaDeNombres.add("Lautaro Solano");
        listaDeNombres.add("Brian Serra");
    }

    public static String nombreAleatorio() {
        String nombreAleatorio;
        int numeroAleatorio = MenuYUtilidades.obtenerAleatorioEntero(0,listaDeNombres.size()-1);

        nombreAleatorio = listaDeNombres.get(numeroAleatorio);
        listaDeNombres.remove(numeroAleatorio);

        return nombreAleatorio;
    }

    public abstract void imprimirEstadisticas();

    public void moverPosicion (int numero) {
        posicionActual += numero;
    }

    //GETTERS Y SETTERS-------------------------------------------------------------------------------------------------
    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    public boolean isTieneLaPelota() {
        return tieneLaPelota;
    }

    public void obtieneLaPelota() {
        tieneLaPelota = true;
    }

    public void yaNoTieneLaPelota() {
        tieneLaPelota = false;
    }

    public String getNombre() {
        return nombre;
    }

}
