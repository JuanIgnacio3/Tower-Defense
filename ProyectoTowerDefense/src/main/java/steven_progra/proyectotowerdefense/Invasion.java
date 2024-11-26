package steven_progra.proyectotowerdefense;
class Invasion {
    private Usuario jugadorHumano;
    private Lista cpus;
    private CPU emperador;

    public Invasion(Usuario jugadorHumano, Lista cpus, CPU emperador) {
        this.jugadorHumano = jugadorHumano;
        this.cpus = cpus;
        this.emperador = emperador;
    }

    public void iniciarTorneo() {
        System.out.println("Iniciando el torneo...");

        // Cuartos de final
        System.out.println("=== Cuartos de Final ===");
        cpus = realizarRonda(cpus, 4);

        // Semifinales
        System.out.println("=== Semifinales ===");
        cpus = realizarRonda(cpus, 2);

        // Final
        System.out.println("=== Final ===");
        CPU finalista = (CPU) cpus.obtener(0);
        if (finalista == null) {
            System.out.println("Error: No hay finalista.");
            return;
        }

        // Batalla contra el emperador
        System.out.println("=== Batalla contra el Emperador ===");
        boolean victoria = realizarBatalla(jugadorHumano, emperador);
        if (victoria) {
            System.out.println(jugadorHumano.getNombre() + " ha derrotado al emperador y es ahora el nuevo Emperador.");
        } else {
            System.out.println("El emperador " + emperador.getNombre() + " ha defendido su título.");
        }
    }

    private Lista realizarRonda(Lista participantes, int numeroDeGanadores) {
        Lista ganadores = new Lista();

        for (int i = 0; i < participantes.tamaño(); i += 2) {
            CPU cpu1 = (CPU) participantes.obtener(i);
            CPU cpu2 = (CPU) participantes.obtener(i + 1);

            if (cpu1 == null || cpu2 == null) {
                System.out.println("Error: No hay suficientes participantes para esta ronda.");
                break;
            }

            System.out.println("Enfrentamiento: " + cpu1.getNombre() + " vs " + cpu2.getNombre());
            boolean ganoCPU1 = realizarBatalla(cpu1, cpu2);

            if (ganoCPU1) {
                ganadores.agregar(cpu1);
                System.out.println(cpu1.getNombre() + " pasa a la siguiente ronda.");
            } else {
                ganadores.agregar(cpu2);
                System.out.println(cpu2.getNombre() + " pasa a la siguiente ronda.");
            }
        }

        return ganadores;
    }

    private boolean realizarBatalla(Usuario jugador, CPU cpu) {
        // Simula la batalla entre jugador y CPU (simplificado)
        return Math.random() > 0.5;
    }

    private boolean realizarBatalla(CPU cpu1, CPU cpu2) {
        // Simula la batalla entre dos CPUs (simplificado)
        return Math.random() > 0.5;
    }
}
