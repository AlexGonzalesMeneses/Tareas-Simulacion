package homework_1;

import java.util.Scanner;

public class Dado {
    public static void main(String[] args) {
        int nCasos;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el número de casos de prueba para lanzar una moneda");
        nCasos = sc.nextInt();
        lanzarDado(nCasos);
    }

    private static void lanzarDado(int nCasos) {
        int [] caras = new int[6];
        double azar;
        int j;
        boolean encontrado;
        double cara;
        for (int i = 0; i < nCasos; i++) {
            azar = Math.random();
            j = 1;
            encontrado = false;
            do {
                cara = ((double) j / (double) caras.length);
                if (azar < cara) {
                    caras[j - 1]++;
                    encontrado = true;
                }
                j++;
            }while (j <= caras.length && !encontrado);
        }
        double cont = 0;
        for (int i = 0; i < caras.length; i++) {
            System.out.println("Salió " + (i + 1) + " -> " + caras[i] + " veces");
            if (nCasos > 0) {
                if (i != caras.length -1){
                    System.out.println("Representado un " + redondearDecimales(caras[i] * (100.0 / nCasos), 3) + "%");
                }else {
                    System.out.println("Representando un " + (100-cont) + "%");
                }
            }
        }
    }
    private static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }
}
