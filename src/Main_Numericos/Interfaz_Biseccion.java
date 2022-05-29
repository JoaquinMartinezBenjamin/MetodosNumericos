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

public class Interfaz_Biseccion extends JFrame implements ActionListener{
    
    //___________________________
    JPanel panel2;
    JTextField txt_biseccion;
    JButton btn_biseccion;
    JLabel lbl_biseccion;
    JTextArea textarea_biseccion;
    JScrollPane scrollpane_biseccion;
    JButton limpiar_biseccion;

    JTextField txt_errorbiseccion;
     JLabel lbl_errorbiseccion;
     JTextField txt_decimalesbiseccion;
     JLabel lbl_decimalesbiseccion;
        JTextField txt_valorabiseccion;
     JLabel lbl_valorabiseccion;
     JTextField txt_valorbbiseccion;
     JLabel lbl_valorbbiseccion;

  //___________________________
    String error[];
    JComboBox cotaerror;

    String decimales[];
    JComboBox numdecimales;
    //__________________________

    public Interfaz_Biseccion(){
        //______________________________________//
        lbl_biseccion=new JLabel("Ingrese la funcion ");
        lbl_biseccion.setBounds(20, 15, 200, 20);

        txt_biseccion=new JTextField();
        txt_biseccion.setBounds(130, 15, 500, 20);

         lbl_valorabiseccion=new JLabel("Valor a ");
        lbl_valorabiseccion.setBounds(20, 100, 200, 20);

        txt_valorabiseccion=new JTextField();
        txt_valorabiseccion.setBounds(130, 100, 150, 20);

        lbl_valorbbiseccion=new JLabel("Valor b ");
        lbl_valorbbiseccion.setBounds(20, 120, 200, 20);

        txt_valorbbiseccion=new JTextField();
        txt_valorbbiseccion.setBounds(130, 120, 150, 20);

         lbl_errorbiseccion=new JLabel("Error");
         lbl_errorbiseccion.setBounds(20, 140, 200, 20);

           error= new String[] { "0.1", "0.01", "0.001","0.0001", "0.00001" };
        cotaerror= new JComboBox(error);
        cotaerror.setSelectedIndex(2);
        cotaerror.setBounds(130, 140, 150, 20);

        // txt_errorbiseccion=new JTextField();
        // txt_errorbiseccion.setBounds(130, 140, 150, 20);

        lbl_decimalesbiseccion=new JLabel("Decimales");
        lbl_decimalesbiseccion.setBounds(20, 160, 200, 20);

        // txt_decimalesbiseccion=new JTextField();
        // txt_decimalesbiseccion.setBounds(130, 160, 150, 20);

          decimales= new String[] {  "1", "2","3", "4","5","6","7" };

        numdecimales= new JComboBox(decimales);
        numdecimales.setSelectedIndex(4);
        numdecimales.setBounds(130, 160, 150, 20);

        btn_biseccion=new JButton("Obtener raiz");
        btn_biseccion.setBounds(20, 200, 200, 20);
        btn_biseccion.addActionListener(this);

        textarea_biseccion=new JTextArea();
        textarea_biseccion.setEditable(false);

        scrollpane_biseccion=new JScrollPane(textarea_biseccion);    
        scrollpane_biseccion.setBounds(300,50,500,300);

        limpiar_biseccion = new JButton("Limpiar texto");
        limpiar_biseccion.setBounds(20, 250, 200, 20);
        limpiar_biseccion.addActionListener(this);

       panel2=new JPanel();
               panel2.setLayout(null);

        panel2.add(scrollpane_biseccion);
        panel2.add(lbl_biseccion);
        panel2.add(txt_biseccion);

        panel2.add(lbl_valorabiseccion);
        panel2.add(txt_valorabiseccion);
         panel2.add(lbl_valorbbiseccion);
        panel2.add(txt_valorbbiseccion);
        panel2.add(btn_biseccion);
        panel2.add(limpiar_biseccion);
        panel2.add(lbl_errorbiseccion);
        panel2.add(cotaerror);
        panel2.add(lbl_decimalesbiseccion);
         panel2.add(numdecimales);

        //_________________________________________//

    }

    public void actionPerformed(ActionEvent mn){

        
        if(mn.getSource()==btn_biseccion){

            String funcion;
            Double a=0.0;
            Double b=0.0;
            Double error=0.0;
            int decimales=0;
            funcion=txt_biseccion.getText();
            funcion=funcion.replaceAll(" ", "");  //quitar espacios

            try{
                a=Double.parseDouble(txt_valorabiseccion.getText());
            }    catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Ingrese un valor numerico", "Valor inicial", JOptionPane.WARNING_MESSAGE);}

            try{
                b=Double.parseDouble(txt_valorbbiseccion.getText());
            }    catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Ingrese un valor numerico", "Valor inicial", JOptionPane.WARNING_MESSAGE);}

              error=Double.parseDouble(cotaerror.getSelectedItem().toString());
            decimales=Integer.parseInt(numdecimales.getSelectedItem().toString());

            if(funcion.length()!=0){
                Biseccion bi = new Biseccion();
               textarea_biseccion.setText(bi.biseccion(funcion,a,b,error,decimales));
            }else{
                JOptionPane.showMessageDialog(null, "La función no ha sido creada", "Casilla vacia ", JOptionPane.WARNING_MESSAGE);}

            
        }

        
         if(mn.getSource()==limpiar_biseccion){
             textarea_biseccion.setText("");
        }

    }
public JPanel interfazbiseccion() {
    return panel2;

    }

}
