package Método_Cuadratura_Gaussiana;

import java.util.function.Function;

/**
 *
 * @author Migue
 */
public class Ejercicio2 {

    // Coeficientes y nodos de Cuadratura Gaussiana para dos puntos
    private static final double[] nodes = {-0.5773502692, 0.5773502692};
    private static final double[] weights = {1.0, 1.0};

    // Método para calcular la integral numérica utilizando Cuadratura Gaussiana
    public static double integrate(double a, double b, Function<Double, Double> func) {
        double integral = 0.0;
        double transform = (b - a) / 2.0;

        for (int i = 0; i < nodes.length; i++) {
            double x = transform * nodes[i] + (a + b) / 2.0;
            integral += weights[i] * func.apply(x);
        }

        return transform * integral;
    }

    // Método para calcular la derivada numérica utilizando Cuadratura Gaussiana
    public static double differentiate(double x, double h, Function<Double, Double> func) {
        double derivative = 0.0;

        for (int i = 0; i < nodes.length; i++) {
            double xi = x + h * nodes[i];
            derivative += weights[i] * func.apply(xi);
        }

        return derivative / h;
    }

    public static void main(String[] args) {
        Function<Double, Double> func = (x) -> 3 * x * x * x - 2 * x * x + x + 5; // Polinomio: 3x^3 - 2x^2 + x + 5
        double a = 1; // Límite inferior
        double b = 4; // Límite superior
        double x0 = 2; // Punto en el que se desea calcular la derivada
        double h = 0.1; // Tamaño del paso

        // Calcular la integral numérica utilizando Cuadratura Gaussiana
        double integral = integrate(a, b, func);
        System.out.println("Resultado de la integración: " + integral);

        // Calcular la derivada numérica utilizando Cuadratura Gaussiana
        double derivative = differentiate(x0, h, func);
        System.out.println("Resultado de la diferenciación en x = " + x0 + ": " + derivative);
    }
}
