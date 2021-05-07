import javax.swing.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.util.InputMismatchException;

public class Interfaz_PuntoFijo extends JFrame implements ActionListener{
  

    //__________________________
    JPanel panel3;
    JTextField txt_puntofijo;
    JButton btn_puntofijo;
    JLabel lbl_puntofijo;
    JTextArea textarea_puntofijo;
    JScrollPane scrollpane_puntofijo;
    JButton limpiar_puntofijo;
    
     JTextField txt_valorinicial;
     JLabel lbl_valorinicial;
     JTextField txt_errorpuntofijo;
     JLabel lbl_errorpuntofijo;
     JTextField txt_decimalespuntofijo;
     JLabel lbl_decimalespuntofijo;
String error[];
JComboBox cotaerror;

String decimales[];
JComboBox numdecimales;

    public  Interfaz_PuntoFijo(){
        //setDefaultCloseOperation(EXIT_ON_CLOSE );
       // setBounds(0, 0, 850, 500);
       //setVisible(true);
       
        
       
        //_________________________________________//
        
        lbl_puntofijo=new JLabel("Ingrese la funcion ");
        lbl_puntofijo.setBounds(20, 15, 200, 20);
       
        txt_puntofijo=new JTextField();
        txt_puntofijo.setBounds(130, 15, 500, 20);
        
        
        lbl_valorinicial=new JLabel("Valor inicial ");
        lbl_valorinicial.setBounds(20, 100, 200, 20);
       
        txt_valorinicial=new JTextField();
        txt_valorinicial.setBounds(130, 100, 150, 20);
        
        
        lbl_errorpuntofijo=new JLabel("Error");
        lbl_errorpuntofijo.setBounds(20, 140, 200, 20);
       
        // txt_errorpuntofijo=new JTextField();
        // txt_errorpuntofijo.setBounds(130, 140, 150, 20);
         error= new String[] { "0.1", "0.01", "0.001","0.0001", "0.00001" };
        
        cotaerror= new JComboBox(error);
        cotaerror.setSelectedIndex(2);
        cotaerror.setBounds(130, 140, 150, 20);
        
        
         lbl_decimalespuntofijo=new JLabel("Decimales");
        lbl_decimalespuntofijo.setBounds(20, 160, 200, 20);
       
        decimales= new String[] {  "1", "2","3", "4","5","6","7" };
        
        numdecimales= new JComboBox(decimales);
        numdecimales.setSelectedIndex(4);
        numdecimales.setBounds(130, 160, 150, 20);
        
        
        // txt_decimalespuntofijo=new JTextField();
        // txt_decimalespuntofijo.setBounds(130, 160, 150, 20);
        
      
        btn_puntofijo=new JButton("Obtener raiz");
        btn_puntofijo.setBounds(20, 200, 200, 20);
        btn_puntofijo.addActionListener(this);
        
        textarea_puntofijo=new JTextArea();
        textarea_puntofijo.setEditable(false);
  
        scrollpane_puntofijo=new JScrollPane(textarea_puntofijo);    
        scrollpane_puntofijo.setBounds(300,50,500,300);
        
        limpiar_puntofijo = new JButton("Limpiar texto");
        limpiar_puntofijo.setBounds(20, 250, 200, 20);
        limpiar_puntofijo.addActionListener(this);
        
         panel3=new JPanel();
               panel3.setLayout(null);
               
        panel3.add(scrollpane_puntofijo);
        panel3.add(lbl_puntofijo);
        panel3.add(txt_puntofijo);
        panel3.add(lbl_errorpuntofijo);
        panel3.add(cotaerror);
        panel3.add(lbl_decimalespuntofijo);
        panel3.add(numdecimales);
        panel3.add(lbl_valorinicial);
        panel3.add(txt_valorinicial);
        panel3.add(btn_puntofijo);
        panel3.add(limpiar_puntofijo);
        //________________________________________________
        
    }

    
    
   public JPanel interfazpuntofijo() {
    return panel3;
    
    }
    
    public void actionPerformed(ActionEvent mn){
      

        if(mn.getSource()==btn_puntofijo){
            String funcion;
            Double inicial=0.0;
            Double error=0.0;
            int decimales=0;
            
            funcion=txt_puntofijo.getText();
            funcion=funcion.replaceAll(" ", "");  //quitar espacios
            try{
            inicial=Double.parseDouble(txt_valorinicial.getText());
        }    catch (NumberFormatException nfe){
        JOptionPane.showMessageDialog(null, "Ingrese un valor numerico", "Valor inicial", JOptionPane.WARNING_MESSAGE);}
        
       
            error=Double.parseDouble(cotaerror.getSelectedItem().toString());
            
       
            decimales=Integer.parseInt(numdecimales.getSelectedItem().toString());
       
        if(funcion.length()!=0){
            
              PuntoFijo pf = new PuntoFijo();
            textarea_puntofijo.setText(pf.puntofijo(funcion,inicial,error,decimales));
        }else{
            
           // System.out.print("hola");
            JOptionPane.showMessageDialog(null, "La función no ha sido creada", "Casilla vacia ", JOptionPane.WARNING_MESSAGE);}
            
          
        }
        
        
         if(mn.getSource()==limpiar_puntofijo){
             textarea_puntofijo.setText("");
        }
        
       

    }

    
    
    // public static void main(String[] args) {
       // Puntofijo2 MN = new Puntofijo2();


    // }

}