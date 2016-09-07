/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.binarios;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
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
    private boolean userInFile(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
