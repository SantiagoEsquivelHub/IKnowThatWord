package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * This class is used for ...
 * @autor Paola-J Rodriguez-C paola.rodriguez@correounivalle.edu.co
 * @version v.1.0.0 date:21/11/2021
 */
public class GUI extends JFrame {

    private Header headerProject;
    private JPanel ingresarNombre, squareWord;
    private JButton initTimer;
    private Timer timer;
    private Escucha escucha;
    private JTextField nombre;
    private JLabel bienvenida, segundaBienvenida;
    private JTextArea areaNombre;
    private FileManager fileManager;
    public static final String PATH_LECTURA_PALABRAS = "src/myProject/files/palabras.txt";
    public static final String PATH_LECTURA_NOMBRE = "src/myProject/files/nombre.txt";
    public static final String MENSAJE_JUGADOR_NOMBRE = "Ingresa tu nombre para empezar el juego.";
    public static final String MENSAJE_JUGADOR_POST_NOMBRE = "Bienvenido";
    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("I know that word!");
        this.setSize(1000,700);
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
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        escucha = new Escucha();
        fileManager = new FileManager();
        //Set up JComponents
        headerProject = new Header("¡I Know That Word!", Color.BLACK);

        //Write player's name
        ingresarNombre = new JPanel();
        ingresarNombre.setBorder(BorderFactory.createTitledBorder("¡Bienvenido!"));
        ingresarNombre.setPreferredSize(new Dimension(600,250));

        bienvenida = new JLabel();
        bienvenida.setText(MENSAJE_JUGADOR_NOMBRE);
        ingresarNombre.add(bienvenida);
        nombre = new JTextField(10);
        nombre.addActionListener(escucha);
        ingresarNombre.add(nombre);

        segundaBienvenida = new JLabel();
        segundaBienvenida.setVisible(false);
        ingresarNombre.add(segundaBienvenida);

        add(ingresarNombre,BorderLayout.CENTER);
        areaNombre = new JTextArea(30,30);
        JScrollPane scroll = new JScrollPane(areaNombre);
        setFocusable(true); //Que se escuche el teclado en primera fila.


        this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout
      /*  squareWord = new JPanel();
        squareWord.setBackground(Color.CYAN);
        squareWord.setPreferredSize(new Dimension(100,100));

        add(squareWord,BorderLayout.CENTER);

        initTimer = new JButton("timer");
        initTimer.setEnabled(false);
        add(initTimer,BorderLayout.SOUTH);

        timer = new Timer(1000,escucha);
        timer.start();*/

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
        private int counter;

        public Escucha(){
            random = new Random();
            counter=0;
        }

        @Override
        public void actionPerformed(ActionEvent e) {


            //Escucha player's name
            if(e.getSource() == nombre){
                //Read the name
                fileManager.escribirTexto(nombre.getText());


              /*  String nombreJugador = fileManager.lecturaFile(PATH_LECTURA_NOMBRE);
                System.out.println(nombre.getText());
                System.out.println(nombreJugador);

                if(nombreJugador.equals(nombre.getText())){

                    //Hide the JFieldText
                    bienvenida.setVisible(false);
                    nombre.setVisible(false);

                    //Unhide the permanent message since that moment
                    segundaBienvenida.setText("Bienvenido "+nombreJugador+"");
                    segundaBienvenida.setVisible(true);

                }else{

                }
            }*/



           /* if(e.getSource()==timer){
                counter++;
                if(counter<=7){
                    squareWord.setBackground(new Color(random.nextInt(256),
                            random.nextInt(256),
                            random.nextInt(256)));
                }else{
                    timer.stop();
                    //initTimer.setVisible(true);
                    initTimer.setEnabled(true);
                    initTimer.addActionListener(escucha);
                }
            }else{
                timer.start();
                counter=0;
                //initTimer.setVisible(false);
                initTimer.setEnabled(false);
                initTimer.removeActionListener(escucha);
            }*/
        }
    }
}
}
