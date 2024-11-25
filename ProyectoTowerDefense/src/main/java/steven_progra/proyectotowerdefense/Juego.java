
package steven_progra.proyectotowerdefense;

public class Juego {
    private Camino camino1;
    private Camino camino2;
    private Castillo castilloJugador;
    private Castillo castilloCPU;

    public Juego() {
        this.camino1 = new Camino();
        this.camino2 = new Camino();
        this.castilloJugador = new Castillo(10);
        this.castilloCPU = new Castillo(10);
    }

    public Camino getCamino1() {
        return camino1;
    }

    public Camino getCamino2() {
        return camino2;
    }

    public Castillo getCastilloJugador() {
        return castilloJugador;
    }

    public Castillo getCastilloCPU() {
        return castilloCPU;
    }

    public void agregarTropasCPU(int tropasDisponibles) {
        for (int i = 0; i < tropasDisponibles - 1; i++) {
            Tropa nuevaTropa = generarTropaAleatoria();
            int caminoAleatorio = (Math.random() < 0.5) ? 1 : 2;
            if (caminoAleatorio == 1) {
                camino1.agregarTropaCPU(nuevaTropa);
            } else {
                camino2.agregarTropaCPU(nuevaTropa);
            }
        }
    }

    private Tropa generarTropaAleatoria() {
        double probabilidad = Math.random();
        if (probabilidad < 0.33) {
            return new Arquero();
        } else if (probabilidad < 0.66) {
            return new Mago();
        } else {
            return new Caballero();
        }
    }

    public void ejecutarTurno() {
        camino1.avanzarTropas(castilloJugador, castilloCPU);
        camino2.avanzarTropas(castilloJugador, castilloCPU);
    }

    public boolean juegoActivo() {
        return castilloJugador.getPuntosVida() > 0 && castilloCPU.getPuntosVida() > 0;
    }
}

