/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package facturacion;

import java.util.Scanner;

/**
 *
 * @author Joseph Castro
 */
public class Facturacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        final double ISV = 0.15;

        int precioProducto = 0;
        int cantidad = 0;
        double descuento = 0;
        double impuesto = 0;
        double subTotal = 0;
        double total = 0;

        //1ra Funcion
        MensajeBienvenida();
        
        //2daFuncion

        System.out.println("Ingrese el Precio del Producto : ");
        precioProducto = scan.nextInt();
        precioProducto = ValidacionNumerica(precioProducto,scan);
        
        System.out.println("Cuantos productos llevas?");
        cantidad = scan.nextInt();
        cantidad = ValidacionNumerica(cantidad,scan);

        subTotal = precioProducto * cantidad;
 
        if (subTotal > 100) {
            descuento = subTotal * 0.10;
        } else {
            descuento = 0;
        }

        impuesto = (subTotal - descuento) * ISV;

        total = subTotal - descuento + impuesto;

        //4ta Funcion
        ResultadoFactura(subTotal,descuento,impuesto,total);

    }//Fin de Main

    public static void MensajeBienvenida() {
        System.out.println("-----------------------------");
        System.out.println("    Sistema de Facturacion   ");
        System.out.println("  La logica de Programacion  ");
        System.out.println("-----------------------------");
    }//Fin de la Funcion MensajeBienvenida

    public static int ValidacionNumerica(int numero, Scanner input) {

        int numeroValido = numero;
        final int LIMITE = 0;

        do {
            if (numeroValido < LIMITE) {
                System.out.println("Valor Numerico no puede ser menor a 0");
                System.out.println("Ingrese nuavamente el dato");
                numeroValido = input.nextInt();
            }
        } while (numeroValido < LIMITE);

        return numeroValido;
    }//Fin de la funcion ValidacionNumerica
    
    public static void ResultadoFactura(double sub, double des, double imp, double tot){
        
        System.out.printf("\nSubtotal: %.2f", sub);
        System.out.printf("\nDescuento: %.2f", des);
        System.out.printf("\nImpuesto: %.2f", imp);
        System.out.printf("\nPrecio a Pagar: %.2f", tot);
    }
    
}//Fin de Class
