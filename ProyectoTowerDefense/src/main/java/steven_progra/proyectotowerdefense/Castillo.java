
package steven_progra.proyectotowerdefense;

public class Castillo {
    private int puntosDeVida;

    public Castillo() {
        this.puntosDeVida = 10;
    }

    public int getPuntosDeVida() {
        return puntosDeVida;
    }

    public void recibirDaño(int daño) {
        puntosDeVida -= daño;
        if (puntosDeVida < 0) {
            puntosDeVida = 0;
        }
    }

    public boolean estaDestruido() {
        return puntosDeVida <= 0;
    }
}
