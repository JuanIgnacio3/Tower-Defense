
package steven_progra.proyectotowerdefense;
public class Batalla {
    private Usuario jugador;
    private CPU cpu;

    public Batalla(Usuario jugador, CPU cpu) {
        this.jugador = jugador;
        this.cpu = cpu;
    }

    public void ejecutarRonda() {
        // Simula una ronda de combate. Simplificado para ejemplo:
        int dañoAlCPU = 2; // Daño ficticio
        int dañoAlJugador = 1; // Daño ficticio

        // Acceder a los castillos de las instancias
        jugador.getCastillo().recibirDaño(dañoAlJugador);
        cpu.getCastillo().recibirDaño(dañoAlCPU);

        // Mostrar resultados (opcional)
        System.out.println("Daño al castillo del CPU: " + dañoAlCPU);
        System.out.println("Daño al castillo del jugador humano: " + dañoAlJugador);
    }
}
