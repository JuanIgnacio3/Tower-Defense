package steven_progra.proyectotowerdefense;

class CPU {
    private String nombre;
    private boolean ganoBatalla;

    // Constructor
    public CPU(String nombre) {
        this.nombre = nombre;
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
}
