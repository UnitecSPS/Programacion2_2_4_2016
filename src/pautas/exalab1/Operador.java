/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exalab1;

import java.util.Scanner;

/**
 *
 * @author andre
 */
public class Operador {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        Sky d = new Sky();
        do{
            System.out.println("1. Agregar");
            System.out.println("2. Imprimir");
            System.out.println("3. Agregar canales a un plan");
            System.out.println("4. Cobrar");
            System.out.println("5. Salir");
            switch(x.nextInt()){
                case 1:
                    System.out.println("Ingrese nombre:");
                    String n = x.next();
                    System.out.println("Ingrese codigo:");
                    int c = x.nextInt();
                    System.out.println("Ingrese tipo de servicio Internet o tv:");
                    String g = x.next();
                    d.agregarServicio(c, n, TipoServicio.valueOf(g));
                    break;
                case 2:
                    d.imprimirServicios();
                    break;
                case 3:
                    System.out.println("Ingrese codigo:");
                    int co = x.nextInt();
                    System.out.println("Ingrese canal:");
                    String ca = x.next();
                    d.agregarCanalAServicioTV(co, ca);
                    break;
                case 4:
                    System.out.println("Ingrese codigo:");
                    int cob = x.nextInt();
                    d.cobrar(cob);
                    break;
                    
            }
            System.out.println("Si dessear salir presione 5");
        }while(x.nextInt() != 5);
    }
    
}
