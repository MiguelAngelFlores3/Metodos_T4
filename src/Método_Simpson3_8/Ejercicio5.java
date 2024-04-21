package Método_Simpson3_8;

import java.util.function.BiFunction;

/**
 *
 * @author Migue
 */
public class Ejercicio5 {

    public static double integrate(double a, double b, int n, BiFunction<Double, Double, Double> func) {
        double h = (b - a) / n;
        double sum = func.apply(a, 1.0) + func.apply(b, 1.0);

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += i % 3 == 0 ? 2 * func.apply(x, 1.0) : 3 * func.apply(x, 1.0);
        }

        return (3 * h / 8) * sum;
    }

    public static double differentiate(double x, double h, BiFunction<Double, Double, Double> func) {
        double result = (-func.apply(x + 2 * h, 1.0) + 9 * func.apply(x + h, 1.0) - 9 * func.apply(x - h, 1.0) + func.apply(x - 2 * h, 1.0)) / (24 * h);
        return result;
    }

    public static void main(String[] args) {
        BiFunction<Double, Double, Double> func = (x, y) -> x - y; // EDO: dy/dx = x - y
        double a = 0; // Límite inferior
        double b = 1; // Límite superior
        int n = 6; // Número de segmentos (debe ser múltiplo de 3 para el Método de Simpson 3/8)
        double x0 = 0.5; // Punto en el que se desea calcular la derivada
        double h = 0.1; // Tamaño del paso

        double solutionApproximation = integrate(a, b, n, func);
        System.out.println("Aproximación de la solución de la EDO: " + solutionApproximation);

        double derivative = differentiate(x0, h, func);
        System.out.println("Derivada de la solución de la EDO en x = " + x0 + ": " + derivative);
    }
}
