/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errores;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class ValidarInput {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        
        do{
            try{
                System.out.print("Ingrese un valor: ");
                int x = lea.nextInt();
                break;
            }
            catch(InputMismatchException e){
                lea.nextLine();
                System.out.println("Por favor ingrese un entero");
            }
        }while(true);
    }
}
