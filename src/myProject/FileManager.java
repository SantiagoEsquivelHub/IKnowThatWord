package myProject;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private FileReader fileReader;
    private BufferedReader input;
    private FileWriter fileWriter;
    private BufferedWriter output;
    private int ronda;

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    /**
     * Advance round in the game.
     */

    public void cambiarRonda(){
        ronda++;
        System.out.println(ronda);
    }

    public ArrayList<Jugador> lecturaFile(String path) {
            ArrayList<Jugador> frases = new ArrayList<Jugador>();

            try {
                fileReader = new FileReader(path);
                input = new BufferedReader(fileReader);

                String line = input.readLine();

                while(line!=null){
                    Jugador jugador = new Jugador();
                   int coma = line.indexOf(",");
                   jugador.setNombre(line.substring(0,coma));//Posicion anterior de la coma
                    ronda = Integer.parseInt(line.substring(coma+1));//Posicion despues de la coma

                    System.out.println("RONDA: "+ronda+"");

                    jugador.setRondaDeJuego(ronda);
                    frases.add(jugador);

                    line=input.readLine();

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return frases;
        }

    public ArrayList<String> lecturaFilePalabrasTotales(String path) {
        ArrayList<String> palabras = new ArrayList<String>();

        try {
            fileReader = new FileReader(path);
            input = new BufferedReader(fileReader);
            String line = input.readLine();
            while(line!=null){
                palabras.add(line);
                line=input.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return palabras;
    }


    public void escribirTexto(String linea){
        try {
            fileWriter = new FileWriter("src/myProject/files/nombre.txt",true);
            output = new BufferedWriter(fileWriter);
            output.write(linea);
            output.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}




