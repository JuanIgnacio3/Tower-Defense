
package steven_progra.proyectotowerdefense;

public class Arquero extends Tropa {
    //Se utiliza super para invocar metodos de la super clase (en este caso el constructor de tropa)
    public Arquero() {
        super("Arquero", 1.0);  // Tipo "Arquero" y daño base de 1.0
    }

    public boolean resisteA(Tropa otra) {
        return otra instanceof Mago;
    }

    public double atacar() {
        return daño;
    }
    
    
    
}
