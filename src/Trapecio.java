public class Trapecio {

String consola="";

public String metodoTrapecio(double a, double b, double n,String funcion,int decimales)  {
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
//System.out.print("("+aux+")"+"+\n");
consola+="("+aux+")"+"+\n";
x=a+h;


while (x<b){
    
aux=R.redondear(2*(EX.evaluarFuncion(funcion,x)),decimales);
sumatoria+=aux;

//System.out.print("("+aux+")"+"+\n");
consola+="("+aux+")"+"+\n";
x+=h;
}
aux=R.redondear(EX.evaluarFuncion(funcion,b),decimales);

sumatoria+=aux;
//System.out.print("("+aux+")"+"\n");
consola+="("+aux+")"+"\n";


double resultado= R.redondear((h/2)*sumatoria,decimales);
//System.out.println("="+resultado);
consola+="="+resultado;
 return consola;
} 
 


// public static void main(String [] args) {


// Trapecio t = new Trapecio () ; 
// String funcion= "1/x";
 // t.metodoTrapecio(1.0, 4.0,6,funcion,5 );

// }


}