// Versión 1: Solo estructura y entrada de datos

import java.util.Scanner;

public class NewtonV1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Ingreso de datos
        System.out.print("Ingrese el valor inicial x0: ");
        double x0 = sc.nextDouble();

        System.out.print("Ingrese la tolerancia: ");
        double tol = sc.nextDouble();

        System.out.print("Ingrese el número máximo de iteraciones: ");
        int maxIter = sc.nextInt();

        sc.close();
    }
}
