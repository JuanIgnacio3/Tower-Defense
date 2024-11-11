
package steven_progra.proyectotowerdefense;

//Abstract: utilizado para clase que será el modelo de otra subclase

public abstract class Tropa {
    protected double ataque;

    public Tropa(double ataque) {
        this.ataque = ataque;
    }

    // Verifica si la tropa es resistente al enemigo.
    public abstract boolean resisteA(Tropa otra);

    // Define el valor de ataque de la tropa.
    public abstract double atacar();

    // Determina si esta tropa continúa en combate en un encuentro con otra.
    public boolean enfrenta(Tropa otra) {
        if (this.resisteA(otra) && !otra.resisteA(this)) {
            return true; // Esta tropa sobrevive
        } else if (otra.resisteA(this) && !this.resisteA(otra)) {
            return false; // Esta tropa muere
        }
        return false; // Ambas mueren si son iguales o ninguna es resistente
    }
}
//Prueba 

/*class Arquero extends Tropa { //sin el public puedo declarar la clase en el mismo .java
    public Arquero() {
        this.tipo = "Arquero";
        this.daño = 1.0;
    }

    public boolean resisteA(Tropa otra) {
        return otra instanceof Mago;
    }

    public double atacar() {
        return daño;
    }
}

class Mago extends Tropa {
    public Mago() {
        this.tipo = "Mago";
        this.daño = 1.5;
    }

    public boolean resisteA(Tropa otra) {
        return otra instanceof Caballero;
    }

    public double atacar() {
        return daño;
    }
}

class Caballero extends Tropa {
    public Caballero() {
        this.tipo = "Caballero";
        this.daño = 2.0;
    }

    public boolean resisteA(Tropa otra) {
        return otra instanceof Arquero;
    }

    public double atacar() {
        return daño;
    }

}*/