
package steven_progra.proyectotowerdefense;
public class Batalla {
    private Juego juego;
    private int rondaActual;

    public Batalla() {
        this.juego = new Juego();
        this.rondaActual = 1;
    }

    public Juego getJuego() {
        return juego;
    }

    public int getRondaActual() {
        return rondaActual;
    }

    public void iniciarRonda() {
        int tropasDisponibles = rondaActual + 1;
        juego.agregarTropasCPU(tropasDisponibles);
    }

    public void enviarTropaJugador(Tropa tropa, int caminoElegido) {
        if (caminoElegido == 1) {
            juego.getCamino1().agregarTropaJugador(tropa);
        } else if (caminoElegido == 2) {
            juego.getCamino2().agregarTropaJugador(tropa);
        } else {
            throw new IllegalArgumentException("Camino inválido. Solo puede ser 1 o 2.");
        }
    }

    public void ejecutarTurno() {
        juego.ejecutarTurno();
    }

    public boolean verificarDerrotaJugador() {
        return juego.getCastilloJugador().getPuntosVida() <= 0;
    }

    public boolean verificarVictoriaJugador() {
        return juego.getCastilloCPU().getPuntosVida() <= 0;
    }

    public void siguienteRonda() {
        if (verificarVictoriaJugador()) {
            rondaActual++;
            reiniciarBatalla();
        }
    }

    private void reiniciarBatalla() {
        juego.getCamino1().reiniciar();
        juego.getCamino2().reiniciar();
        juego.getCastilloJugador().reiniciarPuntosVida();
        juego.getCastilloCPU().reiniciarPuntosVida();
    }
}
