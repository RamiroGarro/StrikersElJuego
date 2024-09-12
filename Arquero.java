public class Arquero extends Jugador{
    //ATRIBUTOS --------------------------------------------------------------------------------------------------------
    private final int mediaDistancia;
    private final int cortaDistancia;

    //CONSTRUCTOR ------------------------------------------------------------------------------------------------------
    public Arquero(Equipo equipo) {
        super(equipo);
        mediaDistancia = MenuYUtilidades.obtenerAleatorioEntero(1,10);
        cortaDistancia = MenuYUtilidades.obtenerAleatorioEntero(1,10);
        esArquero = true;
    }

    //MÉTODOS ----------------------------------------------------------------------------------------------------------
    @Override
    public void imprimirEstadisticas(){
        System.out.println(
                "Nombre: "+nombre+"\nMedia Distancia: "+mediaDistancia+"\nCorta distancia: "+cortaDistancia
        );
    }

    //GETTERS Y SETTERS ------------------------------------------------------------------------------------------------
    public int getMediaDistancia() {
        return mediaDistancia;
    }

    public int getCortaDistancia() {
        return cortaDistancia;
    }
}
