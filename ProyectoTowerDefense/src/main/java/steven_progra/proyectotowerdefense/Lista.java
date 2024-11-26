package steven_progra.proyectotowerdefense;
    class Lista {
    private Nodo cabeza;

    public Lista() {
        this.cabeza = null;
    }

    public void agregar(Object dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }

    public Object obtener(int indice) {
        Nodo actual = cabeza;
        int contador = 0;
        while (actual != null) {
            if (contador == indice) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
            contador++;
        }
        System.out.println("Índice fuera de rango.");
        return null; // Retorna null si el índice no es válido.
    }

    public int tamaño() {
        int contador = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

    public void eliminar(int indice) {
        if (indice < 0 || cabeza == null) {
            System.out.println("Índice inválido o la lista está vacía.");
            return;
        }

        if (indice == 0) {
            cabeza = cabeza.getSiguiente();
            return;
        }

        Nodo actual = cabeza;
        int contador = 0;

        while (actual != null && contador < indice - 1) {
            actual = actual.getSiguiente();
            contador++;
        }

        if (actual != null && actual.getSiguiente() != null) {
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }
}

