
import java.lang.Math;
public class MetodosNumericos {
    


    public static void metodoBiseccion(double a, double b, double e){
        //Este metodo calcula la aproximacion de la raiz utilizando
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

    public static double sumatoria(double[] datos, int xi, int desde,int hasta){
        /*Este metodo hace una sumatoria de los elementos de un arreglo empezando desde la posicion  */
        double res=0;
        for(int i=desde; i< datos.length-hasta; i+=xi){
            res+= Math.tan(datos[i]);
        }

        return res;
    }

    public static void metodoDeTrapecios(double [] datos, double h){
        //Este metodo calcula la aproximacion de un area
        //el metodo de Metodo de los Trapecios

        double r= (h/2)*(Math.tan(datos[0])+Math.tan(datos[datos.length-1]) + (2*(MetodosNumericos.sumatoria(datos, 1,1,1))));
        System.out.println("area aproximada: "+ r);
    }

    public static void metodoDeSimpson(double [] datos, double h){
        //Este metodo calcula la aproximacion de un area
        //el metodo de Metodo de Simpson 1/3
 
        if(datos.length%2 == 1) {
            
            double r= (h/3)*(Math.tan(datos[0])+Math.tan(datos[datos.length-1]) + 
            (4*(MetodosNumericos.sumatoria(datos,2,1,1 ))) + (2*(MetodosNumericos.sumatoria(datos,2,2,2 ))));
            
            System.out.println("area aproximada: "+ r);
        
        }else{
            System.out.println("la cantidad de datos no permite utilizar el metodo");
        }
    }

    public static double funcionXY(double x, double y){
        return 16- Math.pow(x, 2)-2*Math.pow(y, 2); // f(x,y)= 16- x^2 - 2y^2
    }
    public static double sumaDeRiemannDoble(int m, int n, double a, double b, double c, double d){
        double resultado = 0;
        double dX= (b-a)/m;
        double dY= (d-c)/m;
        double dA= dX*dY;

        for(double i=dX; i<=b; i+=dX){
            for(double j=dY; j<=d; j+=dY){
                resultado+= funcionXY(i,j);
            }
        }
        return dA*resultado;
    }
    public static void main(String[] args) {
        
        //MetodosNumericos.metodoBiseccion(1.0, 3.0, 0.1);
        
        //MetodosNumericos.newtonRaphson(1, 0.1);
        //double [] datos= new double[]{-1,-0.375,0.25,0.875,1.5};
        //MetodosNumericos.metodoDeSimpson(datos, 0.625);

        System.out.println("suma de Riemann: "+ sumaDeRiemannDoble(4,4,0,2,0,2));



    }
        
}

