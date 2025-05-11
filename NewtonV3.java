// Versión 3: Comentarios y manejo de errores

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewtonV3 {

    // Representa una iteración
    static class Iteracion {
        int numero;
        double x;
        double fx;
        double error;

        Iteracion(int numero, double x, double fx, double error) {
            this.numero = numero;
            this.x = x;
            this.fx = fx;
            this.error = error;
        }
    }

    // Función a evaluar
    public static double f(double x) {
        return x * x - 2;
    }

    // Derivada de la función
    public static double df(double x) {
        return 2 * x;
    }

    // Implementación del método Newton-Raphson
    public static List<Iteracion> newtonRaphson(double x0, double tol, int maxIter) throws Exception {
        List<Iteracion> historial = new ArrayList<>();

        for (int i = 0; i < maxIter; i++) {
            double fx = f(x0);
            double dfx = df(x0);

            if (dfx == 0) {
                throw new Exception("Derivada cero. Método no puede continuar.");
            }

            double x1 = x0 - fx / dfx;
            double error = Math.abs(x1 - x0);

            historial.add(new Iteracion(i + 1, x0, fx, error));

            if (error < tol) {
                return historial;
            }

            x0 = x1;
        }

        throw new Exception("No se alcanzó la tolerancia deseada.");
    }

    // Mostrar los resultados
    public static void imprimirResultados(List<Iteracion> historial) {
        System.out.println("\nIteración\t x\t\t f(x)\t\t Error");
        for (Iteracion it : historial) {
            System.out.printf("%d\t\t %.6f\t %.6f\t %.6f%n", it.numero, it.x, it.fx, it.error);
        }
        Iteracion ultima = historial.get(historial.size() - 1);
        System.out.printf("\nRaíz encontrada: %.6f en %d iteraciones.%n", ultima.x, ultima.numero);
    }

    // Entrada de datos
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el valor inicial x0: ");
        double x0 = sc.nextDouble();

        System.out.print("Ingrese la tolerancia: ");
        double tol = sc.nextDouble();

        System.out.print("Ingrese el número máximo de iteraciones: ");
        int maxIter = sc.nextInt();

        try {
            List<Iteracion> resultado = newtonRaphson(x0, tol, maxIter);
            imprimirResultados(resultado);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
