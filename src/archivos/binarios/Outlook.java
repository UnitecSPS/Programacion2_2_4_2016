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
 * @author jrmartinez
 */
public class Outlook {
    static JavaMail mail = new JavaMail();
    static Scanner lea = new Scanner(System.in);
    static boolean r;
    
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

    /**
     * 1- Manda a llamar la funcion login del objeto mail y se confirma si
     * se pudo login o no.
     *  SI FUE EXITOSO:
     *      Se llama subMenuUser()
     */
    private static void session() throws IOException {
        if(mail.login(mail.currentUser.username,mail.currentUser.password )){
            mail.subMenuEmail(mail.pos);
        }
    }
    
    /**
     * 2- funcion que imprime un menu con las opciones que llama la funcion 
     * correspondiente de mail:
     *      a)Mirar mi Inbox. Pedir el InboxOption
     *      b)Leer un Correo
     *      c)Mandar Correo
     *      c)Cancelar mi correo
     *      d)Log Out
     * El ciclo termina cuando le dan cancelar mi correo o logout. 
     * Si recibe una excepcion, se atrapa y se muestra el mensaje.
     */
    private static void subMenuUser(){
        do{
        try{
            System.out.println("a)Mirar mi Inbox.");
            System.out.println("b)Leer un Correo");
            System.out.println("c)Mandar Correo");
            System.out.println("d)Cancelar mi correo");
            System.out.println("e)Log Out");
            
            String op= lea.next();
            switch(op){
                case "a":
                    System.out.println("NORMAL,FAVORITE,SPAM");
                    Genero opc = Genero.valueOf(lea.next());
                    break;
                case "b":
                    System.out.println("reciever,subject,content,attachments");
                    String rec = lea.next();
                    String sub = lea.next();
                    String cont = lea.next();
                    int attc = lea.nextInt();
                    mail.sendEmailTo(rec, sub, cont, attc);
                    break;
                case "c":
                    mail.cancelMyAccount();
                    r=true;
                    break;
                case "d":
                    r=true;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }while(r);
    }
}