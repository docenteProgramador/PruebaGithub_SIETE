/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trayectoriabalistica;

import java.util.Scanner;

/**
 *
 * @author Joseph Castro
 */
public class TrayectoriaBalistica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double Vo = 0;
        int angulo = 0;
        double radianes = 0;
        double altura = 0;
        double alturaMaxima = 0;
        int segundoMax = 0;
        final double GRAVEDAD = 9.8;

        System.out.println("Simulacion de Trayectoria Balistica");
        System.out.println("Ingrese la Velocidad Inicial: Vo");
        Vo = sc.nextDouble();
        do {
            if (Vo <= 0) {
                System.out.println("El numero que ingreso no es valido ingrese un numero positivo");
                Vo = sc.nextDouble();
            }//fin de if
        } while (Vo <= 0);//Fin de while
        System.out.println("Ingrese el Angulo de Lanzamineto");
        angulo = sc.nextInt();
        do {
            if (angulo <= 0 || angulo >= 90) {
                System.out.println("El numero que ingreso no es valido ingrese un numero entre 1 y 89");
                angulo = sc.nextInt();
            }//fin de if
        } while (angulo <= 0 || angulo >= 90);//fin de while

        radianes = angulo * Math.PI / 180;

        for (int t = 1; t <= 10; t++) {
            altura = Vo * Math.sin(radianes) * t - 0.5 * GRAVEDAD * Math.pow(t, 2);

            System.out.printf("Segundo %d: altura = %.2f m\n", t, altura);

            if (altura < 0) {
                System.out.println("El proyectil impacto el suelo en el segundo " + t);
                break;
            } else if (altura > alturaMaxima) {
                alturaMaxima = altura;
                segundoMax = t;
            }
        }//Fin de For}

        System.out.printf("La altura maxima fue de %.2f m en el segundo %d\n", alturaMaxima, segundoMax);

    }//Fin de Main

}//Fin de Class
