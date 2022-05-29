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
public class MinimosCuadrados {



public String metodoMinimosCuadrados (double [][] arreglo,int decimales ) {
    
    Redondeo R = new Redondeo();
String consola="";

double sumatoriax=0.0;
double sumatoriay=0.0;
double sumatoriaxy=0.0;
double sumatoriax2=0.0;

double m=0.0;
double b=0.0;
double n=arreglo.length;

for(int i=0; i<arreglo.length; i++){
    for(int j=0; j<2; j++){
  consola+=arreglo[i][j]+"\t";
    }
    consola+="\n";
}
consola+="\n";


for(int i=0; i<arreglo.length; i++){
    sumatoriax+= arreglo[i][0];
    sumatoriay+= arreglo[i][1];
    sumatoriaxy+= arreglo[i][0] * arreglo[i][1];
    sumatoriax2+= Math.pow(arreglo[i][0],2);
}

consola+="Sumatoria x: "+sumatoriax+"\n";
consola+="Sumatoria y: "+sumatoriay+"\n";
consola+="Sumatoria x * y: "+sumatoriaxy+"\n";
consola+="Sumatoria x^2: "+sumatoriax2+"\n";


m = ((n * sumatoriaxy) - (sumatoriax * sumatoriay)) / ((n * sumatoriax2) - Math.pow((Math.abs(sumatoriax)),2) );
b = ((sumatoriay * sumatoriax2) - (sumatoriax * sumatoriaxy)) / ((n * sumatoriax2) - Math.pow((Math.abs(sumatoriax)),2) );

m=R.redondear(m,decimales);
b=R.redondear(b,decimales);
consola+="m= "+m+"\n";
consola+="b= "+b+"\n";

consola+="y= "+m+"x"+"+"+b;
return consola;
}
}