
package steven_progra.proyectotowerdefense;

public class Camino {
    private Tropa[] tropasJugador;     // Arreglo para tropas del jugador
    private Tropa[] tropasOponente;    // Arreglo para tropas del oponente
    private int contadorJugador;       // Cantidad de tropas del jugador en el camino
    private int contadorOponente;      // Cantidad de tropas del oponente en el camino

    // Constructor que inicializa el tamaño de los arreglos de tropas
    public Camino(int capacidadMaxima) {
        this.tropasJugador = new Tropa[capacidadMaxima];
        this.tropasOponente = new Tropa[capacidadMaxima];
        this.contadorJugador = 0;
        this.contadorOponente = 0;
    }

    // Añadir una tropa del jugador
    public boolean añadirTropaJugador(Tropa tropa) {
        if (contadorJugador < tropasJugador.length) {
            tropasJugador[contadorJugador++] = tropa;
            return true;
        }
        return false; // El camino está lleno para tropas del jugador
    }

    // Añadir una tropa del oponente
    public boolean añadirTropaOponente(Tropa tropa) {
        if (contadorOponente < tropasOponente.length) {
            tropasOponente[contadorOponente++] = tropa;
            return true;
        }
        return false; // El camino está lleno para tropas del oponente
    }

    // Obtener la siguiente tropa del jugador
    public Tropa obtenerSiguienteTropaJugador() {
        if (contadorJugador > 0) {
            Tropa siguienteTropa = tropasJugador[0];
            // Mover tropas hacia adelante en el arreglo
            for (int i = 1; i < contadorJugador; i++) {
                tropasJugador[i - 1] = tropasJugador[i];
            }
            tropasJugador[--contadorJugador] = null; // Limpiar última posición
            return siguienteTropa;
        }
        return null; // No hay tropas
    }

    // Obtener la siguiente tropa del oponente
    public Tropa obtenerSiguienteTropaOponente() {
        if (contadorOponente > 0) {
            Tropa siguienteTropa = tropasOponente[0];
            // Mover tropas hacia adelante en el arreglo
            for (int i = 1; i < contadorOponente; i++) {
                tropasOponente[i - 1] = tropasOponente[i];
            }
            tropasOponente[--contadorOponente] = null; // Limpiar última posición
            return siguienteTropa;
        }
        return null; // No hay tropas
    }

    // Avanza todas las tropas y resuelve el combate cuando se topan
    public void avanzarYResolverCombate() {
        System.out.println("Las tropas avanzan en el camino y enfrentan combates...");

        int i = 0; // Índice para tropas del jugador
        int j = 0; // Índice para tropas del oponente

        // Iterar hasta que una de las tropas llegue al castillo o se agoten las tropas
        while (i < contadorJugador && j < contadorOponente) {
            Tropa tropaJugador = tropasJugador[i];
            Tropa tropaOponente = tropasOponente[j];

            // Resolver combate entre las tropas enfrentadas en el camino
            if (resolverCombate(tropaJugador, tropaOponente)) {
                System.out.println("Tropa del jugador avanza tras vencer a la tropa del oponente.");
                j++; // La tropa del oponente fue derrotada, avanzamos el índice oponente
            } else {
                System.out.println("Tropa del oponente avanza tras vencer a la tropa del jugador.");
                i++; // La tropa del jugador fue derrotada, avanzamos el índice jugador
            }
        }

        // Mover tropas restantes en el camino si no encontraron oposición
        while (i < contadorJugador) {
            tropasJugador[i++].avanzar();
        }
        while (j < contadorOponente) {
            tropasOponente[j++].avanzar();
        }
    }

    // Resolver combate entre una tropa del jugador y una del oponente
    private boolean resolverCombate(Tropa tropaJugador, Tropa tropaOponente) {
        if (tropaJugador.resisteA(tropaOponente)) {
            tropaOponente.recibirDaño(tropaJugador.atacar());
            if (tropaOponente.estaDerrotada()) {
                return true; // La tropa del jugador gana
            }
        } else {
            tropaJugador.recibirDaño(tropaOponente.atacar());
            if (tropaJugador.estaDerrotada()) {
                return false; // La tropa del oponente gana
            }
        }
        return tropaJugador.getPoder() > tropaOponente.getPoder(); // Define el ganador
    }

    // Métodos auxiliares para verificar si hay tropas en el camino
    public boolean hayTropasJugador() {
        return contadorJugador > 0;
    }

    public boolean hayTropasOponente() {
        return contadorOponente > 0;
    }
    
    
}
