/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_Numericos;

/**
 *
 * @author Benjamin
 */
import javax.swing.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    JTabbedPane pestanias;
    JTabbedPane tipo;
    JTabbedPane sistemas;
    JPanel panelprueba;
    JTabbedPane integracion;
    JTabbedPane derivacion;

    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel4;
    JPanel panel5;
    JPanel panel6;
    JPanel panel7;
    JPanel panel8;
    JPanel panel9;
    JPanel panel10;
    JPanel panel11;

    public Main() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0, 0, 850, 500);
        setVisible(true);
        setTitle("Metodos Numericos\t\t Version 1.0.0");
        panelprueba = new JPanel();
        panelprueba.setLayout(null);

        panel2 = new JPanel();
        panel2.setLayout(null);

        panel3 = new JPanel();
        panel3.setLayout(null);

        panel1 = new JPanel();
        panel1.setLayout(null);

        panel4 = new JPanel();
        panel4.setLayout(null);

        panel5 = new JPanel();
        panel5.setLayout(null);

        panel6 = new JPanel();
        panel6.setLayout(null);

        panel7 = new JPanel();
        panel7.setLayout(null);

        panel8 = new JPanel();
        panel8.setLayout(null);

        panel9 = new JPanel();
        panel9.setLayout(null);

        panel10 = new JPanel();
        panel10.setLayout(null);

        panel11 = new JPanel();
        panel11.setLayout(null);
        //________________________________________________
        Interfaz_falsaposicion f = new Interfaz_falsaposicion();
        panel1 = f.interfaz();

        Interfaz_Biseccion biseccion = new Interfaz_Biseccion();
        panel2 = biseccion.interfazbiseccion();

        Interfaz_PuntoFijo pfijo = new Interfaz_PuntoFijo();
        panel3 = pfijo.interfazpuntofijo();

        Interfaz_Newton newton = new Interfaz_Newton();
        panel4 = newton.interfazNewton();

        Interfaz_Secante secante = new Interfaz_Secante();
        panel5 = secante.interfazSecante();

        InterfazJacobi jacobi = new InterfazJacobi();
        panel6 = jacobi.interfazJacobi();

        InterfazGaussSeidel gs = new InterfazGaussSeidel();
        panel7 = gs.interfazGaussSeidel();

        Interfaz_Simpson s = new Interfaz_Simpson();
        panel8 = s.interfaz();

        Interfaz_Trapecio t = new Interfaz_Trapecio();
        panel9 = t.interfaz();

        Interfaz_Diferencias d = new Interfaz_Diferencias();
        panel10 = d.interfazDiferencias();

        InterfazMinimosCuadrados mc = new InterfazMinimosCuadrados();
        panel11 = mc.interfazMinimosCuadrados();

        //________________________________________________ 
        tipo = new JTabbedPane();
        pestanias = new JTabbedPane();
        sistemas = new JTabbedPane();
        integracion = new JTabbedPane();
        //derivacion=new JTabbedPane();

        pestanias.addTab("Punto fijo", panel3);
        pestanias.addTab("Falsa posicion", panel1);
        pestanias.addTab("Biseccion", panel2);
        pestanias.addTab("Newton", panel4);
        pestanias.addTab("Secante", panel5);
        sistemas.addTab("Jacobi", panel6);
        sistemas.addTab("Gauss_Seidel", panel7);
        integracion.addTab("Simpson", panel8);
        integracion.addTab("Trapecio", panel9);
        //derivacion.addTab("Derivación",panel10);
        tipo.addTab("Solución de ecuaciones", pestanias);
        tipo.addTab("Sistemas de ecuaciones", sistemas);
        tipo.addTab("Integracion numerica", integracion);
        tipo.addTab("Derivación numérica", panel10);
        tipo.addTab("Regresion lineal", panel11);
        getContentPane().add(tipo);

    }

    public void actionPerformed(ActionEvent mn) {

        // if(mn.getSource()==limpiar_biseccion){
        // textarea_biseccion.setText("");
        // }
    }

    public static void main(String[] args) {
        Main MN = new Main();
    }

}
