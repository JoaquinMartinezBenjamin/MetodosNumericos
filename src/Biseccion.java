public class Biseccion  {

public String consola="";

public Biseccion(){

}
    
public String biseccion(String funcion, double a, double b, double tolerancia, int decimales){
        //double a=0.5;
        //double b=2.0;
        //double tolerancia=0.001;
       // int decimales=7;
        //String funcion= "e(-x)-ln(x)";
        //_________________________
        consola+="METODO DE LA BISECCION";
        consola+="\n";
        Redondeo R= new Redondeo();
        EvaluarX EX=new EvaluarX();

        double funcionA,funcionB,funcionC=0;
        double error=tolerancia+1;
        double c=0; 
        double cAnterior=c;
        int contador=0;

        funcionA=EX.evaluarFuncion(funcion,a);      
        funcionB=EX.evaluarFuncion(funcion,b);
        
        consola+=a+"\n"; 
  consola+=b+"\n";

  consola+=funcionA+"\n"; 
  consola+=funcionB+"\n";
        if ((funcionA * funcionB)<0)
        {
            while(error>=tolerancia){ 

               consola+= "________________________________________________";
               consola+="\n"; 
               cAnterior=c;
                c=(a+b)/2;
                c=R.redondear(c,decimales);

                funcionC= EX.evaluarFuncion(funcion,c);
                funcionC=R.redondear(funcionC,decimales);

                error= Math.abs((Math.abs(c)-Math.abs(cAnterior))/Math.abs(c)) * 100;
                error=R.redondear(error,decimales);
                if(error>=tolerancia)
                  consola+=  contador+"\t"+c+"\t"+funcionC+"\t\t"+error;
                
                  consola+="\n";
                  contador++;

                funcionA= EX.evaluarFuncion(funcion,a);
                funcionA=R.redondear(funcionA,decimales);

                if((funcionA*funcionC)<0){
                    b=c;    
                }
                else { 
                    a=c; 
                }

            }
        }else{consola+= " f(a) * f(b) es mayor que 0 \n Introduzca nuevos valores de a y b";}

return consola;

}    
    // public static void main (String [] args){
        // Biseccion b = new Biseccion("e(-x)-ln(x)");
        // b.biseccion();
  // }

}