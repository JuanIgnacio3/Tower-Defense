    
package steven_progra.proyectotowerdefense;

public class Camino {
    private NodoTropa cabezaJugador;
    private NodoTropa cabezaCPU;

    public Camino() {
        this.cabezaJugador = null;
        this.cabezaCPU = null;
    }

    public NodoTropa getCabezaJugador() {
        return cabezaJugador;
    }

    public NodoTropa getCabezaCPU() {
        return cabezaCPU;
    }
    
    

    // Método para agregar tropas del jugador
    public void agregarTropaJugador(Tropa tropa) {
        cabezaJugador = new NodoTropa(tropa, cabezaJugador);
    }

    // Método para agregar tropas del CPU
    public void agregarTropaCPU(Tropa tropa) {
        cabezaCPU = new NodoTropa(tropa, cabezaCPU);
    }

    // Avanza las tropas, resuelve combates y ataca castillos
    public boolean avanzarTropas(Castillo castilloJugador, Castillo castilloCPU) {
        if (cabezaJugador != null && cabezaCPU != null) {
            Tropa jugador = cabezaJugador.getTropa();
            Tropa cpu = cabezaCPU.getTropa();

            if (jugador.resisteA(cpu)) {
                cabezaCPU = cabezaCPU.getSiguiente();
            } else if (cpu.resisteA(jugador)) {
                cabezaJugador = cabezaJugador.getSiguiente();
            } else {
                cabezaJugador = cabezaJugador.getSiguiente();
                cabezaCPU = cabezaCPU.getSiguiente();
            }
        } else if (cabezaJugador != null) {
            castilloCPU.recibirAtaque(cabezaJugador.getTropa().atacar());
            cabezaJugador = cabezaJugador.getSiguiente();
            return true;
        } else if (cabezaCPU != null) {
            castilloJugador.recibirAtaque(cabezaCPU.getTropa().atacar());
            cabezaCPU = cabezaCPU.getSiguiente();
            return true;
        }
        return false;
    }

    // Reinicia el camino
    public void reiniciar() {
        cabezaJugador = null;
        cabezaCPU = null;
    }
}