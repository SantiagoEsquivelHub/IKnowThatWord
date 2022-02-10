package myProject;

public class Jugador {
    String nombre;
    int rondaDeJuego;

    public Jugador(){
        this.nombre = "";
        this.rondaDeJuego = 1;
    }

    public String getNombre() {
        return nombre;
    }

    public int getRondaDeJuego() {
        return rondaDeJuego;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRondaDeJuego(int rondaDeJuego) {
        this.rondaDeJuego = rondaDeJuego;
    }
}
