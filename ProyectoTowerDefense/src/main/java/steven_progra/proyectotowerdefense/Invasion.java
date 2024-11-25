package steven_progra.proyectotowerdefense;
import java.util.Random;

public class Invasion {
    // Nodo para lista enlazada
    static class Nodo {
        Object participante; // Puede ser Usuario o CPU
        Nodo siguiente;

        public Nodo(Object participante) {
            this.participante = participante;
            this.siguiente = null;
        }
    }

    // Lista enlazada
    static class Lista {
        Nodo cabeza;

        public void agregar(Object participante) {
            Nodo nuevoNodo = new Nodo(participante);
            if (cabeza == null) {
                cabeza = nuevoNodo;
            } else {
                Nodo actual = cabeza;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevoNodo;
            }
        }

        public Object obtener(int indice) {
            Nodo actual = cabeza;
            int contador = 0;
            while (actual != null) {
                if (contador == indice) {
                    return actual.participante;
                }
                actual = actual.siguiente;
                contador++;
            }
            return null;
        }

        public void eliminar(int indice) {
            if (cabeza == null) return;

            if (indice == 0) {
                cabeza = cabeza.siguiente;
                return;
            }

            Nodo actual = cabeza;
            Nodo previo = null;
            int contador = 0;

            while (actual != null && contador != indice) {
                previo = actual;
                actual = actual.siguiente;
                contador++;
            }

            if (actual != null) {
                previo.siguiente = actual.siguiente;
            }
        }

        public int tamano() {
            Nodo actual = cabeza;
            int contador = 0;
            while (actual != null) {
                contador++;
                actual = actual.siguiente;
            }
            return contador;
        }
    }

    // Método para gestionar rondas
    public Lista gestionarRonda(Lista participantes, Batalla batalla) {
        Lista ganadores = new Lista();
        Nodo actual = participantes.cabeza;

        while (actual != null && actual.siguiente != null) {
            // Llamada a la clase externa `Batalla` para determinar el ganador
            Object ganador = batalla.combatir(actual.participante, actual.siguiente.participante);
            
            // Actualizar el estado de la batalla
            if (ganador instanceof Usuario) {
                ((Usuario) ganador).setGanoBatalla(true);
            } else if (ganador instanceof CPU) {
                ((CPU) ganador).setGanoBatalla(true);
            }

            // Agregar al ganador a la lista de ganadores
            ganadores.agregar(ganador);

            // Avanzar al siguiente par de participantes
            actual = actual.siguiente.siguiente;
        }

        return ganadores;
    }

    // Método principal para ejecutar el torneo
    public void iniciarTorneo(Batalla batalla) {
        Lista participantes = new Lista();

        // Crear un jugador humano
        participantes.agregar(new Usuario("Jugador Humano"));

        // Crear participantes CPU
        for (int i = 1; i < 8; i++) {
            participantes.agregar(new CPU("CPU " + i));
        }

        // Rondas del torneo
        System.out.println("Iniciando el torneo...");
        String[] rondas = {"Cuartos de final", "Semifinales", "Final"};
        for (String ronda : rondas) {
            System.out.println("Ronda: " + ronda);
            participantes = gestionarRonda(participantes, batalla);
            mostrarParticipantes(participantes);
        }

        // Final contra el Emperador
        System.out.println("El ganador se enfrentará al Emperador...");
        CPU emperador = new CPU("Emperador");
        Object campeon = batalla.combatir(participantes.obtener(0), emperador);

        if (campeon instanceof Usuario) {
            System.out.println("¡Felicidades! El jugador humano se ha convertido en el nuevo Emperador.");
        } else if (campeon instanceof CPU) {
            System.out.println("El Emperador sigue reinando. Mejor suerte la próxima vez.");
        }
    }

    // Método para mostrar los participantes restantes
    public void mostrarParticipantes(Lista participantes) {
        Nodo actual = participantes.cabeza;
        while (actual != null) {
            if (actual.participante instanceof Usuario) {
                Usuario usuario = (Usuario) actual.participante;
                System.out.println(usuario.getNombre() + " (Humano)");
            } else if (actual.participante instanceof CPU) {
                CPU cpu = (CPU) actual.participante;
                System.out.println(cpu.getNombre() + " (CPU)");
            }
            actual = actual.siguiente;
        }
    }

    public static void main(String[] args) {
        Invasion invasion = new Invasion();
        Batalla batalla = new Batalla(); // Clase externa para resolver las batallas
        invasion.iniciarTorneo(batalla);
    }
}
