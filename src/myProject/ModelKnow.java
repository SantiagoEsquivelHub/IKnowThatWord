package myProject;

import java.util.ArrayList;
import java.util.Random;

public class ModelKnow {
    private FileManager fileManager;
    public static final String PATH_LECTURA_PALABRAS = "src/myProject/files/palabras.txt";
    private ArrayList<String> allWords;
    private ArrayList<PalabraNivel> arrayPalabrasPorNivel;
    private ArrayList<PalabraNivel> palabrasParaJugar;
    private Jugador jugador;
    private int puntosRonda;
    private String mensaje;

    public ModelKnow() {
        fileManager = new FileManager();
        allWords = fileManager.lecturaFilePalabrasTotales(PATH_LECTURA_PALABRAS); //200 palabras
        jugador = new Jugador();
    }

    /**
     * It asks if the name of the typed player is the same as the one saved in the text file.
     */

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

    /**
     * Extract words from the text file to an array according to the level at which it is
     level is the number of total words to show.
     */

    public ArrayList <PalabraNivel> wordsForLevel (ArrayList<String> palabras, int level){

        ArrayList <PalabraNivel> wordsForLevel = new ArrayList<PalabraNivel>();
        Random aleatorio = new Random();
        int usar = aleatorio.nextInt(palabras.size());

        for (int i = 1; i <= level; i++){
            PalabraNivel palabraNivel = new PalabraNivel();
            palabraNivel.setPalabra(palabras.get(usar));
            wordsForLevel.add(palabraNivel);
            palabras.remove(usar);
        }
        return wordsForLevel;
    }

    /**
     * Read the PalabraNivel from the array of PalabraNivel and the first ones that are the memorized words change
     * their boolean attribute to true and the rest are kept false.
     */

    public ArrayList<PalabraNivel> palabrasParaJugar (ArrayList <PalabraNivel> arrayPalabrasPorNivel, int parada){

        for (int i = 0; i < arrayPalabrasPorNivel.size(); i++){

            if(i > parada-1){
                arrayPalabrasPorNivel.get(i).setMemorizada(true);// se cambia el atributo a true
            }
        }
        return arrayPalabrasPorNivel;
    }



    public void crearArreglos(int rondaDeJuego){
        switch (rondaDeJuego){
            case 1:
                arrayPalabrasPorNivel = wordsForLevel(allWords, 20);
                palabrasParaJugar = palabrasParaJugar (arrayPalabrasPorNivel, 10);
                break;
            case 2:
                arrayPalabrasPorNivel = wordsForLevel(allWords, 40);
                palabrasParaJugar = palabrasParaJugar (arrayPalabrasPorNivel, 20);
                break;
            case 3:
                arrayPalabrasPorNivel = wordsForLevel(allWords, 50);
                palabrasParaJugar = palabrasParaJugar (arrayPalabrasPorNivel, 25);
                break;
            case 4:
                arrayPalabrasPorNivel = wordsForLevel(allWords, 60);
                palabrasParaJugar = palabrasParaJugar (arrayPalabrasPorNivel, 30);
                break;
            case 5:
                arrayPalabrasPorNivel = wordsForLevel(allWords, 70);
                palabrasParaJugar = palabrasParaJugar (arrayPalabrasPorNivel, 35);
                break;
            case 6:
                arrayPalabrasPorNivel = wordsForLevel(allWords, 80);
                palabrasParaJugar = palabrasParaJugar (arrayPalabrasPorNivel, 40);
                break;
            case 7:
                arrayPalabrasPorNivel = wordsForLevel(allWords, 100);
                palabrasParaJugar = palabrasParaJugar (arrayPalabrasPorNivel, 50);
                break;
            case 8:
                arrayPalabrasPorNivel = wordsForLevel(allWords, 120);
                palabrasParaJugar = palabrasParaJugar (arrayPalabrasPorNivel, 60);
                break;
            case 9:
                arrayPalabrasPorNivel = wordsForLevel(allWords, 140);
                palabrasParaJugar = palabrasParaJugar (arrayPalabrasPorNivel, 70);
                break;
            case 10:
                arrayPalabrasPorNivel = wordsForLevel(allWords, 200);
                palabrasParaJugar = palabrasParaJugar (arrayPalabrasPorNivel, 100);
                break;
        }

    }

    public String devolverPalabraMemorizar(int index){
        return palabrasParaJugar.get(index).getPalabra();
    }

    public int sizeArrayPalabrasMemorizar(){
        return palabrasParaJugar.size();
    }

    public String devolverPalabraNivel(int index){
        return arrayPalabrasPorNivel.get(index).getPalabra();
    }

    public int sizeArrayPalabrasNivel(){
        return arrayPalabrasPorNivel.size();
    }

    public int puntosPorRonda(int rondaDeJuego){
        switch (rondaDeJuego){
            case 1:
                puntosRonda = 7;
                break;
            case 2:
                puntosRonda = 14;
                break;
            case 3:
                puntosRonda = 19;
                break;
            case 4:
                puntosRonda = 24;
                break;
            case 5:
                puntosRonda = 28;
                break;
            case 6:
                puntosRonda = 34;
                break;
            case 7:
                puntosRonda = 45;
                break;
            case 8:
                puntosRonda = 54;
                break;
            case 9:
                puntosRonda = 66;
                break;
            case 10:
                puntosRonda = 100;
                break;
        }
        return puntosRonda;
    }

    public String mensajePorRonda(int rondaDeJuego){

        switch (rondaDeJuego){
            case 1:
                mensaje = "En este nivel tendrás que recordar 10 palabras \n" +
                        "de un total de 20 palabras.\n" +
                        "Para superar el nivel tendrás que lograr 70% de aciertos.\n";
                break;
            case 2:
                mensaje = "En este nivel tendrás que recordar 20 palabras de un total de 40 palabras.\n" +
                        " Para superar el nivel tendrás que lograr 70% de aciertos.";
                break;
            case 3:
                mensaje = "En este nivel tendrás que recordar 25 palabras de un total de 50 palabras.\n" +
                        " Para superar el nivel tendrás que lograr 75% de aciertos.";
                break;
            case 4:
                mensaje = "En este nivel tendrás que recordar 30 palabras de un total de 60 palabras.\n" +
                        " Para superar el nivel tendrás que lograr 80% de aciertos.";
                break;
            case 5:
                mensaje = "En este nivel tendrás que recordar 35 palabras de un total de 70 palabras.\n" +
                        " Para superar el nivel tendrás que lograr 80% de aciertos.";
                break;
            case 6:
                mensaje = "En este nivel tendrás que recordar 40 palabras de un total de 80 palabras.\n" +
                        " Para superar el nivel tendrás que lograr 85% de aciertos.";
                break;
            case 7:
                mensaje = "En este nivel tendrás que recordar 50 palabras de un total de 100 palabras.\n" +
                        " Para superar el nivel tendrás que lograr 90% de aciertos.";
                break;
            case 8:
                mensaje = "En este nivel tendrás que recordar 60 palabras de un total de 120 palabras.\n" +
                        " Para superar el nivel tendrás que lograr 90% de aciertos.";
                break;
            case 9:
                mensaje = "En este nivel tendrás que recordar 70 palabras de un total de 140 palabras.\n" +
                        " Para superar el nivel tendrás que lograr 95% de aciertos.";
                break;
            case 10:
                mensaje = "En este nivel tendrás que recordar 100 palabras de un total de 200 palabras.\n" +
                        " Para superar el nivel tendrás que lograr 10% de aciertos.";
                break;
        }

        return mensaje;
    }


}
