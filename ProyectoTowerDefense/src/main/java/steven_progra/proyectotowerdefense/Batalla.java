
package steven_progra.proyectotowerdefense;

public class Batalla {
    private Camino camino1;
    private Camino camino2;
    private Castillo castilloJugador;
    private Castillo castilloCPU;

    public Batalla(Castillo castilloJugador, Castillo castilloCPU) {
        this.camino1 = new Camino(10);
        this.camino2 = new Camino(10);
        this.castilloJugador = castilloJugador;
        this.castilloCPU = castilloCPU;
    }

    public void prepararBatalla(Tropa[] tropasJugador, Tropa[] tropasCPU) {
        for (int i = 0; i < tropasJugador.length; i++) {
            if (i % 2 == 0) camino1.añadirTropaJugador(tropasJugador[i]);
            else camino2.añadirTropaJugador(tropasJugador[i]);
        }
        for (int i = 0; i < tropasCPU.length; i++) {
            if (i % 2 == 0) camino1.añadirTropaCPU(tropasCPU[i]);
            else camino2.añadirTropaCPU(tropasCPU[i]);
        }
    }

    public void iniciarRonda() {
        camino1.resolverCombate(castilloJugador, castilloCPU);
        camino2.resolverCombate(castilloJugador, castilloCPU);
    }

    public boolean ganoJugador() {
        return castilloCPU.estaDestruido();
    }

    public boolean perdioJugador() {
        return castilloJugador.estaDestruido();
    }
}
