/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class FileTest {
    public static void main(String[] args) {
        MiFile mf = new MiFile();
        Scanner lea = new Scanner(System.in);
        
        int op=0;
        
        do{
            System.out.println("1- Set Archivo/Folder");
            System.out.println("2- Ver Informacion");
            System.out.println("3- Crear Archivo");
            System.out.println("10- Salir");
            System.out.print("Escoja Opcion: ");
            
            try{
                op = lea.nextInt();
                
                switch(op){
                    case 1:
                        System.out.print("Direccion: ");
                        mf.setFile(lea.next());
                        break;
                    case 2:
                        mf.info();
                        break;
                    case 3:
                        if( mf.crear() )
                            System.out.println("SE CREO!");
                        else
                            System.out.println("NO SE CREO!");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Ingrese una opcion valida");
                lea.next();
            }
            catch(NullPointerException e){
                System.out.println("Porfavor Seleccione primero la opcion 1");
            }
            catch(IOException e){
                System.out.println("Error: "+e.getMessage());
            }
        }while(op!=10);
    }
}
