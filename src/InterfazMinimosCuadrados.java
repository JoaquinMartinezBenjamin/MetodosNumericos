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

public class InterfazMinimosCuadrados extends JFrame implements ActionListener{

    JTextField txt_tam;

    JTextField txt_decimales;
    JLabel lbl_decimales;

    String error[];
    JComboBox cotaerror;

    String decimales[];
    JComboBox numdecimales;

    JComboBox tams;
    JTextField celdas[][];

    JPanel panelNumeros, panelOperaciones,panelEncabezado,panelIniciales,contenido;
    JPanel panel;
 
    int tam;

    JButton btn_raiz;
    JButton btn_tam;
    JTextArea textarea_MinimosCuadrados;
    JScrollPane scrollpane_MinimosCuadrados;
    JScrollPane scrollpane;

    public InterfazMinimosCuadrados() {
        contenido =new JPanel(); 
        contenido.setLayout(null);
        contenido.setBounds(0, 0, 850, 500);

        lbl_decimales=new JLabel("Decimales");
        lbl_decimales.setBounds(20, 160, 200, 20);
        contenido.add(lbl_decimales);
        decimales= new String[] {  "1", "2","3", "4","5","6","7" };

        numdecimales= new JComboBox(decimales);
        numdecimales.setSelectedIndex(4);
        numdecimales.setBounds(130, 160, 150, 20);
        contenido.add(numdecimales);

        textarea_MinimosCuadrados=new JTextArea();
        textarea_MinimosCuadrados.setEditable(false);

        scrollpane_MinimosCuadrados=new JScrollPane(textarea_MinimosCuadrados);    
        scrollpane_MinimosCuadrados.setBounds(300,250,400,130);
        contenido.add(scrollpane_MinimosCuadrados);

        JLabel ancho = new JLabel("Numero de datos");
        ancho.setBounds(20, 50, 200, 20);
        contenido.add(ancho);

        btn_raiz=new JButton("obtener recta");
        btn_raiz.setBounds(20, 200, 200, 20);
        contenido.add(btn_raiz);
        btn_raiz.addActionListener(this);

        // tam= new String[] { "2 x 2", "3 x 3", "4 x 4" };
        // tams= new JComboBox(tam);
        // tams.setSelectedIndex(0);
        // tams.setBounds(130, 150, 150, 20);
        // contenido.add(tams);
        // tams.addActionListener(this);

        tam=5;

        btn_tam=new JButton("Guardar");
        btn_tam.setBounds(150, 80, 100, 20);
        btn_tam.addActionListener(this);
        contenido.add(btn_tam);

        txt_tam=new JTextField();
        txt_tam.setBounds(150, 50, 100, 20);
        contenido.add(txt_tam);

        celdas = new JTextField[tam][2];
        panel =new JPanel(); 
        panel.setLayout(new BorderLayout());
        //panel.setBounds(300, 50, 400, 200);

        panelEncabezado = new JPanel();
        panelEncabezado.setLayout(new GridLayout(1,tam+1));
        String variable="X";

        //for(int k = 0; k<tam; k++){
        panelEncabezado.add(new JLabel("x"));
        panelEncabezado.add(new JLabel("y"));

        //}

        panel.add("North", panelEncabezado);

        //________________________________________________________________

        //________________________________________________________________________________

        panelNumeros = new JPanel();
        panelNumeros.setLayout(new GridLayout(tam,tam+1));
        panelNumeros.setBorder(new EmptyBorder(8, 8, 8, 8));

        for(int i =0; i<tam; i++){
            for(int j = 0; j<2; j++){
                celdas[i][j]=new JTextField();
                celdas[i][j].setText(""+i+","+j);

            }
        }

        // for(int i =0; i<tam; i++){

            // for(int j = 0; j<2; j++){

                // panelNumeros.add(celdas[i][j]);
            // }

        // }

        panel.add("Center", panelNumeros);
        scrollpane =new JScrollPane(panel);
        scrollpane.setBounds(300, 50, 400, 200);
        //contenido.add(panel);
        contenido.add(scrollpane);

    }

    public void actionPerformed(ActionEvent mn){
        if(mn.getSource()== btn_raiz){
            
            
             double matriz[][] = new double [tam][2];
             String aux="";
            for(int i=0; i<tam; i++){
                for (int j=0; j<2; j++){
                    aux=celdas[i][j].getText();
                    aux.replaceAll(" ", "");
                    try{
                        matriz[i][j] =Double.parseDouble(aux);
                    }    catch (NumberFormatException nfe){
                        //JOptionPane.showMessageDialog(null, "Ingrese un valor numerico", "celda "+i+" "+j, JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            
            
              int decimals=Integer.parseInt(numdecimales.getSelectedItem().toString());
            
            MinimosCuadrados mc = new MinimosCuadrados();
            //mc.metodoMinimosCuadrados(matriz,decimals);
             textarea_MinimosCuadrados.setText("");
                 textarea_MinimosCuadrados.setText( mc.metodoMinimosCuadrados(matriz,decimals));

        }
        if(mn.getSource()== btn_tam){
             panelNumeros.removeAll();
            panelEncabezado.removeAll();
            
         
            
            String aux=txt_tam.getText(); aux.replaceAll(" ", "");
                try{tam=Integer.parseInt(aux);}catch (NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null, "Ingrese un valor numerico", "tam", JOptionPane.WARNING_MESSAGE);}
            
                    
                      celdas = new JTextField[tam][2];
            
        panelEncabezado.add(new JLabel("x"));
        panelEncabezado.add(new JLabel("y"));
                    
                    
            
        
        
        panelNumeros.setLayout(new GridLayout(tam,tam+1));
        panelNumeros.setBorder(new EmptyBorder(8, 8, 8, 8));

        for(int i =0; i<tam; i++){
            for(int j = 0; j<2; j++){
                celdas[i][j]=new JTextField();
                celdas[i][j].setText("");

            }
        }

        for(int i =0; i<tam; i++){

            for(int j = 0; j<2; j++){

                panelNumeros.add(celdas[i][j]);
            }

        }
        
        
        
             panelNumeros.setVisible(false);
            panelEncabezado.setVisible(false);
        

            panelNumeros.setVisible(true);
            panelEncabezado.setVisible(true);
       
        }
    }

    public JPanel interfazMinimosCuadrados() {
        return contenido;

    }

}