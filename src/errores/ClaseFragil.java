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
public class ClaseFragil {
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        String x = null;
        System.out.println("Iniciando Main..."/*+x.length()*/);
        
        try{
            System.out.println("Iniciando Try---");
            foo();
            System.out.println("Finalizando Try----");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Por favor ingrese una posicion valida");
        }
        catch(InputMismatchException e){
            System.out.println("Por favor ingrese un entero");
        }
        catch(NumberFormatException e){
            System.out.println("El valor no es numero");
        }
        /*catch(Exception e){
            System.out.println("Sucedio un Error.."+e);
            e.printStackTrace();
            //System.out.println(e.getStackTrace()[0]);
        }*/
        finally{
            System.out.println("Cerrando todo...");
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
        String arr[] = {"0","10","hola",null};
        System.out.print("Posicion: ");
        
        //Puede Suceder un InputMismatch
        int pos = lea.nextInt();
        //Puede Sucer un ArrayIndexOutOfBound
        String valor = arr[pos];
        //Puede suceder un NullPointerExeption
        System.out.println("Longitud del valor: "+valor.length());
        //Puede Suceder un NumberFormatException
        int num = Integer.parseInt(valor);
        //Puede Sucer un Arithmetic
        System.out.println("Valor: "+ 10/num);
        System.out.println("Finalizando boo....");
    }
    
    
}
