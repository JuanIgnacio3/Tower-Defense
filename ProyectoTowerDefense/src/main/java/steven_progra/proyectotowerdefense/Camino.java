
package steven_progra.proyectotowerdefense;

public class Camino {
    private Tropa[] tropasJugador;
    private Tropa[] tropasCPU;
    private int indiceJugador;
    private int indiceCPU;

    public Camino(int capacidad) {
        this.tropasJugador = new Tropa[capacidad];
        this.tropasCPU = new Tropa[capacidad];
        this.indiceJugador = 0;
        this.indiceCPU = 0;
    }

    public void añadirTropaJugador(Tropa tropa) {
        if (indiceJugador < tropasJugador.length) {
            tropasJugador[indiceJugador++] = tropa;
        }
    }

    public void añadirTropaCPU(Tropa tropa) {
        if (indiceCPU < tropasCPU.length) {
            tropasCPU[indiceCPU++] = tropa;
        }
    }

    // Resuelve el avance y el combate entre las tropas en el camino
    public void resolverCombate(Castillo castilloJugador, Castillo castilloCPU) {
        for (int i = 0; i < Math.max(indiceJugador, indiceCPU); i++) {
            Tropa tropaJugador = i < indiceJugador ? tropasJugador[i] : null;
            Tropa tropaCPU = i < indiceCPU ? tropasCPU[i] : null;

            if (tropaJugador != null && tropaCPU != null) {
                if (tropaJugador.enfrenta(tropaCPU)) {
                    tropasCPU[i] = null; // La tropa del jugador continúa, la del CPU es eliminada
                } else if (tropaCPU.enfrenta(tropaJugador)) {
                    tropasJugador[i] = null; // La tropa del CPU continúa, la del jugador es eliminada
                } else {
                    tropasJugador[i] = null; // Ambas mueren
                    tropasCPU[i] = null;
                }
            } else if (tropaJugador != null) {
                castilloCPU.recibirAtaque(tropaJugador.atacar());
            } else if (tropaCPU != null) {
                castilloJugador.recibirAtaque(tropaCPU.atacar());
            }
        }
    }
}