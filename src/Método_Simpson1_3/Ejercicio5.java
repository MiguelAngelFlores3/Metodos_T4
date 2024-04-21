package Método_Simpson1_3;

import java.util.function.BiFunction;

/**
 *
 * @author Migue
 */
public class Ejercicio5 {

    public class ODEApproximationAndDifferentiationSimpson {

        public static double integrate(double a, double b, int n, BiFunction<Double, Double, Double> func) {
            double h = (b - a) / n;
            double sum = func.apply(a, 1.0) + func.apply(b, 1.0);

            for (int i = 1; i < n; i++) {
                double x = a + i * h;
                sum += i % 2 == 0 ? 2 * func.apply(x, 1.0) : 4 * func.apply(x, 1.0);
            }

            return (h / 3) * sum;
        }

        public static double differentiate(double x, double h, BiFunction<Double, Double, Double> func) {
            double result = (func.apply(x - 2 * h, 1.0) - 8 * func.apply(x - h, 1.0) + 8 * func.apply(x + h, 1.0) - func.apply(x + 2 * h, 1.0)) / (12 * h);
            return result;
        }

        public static void main(String[] args) {
            BiFunction<Double, Double, Double> func = (x, y) -> x - y; // EDO: dy/dx = x - y
            double a = 0; // Límite inferior
            double b = 1; // Límite superior
            int n = 6; // Número de segmentos (debe ser par para el Método de Simpson 1/3)
            double x0 = 0.5; // Punto en el que se desea calcular la derivada
            double h = 0.1; // Tamaño del paso

            double solutionApproximation = integrate(a, b, n, func);
            System.out.println("Aproximación de la solución de la EDO: " + solutionApproximation);

            double derivative = differentiate(x0, h, func);
            System.out.println("Derivada de la solución de la EDO en x = " + x0 + ": " + derivative);
        }
    }
}
