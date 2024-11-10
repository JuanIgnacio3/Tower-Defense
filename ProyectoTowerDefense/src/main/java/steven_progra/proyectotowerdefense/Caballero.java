
package steven_progra.proyectotowerdefense;

public class Caballero extends Tropa{
    public Caballero() {
        super("Caballero", 2.0);  // Tipo "Caballero" y daño base de 2.0

    }

    public boolean resisteA(Tropa otra) {
        return otra instanceof Arquero;
    }

    public double atacar() {
        return daño;    
}
    
}
