/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.binarios;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 *
 * @author Aula
 */
public class User {
    public String username, name, password;
    public Genero genero;

    public User(String username, String name, String password, Genero genero) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + "@javamail.com, name=" + name + '}';
    }
    
    public RandomAccessFile getInboxFile() throws FileNotFoundException{
        String path = JavaMail.ROOT+"/"+username+"_inbox.jml";
        return new RandomAccessFile(path, "rw");
    }
    
}
