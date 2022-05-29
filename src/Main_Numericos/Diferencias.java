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
public class Diferencias { 

public String diferenciaProgresiva (double x, double h, String f)  {
//double x = 1.0; 
//double h= 0.01;
EvaluarX EX = new EvaluarX();

//double funcion= Math.pow(((( 3 * x ) - 1)/( Math.pow(x,2) + 3)),2);
double funcion=EX.evaluarFuncion(f,x);

//System.out.println("funcion x " + funcion);

double x1= x + h;
//double funcionx1= Math.pow(((( 3 * x1 ) - 1)/( Math.pow(x1,2) + 3)),2);
double funcionx1=EX.evaluarFuncion(f,x1);
//System.out.println("funcion x + h " + funcionx1);
//double progresiva 
double progresiva =( funcionx1 - funcion )/h;
//double real= (-18 + (50 * x) + (18 * Math.pow(x,2)) - (18 * Math.pow(x,3))) / (Math.pow(((x*x)+3),3)); 
//System.out.println("real  " + real);
//System.out.println("progresiva " + progresiva);

return "progresiva " + progresiva;
} 



public String diferenciaRegresiva (double x, double h, String f) {
 EvaluarX EX = new EvaluarX();

double x1= x - h ; 
double funcion=EX.evaluarFuncion(f,x);
double funcionx1= EX.evaluarFuncion(f,x1);//Math.pow(((( 3 * x1 ) - 1)/( Math.pow(x1,2) + 3)),2);
double regresiva = (funcion - funcionx1) /h;
//System.out.println("funcion x - h " + funcionx1);

return "regresiva " + regresiva;
} 

public String diferenciaCentrada (double x, double h , String f )  {

EvaluarX EX = new EvaluarX();
double x0= x+h;
double x1= x - h ; 
double funcionx0= EX.evaluarFuncion(f,x0);//Math.pow(((( 3 * (x+h) ) - 1)/( Math.pow((x+h),2) + 3)),2);
double funcionx1= EX.evaluarFuncion(f,x1);


double centrada = (funcionx0-funcionx1);
//System.out.println("fx+h - fx-h "+centrada);
centrada=centrada/(2*h);

return "centrada " + centrada;


}



// public static void main (String [] args) {




// double funcion= Math.pow(((( 3 * x ) - 1)/( Math.pow(x,2) + 3)),2);

// System.out.println("funcion x " + funcion);

// double x1= x + h;
// double funcionx1= Math.pow(((( 3 * x1 ) - 1)/( Math.pow(x1,2) + 3)),2);
// System.out.println("funcion x + h " + funcionx1);
// //double progresiva 
// double progresiva =( funcionx1 - funcion )/h;
// double real= (-18 + (50 * x) + (18 * Math.pow(x,2)) - (18 * Math.pow(x,3))) / (Math.pow(((x*x)+3),3)); 
// System.out.println("real  " + real);
// System.out.println("progresiva " + progresiva);


// //double regresiva
// x1= x - h ; 
// funcionx1= Math.pow(((( 3 * x1 ) - 1)/( Math.pow(x1,2) + 3)),2);
// double regresiva = (funcion - funcionx1) /h;
// System.out.println("funcion x - h " + funcionx1);

// System.out.println("regresiva " + regresiva);


// double funcionx0= Math.pow(((( 3 * (x+h) ) - 1)/( Math.pow((x+h),2) + 3)),2);


// double centrada = (funcionx0-funcionx1);
// System.out.println("fx+h - fx-h "+centrada);
// centrada=centrada/(2*h);

// System.out.println("centrada " + centrada);


// System.out.println("Error");
// //sacar el valor absoluto 
// System.out.println("Progresivas: "+ (progresiva - real));
// System.out.println("Regresivas: "+ (regresiva - real));
// System.out.println("Centradas: "+ (centrada - real));

// }


// public static void main (String [] args)  {
// String funcion="(((3*x)-1)/((x^2)+3))^2";
// Diferencias    D = new Diferencias () ; 
 // D.diferenciaProgresiva(1,0.1,funcion) ; 
 // D.diferenciaRegresiva(1,0.1,funcion) ; 
 // D.diferenciaCentrada(1,0.1,funcion) ;
// } 

}
