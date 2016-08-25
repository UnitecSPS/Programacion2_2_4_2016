/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errores.prueba3;

import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class Terminal {
    static Bus bus = new Bus();
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        do{
            try{
                System.out.print("Asiento: ");
                bus.vender(lea.nextInt());
                break;
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Por favor Ingrese un asiento Correcto");
            }
            catch(AsientoOcupadoException e){
                System.out.println(e.getMessage());
            }
        }while(true);
    }
}
