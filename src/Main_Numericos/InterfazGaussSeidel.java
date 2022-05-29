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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InterfazGaussSeidel extends JFrame implements ActionListener{

    JTextField txt_error;
    JLabel lbl_error;
    JTextField txt_decimales;
    JLabel lbl_decimales;
    
    String error[];
JComboBox cotaerror;

String decimales[];
JComboBox numdecimales;

    JComboBox tamanios;
    JTextField celdas[][];
    JTextField resultados[];
    JTextField iniciales[];

    JPanel panelNumeros, panelOperaciones,panelEncabezado,panelIniciales,contenido;
    JPanel panel;
    String tam[];
    int tamanio;

    JButton btn_raiz;
    JTextArea textarea_GaussSeidel;
    JScrollPane scrollpane_GaussSeidel;
    public InterfazGaussSeidel() {
        contenido =new JPanel(); 
        contenido.setLayout(null);
        contenido.setBounds(0, 0, 850, 500);

        //setSize(850, 500);
        
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setResizable(false);

        //setVisible(true);
        //setLayout(null);

        
          lbl_error=new JLabel("Error");
         lbl_error.setBounds(20, 140, 200, 20);
       contenido.add(lbl_error);

         error= new String[] { "0.1", "0.01", "0.001","0.0001", "0.00001" };
        
        cotaerror= new JComboBox(error);
        cotaerror.setSelectedIndex(2);
        cotaerror.setBounds(130, 140, 150, 20);
        contenido.add(cotaerror);
        
        
         lbl_decimales=new JLabel("Decimales");
        lbl_decimales.setBounds(20, 160, 200, 20);
        contenido.add(lbl_decimales);
        decimales= new String[] {  "1", "2","3", "4","5","6","7" };
        
        numdecimales= new JComboBox(decimales);
        numdecimales.setSelectedIndex(4);
        numdecimales.setBounds(130, 160, 150, 20);
        contenido.add(numdecimales);
        
        
        
        
        textarea_GaussSeidel=new JTextArea();
        textarea_GaussSeidel.setEditable(false);

        scrollpane_GaussSeidel=new JScrollPane(textarea_GaussSeidel);    
        scrollpane_GaussSeidel.setBounds(300,250,400,130);
        contenido.add(scrollpane_GaussSeidel);

        JLabel ancho = new JLabel("Matriz");
        ancho.setBounds(20, 50, 200, 20);
        contenido.add(ancho);

        btn_raiz=new JButton("Soluciones");
        btn_raiz.setBounds(20, 200, 200, 20);
        contenido.add(btn_raiz);
        btn_raiz.addActionListener(this);

        tam= new String[] { "2 x 2", "3 x 3", "4 x 4" };
        tamanios= new JComboBox(tam);
        tamanios.setSelectedIndex(0);
        tamanios.setBounds(130, 50, 150, 20);
        contenido.add(tamanios);
        tamanios.addActionListener(this);

        tamanio=2;
        //tamanios.getSelectedIndex();

        celdas = new JTextField[tamanio][tamanio];
        resultados = new JTextField[tamanio];

        iniciales = new JTextField[tamanio];
        panel =new JPanel(); 
        panel.setLayout(new BorderLayout());
        panel.setBounds(300, 50, 400, 200);

        panelEncabezado = new JPanel();
        panelEncabezado.setLayout(new GridLayout(1,tamanio+1));
        String variable="X";

        for(int k = 0; k<tamanio; k++){
            panelEncabezado.add(new JLabel("   "+variable+""+k));

        }
        panelEncabezado.add(new JLabel("Resultado"));
        panel.add("North", panelEncabezado);

        //________________________________________________________________
        for(int k = 0; k<tamanio; k++){
            iniciales[k]=new JTextField();

        }
        panelIniciales = new JPanel();
        panelIniciales.setLayout(new GridLayout(1,tamanio+1));

        for(int k = 0; k<tamanio; k++){
            panelIniciales.add(new JLabel("Inicial x"+k));
            panelIniciales.add(iniciales[k]);

        }

        panel.add("South", panelIniciales);
        //________________________________________________________________________________

        

        panelNumeros = new JPanel();
        panelNumeros.setLayout(new GridLayout(tamanio,tamanio+1));
        panelNumeros.setBorder(new EmptyBorder(8, 8, 8, 8));

        for(int k = 0; k<tamanio; k++){
            resultados[k]=new JTextField();

        }
        for(int i =0; i<tamanio; i++){
            for(int j = 0; j<tamanio; j++){
                celdas[i][j]=new JTextField();
                celdas[i][j].setText("");

            }
        }

        for(int i =0; i<tamanio; i++){

            for(int j = 0; j<tamanio; j++){

                panelNumeros.add(celdas[i][j]);
            }
            panelNumeros.add(resultados[i]);
        }

        panel.add("Center", panelNumeros);
        //getContentPane().add(panel);
        contenido.add(panel);
        //contenido.setVisible(false);
        ///contenido.setVisible(true);

    }

    public void actionPerformed(ActionEvent mn){
        // if(mn.getSource()== btn_llavea){
        // funcion+="(";
        // pantalla.setText(funcion);

        // }
        // if(mn.getSource()== btn_llaveb){
        // funcion+=")";
        // pantalla.setText(funcion);

        // }
        if(mn.getSource()== btn_raiz){

            double matriz[][] = new double [tamanio][tamanio];
            double results[] = new double[tamanio];
            double inicials[] = new double[tamanio];
double error=0.0;
int decimales=0;
            String aux="";
            for(int i=0; i<tamanio; i++){
                for (int j=0; j<tamanio; j++){
                    aux=celdas[i][j].getText();
                    aux.replaceAll(" ", "");
                    try{
                        matriz[i][j] =Double.parseDouble(aux);
                    }    catch (NumberFormatException nfe){
                        JOptionPane.showMessageDialog(null, "Ingrese un valor numerico", "celda "+i+" "+j, JOptionPane.WARNING_MESSAGE);}
                }
            }

            aux="";
            for(int i=0; i<tamanio; i++){ aux=resultados[i].getText(); aux.replaceAll(" ", "");
                try{results[i]=Double.parseDouble(aux);}catch (NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null, "Ingrese un valor numerico", "celda "+i, JOptionPane.WARNING_MESSAGE);}

            }

    
            aux="";
            for(int i=0; i<tamanio; i++){ aux=iniciales[i].getText(); aux.replaceAll(" ", "");
                try{inicials[i]=Double.parseDouble(aux);}catch (NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null, "Ingrese un valor numerico", "celda "+i, JOptionPane.WARNING_MESSAGE);}

            }

            error=Double.parseDouble(cotaerror.getSelectedItem().toString());
            
       
            decimales=Integer.parseInt(numdecimales.getSelectedItem().toString());
            
            GaussSeidel J = new GaussSeidel();
             textarea_GaussSeidel.setText("");
              textarea_GaussSeidel.setText(J.metodoGaussSeidel (matriz,results,inicials,error,decimales));
           // J.metodoGaussSeidel (matriz,results,inicials,error,decimales);

        }
        if(mn.getSource()== tamanios){
            tamanio=tamanios.getSelectedIndex()+2;
            panelNumeros.removeAll();
            panelEncabezado.removeAll();
            panelIniciales.removeAll();
            //panelNumeros.repaint();

            panelEncabezado.setLayout(new GridLayout(1,tamanio+1));
            String variable="X";

            for(int k = 0; k<tamanio; k++){
                panelEncabezado.add(new JLabel("   "+variable+""+k));

            }
            panelEncabezado.add(new JLabel("Resultado"));
            panel.add("North", panelEncabezado);

            panelNumeros.setLayout(new GridLayout(tamanio,tamanio+1));
            panelNumeros.setBorder(new EmptyBorder(8, 8, 8, 8));

            celdas = new JTextField[tamanio][tamanio];
            resultados = new JTextField[tamanio];
            iniciales = new JTextField[tamanio];  ///____________________________
            for(int k = 0; k<tamanio; k++){
                iniciales[k]=new JTextField();

            }
            panelIniciales.setLayout(new GridLayout(1,tamanio+1));

            for(int k = 0; k<tamanio; k++){
                panelIniciales.add(new JLabel("Inicial x"+k));
                panelIniciales.add(iniciales[k]);

            }

            for(int k = 0; k<tamanio; k++){
                resultados[k]=new JTextField();

            }
            for(int i =0; i<tamanio; i++){
                for(int j = 0; j<tamanio; j++){
                    celdas[i][j]=new JTextField();
                    celdas[i][j].setText("");

                }
            }

            for(int i =0; i<tamanio; i++){

                for(int j = 0; j<tamanio; j++){

                    panelNumeros.add(celdas[i][j]);
                }
                panelNumeros.add(resultados[i]);
            }
            panelNumeros.setVisible(false);
            panelEncabezado.setVisible(false);
            panelIniciales.setVisible(false);

            panelNumeros.setVisible(true);
            panelEncabezado.setVisible(true);
            panelIniciales.setVisible(true);

        }
    }
 public JPanel interfazGaussSeidel() {
        return contenido;

    }
    // public static void main (String [] args){
        // Matriz c = new Matriz();
    // }
}
