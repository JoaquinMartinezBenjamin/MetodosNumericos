public class Derivada{

    public double obtenerDerivada(String funcion, double x0,int decimales) {
        //String funcion = " x ^ 2";
        // double x0 = 1.0; 

        double h= 0.001;
        EvaluarX EX = new EvaluarX();

        double funcionx0mash= EX.evaluarFuncion(funcion,(x0+h));
        double funcionx0menosh= EX.evaluarFuncion(funcion,(x0-h));

        double centrada = (funcionx0mash-funcionx0menosh) /(2*h);
     
        Redondeo r = new Redondeo(); 
        return   r.redondear(centrada,decimales);    }
        
        
    // public static void main (String [] args) {
        // Derivada d = new Derivada (); 
        // System.out.println(d.obtenerDerivada("(e^x)-((10*x)^2)+ 2",0.0,4));

    // } 
}