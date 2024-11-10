
package steven_progra.proyectotowerdefense;

public class ProyectoTowerDefense {

    public static void main(String[] args) {

       Arquero arquero = new Arquero();
       Caballero caballero = new Caballero();
       Mago mago = new Mago();

        //Prueba si no es resistente
        if (arquero.resisteA(caballero)) {
             System.out.println("El arquero es resistente al Caballero.");
        } else {
             System.out.println("El arquero no es resistente al Caballero.");
} 
        
        //Prueba si es resistente
        if (arquero.resisteA(mago)) {
             System.out.println("El arquero es resistente al mago.");
        } else {
             System.out.println("El arquero no es resistente al mago.");
}
        
        
        
        
        
        
    }
}
