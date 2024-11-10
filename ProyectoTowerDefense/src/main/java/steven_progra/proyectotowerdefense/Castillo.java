
package steven_progra.proyectotowerdefense;

public class Castillo {
    private int puntosVida;  //Puntos de vida actuales del castillo
    private int puntosVidaInicial;  //Puntos de vida iniciales (por ejemplo, 10 puntos)
    private String nombre;  //Nombre del castillo

    //Constructor que inicializa el castillo con un nombre y puntos de vida iniciales
    public Castillo(String nombre, int puntosVidaInicial) {
        this.nombre = nombre;
        this.puntosVidaInicial = puntosVidaInicial;
        this.puntosVida = puntosVidaInicial;
    }

    //Método para reducir los puntos de vida del castillo cuando recibe daño
    public void recibirDanno(int danno) {
        puntosVida -= danno;
        if (puntosVida < 0) {
            puntosVida = 0;
        }
        System.out.println(nombre + " ha recibido " + danno + " puntos de daño. Puntos de vida restantes: " + puntosVida);
    }

    //Método que indica si el castillo ha sido destruido
    public boolean estaDestruido() {
        return puntosVida <= 0;
    }

    //Método para restaurar los puntos de vida del castillo a su estado inicial
    public void restaurar() {
        puntosVida = puntosVidaInicial;
    }

    //Métodos getters para obtener información del castillo
    public int getPuntosVida() {
        return puntosVida;
    }

    public String getNombre() {
        return nombre;
    }   
}
