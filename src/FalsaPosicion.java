public class FalsaPosicion {

    public String consola="";
    
    public String falsaPosicion(String funcion,double a, double b, double tolerancia, int decimales){
        consola+="METODO DE LA FALSA POSICION\n";
        consola+="\nx"+"\t"+"f(x)\t"+"error"+"\n";
        //_________________________
        //double a=0;
        //double b=1;
        //double tolerancia=0.0001;
        //int decimales=6;
       // String funcion= "10*e(-0.5*x)*cos(2*x)";
        //String funcion= "(5*(x^ 3))-(5*(x^2))+(6 * x)-2";
        //String funcion="(0.05*x)-(sen(x))";
       
        //_________________________
       
       
        Redondeo R= new Redondeo();
        EvaluarX EX=new EvaluarX();
        
        double funcionA,funcionB,funcionC=0;
        double error=tolerancia+1;
        double c=0; 
        double cAnterior=c;
        int contador=0;

       
       funcionA=R.redondear((EX.evaluarFuncion(funcion,a)),decimales);      
        funcionB=R.redondear((EX.evaluarFuncion(funcion,b)),decimales);
   
       
        
        if ((funcionA * funcionB)<0)
        {
            while(error>=tolerancia){ 
                
             consola+="________________________________________________";
              consola+="\n";
               
            
                cAnterior=c;
                
        funcionA=R.redondear((EX.evaluarFuncion(funcion,a)),decimales);      
        funcionB=R.redondear((EX.evaluarFuncion(funcion,b)),decimales);
        
                c=a - (((b-a)* funcionA)/(funcionB-funcionA)) ;
                c=R.redondear(c,decimales);
               
                funcionC= EX.evaluarFuncion(funcion,c);
                funcionC=R.redondear(funcionC,decimales);
                 
               // error= Math.abs((Math.abs(c)-Math.abs(cAnterior))/Math.abs(c)) * 100;  //eap
                error= Math.abs(Math.abs(c)-Math.abs(cAnterior));  //ea
                error=R.redondear(error,decimales);
            
                //if(error>=tolerancia){
                  
                
              consola+=c+"\t"+funcionC+"\t\t"+error;
              consola+="\n";
                //                         }
                 if(c==0) error=tolerancia-1;   //para detener el ciclo
                contador++;

                 
                if((funcionA*funcionC)<0){
                   
                    b=c;    
                }
                else { 
                    a=c; 
                 
                }


            }
           
        } else{consola+= " f(a) * f(b) es mayor que 0 \n Introduzca nuevos valores de a y b";}
        
        
         return consola;
    }


}



