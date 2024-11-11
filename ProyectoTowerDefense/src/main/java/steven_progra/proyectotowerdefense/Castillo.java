
package steven_progra.proyectotowerdefense;

public class Castillo {
    private int puntosDeVida;

    public Castillo(int puntosDeVidaInicial) {
        this.puntosDeVida = puntosDeVidaInicial;
    }

    public void recibirAtaque(double puntos) {
        puntosDeVida -= puntos;
        if (puntosDeVida < 0) puntosDeVida = 0;
    }

    public boolean estaDestruido() {
        return puntosDeVida <= 0;
    }

    public int getPuntosDeVida() {
        return puntosDeVida;
    }
}
