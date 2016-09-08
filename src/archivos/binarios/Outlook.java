/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.binarios;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class Outlook {
    static JavaMail mail = new JavaMail();
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        int op=0, sop;
        
        do{
            System.out.println("1- Agregar Usuario");
            System.out.println("2- Listar Usuarios Activos");
            System.out.println("3- Login");
            System.out.println("4- Salir");
            System.out.print("opcion: ");
            
            try{
                op = lea.nextInt();

                switch(op){
                    case 1:
                        addUser();
                        break;
                    case 2:
                        mail.listActiveUsers();
                        break;
                    case 3:
                        session();
                        break;
                    case 5:
                        mail.increaseSizeForUser(lea.next(), lea.nextLong());
                        break;
                }
            }
            catch(IOException e){
                System.out.println("Error en Archivo: "+e.getMessage());
            }
            catch(InputMismatchException e){
                System.out.println("Ingrese un valor valido");
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }while(op!=4);
    }

    private static void addUser()throws IOException {
        System.out.print("Nombre: ");
        String n = lea.next();
        System.out.print("Username: ");
        String u = lea.next();
        System.out.print("Password: ");
        String p = lea.next();
        System.out.print("Genero: MASCULINO o FEMENINO: ");
        Genero g = Genero.valueOf(lea.next());
        
        if(mail.addUser(new User(u, n, p, g)))
            System.out.println("USUARIO CREADO!\n\n");
        else
            System.out.println("USUARIO YA ESTA TOMADO\n\n");
    }

    private static void session() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
