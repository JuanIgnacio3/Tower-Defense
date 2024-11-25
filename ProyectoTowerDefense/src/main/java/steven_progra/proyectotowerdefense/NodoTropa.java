
package steven_progra.proyectotowerdefense;

public class NodoTropa {
    private Tropa tropa;        // La tropa almacenada en este nodo
    private NodoTropa siguiente; // Referencia al siguiente nodo en la lista

    // Constructor
    public NodoTropa(Tropa tropa, NodoTropa siguiente) {
        this.tropa = tropa;
        this.siguiente = siguiente;
    }

    // Getter para la tropa
    public Tropa getTropa() {
        return tropa;
    }

    // Setter para la tropa
    public void setTropa(Tropa tropa) {
        this.tropa = tropa;
    }

    // Getter para el siguiente nodo
    public NodoTropa getSiguiente() {
        return siguiente;
    }

    // Setter para el siguiente nodo
    public void setSiguiente(NodoTropa siguiente) {
        this.siguiente = siguiente;
    }
}