
package steven_progra.proyectotowerdefense;

public class Mago extends Tropa{
    public Mago() {
        super(1.5);
    }

    @Override
    public boolean resisteA(Tropa otra) {
        return otra instanceof Caballero;
    }

    @Override
    public double atacar() {
        return ataque;
    }
}
