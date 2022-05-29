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

public class Interfaz_Trapecio extends JFrame implements ActionListener{

    JLabel lbl_segmentos;
    JTextField txt_segmentos;
    
    JPanel panel1;
    JTextField txt_Trapecio;
    JButton btn_Trapecio;
    JLabel lbl_Trapecio;
    JTextArea textarea_Trapecio;
    JScrollPane scrollpane_Trapecio;
    JButton limpiar_Trapecio;

    JTextField txt_errorTrapecio;
    JLabel lbl_errorTrapecio;
    JTextField txt_decimalesTrapecio;
    JLabel lbl_decimalesTrapecio;
    JTextField txt_valoraTrapecio;
    JLabel lbl_valoraTrapecio;
    JTextField txt_valorbTrapecio;
    JLabel lbl_valorbTrapecio;

    //___________________________
    String error[];
    JComboBox cotaerror;

    String decimales[];
    JComboBox numdecimales;
    //__________________________

    public Interfaz_Trapecio(){
        lbl_Trapecio=new JLabel("Ingrese la funcion ");
        lbl_Trapecio.setBounds(20, 15, 200, 20);

        txt_Trapecio=new JTextField();
        txt_Trapecio.setBounds(130, 60, 150, 20);
        txt_Trapecio.setBounds(130, 15, 500, 20);

        lbl_segmentos=new JLabel("No.Segmentos ");
        lbl_segmentos.setBounds(20, 50, 200, 20);
        
        txt_segmentos=new JTextField();
        txt_segmentos.setBounds(130, 50, 150, 20);
        
        
        lbl_valoraTrapecio=new JLabel("Limite a ");
        lbl_valoraTrapecio.setBounds(20, 100, 200, 20);

        txt_valoraTrapecio=new JTextField();
        txt_valoraTrapecio.setBounds(130, 100, 150, 20);

        lbl_valorbTrapecio=new JLabel("Limite b ");
        lbl_valorbTrapecio.setBounds(20, 120, 200, 20);

        txt_valorbTrapecio=new JTextField();
        txt_valorbTrapecio.setBounds(130, 120, 150, 20);


        lbl_decimalesTrapecio=new JLabel("Decimales");
        lbl_decimalesTrapecio.setBounds(20, 160, 200, 20);

        // txt_decimalesTrapecio=new JTextField();
        // txt_decimalesTrapecio.setBounds(130, 160, 150, 20);

        decimales= new String[] {  "1", "2","3", "4","5","6","7" };

        numdecimales= new JComboBox(decimales);
        numdecimales.setSelectedIndex(4);
        numdecimales.setBounds(130, 160, 150, 20);

        btn_Trapecio=new JButton("Obtener integral");
        btn_Trapecio.setBounds(20, 200, 200, 20);
        btn_Trapecio.addActionListener(this);

        textarea_Trapecio=new JTextArea();
        textarea_Trapecio.setEditable(false);

        scrollpane_Trapecio=new JScrollPane(textarea_Trapecio);    
        scrollpane_Trapecio.setBounds(300,50,500,300);

        limpiar_Trapecio = new JButton("Limpiar texto");
        limpiar_Trapecio.setBounds(20, 250, 200, 20);
        limpiar_Trapecio.addActionListener(this);

        panel1=new JPanel();
        panel1.setLayout(null);

        panel1.add(scrollpane_Trapecio);
        panel1.add(lbl_Trapecio);
        panel1.add(txt_Trapecio);

        panel1.add(lbl_valoraTrapecio);
        panel1.add(txt_valoraTrapecio);

        panel1.add(lbl_valorbTrapecio);
        panel1.add(txt_valorbTrapecio);


        panel1.add(lbl_decimalesTrapecio);
        panel1.add(numdecimales);

        panel1.add(btn_Trapecio);
        panel1.add(limpiar_Trapecio);

        
        panel1.add(lbl_segmentos);
        panel1.add(txt_segmentos);
    }

    public JPanel interfaz() {
        return panel1;

    }

    public void actionPerformed(ActionEvent mn){

        if(mn.getSource()==btn_Trapecio){
            String funcion;
            Double a=0.0;
            Double b=0.0;
            Double error=0.0;
            int decimales=0;
             double n =0.0;

            funcion=txt_Trapecio.getText();
            funcion=funcion.replaceAll(" ", "");  //quitar espacios

            try{
                a=Double.parseDouble(txt_valoraTrapecio.getText());
            }    catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Ingrese un valor numerico", "Valor inicial", JOptionPane.WARNING_MESSAGE);}

            try{
                b=Double.parseDouble(txt_valorbTrapecio.getText());
            }    catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Ingrese un valor numerico", "Valor inicial", JOptionPane.WARNING_MESSAGE);}

            //error=Double.parseDouble(cotaerror.getSelectedItem().toString());
            decimales=Integer.parseInt(numdecimales.getSelectedItem().toString());
            
             try{
                n=Double.parseDouble(txt_segmentos.getText());
            }    catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Ingrese un valor numerico", "Valor inicial", JOptionPane.WARNING_MESSAGE);}
            
            
            if(funcion.length()!=0){
                Trapecio f= new Trapecio();
                textarea_Trapecio.setText(f.metodoTrapecio(a,b,n,funcion,decimales));
            }else{
                JOptionPane.showMessageDialog(null, "La función no ha sido creada", "Casilla vacia ", JOptionPane.WARNING_MESSAGE);}

        }

        if(mn.getSource()==limpiar_Trapecio){
            textarea_Trapecio.setText("");
        }

    }
}
