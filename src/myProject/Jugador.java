package myProject;

public class Jugador {
    String nombre;
    int rondaDeJuego;
    int puntosRonda;

    public Jugador(){
        this.nombre = "";
        this.rondaDeJuego = 1;
        this.puntosRonda = 0;
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

    public int getPuntosRonda() {
        return puntosRonda;
    }

    public void setPuntosRonda(int puntosRonda) {
        this.puntosRonda = puntosRonda;
    }
}
