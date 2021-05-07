import javax.swing.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz_falsaposicion extends JFrame implements ActionListener{
    
    JPanel panel1;
    JTextField txt_falsaposicion;
    JButton btn_falsaPosicion;
    JLabel lbl_falsaposicion;
    JTextArea textarea_falsaposicion;
    JScrollPane scrollpane_falsaposicion;
    JButton limpiar_falsaposicion;

    JTextField txt_errorfalsaposicion;
    JLabel lbl_errorfalsaposicion;
    JTextField txt_decimalesfalsaposicion;
    JLabel lbl_decimalesfalsaposicion;
    JTextField txt_valorafalsaposicion;
    JLabel lbl_valorafalsaposicion;
    JTextField txt_valorbfalsaposicion;
    JLabel lbl_valorbfalsaposicion;

    //___________________________
    String error[];
    JComboBox cotaerror;

    String decimales[];
    JComboBox numdecimales;
    //__________________________


    public Interfaz_falsaposicion(){
        lbl_falsaposicion=new JLabel("Ingrese la funcion ");
        lbl_falsaposicion.setBounds(20, 15, 200, 20);

        txt_falsaposicion=new JTextField();
        txt_falsaposicion.setBounds(130, 60, 150, 20);
         txt_falsaposicion.setBounds(130, 15, 500, 20);

        lbl_valorafalsaposicion=new JLabel("Valor a ");
        lbl_valorafalsaposicion.setBounds(20, 100, 200, 20);

        txt_valorafalsaposicion=new JTextField();
        txt_valorafalsaposicion.setBounds(130, 100, 150, 20);

        lbl_valorbfalsaposicion=new JLabel("Valor b ");
        lbl_valorbfalsaposicion.setBounds(20, 120, 200, 20);

        txt_valorbfalsaposicion=new JTextField();
        txt_valorbfalsaposicion.setBounds(130, 120, 150, 20);

        lbl_errorfalsaposicion=new JLabel("Error");
        lbl_errorfalsaposicion.setBounds(20, 140, 200, 20);

        // txt_errorfalsaposicion=new JTextField();
        // txt_errorfalsaposicion.setBounds(130, 140, 150, 20);

        error= new String[] { "0.1", "0.01", "0.001","0.0001", "0.00001" };
        cotaerror= new JComboBox(error);
        cotaerror.setSelectedIndex(2);
        cotaerror.setBounds(130, 140, 150, 20);

        
        lbl_decimalesfalsaposicion=new JLabel("Decimales");
        lbl_decimalesfalsaposicion.setBounds(20, 160, 200, 20);

        // txt_decimalesfalsaposicion=new JTextField();
        // txt_decimalesfalsaposicion.setBounds(130, 160, 150, 20);

        decimales= new String[] {  "1", "2","3", "4","5","6","7" };

        numdecimales= new JComboBox(decimales);
        numdecimales.setSelectedIndex(4);
        numdecimales.setBounds(130, 160, 150, 20);

        btn_falsaPosicion=new JButton("Obtener raiz");
        btn_falsaPosicion.setBounds(20, 200, 200, 20);
        btn_falsaPosicion.addActionListener(this);

        textarea_falsaposicion=new JTextArea();
        textarea_falsaposicion.setEditable(false);

        scrollpane_falsaposicion=new JScrollPane(textarea_falsaposicion);    
        scrollpane_falsaposicion.setBounds(300,50,500,300);

        limpiar_falsaposicion = new JButton("Limpiar texto");
        limpiar_falsaposicion.setBounds(20, 250, 200, 20);
        limpiar_falsaposicion.addActionListener(this);

        panel1=new JPanel();
        panel1.setLayout(null);


        panel1.add(scrollpane_falsaposicion);
        panel1.add(lbl_falsaposicion);
        panel1.add(txt_falsaposicion);

        panel1.add(lbl_valorafalsaposicion);
        panel1.add(txt_valorafalsaposicion);

        panel1.add(lbl_valorbfalsaposicion);
        panel1.add(txt_valorbfalsaposicion);

        panel1.add(lbl_errorfalsaposicion);
        panel1.add(cotaerror);

        panel1.add(lbl_decimalesfalsaposicion);
        panel1.add(numdecimales);

        panel1.add(btn_falsaPosicion);
        panel1.add(limpiar_falsaposicion);

    }
    public JPanel interfaz() {
        return panel1;

    }

    public void actionPerformed(ActionEvent mn){

        if(mn.getSource()==btn_falsaPosicion){
            String funcion;
            Double a=0.0;
            Double b=0.0;
            Double error=0.0;
            int decimales=0;

            funcion=txt_falsaposicion.getText();
            funcion=funcion.replaceAll(" ", "");  //quitar espacios

            try{
                a=Double.parseDouble(txt_valorafalsaposicion.getText());
            }    catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Ingrese un valor numerico", "Valor inicial", JOptionPane.WARNING_MESSAGE);}

            try{
                b=Double.parseDouble(txt_valorbfalsaposicion.getText());
            }    catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Ingrese un valor numerico", "Valor inicial", JOptionPane.WARNING_MESSAGE);}

           
            error=Double.parseDouble(cotaerror.getSelectedItem().toString());
            decimales=Integer.parseInt(numdecimales.getSelectedItem().toString());
            if(funcion.length()!=0){
                FalsaPosicion f= new FalsaPosicion();
                textarea_falsaposicion.setText(f.falsaPosicion(funcion,a,b,error,decimales));
            }else{
                JOptionPane.showMessageDialog(null, "La función no ha sido creada", "Casilla vacia ", JOptionPane.WARNING_MESSAGE);}

        }
        
        if(mn.getSource()==limpiar_falsaposicion){
            textarea_falsaposicion.setText("");
        }


    }
  
}
