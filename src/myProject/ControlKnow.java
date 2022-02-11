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
    public void wordsForLevel (ArrayList <String> arrayJugadores, int  level){

        if(level == 1){

            for (int i = 1; i <=level*2; i++ ){
                //total palabras nivel

            }

        }if (level == 2){

        }

    }




}
