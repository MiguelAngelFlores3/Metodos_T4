package Método_Trapecio;

import java.util.function.Function;

/**
 *
 * @author Migue
 */
public class Ejercicio1 {
        
    
    // Método para calcular la integral numérica utilizando el Método del Trapecio
    public static double integrate(double a, double b, int n, Function<Double, Double> func) {
        double h = (b - a) / n;
        double sum = 0.5 * (func.apply(a) + func.apply(b));
        
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += func.apply(x);
        }
        
        return h * sum;
    }
    
    // Método para calcular la derivada numérica utilizando el Método del Trapecio
    public static double differentiate(double x, double h, Function<Double, Double> func) {
        double result = (func.apply(x + h) - func.apply(x - h)) / (2 * h);
        return result;
    }
    
    public static void main(String[] args) {
        // Definir la función que se desea integrar y diferenciar
        Function<Double, Double> func = (x) -> Math.sin(x); // Ejemplo: función seno
        
        // Definir los límites de integración y el número de segmentos
        double a = 0; // Límite inferior
        double b = Math.PI / 2; // Límite superior
        int n = 1000; // Número de segmentos
        
        // Calcular la integral numérica utilizando el Método del Trapecio
        double integral = integrate(a, b, n, func);
        System.out.println("Resultado de la integración: " + integral);
        
        // Calcular la derivada numérica utilizando el Método del Trapecio
        double x0 = Math.PI / 4; // Punto en el que se desea calcular la derivada
        double h = 0.001; // Tamaño del paso
        double derivative = differentiate(x0, h, func);
        System.out.println("Resultado de la diferenciación en x = " + x0 + ": " + derivative);
        
    }
}
