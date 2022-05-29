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

public class Interfaz_Diferencias extends JFrame implements ActionListener{
  

    //__________________________
    JPanel panel3;
    JTextField txt_Diferencias;
    JButton btn_Diferencias;
       JButton btn_Centradas;
    JLabel lbl_Diferencias;
    JTextArea textarea_Diferencias;
    JScrollPane scrollpane_Diferencias;
    JButton limpiar_Diferencias;
    
     JTextField txt_valorinicial;
     JLabel lbl_valorinicial;
     JTextField txt_errorDiferencias;
     JLabel lbl_errorDiferencias;
     JTextField txt_decimalesDiferencias;
     JLabel lbl_decimalesDiferencias;
String error[];
JComboBox cotaerror;

String decimales[];
JComboBox numdecimales;

    public  Interfaz_Diferencias(){
        //setDefaultCloseOperation(EXIT_ON_CLOSE );
       // setBounds(0, 0, 850, 500);
       //setVisible(true);
       
        
       
        //_________________________________________//
        
        lbl_Diferencias=new JLabel("Ingrese la funcion ");
        lbl_Diferencias.setBounds(20, 15, 200, 20);
       
        txt_Diferencias=new JTextField();
        txt_Diferencias.setBounds(130, 15, 500, 20);
        
        
        lbl_valorinicial=new JLabel("Valor inicial x");
        lbl_valorinicial.setBounds(20, 100, 200, 20);
       
        txt_valorinicial=new JTextField();
        txt_valorinicial.setBounds(130, 100, 150, 20);
        
        
        lbl_errorDiferencias=new JLabel("h");
        lbl_errorDiferencias.setBounds(20, 140, 200, 20);
       
        // txt_errorDiferencias=new JTextField();
        // txt_errorDiferencias.setBounds(130, 140, 150, 20);
         error= new String[] { "0.1", "0.01", "0.001","0.0001", "0.00001" };
        
        cotaerror= new JComboBox(error);
        cotaerror.setSelectedIndex(2);
        cotaerror.setBounds(130, 140, 150, 20);
        
        
         lbl_decimalesDiferencias=new JLabel("Decimales");
        lbl_decimalesDiferencias.setBounds(20, 160, 200, 20);
       
        decimales= new String[] {  "1", "2","3", "4","5","6","7" };
        
        numdecimales= new JComboBox(decimales);
        numdecimales.setSelectedIndex(4);
        numdecimales.setBounds(130, 160, 150, 20);
        
        
        // txt_decimalesDiferencias=new JTextField();
        // txt_decimalesDiferencias.setBounds(130, 160, 150, 20);
        
      
        btn_Diferencias=new JButton("Progresiva");
        btn_Diferencias.setBounds(20, 200, 200, 20);
        btn_Diferencias.addActionListener(this);
        
        btn_Centradas=new JButton("Centrada");
        btn_Centradas.setBounds(20, 225, 200, 20);
        btn_Centradas.addActionListener(this);
        
        textarea_Diferencias=new JTextArea();
        textarea_Diferencias.setEditable(false);
  
        scrollpane_Diferencias=new JScrollPane(textarea_Diferencias);    
        scrollpane_Diferencias.setBounds(300,50,500,300);
        
        limpiar_Diferencias = new JButton("Regresiva");
        limpiar_Diferencias.setBounds(20, 250, 200, 20);
        limpiar_Diferencias.addActionListener(this);
        
         panel3=new JPanel();
               panel3.setLayout(null);
               
        panel3.add(scrollpane_Diferencias);
        panel3.add(lbl_Diferencias);
        panel3.add(txt_Diferencias);
        panel3.add(lbl_errorDiferencias);
        panel3.add(cotaerror);
        //panel3.add(lbl_decimalesDiferencias);
        //panel3.add(numdecimales);
        panel3.add(lbl_valorinicial);
        panel3.add(txt_valorinicial);
        panel3.add(btn_Diferencias);
        panel3.add(limpiar_Diferencias);
        panel3.add(btn_Centradas);
        //________________________________________________
        
    }

    
    
   public JPanel interfazDiferencias() {
    return panel3;
    
    }
    
    public void actionPerformed(ActionEvent mn){
      

        if(mn.getSource()==btn_Diferencias){
            String funcion;
            Double inicial=0.0;
            Double error=0.0;
           // int decimales=0;
            
            funcion=txt_Diferencias.getText();
            funcion=funcion.replaceAll(" ", "");  //quitar espacios
            try{
            inicial=Double.parseDouble(txt_valorinicial.getText());
        }    catch (NumberFormatException nfe){
        JOptionPane.showMessageDialog(null, "Ingrese un valor numerico", "Valor inicial", JOptionPane.WARNING_MESSAGE);}
        
       
            error=Double.parseDouble(cotaerror.getSelectedItem().toString());
            
       
            //decimales=Integer.parseInt(numdecimales.getSelectedItem().toString());
       
        if(funcion.length()!=0){
            
              Diferencias pf = new Diferencias();
              textarea_Diferencias.setText("");
            textarea_Diferencias.setText(pf.diferenciaProgresiva(inicial,error,funcion));
        }else{
            
           // System.out.print("hola");
            JOptionPane.showMessageDialog(null, "La función no ha sido creada", "Casilla vacia ", JOptionPane.WARNING_MESSAGE);}
            
          
        }
        
        if(mn.getSource()== btn_Centradas){
             String funcion;
            Double inicial=0.0;
            Double error=0.0;
           // int decimales=0;
            
            funcion=txt_Diferencias.getText();
            funcion=funcion.replaceAll(" ", "");  //quitar espacios
            try{
            inicial=Double.parseDouble(txt_valorinicial.getText());
        }    catch (NumberFormatException nfe){
        JOptionPane.showMessageDialog(null, "Ingrese un valor numerico", "Valor inicial", JOptionPane.WARNING_MESSAGE);}
        
       
            error=Double.parseDouble(cotaerror.getSelectedItem().toString());
            
       
            //decimales=Integer.parseInt(numdecimales.getSelectedItem().toString());
       
        if(funcion.length()!=0){
            
              Diferencias pf = new Diferencias();
              textarea_Diferencias.setText("");
            textarea_Diferencias.setText(pf.diferenciaCentrada(inicial,error,funcion));
        }else{
            
           // System.out.print("hola");
            JOptionPane.showMessageDialog(null, "La función no ha sido creada", "Casilla vacia ", JOptionPane.WARNING_MESSAGE);}
        }
        
        
        
        
        
         if(mn.getSource()==limpiar_Diferencias){
               String funcion;
            Double inicial=0.0;
            Double error=0.0;
           // int decimales=0;
            
            funcion=txt_Diferencias.getText();
            funcion=funcion.replaceAll(" ", "");  //quitar espacios
            try{
            inicial=Double.parseDouble(txt_valorinicial.getText());
        }    catch (NumberFormatException nfe){
        JOptionPane.showMessageDialog(null, "Ingrese un valor numerico", "Valor inicial", JOptionPane.WARNING_MESSAGE);}
        
       
            error=Double.parseDouble(cotaerror.getSelectedItem().toString());
            
       
            //decimales=Integer.parseInt(numdecimales.getSelectedItem().toString());
       
        if(funcion.length()!=0){
            
              Diferencias pf = new Diferencias();
              textarea_Diferencias.setText("");
            textarea_Diferencias.setText(pf.diferenciaRegresiva(inicial,error,funcion));
        }else{
            
           // System.out.print("hola");
            JOptionPane.showMessageDialog(null, "La función no ha sido creada", "Casilla vacia ", JOptionPane.WARNING_MESSAGE);}
        }
        
       

    }

    
    
    // public static void main(String[] args) {
       // Diferencias2 MN = new Diferencias2();


    // }

}