public class Secante {

    public String consola="";
    
    
   // metodoSecante(inicial,funcion,error,decimales))
    public String metodoSecante(double x0, double x00,String funcion, double tolerancia,int decimales){

        double f0;
        double f00;
        double z=0;

       // double x0=0;
       // double x00 = 0;
        int contador=0;
        //double tolerancia=0.001;
        double error=tolerancia+1;

       // x00=0.1;
        //x0=0.2;
        Redondeo R= new Redondeo();
        EvaluarX ex= new EvaluarX();
      
       // System.out.println("Xn\tXn-1\tf(xn)\tf(xn+1)\tError");
        consola+="Xn\tXn-1\tf(xn)\tf(xn+1)\tError";
        consola+="\n";
       // System.out.println("__________________________________");
        consola+="__________________________________";
        consola+="\n";
        //System.out.print(x0+"\t"+x00);
        consola+=x0+"\t"+x00;
        f0= R.redondear(ex.evaluarFuncion(funcion,x0),decimales);
        f00= R.redondear(ex.evaluarFuncion(funcion,x00),decimales);
        //System.out.print("\t"+f0+"\t"+f00+"\t---\n");
        consola+="\t"+f0+"\t"+f00+"\t---\n";
        
       
        
        //System.out.println("__________________________________");

        
         consola+="\n";
        
        while (error>tolerancia){
            
        z=x0;
        x0=R.redondear((x0 - ( f0/  ((f0 - f00)/ (x0 - x00)))),decimales);
        x00=z;
        
            f0= R.redondear(ex.evaluarFuncion(funcion,x0),decimales);
            f00= R.redondear(ex.evaluarFuncion(funcion,x00),decimales);

            error=R.redondear(( Math.abs(Math.abs(x0)-Math.abs(x00))),decimales);
       consola+=x0+"\t"+x00+"\t"+f0+"\t"+f00+"\t"+error;
            //System.out.println(x0+"\t"+x00+"\t"+f0+"\t"+f00+"\t"+error);
       
           // System.out.println("__________________________________");
             consola+="\n";
        }
return consola;
    
    }
    
    // public static void main (String [] args) {

        // Secante s= new Secante();
        // s.metodoSecante(0.1,0.2,"4^(2*x)-8*(4^x)+12",0.001,5);
    // }

}