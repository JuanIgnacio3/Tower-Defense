
package steven_progra.proyectotowerdefense;

public class Mago extends Tropa{
    public Mago() {
        super("Mago", 1.5);  // Tipo "Mago" y daño base de 1.5
        //dasdada
    }

    public boolean resisteA(Tropa otra) {
        return otra instanceof Caballero;
    }

    public double atacar() {
        return daño;
    }   
    
}
