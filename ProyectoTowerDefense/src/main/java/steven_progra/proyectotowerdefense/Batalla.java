
package steven_progra.proyectotowerdefense;

public class Batalla {
    private Castillo castilloJugador;
    private Castillo castilloCPU;

    public Batalla(Castillo castilloJugador, Castillo castilloCPU) {
        this.castilloJugador = castilloJugador;
        this.castilloCPU = castilloCPU;
    }

    public void ejecutarRonda() {
        // Simula una ronda de combate. Simplificado para ejemplo:
        int dañoAlCPU = 2; // Daño ficticio
        int dañoAlJugador = 1; // Daño ficticio

        castilloCPU.recibirDaño(dañoAlCPU);
        castilloJugador.recibirDaño(dañoAlJugador);
    }
}
