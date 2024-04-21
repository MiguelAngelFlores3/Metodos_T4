
package Método_Trapecio;

import java.util.function.Function;

/**
 *
 * @author Migue
 */
public class Ejercicio5 {
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
        Function<Double, Double> f = (x) -> x * x; // Función f(x): x^2
        Function<Double, Double> g = (x) -> x; // Función g(x): x
        double a = 0; // Límite inferior
        double b = 2; // Límite superior
        int n = 1000; // Número de segmentos
        double x0 = 1; // Punto en el que se desea calcular la derivada
        double h = 0.001; // Tamaño del paso

        // Calcular el área bajo la función f(x)
        double areaF = integrate(a, b, n, f);
        // Calcular el área bajo la función g(x)
        double areaG = integrate(a, b, n, g);

        // Calcular el área entre las dos funciones
        double areaBetween = Math.abs(areaF - areaG);
        System.out.println("Área entre las dos funciones: " + areaBetween);

        // Calcular la derivada de f(x) en x0
        double derivativeF = differentiate(x0, h, f);
        System.out.println("Derivada de la función f(x) en x = " + x0 + ": " + derivativeF);

        // Calcular la derivada de g(x) en x0
        double derivativeG = differentiate(x0, h, g);
        System.out.println("Derivada de la función g(x) en x = " + x0 + ": " + derivativeG);
    }
}
