
package steven_progra.proyectotowerdefense;

public class Arquero extends Tropa {
    //Se utiliza super para invocar metodos de la super clase (en este caso el constructor de tropa)
    public Arquero() {
        super(1.0);
    }

    @Override
    public boolean resisteA(Tropa otra) {
        return otra instanceof Mago;
    }

    @Override
    public double atacar() {
        return ataque;
    }
}