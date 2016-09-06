/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.binarios;

/**
 *
 * FORMATOS:
 * 
 * javamail/users.jml
 * -------------------
 * String username
 * String Nombre
 * String password
 * long fecha
 * double size
 * char genero
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
 */
public class JavaMail {
    public static final double MAX_PER_INBOX = 500;
}
