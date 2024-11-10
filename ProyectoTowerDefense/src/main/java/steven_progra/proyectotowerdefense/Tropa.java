
package steven_progra.proyectotowerdefense;

//Abstract: utilizado para clase que será el modelo de otra subclase

public abstract class Tropa {
    protected double daño;  // Daño base que la tropa inflige al atacar.
    protected String tipo;  // Tipo de tropa (ejemplo: "Arquero", "Mago", "Caballero").
    
    //Constructor para inicializar el tipo y daño de la tropa
    public Tropa(String tipo, double daño) {
        this.tipo = tipo;
        this.daño = daño;
    }

    public double getDaño() {
        return daño;
    }

    public String getTipo() {
        return tipo;
    }

    
    //Al definir estos metodo en la super clase , me aseguro que los metodos están igualmente en las subclases
    //Polimorfismo , lo que permite manejar objetos de diferentes subclases.
    public abstract boolean resisteA(Tropa otra); //Parametro tipo tropa, representa otra tropa para comparar

    public abstract double atacar(); //con el abstract puedo crear el metodo sin ingresar 

}

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