package Método_Simpson1_3;

import java.util.function.Function;

/**
 *
 * @author Migue
 */
public class Ejercicio2 {

    public class IntegralAndDifferentiationPolynomialSimpson {

        public static double integrate(double a, double b, int n, Function<Double, Double> func) {
            double h = (b - a) / n;
            double sum = func.apply(a) + func.apply(b);

            for (int i = 1; i < n; i++) {
                double x = a + i * h;
                sum += i % 2 == 0 ? 2 * func.apply(x) : 4 * func.apply(x);
            }

            return (h / 3) * sum;
        }

        public static double differentiate(double x, double h, Function<Double, Double> func) {
            double result = (func.apply(x - 2 * h) - 8 * func.apply(x - h) + 8 * func.apply(x + h) - func.apply(x + 2 * h)) / (12 * h);
            return result;
        }

        public static void main(String[] args) {
            Function<Double, Double> func = (x) -> 3 * x * x * x - 2 * x * x + x + 5; // Polinomio: 3x^3 - 2x^2 + x + 5
            double a = 1; // Límite inferior
            double b = 4; // Límite superior
            int n = 6; // Número de segmentos (debe ser par para el Método de Simpson 1/3)
            double x0 = 2; // Punto en el que se desea calcular la derivada
            double h = 0.1; // Tamaño del paso

            double integral = integrate(a, b, n, func);
            System.out.println("Integral de la función: " + integral);

            double derivative = differentiate(x0, h, func);
            System.out.println("Derivada de la función en x = " + x0 + ": " + derivative);
        }
    }
}
