
import java.lang.Math;
public class MetodosNumericos {
    


    public static void metodoBiseccion(double a, double b, double e){
        //Este metodo calcula la aproximacion de la raiz utilizando
        //el metodo de biseccion
        //no tiene en cuenta si la derivada de la funcion da 0
        double r;
        // f(x)= 2sen(x+1)
        if((2*Math.sin(1+a))*(2*Math.sin(1+b)) < 0){
            do {
                r= (a+b)/2; 
                System.out.println(r);
                if((2*Math.sin(1+a))*(2*Math.sin(1+r)) < 0){
                    b=r;
                }else{
                    a=r;
                }
            } while (Math.abs(2*Math.sin(1+r))> e);
            System.out.println("Raiz aproximada: "+ r);
        }else{
            System.out.println("No se cumple la condicion inicial f(a)f(b) < 0");
        }


        
    }

    public static void newtonRaphson(double a, double e){
        //Este metodo calcula la aproximacion de la raiz utilizando
        //el metodo de Newton-Raphson
        //no tiene en cuenta si la derivada de la funcion da 0
        
        while(Math.abs(2*Math.sin(1+a))> e){
            System.out.println("x0 = "+ a);
            System.out.println("f(x0) = "+ 2*Math.sin(1+a) );
            System.out.println("f'(x0) = "+ 2*Math.cos(1+a)*1+a );
            a= a-((2*Math.sin(1+a))/ (2*Math.cos(1+a)*(1+a)));
            System.out.println("x1 = "+ a);
        }
        System.out.println("Raiz aproximada: " + a);
    }

    public static double sumatoria(double[] datos){
        double res=0;
        for(int i=1; i< datos.length-1; i++){
            res+= Math.tan(datos[i]);
        }

        return res;
    }
    public static void metodoDeTrapecios(double [] datos, double h){
        //Este metodo calcula la aproximacion de un area
        //el metodo de Metodo de los Trapecios
        //no tiene en cuenta si la derivada de la funcion da 0
        double r= (h/2)*(Math.tan(datos[0])+Math.tan(datos[datos.length-1]) + (2*(MetodosNumericos.sumatoria(datos))));
        System.out.println("area aproximada: "+ r);
    }

    public static void main(String[] args) {
        
        //MetodosNumericos.metodoBiseccion(-2.0, 0.0, 0.1);
        //MetodosNumericos.newtonRaphson(1, 0.1);
        double [] datos= new double[]{-1,-0.6875,-0.375,-0.0625,0.25,0.5625,0.875,1.1875,1.5};
        MetodosNumericos.metodoDeTrapecios(datos, 0.3125);
    }
        
}

