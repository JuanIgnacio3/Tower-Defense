
package steven_progra.proyectotowerdefense;

public class Juego {
    private int batallaActual;
    private boolean jugadorGanador;
    private Castillo castilloJugador;
    private Batalla batalla;

    public Juego() {
        this.batallaActual = 1;
        this.jugadorGanador = false;
        this.castilloJugador = new Castillo(10);
    }

    public void iniciarJuego() {
        while (batallaActual <= 3 && !castilloJugador.estaDestruido()) {
            System.out.println("Batalla " + batallaActual + " comienza.");
            Castillo castilloCPU = new Castillo(10);
            batalla = new Batalla(castilloJugador, castilloCPU);

            Tropa[] tropasJugador = {/* Tropas generadas por el jugador */};
            Tropa[] tropasCPU = {/* Tropas generadas aleatoriamente para CPU */};

            batalla.prepararBatalla(tropasJugador, tropasCPU);
            batalla.iniciarRonda();

            if (batalla.ganoJugador()) {
                System.out.println("Has ganado la Batalla " + batallaActual);
                batallaActual++;
            } else if (batalla.perdioJugador()) {
                System.out.println("Has perdido la invasión.");
                break;
            }
        }

        verificarEstadoFinal();
    }

    private void verificarEstadoFinal() {
        if (castilloJugador.estaDestruido()) {
            System.out.println("Has sido derrotado. ¡Juego terminado!");
        } else if (batallaActual > 3) {
            jugadorGanador = true;
            System.out.println("¡Felicidades! Has conquistado todos los castillos.");
        }
    }
}
