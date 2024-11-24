
package steven_progra.proyectotowerdefense;

public class Juego {
    private Castillo castilloJugador;
    private Castillo castilloCPU;
    private Batalla batalla;

    public Juego() {
        castilloJugador = new Castillo();
        castilloCPU = new Castillo();
        batalla = new Batalla(castilloJugador, castilloCPU);
    }

    public Castillo getCastilloJugador() {
        return castilloJugador;
    }

    public Castillo getCastilloCPU() {
        return castilloCPU;
    }

    public void iniciarJuego() {
        // Inicia una nueva ronda de batalla
        batalla.ejecutarRonda();
    }
}
