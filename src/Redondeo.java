public class Redondeo {

public double redondear(double numero,int digitos)
{
      int cifras=(int) Math.pow(10,digitos);
      return Math.rint(numero*cifras)/cifras;
}

}