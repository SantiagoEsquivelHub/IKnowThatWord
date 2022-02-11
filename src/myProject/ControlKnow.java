package myProject;

import java.util.ArrayList;

public class ControlKnow {



    public boolean pintarNombreJugador(ArrayList<Jugador> arrayJugadores, String nombreABuscar){
        //Inicializamos la variable de nombre
        boolean estaNombre = false;
        for(int i = 0; i < arrayJugadores.size(); i++){
            if(arrayJugadores.get(i).getNombre().equals(nombreABuscar)){

                estaNombre = true;
                break;
            }
        }
        return estaNombre;
    }

}
