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
import javax.swing.JOptionPane;


public class EvaluarX{
    
    public double evaluarFuncion(String funcion,double x){
    // String sustitucionx= funcion.replaceAll("x",String.valueOf(x));
       // sustitucionx= sustitucionx.replaceAll("E","*10^");
          // sustitucionx= sustitucionx.replaceAll("e^","e");
       String sustitucion="";
       sustitucion=funcion.replace("e^","e");
         sustitucion=sustitucion.replaceAll("x",String.valueOf(x));
          sustitucion=sustitucion.replaceAll("E","*10^");
          //sustitucion=sustitucion.replaceAll("E","^");
          // funcion.replaceAll("e^","e");
       
    //System.out.println(sustitucion);
    EvaluadorFunciones EF= new EvaluadorFunciones();
    double resultado=0.0;
    try{
    resultado=EF.eval(sustitucion);
}catch(Exception excepcion)
		        
		         {
			          //JOptionPane.showMessageDialog(null, "error de sintaxis", " ", JOptionPane.WARNING_MESSAGE);
		         }
    
    return resultado;
             }
             
             
             
    public String sustitucionx1(String funcion,double x){
    String sustitucionx= funcion.replaceAll("x1",String.valueOf(x));
    return sustitucionx;
             }
             
             public String sustitucionx2(String funcion,double x){
    String sustitucionx= funcion.replaceAll("x2",String.valueOf(x));
    return sustitucionx;
             }
             
              public String sustitucionx3(String funcion,double x){
    String sustitucionx= funcion.replaceAll("x3",String.valueOf(x));
    return sustitucionx;
             }
             
     public double evaluarFuncionxxx(String funcion,double x1,double x2,double x3){
    String sustitucionx= funcion;
    sustitucionx= sustitucionx1(sustitucionx, x1);
    //System.out.println(sustitucionx);
    sustitucionx= sustitucionx2(sustitucionx, x2);
    //System.out.println(sustitucionx);
    sustitucionx= sustitucionx3(sustitucionx, x3);
    //System.out.println(sustitucionx);
 
    
    EvaluadorFunciones EF= new EvaluadorFunciones();
    return EF.eval(sustitucionx);
    
    
             }
    
}