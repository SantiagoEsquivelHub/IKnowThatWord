package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class is used for ...
 * @autor Paola-J Rodriguez-C paola.rodriguez@correounivalle.edu.co
 * @version v.1.0.0 date:21/11/2021
 */
public class GUI extends JFrame {
    private ModelKnow modelKnow;
    private Header headerProject;
    private JPanel ingresarNombre, juego;
    private JButton initGame,botonSi,botonNo, validar, reset;
    private Timer timerPalabrasMemorizar, timerPalabrasNivel;
    private Escucha escucha;
    private JTextField nombre;
    private JLabel bienvenida, segundaBienvenida, mostrarPalabra, score, level;
    private JTextArea mostrarMensajeRonda, mostrarMensajeInicial;
    private JTextArea areaNombre;
    private FileManager fileManager;
    public static final String PATH_LECTURA_NOMBRE = "src/myProject/files/nombre.txt";
    public static final String MENSAJE_JUGADOR_NOMBRE = "Ingresa tu nombre para empezar el juego.";
    public static final String MENSAJE_JUEGO_GENERAL = "Debes recordar las palabras indicadas en cada ronda,\n" +
            " tendras un limite de tiempo para ello.\n" +
            "La velocidad es fundamental para lograr tu objetivo,\n" +
            " habra limites de tiempo para tomar \n" +
            "decisiones, esperamos que este juego sea de tu agrado\n";

    /*
    * Implementación de Array List
    * **/

    //Comentado mientras se crea la clase
    //private ArrayList <PalabraNivel> allWords = fileManager.lecturaPalabra(  PATH_LECTURA_PALABRAS);



    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("I know that word!");
        this.setSize(900,700);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        escucha = new Escucha();
        fileManager = new FileManager();
        modelKnow = new ModelKnow();
        //Set up JComponents
        headerProject = new Header("¡I Know That Word!", Color.BLACK);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        this.add(headerProject,constraints);

        //Write player's name
        ingresarNombre = new JPanel();
        ingresarNombre.setBorder(BorderFactory.createTitledBorder("¡Bienvenido!"));
        ingresarNombre.setPreferredSize(new Dimension(700,60));
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.BOTH;
        this.add(ingresarNombre,constraints);

        bienvenida = new JLabel();
        bienvenida.setText(MENSAJE_JUGADOR_NOMBRE);
        ingresarNombre.add(bienvenida);
        nombre = new JTextField(10);
        nombre.addActionListener(escucha);
        ingresarNombre.add(nombre);

        segundaBienvenida = new JLabel();
        segundaBienvenida.setVisible(false);
        ingresarNombre.add(segundaBienvenida);


        areaNombre = new JTextArea(30,30);
        JScrollPane scroll = new JScrollPane(areaNombre);
        setFocusable(true); //Que se escuche el teclado en primera fila.

        juego = new JPanel(new GridBagLayout());
        GridBagConstraints constraintsJuego = new GridBagConstraints();
        juego.setBorder(BorderFactory.createTitledBorder("¡I know that word!"));
        juego.setPreferredSize(new Dimension(700,400));
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.BOTH;
        this.add(juego,constraints);


        mostrarMensajeInicial = new JTextArea(5, 20);
        constraintsJuego.gridx=0;
        constraintsJuego.gridy=1;
        constraintsJuego.gridwidth=4;
      //constraintsJuego.fill=GridBagConstraints.CENTER;
        mostrarMensajeInicial.setText(MENSAJE_JUEGO_GENERAL);
        juego.add(mostrarMensajeInicial, constraintsJuego);

        mostrarMensajeRonda = new JTextArea(3, 30);
        mostrarMensajeRonda.setVisible(false);
        mostrarMensajeRonda.setEditable(false);
        constraintsJuego.gridx=0;
        constraintsJuego.gridy=1;
        constraintsJuego.gridwidth=3;
        //constraintsJuego.fill=GridBagConstraints.CENTER;
        juego.add(mostrarMensajeRonda, constraintsJuego);

        botonSi = new JButton("SI");
        botonSi.addActionListener(escucha);
        botonSi.setVisible(false);
        constraintsJuego.gridx=0;
        constraintsJuego.gridy=3;
        constraintsJuego.gridwidth=2;
        //constraintsJuego.fill=GridBagConstraints.BOTH;
        juego.add(botonSi, constraintsJuego);

        botonNo = new JButton("NO");
        botonNo.addActionListener(escucha);
        botonNo.setVisible(false);
        constraintsJuego.gridx=4;
        constraintsJuego.gridy=3;
        constraintsJuego.gridwidth=2;
        //constraintsJuego.fill=GridBagConstraints.BOTH;
        juego.add(botonNo, constraintsJuego);


        validar = new JButton("VALIDAR");
        validar.addActionListener(escucha);
        validar.setVisible(false);
        constraintsJuego.gridx=0;
        constraintsJuego.gridy=2;
        constraintsJuego.gridwidth=4;
        //constraintsJuego.fill=GridBagConstraints.BOTH;
        juego.add(validar, constraintsJuego);

        mostrarPalabra = new JLabel();
        mostrarPalabra.setVisible(false);
        constraintsJuego.gridx=2;
        constraintsJuego.gridy=2;
        constraintsJuego.gridwidth=1;
        //constraintsJuego.fill=GridBagConstraints.BOTH;
        juego.add(mostrarPalabra, constraintsJuego);

        score = new JLabel();
        score.setVisible(false);
        constraintsJuego.gridx=0;
        constraintsJuego.gridy=5;
        constraintsJuego.gridwidth=2;
        //constraintsJuego.fill=GridBagConstraints.BOTH;
        juego.add(score, constraintsJuego);

        level = new JLabel();
        level.setVisible(false);
        constraintsJuego.gridx=4;
        constraintsJuego.gridy=5;
        constraintsJuego.gridwidth=2;
        //constraintsJuego.fill=GridBagConstraints.BOTH;
        juego.add(level, constraintsJuego);


        initGame = new JButton("JUGAR");
        initGame.addActionListener(escucha);
        initGame.setVisible(false);
        constraintsJuego.gridx=0;
        constraintsJuego.gridy=2;
        constraintsJuego.gridwidth=4;
        constraintsJuego.fill=GridBagConstraints.LINE_END;
        juego.add(initGame, constraintsJuego);

        reset = new JButton("REINICIAR");
        reset.addActionListener(escucha);
        reset.setVisible(false);
        constraintsJuego.gridx=0;
        constraintsJuego.gridy=2;
        constraintsJuego.gridwidth=4;
        constraintsJuego.fill=GridBagConstraints.LINE_END;
        juego.add(reset, constraintsJuego);

        timerPalabrasMemorizar = new Timer(5000,escucha);
        timerPalabrasNivel = new Timer(7000,escucha);


    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener {
        private Random random;
        private int counterMemorizada, counterNivel;


        public Escucha(){
            random = new Random();
            counterMemorizada=1;
            counterNivel=1;

        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource()==timerPalabrasMemorizar){
                if(counterMemorizada < (modelKnow.sizeArrayPalabrasMemorizar()/2)){
                    //System.out.println("num de palabras a memorizar "+(modelKnow.sizeArrayPalabrasMemorizar()/2)+"");
                    mostrarPalabra.setText(modelKnow.devolverPalabraMemorizar(counterMemorizada));
                    counterMemorizada++;
                }else{
                    timerPalabrasMemorizar.stop();
                    mostrarPalabra.setText(modelKnow.devolverPalabraNivel(0));
                    JOptionPane.showMessageDialog(null,
                            "COMIENZA EL JUEGO",

                            "PopUp Dialog",
                            JOptionPane.INFORMATION_MESSAGE);
                    botonSi.setVisible(true);
                    botonNo.setVisible(true);
                    timerPalabrasNivel.start();

                }
            }

            if(e.getSource()==timerPalabrasNivel){
                if(counterNivel < modelKnow.sizeArrayPalabrasNivel()){
                    botonSi.setEnabled(true);
                    botonNo.setEnabled(true);
                    level.setVisible(true);
                    level.setText("Ronda: "+modelKnow.getRonda()+"");
                    score.setVisible(true);
                    score.setText("Puntaje: "+modelKnow.retornaAciertosActuales()+"");
                    mostrarPalabra.setText(modelKnow.devolverPalabraNivel(counterNivel));
                    counterNivel++;
                }else{
                    timerPalabrasNivel.stop();
                    validar.setVisible(true);
                    botonNo.setVisible(false);
                    botonSi.setVisible(false);
                    mostrarPalabra.setVisible(false);
                }
            }

            //Escucha player's name
            if(e.getSource() == nombre){

                boolean nombreJugador = modelKnow.pintarNombreJugador(fileManager.lecturaFile(PATH_LECTURA_NOMBRE),nombre.getText());
                //modelKnow.getRonda();

                if(nombreJugador){
                    //Hide the JFieldText
                    bienvenida.setVisible(false);
                    nombre.setVisible(false);
                    initGame.setVisible(true);

                    //Unhide the permanent message since that moment
                    segundaBienvenida.setText("Bienvenido "+nombre.getText()+"");
                    segundaBienvenida.setVisible(true);
                    juego.setVisible(true);

                }else{
                    //Hide the JFieldText
                    bienvenida.setVisible(false);
                    nombre.setVisible(false);
                    initGame.setVisible(true);

                    fileManager.escribirTexto(""+nombre.getText()+","+modelKnow.getRonda()+"");
                    segundaBienvenida.setText("Bienvenido "+nombre.getText()+"");
                    segundaBienvenida.setVisible(true);
                    juego.setVisible(true);
                }

            }

            if(e.getSource()==initGame){

                fileManager.lecturaFile(PATH_LECTURA_NOMBRE);
                initGame.setVisible(false);
                mostrarPalabra.setVisible(true);
                mostrarMensajeInicial.setVisible(false);


                //System.out.println(fileManager.getRonda());

                String mensajeRonda = modelKnow.mensajePorRonda(modelKnow.getRonda());
                mostrarMensajeRonda.setVisible(true);
                mostrarMensajeRonda.setText(mensajeRonda);


                modelKnow.crearArreglos(modelKnow.getRonda());


                mostrarPalabra.setText(modelKnow.devolverPalabraMemorizar(0));

                JOptionPane.showMessageDialog(null,
                        ""+modelKnow.palabrasMemorizarPorRonda(modelKnow.getRonda())+" PALABRAS A MEMORIZAR",

                        "PopUp Dialog",
                        JOptionPane.INFORMATION_MESSAGE);
                timerPalabrasMemorizar.start();





                /*for (int i = 0; i < modelKnow.sizeArrayPalabrasMemorizar(); i++){

                    System.out.println(modelKnow.devolverPalabraMemorizar(i));

                }*/


            }


                if (e.getSource() == botonSi) {
                    modelKnow.palabraEsMemorizada(modelKnow.devolverPalabraMemorizarObj(counterNivel-1));
                    botonSi.setEnabled(false);
                    botonNo.setEnabled(false);
                }

                if (e.getSource() == botonNo) {
                    modelKnow.palabraNoEsMemorizada(modelKnow.devolverPalabraMemorizarObj(counterNivel-1));
                    botonNo.setEnabled(false);
                    botonSi.setEnabled(false);
                }

                if(e.getSource()==reset){
                    modelKnow.setRonda(1);
                    reset.setVisible(false);
                    initGame.setVisible(true);
                }

                if(modelKnow.getRonda() == 11){
                    initGame.setVisible(false);
                    mostrarMensajeInicial.setVisible(false);
                    mostrarMensajeRonda.setText(modelKnow.mensajePorRonda(11));
                    mostrarMensajeRonda.setVisible(true);
                    reset.setVisible(true);

                }


            if(e.getSource()==validar){
                int puntosPasarRonda = modelKnow.puntosPorRonda(modelKnow.getRonda());
                int puntosActuales = modelKnow.retornaAciertosActuales();
                if(puntosActuales >= puntosPasarRonda){

                    int opcion = JOptionPane.showConfirmDialog(null, "PASASTE DE RONDA\n"
                                    + "Obtuviste " + puntosActuales + " de " + puntosPasarRonda + " para pasar de ronda\n"
                                    + "¿Quienes jugar la siguiente ronda ahora?",
                            "PopUp Dialog", JOptionPane.YES_NO_OPTION);
                    level.setVisible(false);
                    score.setVisible(false);
                    validar.setVisible(false);
                    modelKnow.reiniciarContadorAciertos();//reiniciamos contador para la ronda de juego nueva
                    counterMemorizada = 1;//reiniciamos contador del ciclo del timer
                    counterNivel = 1;
                    modelKnow.cambiarRonda(fileManager.lecturaFile(PATH_LECTURA_NOMBRE),nombre.getText());

                    //Change text file.



                    if(opcion == JOptionPane.YES_OPTION){
                        String mensajeRonda = modelKnow.mensajePorRonda(modelKnow.getRonda());
                        mostrarMensajeRonda.setText(mensajeRonda);
                        initGame.setVisible(true);

                    }else{
                        if(opcion == JOptionPane.NO_OPTION){
                            System.exit(0);
                        }else{
                            System.exit(0);
                        }
                    }



                }else{
                    int opcion = JOptionPane.showConfirmDialog(null, "PERDISTE LA RONDA\n"
                                    + "Obtuviste " + puntosActuales + " de " + puntosPasarRonda + " para pasar de ronda\n"
                                    + "¿Quienes jugar la siguiente repetir la ronda ahora?",
                            "PopUp Dialog", JOptionPane.YES_NO_OPTION);
                    level.setVisible(false);
                    score.setVisible(false);
                    modelKnow.reiniciarContadorAciertos();//reiniciamos contador para volver a jugar la ronda anterior
                    counterMemorizada = 1;//reiniciamos contador del ciclo del timer
                    counterNivel = 1;
                    if(opcion == JOptionPane.YES_OPTION){
                        validar.setVisible(false);
                        initGame.setVisible(true);

                    }else{
                        if(opcion == JOptionPane.NO_OPTION){
                            System.exit(0);
                        }else{
                            System.exit(0);
                        }
                    }

                }


            }


            revalidate();
            repaint();

        }
    }
}

