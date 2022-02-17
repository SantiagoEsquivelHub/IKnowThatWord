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
    private int puntosRonda, contadorAciertos, ronda, palabrasParaMemorizar;
    private String mensaje;

    public ModelKnow() {
        fileManager = new FileManager();
        allWords = fileManager.lecturaFilePalabrasTotales(PATH_LECTURA_PALABRAS); //200 palabras
        jugador = new Jugador();
        ronda = 1;
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
                ronda = arrayJugadores.get(i).getRondaDeJuego();
                //System.out.println("RONDA MODEL "+ronda+"");
                break;
            }

        }
        return estaNombre;
    }


    /**
     * Return the round of the player.
     */

    public int getRonda(){
        return ronda;
    }

    /**
     * Change the round of the player.
     */

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    /**
     * Advance round in the game.
     */

    public void cambiarRonda(ArrayList<Jugador> jugadores,String nombreJugador){

        ArrayList<String> jugadoresString = new ArrayList<String>();
        setRonda(ronda+1);
        for(int i = 0; i < jugadores.size(); i++){
        //System.out.println("nombreJugador: "+nombreJugador+"");
            if(jugadores.get(i).getNombre().equals(nombreJugador)){

                String jugadorCompleto = "";

                jugadorCompleto = ""+jugadores.get(i).getNombre()+","+ronda+"";
                jugadoresString.add(jugadorCompleto);

            }else{
                //System.out.println("nombreJugador: "+jugadores.get(i).getNombre()+"");
                String jugadorCompleto = "";

                jugadorCompleto = ""+jugadores.get(i).getNombre()+","+jugadores.get(i).getRondaDeJuego()+"";
                jugadoresString.add(jugadorCompleto);
            }
        }

        fileManager.limpiarArchivoTexto();

        for(int i = 0; i < jugadoresString.size(); i++){
            fileManager.escribirTexto(jugadoresString.get(i));
        }



        //System.out.println(ronda);
    }


    /**
     * Extract words from the text file to an array according to the level at which it is
     level is the number of total words to show.
     */

    public ArrayList <PalabraNivel> wordsForLevel (ArrayList<String> palabras, int level){

        ArrayList <PalabraNivel> wordsForLevel = new ArrayList<PalabraNivel>();
        Random aleatorio = new Random();
        int usar = aleatorio.nextInt(palabras.size());

        for (int i = 0; i < level; i++){

            if(level == 200){
                PalabraNivel palabraNivel = new PalabraNivel();
                palabraNivel.setPalabra(palabras.get(i));
                System.out.println(i);
                wordsForLevel.add(palabraNivel);
            }else{
                PalabraNivel palabraNivel = new PalabraNivel();
                palabraNivel.setPalabra(palabras.get(usar));
                wordsForLevel.add(palabraNivel);
                palabras.remove(usar);
            }
        }
        return wordsForLevel;
    }

    /**
     * Read the PalabraNivel from the array of PalabraNivel and the first ones that are the memorized words change
     * their boolean attribute to true and the rest are kept false.
     */

    public ArrayList<PalabraNivel> palabrasParaJugar (ArrayList <PalabraNivel> arrayPalabrasPorNivel, int parada){

        for (int i = 0; i < arrayPalabrasPorNivel.size(); i++){
        int parar= 0;
            /*if(i < parada-1){
                arrayPalabrasPorNivel.get(i).setMemorizada(true);// se cambia el atributo a true

            }*/
            if (i % 2 == 0) {
                arrayPalabrasPorNivel.get(i).setMemorizada(true);// se cambia el atributo a true
            }


            //System.out.println(arrayPalabrasPorNivel.get(i).getMemorizada());
        }
        return arrayPalabrasPorNivel;
    }

    /**
    * Create arrangements of memorized words and words by level according to the player's round.
    * */

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

    /**
     * Return palabraNivel about the index in palabrasParaJugar array.
     */

    public String devolverPalabraMemorizar(int index){
        return palabrasParaJugar.get(index).getPalabra();
    }

    /**
     * Return palabraNivel Object about the index in palabrasParaJugar array.
     */

    public PalabraNivel devolverPalabraMemorizarObj(int index){
        return palabrasParaJugar.get(index);
    }

    /**
     * Return the size of palabrasParaJugar array.
     */

    public int sizeArrayPalabrasMemorizar(){
        return palabrasParaJugar.size();
    }

    /**
     * Return palabraNivel about the index in arrayPalabrasPorNivel array.
     */

    public String devolverPalabraNivel(int index){
        return arrayPalabrasPorNivel.get(index).getPalabra();
    }

    /**
     * Return the size of arrayPalabrasPorNivel array.
     */

    public int sizeArrayPalabrasNivel(){
        return arrayPalabrasPorNivel.size();
    }

    /**
     * Return the number of memorized words per round.
     */

    public int palabrasMemorizarPorRonda(int rondaDeJuego){
        switch (rondaDeJuego){
            case 1:
                palabrasParaMemorizar = 10;
                break;
            case 2:
                palabrasParaMemorizar = 20;
                break;
            case 3:
                palabrasParaMemorizar = 25;
                break;
            case 4:
                palabrasParaMemorizar = 30;
                break;
            case 5:
                palabrasParaMemorizar = 35;
                break;
            case 6:
                palabrasParaMemorizar = 40;
                break;
            case 7:
                palabrasParaMemorizar = 50;
                break;
            case 8:
                palabrasParaMemorizar = 60;
                break;
            case 9:
                palabrasParaMemorizar = 70;
                break;
            case 10:
                palabrasParaMemorizar = 100;
                break;
        }
        return palabrasParaMemorizar;
    }

    /**
     * Points needed to pass the round.
     */

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

    /**
     * An initial message is displayed depending on the round you are in.
     */

    public String mensajePorRonda(int rondaDeJuego){

        switch (rondaDeJuego){
            case 1:
                mensaje = "En este nivel tendrás que recordar 10 palabras de un total de 20 palabras.\n" +
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
                        " Para superar el nivel tendrás que lograr 100% de aciertos.";
                break;
            case 11:
                mensaje = "Ganaste todos los niveles jugador, eres un crack!";
                break;
        }

        return mensaje;
    }

    /**
     * If the word is memorized, it is added to a hit counter and return a message.
     */

    public void palabraEsMemorizada(PalabraNivel palabra){
        if(palabra.getMemorizada() == true){
            contadorAciertos++;
            //System.out.println(contadorAciertos);
        }

    }

    /**
     * If the word is not memorized, it is added to a hit counter and return a message.
     */

    public void palabraNoEsMemorizada(PalabraNivel palabra){
        if(palabra.getMemorizada() == false){
            contadorAciertos++;
            //System.out.println(contadorAciertos);
        }

    }



    /**
     * Return the number of hits made in the round.
     */

    public int retornaAciertosActuales(){
        return contadorAciertos;
    }

    /**
     * Return the player's current round.
     */

    public int retornaRondaJugador(){
        return ronda;
    }


    /**
     * Reset the number of ContadorAciertos.
     */

    public void reiniciarContadorAciertos(){
        contadorAciertos = 0;
    }



}
