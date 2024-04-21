
package Método_Simpson1_3;

import java.util.function.Function;
/**
 *
 * @author Migue
 */
public class Ejercicio1 {
    // Método para calcular la integral numérica utilizando el Método de Simpson 1/3
    public static double integrate(double a, double b, int n, Function<Double, Double> func) {
        double h = (b - a) / n;
        double sum = func.apply(a) + func.apply(b);

        for (int i = 1; i < n; i += 2) {
            double x = a + i * h;
            sum += 4 * func.apply(x);
        }

        for (int i = 2; i < n - 1; i += 2) {
            double x = a + i * h;
            sum += 2 * func.apply(x);
        }

        return (h / 3) * sum;
    }
    
    // Método para calcular la derivada numérica utilizando el Método de Simpson 1/3
    public static double differentiate(double x, double h, Function<Double, Double> func) {
        double result = (func.apply(x - 2 * h) - 8 * func.apply(x - h) + 8 * func.apply(x + h) - func.apply(x + 2 * h)) / (12 * h);
        return result;
    }
    
    public static void main(String[] args) {
        // Definir la función que se desea integrar y diferenciar
        Function<Double, Double> func = (x) -> Math.sin(x); // Ejemplo: función seno
        
        // Definir los límites de integración y el número de segmentos
        double a = 0; // Límite inferior
        double b = Math.PI / 2; // Límite superior
        int n = 4; // Número de segmentos (debe ser par para el Método de Simpson 1/3)
        
        // Calcular la integral numérica utilizando el Método de Simpson 1/3
        double integral = integrate(a, b, n, func);
        System.out.println("Resultado de la integración: " + integral);
        
        // Calcular la derivada numérica utilizando el Método de Simpson 1/3
        double x0 = Math.PI / 4; // Punto en el que se desea calcular la derivada
        double h = 0.1; // Tamaño del paso
        double derivative = differentiate(x0, h, func);
        System.out.println("Resultado de la diferenciación en x = " + x0 + ": " + derivative);
    }
}
