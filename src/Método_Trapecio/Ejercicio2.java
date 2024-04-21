
package Método_Trapecio;

import java.util.function.Function;

/**
 *
 * @author Migue
 */
public class Ejercicio2 {
    
      public static double integrate(double a, double b, int n, Function<Double, Double> func) {
        double h = (b - a) / n;
        double sum = 0.5 * (func.apply(a) + func.apply(b));

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += func.apply(x);
        }

        return h * sum;
    }

    public static double differentiate(double x, double h, Function<Double, Double> func) {
        double result = (func.apply(x + h) - func.apply(x - h)) / (2 * h);
        return result;
    }

    public static void main(String[] args) {
        Function<Double, Double> func = (x) -> 2 * x * x + 3 * x - 5; // Polinomio: 2x^2 + 3x - 5
        double a = 1; // Límite inferior
        double b = 3; // Límite superior
        int n = 1000; // Número de segmentos
        int x0 = 2; // Punto en el que se desea calcular la derivada
        double h = 0.001; // Tamaño del paso

        double integral = integrate(a, b, n, func);
        System.out.println("Integral de la función: " + integral);

        double derivative = differentiate(x0, h, func);
        System.out.println("Derivada de la función en x = " + x0 + ": " + derivative);
    }
}
