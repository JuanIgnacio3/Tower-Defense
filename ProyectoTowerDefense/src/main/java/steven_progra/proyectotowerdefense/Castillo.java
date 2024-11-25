
package steven_progra.proyectotowerdefense;

public class Castillo {
    private int puntosVida;

    public Castillo(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    // Obtener los puntos de vida del castillo
    public int getPuntosVida() {
        return puntosVida;
    }

    // Reducir los puntos de vida del castillo al recibir un ataque
    public void recibirAtaque(double danio) {
        puntosVida -= danio;
        if (puntosVida < 0) {
            puntosVida = 0; // Asegurar que no sea negativo
        }
    }

    // Verificar si el castillo sigue en pie
    public boolean estaEnPie() {
        return puntosVida > 0;
    }

    // Restablecer puntos de vida (opcional, útil para reiniciar el juego)
    public void reiniciarPuntosVida() {
        this.puntosVida = 10; // Valor inicial por defecto
    }
}
