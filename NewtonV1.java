// Versión 2: Método de Newton-Raphson

import java.util.Scanner;

public class NewtonV2 {
    public static double f(double x) {
        return x * x - 2;
    }

    public static double df(double x) {
        return 2 * x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nIngrese el valor inicial x0: ");
        double x0 = sc.nextDouble();

        System.out.print("Ingrese la tolerancia: ");
        double tol = sc.nextDouble();

        System.out.print("Ingrese el número máximo de iteraciones: ");
        int maxIter = sc.nextInt();

        System.out.println("\nIteración\t x\t\t f(x)\t\t Error");

        for (int i = 0; i < maxIter; i++) {
            double fx = f(x0);
            double dfx = df(x0);

            if (dfx == 0) {
                System.out.println("Derivada cero. Método falla.");
                break;
            }

            double x1 = x0 - fx / dfx;
            double error = Math.abs(x1 - x0);

            System.out.printf("%d\t\t %.6f\t %.6f\t %.6f%n", i + 1, x0, fx, error);

            if (error < tol) {
                System.out.printf("\nRaíz encontrada: %.6f en %d iteraciones.%n", x1, i + 1);
                break;
            }

            x0 = x1;
        }

        sc.close();
    }
}
