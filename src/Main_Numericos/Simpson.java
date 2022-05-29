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
public class Simpson {
String consola="";


public String metodoSimpson(double a, double b, double n,String funcion,int decimales)  {
if(n%2==0){
    Redondeo R= new Redondeo();
double h = R.redondear((b-a)/n,decimales);
//System.out.println("h:"+h);
consola+="h:"+h+"\n";
double x= 0;
double aux= 0.0;
double sumatoria=0;
EvaluarX EX = new EvaluarX();

aux=R.redondear(EX.evaluarFuncion(funcion,a),decimales);

sumatoria+=aux;
consola+="("+aux+")"+"+\n";
//System.out.print("("+aux+")"+"+\n");
x=a+h;

int contador=2;
while (x<b){
  if(contador%2==0){  
aux=R.redondear(4*(EX.evaluarFuncion(funcion,x)),decimales);
}else{aux=R.redondear(2*(EX.evaluarFuncion(funcion,x)),decimales);}
sumatoria+=aux;
consola+="("+aux+")"+"+\n";
//System.out.print("("+aux+")"+"+\n");
x+=h;
contador++;
}
aux=R.redondear(EX.evaluarFuncion(funcion,b),decimales);

sumatoria+=aux;
consola+="("+aux+")"+"\n";
//System.out.print("("+aux+")"+"\n");


double resultado= R.redondear((h/3)*sumatoria,decimales);
//System.out.println("="+resultado);
consola+="="+resultado;
 }else{consola+="n tiene que ser par";}
 
 return consola;
} 
 


// public static void main(String [] args) {


// Simpson t= new Simpson() ; 
// String funcion= "1/x";
 // t.metodoSimpson(1.0, 4.0,6,funcion,4 );

// }


}