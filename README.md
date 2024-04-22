<h1> <font color = "darkred" size="+5" font face = "cooper black"> <b> <i> Tema 4: Métodos de solución de problemas aplicando diferenciación y integración</i> </b> </font> </h1>

<h4> <font color = "darkred" size="+5" font face = "cooper black"> <b> <i>Integrantes </i> </b> </font> </h4>

-----------------------------------------------------------------------------------------

<h3 align = "center"> <font color = "darkorange" size = "+6"  font face =  "cooper black">  Índice </font> </h3>

<header> <font color = "red" size="+1" font face = "aharoni">
                <nav class="navegacion">
                    <ul class="Indice">
                       <li> <a href="#Temario"> </a> </li>
                            <ul class="subindice"> 
                                <li> <a href="#"> </a> </li>
                                <li> <a href="#">  </a> </li>
                                <li> <a href="#">  </a> </li>  
                            </ul>
                      <li> <a href="#Métodos"> Métodos </a> <br> </li>
                            <ul class="subindice"> 
                                <li> <a href="#Método de Bisección"> Método de Bisección. </a> </li>
                                <li> <a href="#Método de la Falsa Posición"> Método de la Falsa Posición. </a> </li>
                                <li> <a href="#Método de la Secante"> Método de la Secante. </a> </li> 
                                <li> <a href="#Método de Newton-Raphson"> Método de Newton-Raphson. </a> </li> 
                            </ul>
                    </ul>
                </nav>
            </font> </header>
-----------------------------------------------------------------------------------------

<h3 align = "center"> <font  font face = "bauhaus 93">  <a name="Descripción"> Descripción</a> </font> </h3>

En este documento podremos obser el funcionamiento de diversos métodos aplicandolos en funciones de diferenciación e integración númerica, los cuales son:

  1. Método del Trapecio 
  2. Método de Simpson 1/3
  3. Método de Simpson 3/8
  4. Método de la Cuadratura Gaussiana

En cada una de las carpetas podremos encontrar lo que son los códigos de cada método, tanto de su diferenciación como la de integración, y en cada carpeta podremos encontrar cinco programas los cuales estan desarrollados en el lenguaje de programación Java, en los cuales estarán documentados para un mayor entendimiento del programa.

-----------------------------------------------------------------------------------------
<h3 align = "center"> <font  font face = "bauhaus 93">  <a name="Temario"> Temario</a> </font> </h3>

   4.1 Diferenciación Numérica 
   
   4.2 Integración Numérica
   
   4.3 Integración Múltiple
   
   4.4 Aplicación

-----------------------------------------------------------------------------------------
<h2 align = "center"> <font  font face = "bauhaus 93"> <a name="Métodos"> Métodos</a> </font> </h2>

<h3 align = "center"> <font  font face = "bauhaus 93"> <a name=" Método del Trapecio ">  Método del Trapecio </a> </font> </h3>

<h4> <font font face = "arial"> Descripción </h4>
  
Este método es útil cuando la función a integrar es difícil o imposible de integrar analíticamente, o cuando se necesita una solución numérica rápida y aceptable. Sin embargo, su precisión depende de la cantidad de segmentos utilizados y puede ser superado por métodos más avanzados, como la regla de Simpson, para funciones que son suaves y continuamente diferenciables.

<h4> <font font face = "arial">Pseudocódigo </h4>
  
1. Pseudocódigo para realizar la integración

        Función Trapecio_Integración(f, a, b, n):
            h = (b - a) / n
            suma = 0.5 * (f(a) + f(b))
            Para i desde 1 hasta n-1:
                xi = a + i * h
                suma = suma + f(xi)
            resultado = h * suma
            Devolver resultado


2. Pseudocódigo para realizar la diferenciación

        Función Trapecio_Diferenciación(f, a, b, n):
            h = (b - a) / n
            suma = f(a) + f(b)
            Para i desde 1 hasta n-1:
                xi = a + i * h
                suma = suma + 2 * f(xi)
            resultado = h * suma / 2
            Devolver resultado

<h4> <font font face = "arial"> <b> <i> Ejemplo en código </i> </b> </h4>

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

<h4> <font font face = "arial"> Programa ejecutado </h4>

![Captura de pantalla 2024-04-21 134559](https://github.com/MiguelAngelFlores3/Metodos_T4/assets/167603831/866c3eca-3072-4589-85c5-e0a3b862bf69)

<h3 align = "center"> <font  font face = "bauhaus 93"> <a name="Método de Simpson 1/3 ">  Método de Simpson 1/3 </a> </font> </h3>

<h4> <font font face = "arial"> Descripción </h4>

Este método proporciona una mayor precisión que el Método del Trapecio para la misma cantidad de puntos de integración y es bastante eficaz para integrandos suaves. Sin embargo, para funciones con oscilaciones rápidas o discontinuidades, puede no ser tan eficaz. En esos casos, métodos más avanzados, como la regla de Simpson 3/8 o métodos adaptativos, pueden ser más apropiados.

<h4> <font font face = "arial">Pseudocódigo </h4>
  
1. Pseudocódigo para realizar la integración

        Función Simpson_Integración(f, a, b, n):
            h = (b - a) / n
            suma = f(a) + f(b)
            Para i desde 1 hasta n-1:
                xi = a + i * h
                Si i es impar:
                    suma = suma + 4 * f(xi)
                Sino:
                    suma = suma + 2 * f(xi)
            resultado = h * suma / 3
            Devolver resultado

2. Pseudocódigo para realizar la diferenciación
    
       Función Simpson_Diferenciación(f, a, b, n):
        h = (b - a) / n
        suma = f(a) + f(b)
        Para i desde 1 hasta n-1:
            xi = a + i * h
            Si i es impar:
                suma = suma + 4 * f(xi)
            Sino:
                suma = suma + 2 * f(xi)
        resultado = h * suma / 3
        resultado = resultado / h # Para la diferenciación
        Devolver resultado

<h4> <font font face = "arial"> <b> <i> Ejemplo en código </i> </b> </h4>

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

<h4> <font font face = "arial"> Programa ejecutado </h4>

![Captura de pantalla 2024-04-21 142010](https://github.com/MiguelAngelFlores3/M-TODOS_T4/assets/167603831/4790a5b1-9e8c-4d36-ac32-fc21be24a584)

<h3 align = "center"> <font  font face = "bauhaus 93"> <a name="Método de Simpson 3/8 ">  Método de Simpson 3/8 </a> </font> </h3>

<h4> <font font face = "arial"> Descripción </h4>

El Método de Simpson 3/8 es una técnica de integración numérica que extiende el Método de Simpson 1/3 para mejorar aún más la precisión de la aproximación. Al igual que el Método de Simpson 1/3, utiliza polinomios de segundo grado (parábolas) para aproximar la función entre los puntos de integración. Sin embargo, en lugar de usar parábolas en cada subintervalo, el Método de Simpson 3/8 utiliza polinomios de tercer grado (cúbicos) para ajustar la función.

<h4> <font font face = "arial">Pseudocódigo </h4>
  
1. Pseudocódigo para realizar la integración

        Función Simpson_3_8_Integración(f, a, b, n):
            h = (b - a) / n
            suma = f(a) + f(b)
            Para i desde 1 hasta n-1:
                xi = a + i * h
                Si i es divisible por 3:
                    suma = suma + 2 * f(xi)
                Sino Si i no es divisible por 3 pero es impar:
                    suma = suma + 3 * f(xi)
                Sino:
                    suma = suma + 3 * f(xi)
            resultado = 3 * h * suma / 8
            Devolver resultado

2. Pseudocódigo para realizar la diferenciación

       Función Simpson_3_8_Diferenciación(f, a, b, n):
        h = (b - a) / n
        suma = f(a) + f(b)
        Para i desde 1 hasta n-1:
            xi = a + i * h
            Si i es divisible por 3:
                suma = suma + 2 * f(xi)
            Sino Si i no es divisible por 3 pero es impar:
                suma = suma + 3 * f(xi)
            Sino:
                suma = suma + 3 * f(xi)
        resultado = 3 * h * suma / 8
        resultado = resultado / h # Para la diferenciación
        Devolver resultado

<h4> <font font face = "arial"> <b> <i> Ejemplo en código </i> </b> </h4>

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

<h4> <font font face = "arial"> Programa ejecutado </h4>

![Captura de pantalla 2024-04-21 144711](https://github.com/MiguelAngelFlores3/M-TODOS_T4/assets/167603831/2f81f60f-9961-47cc-b7d6-9cc7e679a7eb)

<h3 align = "center"> <font  font face = "bauhaus 93"> <a name="Método de la Cuadratura Gaussiana ">  Método de la Cuadratura Gaussiana </a> </font> </h3>

<h4> <font font face = "arial"> Descripción </h4>
  
El Método de la Cuadratura Gaussiana es una técnica de integración numérica que utiliza una selección cuidadosa de puntos de evaluación y pesos para proporcionar una alta precisión en la aproximación de integrales definidas. A diferencia de los métodos de interpolación como el Método del Trapecio o el Método de Simpson, la Cuadratura Gaussiana no intenta ajustar polinomios a la función a integrar. En cambio, aprovecha las propiedades de ciertas funciones de peso para elegir de manera óptima los puntos de evaluación.

<h4> <font font face = "arial">Pseudocódigo </h4>
  
1. Pseudocódigo para realizar la integración

        Función Cuadratura_Gaussiana_Integración(f, a, b, n):
            coeficientes, nodos = obtener_coeficientes_y_nodos(n)
            suma = 0
            Para i desde 0 hasta n-1:
                xi = (b - a) / 2 * nodos[i] + (b + a) / 2
                suma = suma + coeficientes[i] * f(xi)
            resultado = (b - a) / 2 * suma
            Devolver resultado

2. Pseudocódigo para realizar la diferenciación

        Función Cuadratura_Gaussiana_Diferenciación(f, a, b, n):
            coeficientes, nodos = obtener_coeficientes_y_nodos(n)
            suma = 0
            Para i desde 0 hasta n-1:
                xi = (b - a) / 2 * nodos[i] + (b + a) / 2
                suma = suma + coeficientes[i] * f(xi)
            resultado = suma
            Devolver resultado

<h4> <font font face = "arial"> <b> <i> Ejemplo en código </i> </b> </h4>

    package Método_Cuadratura_Gaussiana;
    
    import java.util.function.Function;
    
    /**
     *
     * @author Migue
     */
    public class Ejercicio1 {
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
            Function<Double, Double> func = (x) -> Math.sin(x); // Función a integrar y diferenciar: sin(x)
            double a = 0; // Límite inferior
            double b = Math.PI / 2; // Límite superior
            double x0 = Math.PI / 4; // Punto en el que se desea calcular la derivada
            double h = 0.1; // Tamaño del paso
    
            // Calcular la integral numérica utilizando Cuadratura Gaussiana
            double integral = integrate(a, b, func);
            System.out.println("Resultado de la integración: " + integral);
    
            // Calcular la derivada numérica utilizando Cuadratura Gaussiana
            double derivative = differentiate(x0, h, func);
            System.out.println("Resultado de la diferenciación en x = " + x0 + ": " + derivative);
        }
    }

<h4> <font font face = "arial"> Programa ejecutado </h4>

![Captura de pantalla 2024-04-21 145400](https://github.com/MiguelAngelFlores3/M-TODOS_T4/assets/167603831/33d51347-cb05-4cdf-9611-78a99cd6448d)
