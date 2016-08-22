/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errores;

import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class ClaseFragil {
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Iniciando Main...");
        
        try{
            System.out.println("Iniciando Try---");
            foo();
            System.out.println("Finalizando Try----");
        }
        catch(Exception e){
            System.out.println("Sucedio un Error..");
        }
        
        System.out.println("Finalizando Main...");
    }

    private static void foo() {
        System.out.println("Iniciando foo...");
        boo();
        System.out.println("Finalizando foo...");
    }

    private static void boo() {
        System.out.println("Iniciando boo....");
        int arr[] = {1,0,5,2};
        System.out.print("Posicion: ");
        int pos = lea.nextInt();
        System.out.println("Valor: "+ arr[pos]);
        System.out.println("Finalizando boo....");
    }
    
    
}
