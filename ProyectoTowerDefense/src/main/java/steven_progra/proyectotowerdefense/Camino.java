    
package steven_progra.proyectotowerdefense;

public class Camino {
    private NodoTropa inicioJugador;
    private NodoTropa inicioCPU;

    public Camino() {
        inicioJugador = null;
        inicioCPU = null;
    }

    // Método para agregar una tropa al camino del jugador
    public void agregarTropaJugador(Tropa tropa) {
        inicioJugador = new NodoTropa(tropa, inicioJugador);
    }

    // Método para agregar una tropa al camino del CPU
    public void agregarTropaCPU(Tropa tropa) {
        inicioCPU = new NodoTropa(tropa, inicioCPU);
    }

    // Método para resolver un turno en el camino
    public void resolverTurno() {
        if (inicioJugador != null && inicioCPU != null) {
            Tropa tropaJugador = inicioJugador.getTropa();
            Tropa tropaCPU = inicioCPU.getTropa();

            if (tropaJugador.resisteA(tropaCPU)) {
                // La tropa del jugador resiste, la tropa del CPU es eliminada
                inicioCPU = inicioCPU.getSiguiente();
            } else if (tropaCPU.resisteA(tropaJugador)) {
                // La tropa del CPU resiste, la tropa del jugador es eliminada
                inicioJugador = inicioJugador.getSiguiente();
            } else {
                // Ambas tropas son iguales, ambas se eliminan
                inicioJugador = inicioJugador.getSiguiente();
                inicioCPU = inicioCPU.getSiguiente();
            }
        }
    }

    // Método para mover las tropas restantes hacia adelante
    public boolean avanzarTropas(Castillo castilloJugador, Castillo castilloCPU) {
        boolean huboImpacto = false;

        // Mueve las tropas del jugador
        if (inicioJugador != null) {
            Tropa tropa = inicioJugador.getTropa();
            castilloCPU.recibirDaño((int) tropa.atacar());
            inicioJugador = inicioJugador.getSiguiente();
            huboImpacto = true;
        }

        // Mueve las tropas del CPU
        if (inicioCPU != null) {
            Tropa tropa = inicioCPU.getTropa();
            castilloJugador.recibirDaño((int) tropa.atacar());
            inicioCPU = inicioCPU.getSiguiente();
            huboImpacto = true;
        }

        return huboImpacto;
    }

    // Método para verificar si hay tropas en el camino
    public boolean hayTropas() {
        return inicioJugador != null || inicioCPU != null;
    }

    // Nodo interno para manejar la lista enlazada de tropas
    private static class NodoTropa {
        private Tropa tropa;
        private NodoTropa siguiente;

        public NodoTropa(Tropa tropa, NodoTropa siguiente) {
            this.tropa = tropa;
            this.siguiente = siguiente;
        }

        public Tropa getTropa() {
            return tropa;
        }

        public NodoTropa getSiguiente() {
            return siguiente;
        }
    }
}