import javax.swing.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz_Simpson extends JFrame implements ActionListener{
    JLabel lbl_segmentos;
    JTextField txt_segmentos;
    JPanel panel1;
    JTextField txt_Simpson;
    JButton btn_Simpson;
    JLabel lbl_Simpson;
    JTextArea textarea_Simpson;
    JScrollPane scrollpane_Simpson;
    JButton limpiar_Simpson;

    JTextField txt_errorSimpson;
    JLabel lbl_errorSimpson;
    JTextField txt_decimalesSimpson;
    JLabel lbl_decimalesSimpson;
    JTextField txt_valoraSimpson;
    JLabel lbl_valoraSimpson;
    JTextField txt_valorbSimpson;
    JLabel lbl_valorbSimpson;

    //___________________________
    String error[];
    JComboBox cotaerror;

    String decimales[];
    JComboBox numdecimales;
    //__________________________


    public Interfaz_Simpson(){
        lbl_Simpson=new JLabel("Ingrese la funcion ");
        lbl_Simpson.setBounds(20, 15, 200, 20);

        lbl_segmentos=new JLabel("No.Segmentos ");
        lbl_segmentos.setBounds(20, 50, 200, 20);
        
        txt_segmentos=new JTextField();
        txt_segmentos.setBounds(130, 50, 150, 20);
        
        
        txt_Simpson=new JTextField();
        txt_Simpson.setBounds(130, 60, 150, 20);
         txt_Simpson.setBounds(130, 15, 500, 20);

        lbl_valoraSimpson=new JLabel("Limite a ");
        lbl_valoraSimpson.setBounds(20, 100, 200, 20);

        txt_valoraSimpson=new JTextField();
        txt_valoraSimpson.setBounds(130, 100, 150, 20);

        lbl_valorbSimpson=new JLabel("Limite b ");
        lbl_valorbSimpson.setBounds(20, 120, 200, 20);

        txt_valorbSimpson=new JTextField();
        txt_valorbSimpson.setBounds(130, 120, 150, 20);

       

        
        lbl_decimalesSimpson=new JLabel("Decimales");
        lbl_decimalesSimpson.setBounds(20, 160, 200, 20);

        // txt_decimalesSimpson=new JTextField();
        // txt_decimalesSimpson.setBounds(130, 160, 150, 20);

        decimales= new String[] {  "1", "2","3", "4","5","6","7" };

        numdecimales= new JComboBox(decimales);
        numdecimales.setSelectedIndex(4);
        numdecimales.setBounds(130, 160, 150, 20);

        btn_Simpson=new JButton("Obtener integral");
        btn_Simpson.setBounds(20, 200, 200, 20);
        btn_Simpson.addActionListener(this);

        textarea_Simpson=new JTextArea();
        textarea_Simpson.setEditable(false);

        scrollpane_Simpson=new JScrollPane(textarea_Simpson);    
        scrollpane_Simpson.setBounds(300,50,500,300);

        limpiar_Simpson = new JButton("Limpiar texto");
        limpiar_Simpson.setBounds(20, 250, 200, 20);
        limpiar_Simpson.addActionListener(this);

        panel1=new JPanel();
        panel1.setLayout(null);


        panel1.add(scrollpane_Simpson);
        panel1.add(lbl_Simpson);
        panel1.add(txt_Simpson);

        panel1.add(lbl_valoraSimpson);
        panel1.add(txt_valoraSimpson);

        panel1.add(lbl_valorbSimpson);
        panel1.add(txt_valorbSimpson);

       

        panel1.add(lbl_decimalesSimpson);
        panel1.add(numdecimales);

        panel1.add(btn_Simpson);
        panel1.add(limpiar_Simpson);
         panel1.add(lbl_segmentos);
        panel1.add(txt_segmentos);

    }
    public JPanel interfaz() {
        return panel1;

    }

    public void actionPerformed(ActionEvent mn){

        if(mn.getSource()==btn_Simpson){
            String funcion;
            Double a=0.0;
            Double b=0.0;
            Double error=0.0;
            int decimales=0;
              Double n=0.0;
            funcion=txt_Simpson.getText();
            funcion=funcion.replaceAll(" ", "");  //quitar espacios

            try{
                a=Double.parseDouble(txt_valoraSimpson.getText());
            }    catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Ingrese un valor numerico", "Valor inicial", JOptionPane.WARNING_MESSAGE);}

            try{
                b=Double.parseDouble(txt_valorbSimpson.getText());
            }    catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Ingrese un valor numerico", "Valor inicial", JOptionPane.WARNING_MESSAGE);}

           
            //error=Double.parseDouble(cotaerror.getSelectedItem().toString());
            decimales=Integer.parseInt(numdecimales.getSelectedItem().toString());
            
                         try{
                n=Double.parseDouble(txt_segmentos.getText());
            }    catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Ingrese un valor numerico", "Valor inicial", JOptionPane.WARNING_MESSAGE);}
            
            if(funcion.length()!=0){
                Simpson f= new Simpson();
                textarea_Simpson.setText(f.metodoSimpson(a,b,n,funcion,decimales));
            }else{
                JOptionPane.showMessageDialog(null, "La función no ha sido creada", "Casilla vacia ", JOptionPane.WARNING_MESSAGE);}

        }
        
        if(mn.getSource()==limpiar_Simpson){
            textarea_Simpson.setText("");
        }


    }
  
}
