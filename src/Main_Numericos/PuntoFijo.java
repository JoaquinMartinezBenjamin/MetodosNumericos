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

public class PuntoFijo{
    String consola="";
    double error;
    double errorRelativo;
    double erp;
    public String puntofijo(String funcion,double x,double margen,int decimales) {

        EvaluarX EX=new EvaluarX();
        Redondeo R= new Redondeo();
        int cifras=decimales;

        //String funcion = "(e(x))/3";
        error= margen + 1;
        double resultado=0;

        consola+="X\t\tFuncion(x)\t\tError"; 
        consola+="\n";

        //while (erp>margen){ 
        while (error>margen){ 
            
            try{

            resultado= R.redondear((EX.evaluarFuncion(funcion,x)),cifras);
           //if(resultado==Infinity);
            error= Math.abs(resultado-x);
            error =R.redondear(error,cifras);
            consola+=""+x+"\t\t"+resultado+"\t\t"+error; 
            consola+="\n";
           // System.out.println(""+x+"\t\t"+resultado+"\t\t"+error+"\n");
            x=resultado;
             }    catch (Exception e){}

        }
        return consola;
    }

    // public static void main (String [] args){

        // PuntoFijo pf= new PuntoFijo();
        // pf.puntofijo("(e^x)-(10*(x^2))+2",1.0,0.0001,5);
    // }
}