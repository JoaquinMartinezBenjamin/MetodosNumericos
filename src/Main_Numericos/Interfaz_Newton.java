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
import javax.swing.JOptionPane;
import java.util.InputMismatchException;

public class Interfaz_Newton extends JFrame implements ActionListener{
  

    //__________________________
    JPanel panel3;
    JTextField txt_Newton;
    JButton btn_Newton;
    JLabel lbl_Newton;
    JTextArea textarea_Newton;
    JScrollPane scrollpane_Newton;
    JButton limpiar_Newton;
    
     JTextField txt_valorinicial;
     JLabel lbl_valorinicial;
     JTextField txt_errorNewton;
     JLabel lbl_errorNewton;
     JTextField txt_decimalesNewton;
     JLabel lbl_decimalesNewton;
String error[];
JComboBox cotaerror;

String decimales[];
JComboBox numdecimales;

    public  Interfaz_Newton(){
        //setDefaultCloseOperation(EXIT_ON_CLOSE );
       // setBounds(0, 0, 850, 500);
       //setVisible(true);
       
        
       
        //_________________________________________//
        
        lbl_Newton=new JLabel("Ingrese la funcion ");
        lbl_Newton.setBounds(20, 15, 200, 20);
       
        txt_Newton=new JTextField();
        txt_Newton.setBounds(130, 15, 500, 20);
        
        
        lbl_valorinicial=new JLabel("Valor inicial ");
        lbl_valorinicial.setBounds(20, 100, 200, 20);
       
        txt_valorinicial=new JTextField();
        txt_valorinicial.setBounds(130, 100, 150, 20);
        
        
        lbl_errorNewton=new JLabel("Error");
        lbl_errorNewton.setBounds(20, 140, 200, 20);
       
        // txt_errorNewton=new JTextField();
        // txt_errorNewton.setBounds(130, 140, 150, 20);
         error= new String[] { "0.1", "0.01", "0.001","0.0001", "0.00001" };
        
        cotaerror= new JComboBox(error);
        cotaerror.setSelectedIndex(2);
        cotaerror.setBounds(130, 140, 150, 20);
        
        
         lbl_decimalesNewton=new JLabel("Decimales");
        lbl_decimalesNewton.setBounds(20, 160, 200, 20);
       
        decimales= new String[] {  "1", "2","3", "4","5","6","7" };
        
        numdecimales= new JComboBox(decimales);
        numdecimales.setSelectedIndex(4);
        numdecimales.setBounds(130, 160, 150, 20);
        
        
        // txt_decimalesNewton=new JTextField();
        // txt_decimalesNewton.setBounds(130, 160, 150, 20);
        
      
        btn_Newton=new JButton("Obtener raiz");
        btn_Newton.setBounds(20, 200, 200, 20);
        btn_Newton.addActionListener(this);
        
        textarea_Newton=new JTextArea();
        textarea_Newton.setEditable(false);
  
        scrollpane_Newton=new JScrollPane(textarea_Newton);    
        scrollpane_Newton.setBounds(300,50,500,300);
        
        limpiar_Newton = new JButton("Limpiar texto");
        limpiar_Newton.setBounds(20, 250, 200, 20);
        limpiar_Newton.addActionListener(this);
        
         panel3=new JPanel();
               panel3.setLayout(null);
               
        panel3.add(scrollpane_Newton);
        panel3.add(lbl_Newton);
        panel3.add(txt_Newton);
        panel3.add(lbl_errorNewton);
        panel3.add(cotaerror);
        panel3.add(lbl_decimalesNewton);
        panel3.add(numdecimales);
        panel3.add(lbl_valorinicial);
        panel3.add(txt_valorinicial);
        panel3.add(btn_Newton);
        panel3.add(limpiar_Newton);
        //________________________________________________
        
    }

    
    
   public JPanel interfazNewton() {
    return panel3;
    
    }
    
    public void actionPerformed(ActionEvent mn){
      

        if(mn.getSource()==btn_Newton){
            String funcion;
            Double inicial=0.0;
            Double error=0.0;
            int decimales=0;
            
            funcion=txt_Newton.getText();
            funcion=funcion.replaceAll(" ", "");  //quitar espacios
            try{
            inicial=Double.parseDouble(txt_valorinicial.getText());
        }    catch (NumberFormatException nfe){
        JOptionPane.showMessageDialog(null, "Ingrese un valor numerico", "Valor inicial", JOptionPane.WARNING_MESSAGE);}
        
       
            error=Double.parseDouble(cotaerror.getSelectedItem().toString());
            
       
            decimales=Integer.parseInt(numdecimales.getSelectedItem().toString());
       
        if(funcion.length()!=0){
            
              Newton pf = new Newton();
            textarea_Newton.setText(pf.metodoNewton(inicial,funcion,error,decimales));
        }else{
            
           // System.out.print("hola");
            JOptionPane.showMessageDialog(null, "La función no ha sido creada", "Casilla vacia ", JOptionPane.WARNING_MESSAGE);}
            
          
        }
        
        
         if(mn.getSource()==limpiar_Newton){
             textarea_Newton.setText("");
        }
        
       

    }

    
    
    // public static void main(String[] args) {
       // Interfaz_Newton MN = new Interfaz_Newton();


    // }

}