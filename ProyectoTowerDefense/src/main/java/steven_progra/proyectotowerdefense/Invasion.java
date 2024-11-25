package steven_progra.proyectotowerdefense;
import java.util.Random;

public class Invasion {
    // Clase interna para representar un nodo de una lista
    static class Nodo {
        Participante participante;
        Nodo siguiente;

        public Nodo(Participante participante) {
            this.participante = participante;
            this.siguiente = null;
        }
    }

    // Implementación de una lista enlazada
    static class Lista {
        Nodo cabeza;

        public void agregar(Participante participante) {
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

        public Participante obtener(int indice) {
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
}
