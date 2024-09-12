public class JugadorDeCampo extends Jugador{
    //ATRIBUTOS --------------------------------------------------------------------------------------------------------
    private final int entradas;
    private  final int marcaje;
    private final int disparoCorto;
    private final int disparoLargo;
    private final int ubicacion;
    private final int velocidad;
    private final int regates;
    private final int pase;
    private final int apoyoDefensivo;
    private final int apoyoOfensivo;

    //CONSTRUCTOR ------------------------------------------------------------------------------------------------------
    public JugadorDeCampo(Equipo equipo) {
        super(equipo);
        disparoCorto = MenuYUtilidades.obtenerAleatorioEntero(1,10);
        disparoLargo = MenuYUtilidades.obtenerAleatorioEntero(1,10);
        regates = MenuYUtilidades.obtenerAleatorioEntero(1,10);
        pase = MenuYUtilidades.obtenerAleatorioEntero(1,10);
        marcaje = MenuYUtilidades.obtenerAleatorioEntero(1,10);
        entradas = MenuYUtilidades.obtenerAleatorioEntero(1,10);
        ubicacion = MenuYUtilidades.obtenerAleatorioEntero(1,10);
        velocidad = MenuYUtilidades.obtenerAleatorioEntero(1,2);
        apoyoDefensivo = MenuYUtilidades.obtenerAleatorioEntero(1,2);
        apoyoOfensivo = MenuYUtilidades.obtenerAleatorioEntero(1,2);
        esArquero = false;
    }

    //MÉTODOS  ---------------------------------------------------------------------------------------------------------
    @Override
    public void imprimirEstadisticas(){
        System.out.println(
                "Nombre: "+nombre+"\nEntradas: "+entradas+"\nMarcaje: "+marcaje+"\nDisparo Corto: "+disparoCorto
                        +"\nDisparo largo: "+disparoLargo+"\nUbicación: "+ubicacion+"\nVelocidad: "+velocidad
                        +"\nRegates: "+regates+"\nPase : "+pase+"\nApoyo ofensivo : "+apoyoOfensivo
                        +"\nApoyo defensivo : "+apoyoDefensivo
        );
    }

    //GETTERS Y SETTERS ------------------------------------------------------------------------------------------------
    public int getEntradas() {
        return entradas;
    }

    public int getMarcaje() {
        return marcaje;
    }

    public int getDisparoCorto() {
        return disparoCorto;
    }

    public int getDisparoLargo() {
        return disparoLargo;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getRegates() {
        return regates;
    }

    public int getPase() {
        return pase;
    }

    public int getApoyoDefensivo() {
        return apoyoDefensivo;
    }

    public int getApoyoOfensivo() {
        return apoyoOfensivo;
    }


}
