package homework_1;

import java.util.Scanner;

public class Moneda {
    public static void main(String[] args) {
        int nCasos;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el número de casos de prueba para lanzar una moneda");
        nCasos = sc.nextInt();
        lanzarMoneda(nCasos);
    }

    private static void lanzarMoneda(int nCasos) {
        int cara = 0;
        int cruz = 0;
        double azar;
        for (int i = 0; i < nCasos; i++) {
            azar = Math.random();
            if (azar > 0.5){
                cara++;
            }else {
                cruz++;
            }
        }
        System.out.println("Salió cara en " + cara + " casos.");
        String vc = "";
        if(nCasos > 0) {
            System.out.println("Representando un " + redondearDecimales(cara * (100.0 / nCasos), 3) + "%");
            vc = "Representando un "+ (100-(redondearDecimales(cara*(100.0/nCasos), 3))) + "%";
        }
        System.out.println("Salio cruz en " + cruz + " casos");
        System.out.println(vc);

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
