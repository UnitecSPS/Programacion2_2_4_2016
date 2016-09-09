/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.binarios;

import static archivos.binarios.InboxOption.FAVORITE;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * FORMATOS:
 * 
 * javamail/codes.jml
 * -------------------
 * int numero
 * 
 * javamail/users.jml
 * -------------------
 * int cod
 * String username
 * String Nombre
 * String password
 * String genero
 * long fecha
 * long size
 * boolean activo
 * 
 * javamail/username_inbox.jml
 * -------------------------------
* long fecha
 * String sender
 * String subject
 * String content
 * int attachments
 * boolean favorito
 * boolean spam
 * boolean leido
 * boolean borrado 
 */
public class JavaMail {
    public static final long MAX_PER_INBOX = 104857600;
    public static final String ROOT = "javamail";
    private RandomAccessFile rCods, rUsers;
    public User currentUser = null;
    public ArrayList <Email> array= new ArrayList<>();
    
    public JavaMail(){
        try{
            //1-Aseguremos que el folder javamail exista
            new File(ROOT).mkdir();
            //2- Instanciemos mis RandomAccessFiles
            rCods = new RandomAccessFile(ROOT+"/codes.jml", "rw");
            rUsers = new RandomAccessFile(ROOT+"/users.jml", "rw");
            //3- Asegurarnos que el archivo de codigos comienze en 0
            initCodes();
        }
        catch(IOException e){
            System.out.println("No deberia de caer aqui");
        }
    }

    /**
     * SI codes.jml es NUEVO, escribir un 0
     */
    private void initCodes()throws IOException {
        if(rCods.length() == 0){
            rCods.writeInt(0);
        }
    }
    
    /**
     * Extraer el codigo que tiene guardado:
     *  sumarle 1, actualizar el archivo y retornarlo
     * @return Codigo Secuencial para el usuario
     * @throws IOException 
     */
    private int getCodigo()throws IOException{
        rCods.seek(0);
        int code = rCods.readInt()+1;
        rCods.seek(0);
        rCods.writeInt(code);
        return code;
    }
    
    public boolean addUser(User u)throws IOException{
        if(!userInFile(u.username)){
            //codigo
            rUsers.writeInt(getCodigo());
            //username
            rUsers.writeUTF(u.username);
            //nombre
            rUsers.writeUTF(u.name);
            //password
            rUsers.writeUTF(u.password);
            //genero
            rUsers.writeUTF(u.genero.name());
            //fecha
            rUsers.writeLong(new Date().getTime());
            //size
            rUsers.writeLong(0);
            //activo
            rUsers.writeBoolean(true);
            return true;
        }
        return false;
    }

    /**
     * Buscar si existe un usuario en el archivo con ese
     * username (OJO si activo esta en false, es como que
     *  no existiera).
     *  - El puntero SI existe lo dejaremos justo despues
     *    de haber leido el dato del username
     * @param username username
     * @return true si existe o false si no.
     */
    private boolean userInFile(String username)throws IOException {
        rUsers.seek(0);
        
        while(rUsers.getFilePointer() < rUsers.length()){
            //esquivar el codigo
            rUsers.skipBytes(4);
            //username
            String u = rUsers.readUTF();
            //posicion despues del dato username
            long pos = rUsers.getFilePointer();
            //avanzamos hasta el boolean
            rUsers.readUTF();//name
            rUsers.readUTF();//password
            rUsers.readUTF();//genero
            rUsers.skipBytes(16);//fecha+size
            if(rUsers.readBoolean() && u.equals(username)){
                //lo dejamos despues del username
                rUsers.seek(pos);
                return true;
            }
        }
        return false;
    }
    
    public boolean increaseSizeForUser(String username,long size)throws IOException{
        if(userInFile(username)){
            rUsers.readUTF();
            rUsers.readUTF();
            rUsers.readUTF();
            rUsers.readLong();
            long s = rUsers.readLong()+size;
            
            if(s <= MAX_PER_INBOX){
                rUsers.seek(rUsers.getFilePointer()-8);
                rUsers.writeLong(s);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Imprime COD-Username-Name-Genero-Size de todos los
     * usuarios activos
     * @throws IOException 
     */
    public void listActiveUsers()throws IOException{
       rUsers.seek(0);
       System.out.println("\n\nActive Users\n---------------");
       while(rUsers.getFilePointer() < rUsers.length()){
           int cod = rUsers.readInt();
           String user = rUsers.readUTF()+"@javamail.com";
           String nom = rUsers.readUTF();
           rUsers.readUTF();
           String g = rUsers.readUTF();
           rUsers.readLong();
           long size = rUsers.readLong();
           if(rUsers.readBoolean()){
               System.out.println(cod+"-"+user+"-"+nom+"-"+g+
                       " Inbox size: "+size+" bytes.");
           }
       }
    }
    
    /**
     * 1- Busca si existe un usuario con ese username, si existe se comprueba 
     * que el password es el correcto. 
     * SI lo Es:
     *  - Inicializa el atributo currentUser con los datos de dicho usuario.
     *  - Retorna true
     * SI NO lo es:
     *  - Retornar false
     * @param username
     * @param password
     * @return True si el usuario es correcto o false si no.
     */
    public boolean login(String username, String password){
        return false;
    }
    
    /**
     * 2- Imprime el Inbox del Current User, si el currentUser esta null, se
     * deja propagar el NullPointerException.
     *  a) Se utiliza el archivo de emails del currentUser
     *  b) Se recorre dicho archivo para ir formando objetos Email con los datos
     *    requeridos y guardandolos en un ArrayList de tipo Email creado.
     *    PERO OJO solo que no esten marcados como borrado y: 
     *      * Si el option es NORMAL: Solo se toman en cuenta los emails que NO son spam
     *      * Si el option es FAVORITE: Solo se toman en cuenta los emails favoritos
     *      * Si el option es SPAM: Solo se toman en cuenta los emails Spam.
     *  c) Se muestra los datos del currentUser (utilizar su toString)
     *  d) Se imprime todos los objetos emails agregados al ArrayList desde el
     *     ultimo hasta el primero para que se miren de recientes a viejos.
     *  e) Se imprime cuentos emails estan sin leer y cuantos leidos.
     */
    public void showMyInbox(InboxOption option) throws IOException{
        System.out.println("\n\nShow my Inbox\n---------------");
        int c = 0,b= 0;       
        if(currentUser != null){
            RandomAccessFile inbox = currentUser.getInboxFile();
            inbox.seek(0);
            while(rUsers.getFilePointer() < rUsers.length()){
                long fecha = inbox.readLong();
                String sender = inbox.readUTF();
                String subject = inbox.readUTF();
                inbox.readUTF();
                inbox.readInt();
                boolean favoritos = inbox.readBoolean(); 
                boolean leido = inbox.readBoolean();
                    if(leido)
                        c++;
                    else
                        b++;
                boolean spam = inbox.readBoolean();
                inbox.readBoolean();

                switch(option){
                    case NORMAL:                                                      
                        if(!leido){
                            array.add(new Email(0,sender,subject,fecha,leido));
                        }                            
                      break;
                    case FAVORITE:                           
                        if(favoritos)
                            array.add(new Email(0,sender,subject,fecha,leido));
                        break;                            
                    case SPAM:
                        if(spam)
                            array.add(new Email(0,sender,subject,fecha,leido));    
                        break;                           
                }

            }
            currentUser.toString();
            for(Email a:array){
                System.out.println(""+a.byteInicio + a.date + a.leido + a.sender + a.subject);
            }
            System.out.println("Leidos= "+c+" , No leidos= "+b);

        }
    }
        
    
    
    /**
     * 3- Muestra todo el contenido de un email. Se recibe el byteInicio de dicho
     * email tal y como se muestra en el inbox.
     *      a) Se lee la informacion del email y se imprime completa siempre y
     *          cuando NO este marcado como borrado.
     *      b) Si se produce una exception (quiza por un byteInicio malo) mientras
     *          se esta leyendo, se deja propagar
     *          pro
     *      d) Se marca como leido
     *      c) Se llama el subMenuEmail y se le manda el byte de Inicio de los
     *          datos boolean.
     * @param byteInicio ByteInicio del correo dentro del archivo de emails
     */
    public void readEmail(long byteInicio){
        
    }
    
    /**
     * 4- Muestra un Sub menu con las opciones:
     *    CICLO MIENTRAS RESPUESTA es != 4
     *      1- Marcar/Desmarcar como Spam (dependiendo si esta true o no)
     *          Invierte el valor booleano del spam
     *      2- Marcar/Desmarcar como Favorito
     *          Invierte el valor booleano del favorito
     *      3- Borrar email
     *          Lo marca como borrado y termina el ciclo
     *      4- Regresar
     *          termina el ciclo
     * @param byteInicio 
     */
    public void subMenuEmail(long byteInicio){
        
    }
    
    /**
     * 5- Manda un correo a un usuario existente. El correo viene en el parametro
     *  receiver (Usar Split de String para extraer el username antes de la @
     *   a) Verificar que el usuario exista:
     *      - SI EXISTE:
     *        1- Formar un objeto User con sus datos necesarios.
     *        2- Sacar el tamaño del correo. Formula: (size de content + 2) + (attachments*3)
     *        3- Verificar con la funcion increaseSizeForUser de que soporte dicho correo.
     *           3.1 SI LO SOPORTA: Crear un nuevo registro en su archivo de correos con
     *                  los datos que recibe. Por default se toma la fecha del momento y todos
     *                  sus booleanos estan en false.
     *                  Retorna true
     *           3.2 Se indica el problema y se retorna false.
     *      - SI NO EXISTE:
     *        1- Se indica el problema y se retorna false.
     * @param receiver
     * @return 
     */
    public boolean sendEmailTo(String receiver, String subject, String content, int attachments){
        return false;
    }
    
    /**
     * 6- Funcion que marca al currentUser como un usuario borrado.
     *      a) Si todo se hizo bien, se llama logOut().
     * @param username
     * @return 
     */
    public void cancelMyAccount() throws IOException{
        if(userInFile(currentUser.username)){
            rUsers.readUTF();
            rUsers.readUTF();
            rUsers.readUTF();
            rUsers.skipBytes(16);
            rUsers.writeBoolean(false);
            logOut();
        }       
    }
    
    /**
     * 7- Asigna null al currentUser
     */
    public void logOut(){
        currentUser = null;
    }
}
