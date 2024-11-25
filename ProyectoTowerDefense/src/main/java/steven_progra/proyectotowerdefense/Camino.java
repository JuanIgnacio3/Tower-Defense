    
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
        if (cabezaJugador != null && cabezaCPU != null) {                       //Si ambos jugadores tienen tropas, se enfrentan
            Tropa jugador = cabezaJugador.getTropa();                           //Tropa actual
            Tropa cpu = cabezaCPU.getTropa();                                   //Tropa actual

            if (jugador.resisteA(cpu)) {
                cabezaCPU = cabezaCPU.getSiguiente();                           //Si la tropa del Jugador es resistente al del CPU, la del CPU es destruida
            } else if (cpu.resisteA(jugador)) {
                cabezaJugador = cabezaJugador.getSiguiente();                   //Si la tropa del CPU es resistente a la del Jugar, la del jugar es destruida
            } else {
                cabezaJugador = cabezaJugador.getSiguiente();                   //Si ambsa tropas son iguales, ambas se eliminan
                cabezaCPU = cabezaCPU.getSiguiente();
            }
        } else if (cabezaJugador != null) {                                     //Si solo el Jugador tiene tropas restantes,
            castilloCPU.recibirAtaque(cabezaJugador.getTropa().atacar());       //el castillo del CPU es atacado
            cabezaJugador = cabezaJugador.getSiguiente();
            return true;
        } else if (cabezaCPU != null) {                                         //Si solo el CPU tiene tropas restantes,
            castilloJugador.recibirAtaque(cabezaCPU.getTropa().atacar());       //el castillo del jugador es atacado
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