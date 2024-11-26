package steven_progra.proyectotowerdefense;
class CPU {
    private String nombre;
    private Castillo castillo;

    public CPU(String nombre, Castillo castillo) {
        this.nombre = nombre;
        this.castillo = castillo;
    }

    public String getNombre() {
        return nombre;
    }

    public Castillo getCastillo() {
        return castillo;
    }
}
