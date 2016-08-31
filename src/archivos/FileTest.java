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
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        MiFile mf = new MiFile();
        int op=0;
        
        do{
            System.out.println("1- Set Archivo/Folder");
            System.out.println("2- Ver Informacion");
            System.out.println("3- Crear Archivo");
            System.out.println("4- Crear un directorio");
            System.out.println("5- Borrar");
            System.out.println("6- Renombrar");
            System.out.println("7- Dir");
            System.out.println("8- Tree");
            System.out.println("9- Escribir un texto");
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
                        break;
                    case 4:
                        if( mf.crearDir() )
                            System.out.println("SE CREO!");
                        else
                            System.out.println("NO SE CREO!");
                        break;
                    case 5:
                        if( mf.borrar() )
                            System.out.println("SE BORRO");
                        else
                            System.out.println("NO SE BORRO!");
                        break;
                    case 6:
                        System.out.println("TODO: rename");
                        System.out.println("Con la ayuda de la funcion de File renameTo");
                        break;
                    case 7:
                        mf.dir();
                        break;
                    case 8:
                        mf.tree();
                    case 9:
                        System.out.print("Append: ");
                        mf.writeText(lea.next().equalsIgnoreCase("SI"));
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
