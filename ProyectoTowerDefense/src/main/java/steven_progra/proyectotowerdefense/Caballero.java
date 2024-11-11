
package steven_progra.proyectotowerdefense;

public class Caballero extends Tropa{
    public Caballero() {
        super(2.0);
    }

    @Override
    public boolean resisteA(Tropa otra) {
        return otra instanceof Arquero;
    }

    @Override
    public double atacar() {
        return ataque;
    }
}
