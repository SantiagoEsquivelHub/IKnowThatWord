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
    private JButton initGame,botonSi,botonNo, validar;
    private Timer timerPalabrasMemorizar, timerPalabrasNivel;
    private Escucha escucha;
    private JTextField nombre;
    private JLabel bienvenida, segundaBienvenida, mostrarPalabra;
    private JTextArea mostrarMensajeRonda;
    private JTextArea areaNombre;
    private FileManager fileManager;
    public static final String PATH_LECTURA_PALABRAS = "src/myProject/files/palabras.txt";
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
        ingresarNombre.setPreferredSize(new Dimension(600,60));
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

        juego = new JPanel();
        juego.setBorder(BorderFactory.createTitledBorder("¡I know that word!"));
        juego.setPreferredSize(new Dimension(600,200));
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.BOTH;
        this.add(juego,constraints);

        mostrarMensajeRonda = new JTextArea();
        mostrarMensajeRonda.setVisible(false);
        mostrarMensajeRonda.setEditable(false);
        juego.add(mostrarMensajeRonda);

        botonSi = new JButton("SI");
        botonSi.addActionListener(escucha);
        botonSi.setVisible(false);
        juego.add(botonSi);

        botonNo = new JButton("NO");
        botonNo.addActionListener(escucha);
        botonNo.setVisible(false);
        juego.add(botonNo);

        validar = new JButton("VALIDAR");
        validar.addActionListener(escucha);
        validar.setVisible(false);
        juego.add(validar);

        mostrarPalabra = new JLabel();
        mostrarPalabra.setVisible(false);
        juego.add(mostrarPalabra);


        initGame = new JButton("JUGAR");
        initGame.addActionListener(escucha);
        initGame.setVisible(false);
        juego.add(initGame);
        timerPalabrasMemorizar = new Timer(1000,escucha);
        timerPalabrasNivel = new Timer(1000,escucha);


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
                if(counterMemorizada < modelKnow.sizeArrayPalabrasMemorizar()/2){
                    mostrarPalabra.setText(modelKnow.devolverPalabraMemorizar(counterMemorizada));
                    if(e.getSource()==botonSi){

                    }
                    counterMemorizada++;
                }else{
                    timerPalabrasMemorizar.stop();
                    mostrarPalabra.setText(modelKnow.devolverPalabraNivel(0));
                    JOptionPane.showMessageDialog(null,
                            "COMIENZA EL JUEGO",

                            "PopUp Dialog",
                            JOptionPane.INFORMATION_MESSAGE);
                    timerPalabrasNivel.start();

                }
            }

            if(e.getSource()==timerPalabrasNivel){
                if(counterNivel < modelKnow.sizeArrayPalabrasNivel()){
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

                if(nombreJugador){

                    //Hide the JFieldText
                    bienvenida.setVisible(false);
                    nombre.setVisible(false);
                    initGame.setVisible(true);

                    //Unhide the permanent message since that moment
                    segundaBienvenida.setText("Bienvenido "+nombre.getText()+"");
                    segundaBienvenida.setVisible(true);
                    juego.setVisible(true);


                    //PRIMERA PARTE DEL JUEGO, SE MUESTRAS LAS PALABRAS CON EL ATRIBUTO MEMORIZADA EN TRUE

                   /* for (int i = 0; i < palabrasParaJugar.size(); i++){
                        mostrarPalabra.setVisible(true);
                        //mostrarPalabra.setText(palabrasParaJugar.get(i).getPalabra());
                        System.out.println("palabra");
                        System.out.println(palabrasParaJugar.get(i).getPalabra());
                        System.out.println("memorizada");
                        System.out.println(palabrasParaJugar.get(i).getMemorizada());
                    }*/

                }

            }

            if(e.getSource()==initGame){
                initGame.setVisible(false);
                mostrarPalabra.setVisible(true);
                botonSi.setVisible(true);
                botonNo.setVisible(true);

                String mensajeRonda = modelKnow.mensajePorRonda(7);
                mostrarMensajeRonda.setVisible(true);
                mostrarMensajeRonda.setText(mensajeRonda);

                modelKnow.crearArreglos(7);


                mostrarPalabra.setText(modelKnow.devolverPalabraMemorizar(0));
                JOptionPane.showMessageDialog(null,
                        "10 PALABRAS A MEMORIZAR",

                        "PopUp Dialog",
                        JOptionPane.INFORMATION_MESSAGE);
                timerPalabrasMemorizar.start();





                for (int i = 0; i < modelKnow.sizeArrayPalabrasMemorizar(); i++){

                    System.out.println(modelKnow.devolverPalabraMemorizar(i));

                }


            }

            if(e.getSource()==validar){
                modelKnow.puntosPorRonda(1);

            }


            revalidate();
            repaint();

        }
    }
}

