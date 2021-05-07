import javax.swing.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz_Secante extends JFrame implements ActionListener{

    //___________________________
    JPanel panel2;
    JTextField txt_Secante;
    JButton btn_Secante;
    JLabel lbl_Secante;
    JTextArea textarea_Secante;
    JScrollPane scrollpane_Secante;
    JButton limpiar_Secante;

    JTextField txt_errorSecante;
    JLabel lbl_errorSecante;
    JTextField txt_decimalesSecante;
    JLabel lbl_decimalesSecante;
    JTextField txt_valoraSecante;
    JLabel lbl_valoraSecante;
    JTextField txt_valorbSecante;
    JLabel lbl_valorbSecante;

    //___________________________
    String error[];
    JComboBox cotaerror;

    String decimales[];
    JComboBox numdecimales;
    //__________________________

    public Interfaz_Secante(){
        //______________________________________//
        lbl_Secante=new JLabel("Ingrese la funcion ");
        lbl_Secante.setBounds(20, 15, 200, 20);

        txt_Secante=new JTextField();
        txt_Secante.setBounds(130, 15, 500, 20);

        lbl_valoraSecante=new JLabel("Valor a ");
        lbl_valoraSecante.setBounds(20, 100, 200, 20);

        txt_valoraSecante=new JTextField();
        txt_valoraSecante.setBounds(130, 100, 150, 20);

        lbl_valorbSecante=new JLabel("Valor b ");
        lbl_valorbSecante.setBounds(20, 120, 200, 20);

        txt_valorbSecante=new JTextField();
        txt_valorbSecante.setBounds(130, 120, 150, 20);

        lbl_errorSecante=new JLabel("Error");
        lbl_errorSecante.setBounds(20, 140, 200, 20);

        error= new String[] { "0.1", "0.01", "0.001","0.0001", "0.00001" };
        cotaerror= new JComboBox(error);
        cotaerror.setSelectedIndex(2);
        cotaerror.setBounds(130, 140, 150, 20);

        // txt_errorSecante=new JTextField();
        // txt_errorSecante.setBounds(130, 140, 150, 20);

        lbl_decimalesSecante=new JLabel("Decimales");
        lbl_decimalesSecante.setBounds(20, 160, 200, 20);

        // txt_decimalesSecante=new JTextField();
        // txt_decimalesSecante.setBounds(130, 160, 150, 20);

        decimales= new String[] {  "1", "2","3", "4","5","6","7" };

        numdecimales= new JComboBox(decimales);
        numdecimales.setSelectedIndex(4);
        numdecimales.setBounds(130, 160, 150, 20);

        btn_Secante=new JButton("Obtener raiz");
        btn_Secante.setBounds(20, 200, 200, 20);
        btn_Secante.addActionListener(this);

        textarea_Secante=new JTextArea();
        textarea_Secante.setEditable(false);

        scrollpane_Secante=new JScrollPane(textarea_Secante);    
        scrollpane_Secante.setBounds(300,50,500,300);

        limpiar_Secante = new JButton("Limpiar texto");
        limpiar_Secante.setBounds(20, 250, 200, 20);
        limpiar_Secante.addActionListener(this);

        panel2=new JPanel();
        panel2.setLayout(null);

        panel2.add(scrollpane_Secante);
        panel2.add(lbl_Secante);
        panel2.add(txt_Secante);

        panel2.add(lbl_valoraSecante);
        panel2.add(txt_valoraSecante);
        panel2.add(lbl_valorbSecante);
        panel2.add(txt_valorbSecante);
        panel2.add(btn_Secante);
        panel2.add(limpiar_Secante);
        panel2.add(lbl_errorSecante);
        panel2.add(cotaerror);
        panel2.add(lbl_decimalesSecante);
        panel2.add(numdecimales);

        //_________________________________________//

    }

    public void actionPerformed(ActionEvent mn){

        if(mn.getSource()==btn_Secante){
            String funcion;
            Double a=0.0;
            Double b=0.0;
            Double error=0.0;
            int decimales=0;
            funcion=txt_Secante.getText();
            funcion=funcion.replaceAll(" ", "");  //quitar espacios

            try{
                a=Double.parseDouble(txt_valoraSecante.getText());
            }    catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Ingrese un valor numerico", "Valor inicial", JOptionPane.WARNING_MESSAGE);}

            try{
                b=Double.parseDouble(txt_valorbSecante.getText());
            }    catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Ingrese un valor numerico", "Valor inicial", JOptionPane.WARNING_MESSAGE);}

            error=Double.parseDouble(cotaerror.getSelectedItem().toString());
            decimales=Integer.parseInt(numdecimales.getSelectedItem().toString());

            if(funcion.length()!=0){
                Secante bi = new Secante();
                textarea_Secante.setText(bi.metodoSecante(a,b,funcion,error,decimales));
            }else{
                JOptionPane.showMessageDialog(null, "La función no ha sido creada", "Casilla vacia ", JOptionPane.WARNING_MESSAGE);}

        }
        
        if(mn.getSource()==limpiar_Secante){
            textarea_Secante.setText("");
        }

    }

    public JPanel interfazSecante() {
        return panel2;

    }

}
