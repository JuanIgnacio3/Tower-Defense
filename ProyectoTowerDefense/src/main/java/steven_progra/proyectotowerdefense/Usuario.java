package steven_progra.proyectotowerdefense;
class Usuario {
    private String nombre;
    private boolean ganoBatalla;
    private Castillo castillo; // Castillo asociado al jugador

    // Constructor
    public Usuario(String nombre, Castillo castillo) {
        this.nombre = nombre;
        this.castillo = castillo;
        this.ganoBatalla = false; // Por defecto no ha ganado ninguna batalla
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isGanoBatalla() {
        return ganoBatalla;
    }

    public void setGanoBatalla(boolean ganoBatalla) {
        this.ganoBatalla = ganoBatalla;
    }

    public Castillo getCastillo() {
        return castillo;
    }

    public void setCastillo(Castillo castillo) {
        this.castillo = castillo;
    }
}
