package Método_Simpson3_8;

import java.util.function.Function;

/**
 *
 * @author Migue
 */
public class Ejercicio1 {
    // Método para calcular la integral numérica utilizando el Método de Simpson 3/8

    public static double integrate(double a, double b, int n, Function<Double, Double> func) {
        double h = (b - a) / n;
        double sum = func.apply(a) + func.apply(b);

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += i % 3 == 0 ? 2 * func.apply(x) : 3 * func.apply(x);
        }

        return (3 * h / 8) * sum;
    }

    // Método para calcular la derivada numérica utilizando el Método de Simpson 3/8
    public static double differentiate(double x, double h, Function<Double, Double> func) {
        double result = (-func.apply(x + 2 * h) + 9 * func.apply(x + h) - 9 * func.apply(x - h) + func.apply(x - 2 * h)) / (24 * h);
        return result;
    }

    public static void main(String[] args) {
        Function<Double, Double> func = (x) -> Math.sin(x); // Función a integrar y diferenciar: sin(x)
        double a = 0; // Límite inferior
        double b = Math.PI / 2; // Límite superior
        int n = 3; // Número de segmentos (debe ser múltiplo de 3 para el Método de Simpson 3/8)
        double x0 = Math.PI / 4; // Punto en el que se desea calcular la derivada
        double h = 0.1; // Tamaño del paso

        // Calcular la integral numérica utilizando el Método de Simpson 3/8
        double integral = integrate(a, b, n, func);
        System.out.println("Resultado de la integración: " + integral);

        // Calcular la derivada numérica utilizando el Método de Simpson 3/8
        double derivative = differentiate(x0, h, func);
        System.out.println("Resultado de la diferenciación en x = " + x0 + ": " + derivative);
    }
}
