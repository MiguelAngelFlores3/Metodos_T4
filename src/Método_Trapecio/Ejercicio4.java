
package Método_Trapecio;

import java.util.function.Function;

/**
 *
 * @author Migue
 */
public class Ejercicio4 {
     public static double integrate(double a, double b, int n, Function<Double, Double> func) {
        double h = (b - a) / n;
        double sum = 0;

        for (int i = 0; i < n; i++) {
            double x1 = a + i * h;
            double x2 = a + (i + 1) * h;
            double y1 = func.apply(x1);
            double y2 = func.apply(x2);
            double deltaS = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
            sum += deltaS;
        }

        return sum;
    }

    public static double differentiate(double x, double h, Function<Double, Double> func) {
        double result = (func.apply(x + h) - func.apply(x - h)) / (2 * h);
        return result;
    }

    public static void main(String[] args) {
        Function<Double, Double> func = (x) -> Math.sqrt(1 + Math.pow(2 * x, 2)); // Función: sqrt(1 + (2x)^2)
        double a = 0; // Límite inferior
        double b = 2; // Límite superior
        int n = 1000; // Número de segmentos
        double x0 = 1; // Punto en el que se desea calcular la derivada
        double h = 0.001; // Tamaño del paso

        double arcLength = integrate(a, b, n, func);
        System.out.println("Longitud del arco de la función: " + arcLength);

        double derivative = differentiate(x0, h, func);
        System.out.println("Derivada de la función en x = " + x0 + ": " + derivative);
    }
}
