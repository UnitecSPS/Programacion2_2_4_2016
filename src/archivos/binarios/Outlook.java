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
        lea.useDelimiter("\n");
        
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
        System.out.println("Username: ");
        String u = lea.next();
        System.out.println("Password: ");
        String p = lea.next();
        
        if(mail.login(u, p)){
            System.out.println("Bienvenido "+u+"!!\n");
            subMenuUser();
        }
        else{
            System.out.println("Usuario invalido\n");
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
        char op='a';
        
        do{
            System.out.println("a) Mirar Inbox");
            System.out.println("b) Mandar Correo");
            System.out.println("c)Leer Correo");
            System.out.println("d) Cancelar mi Correo");
            System.out.println("e) Log Out");
            System.out.print("Opcion: ");
            
            try{
                op = lea.next().charAt(0);
                
                if(op=='a'){
                    //inbox
                    System.out.println("Opcion NORMAL, FAVORITE o SPAM?: ");
                    InboxOption option = InboxOption.valueOf(lea.next().toUpperCase());
                    mail.showMyInbox(option);
                }
                else if(op=='b'){
                    //mandar correo
                    System.out.print("To: ");
                    String to = lea.next();
                    System.out.print("Subject: ");
                    String sub = lea.next();
                    System.out.println("Contenido: ");
                    String cont = lea.next();
                    System.out.print("Numero de Attachments: ");
                    int atta = lea.nextInt();
                    
                    mail.sendEmailTo(to, sub, cont, atta);
                }
                else if(op=='c'){
                    //leer correo
                    System.out.println("Codigo (byte inicio): ");
                    mail.readEmail(lea.nextLong());
                }
                else if(op=='d'){
                    //cancelar correo
                    System.out.println("Desea cancelar su cuenta?: ");
                    if(lea.next().equalsIgnoreCase("SI")){
                        mail.cancelMyAccount();
                        break;//parar ciclo
                    }
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }while(op!='e');
    }
}
