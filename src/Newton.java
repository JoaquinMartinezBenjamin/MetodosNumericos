public class Newton {
public String consola="";
    public String metodoNewton(double x, String funcion, double tolerancia, int decimales){   
        double h;
        double z;
        //double x = 0.0;
        int contador=0;
        //double tolerancia=0.001;
        double error=tolerancia+1;

        double fx;
        double fprimax;

        Redondeo R= new Redondeo();
        EvaluarX EX= new EvaluarX();
        Derivada D = new Derivada();

        consola+="x"+"\t"+"f(x)"+"\t"+"f´(x)"+"\t"+"h"+"\t"+"error";
         consola+="\n";
        //System.out.println("x"+"\t"+"f(x)"+"\t"+"f´(x)"+"\t"+"h"+"\t"+"error");

        fx=R.redondear(EX.evaluarFuncion(funcion,x),decimales);
        fprimax=R.redondear(D.obtenerDerivada(funcion,x,decimales),decimales);
        h= R.redondear((fx/fprimax),decimales);
        z=x;
        x= R.redondear(x-h,decimales);
        //System.out.println(z+"\t"+fx+"\t"+fprimax+"\t"+h+"\t---");
        consola+=z+"\t"+fx+"\t"+fprimax+"\t"+h+"\t---";
        consola+="\n";

        while(error>tolerancia){
            error=R.redondear(Math.abs(Math.abs(x)-Math.abs(z)),decimales);
            fx=R.redondear(EX.evaluarFuncion(funcion,x),decimales);
            fprimax=R.redondear(D.obtenerDerivada(funcion,x,decimales),decimales);
            h= R.redondear((fx/fprimax),decimales);
            z=x;
            x= R.redondear(x-h,decimales);
            //System.out.println(z+"\t"+fx+"\t"+fprimax+"\t"+h+"\t"+error);
consola+=z+"\t"+fx+"\t"+fprimax+"\t"+h+"\t"+error;
consola+="\n";
        }
    return consola;
    }

    // public static void main (String [] args) {
        // Newton n = new Newton();
        // n.metodoNewton(0.0,"(e^x)-(10*(x^2))+2",0.001,5);
    // }

}