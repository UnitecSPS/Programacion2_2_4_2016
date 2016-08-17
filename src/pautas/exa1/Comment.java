/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exa1;

/**
 *
 * @author Aula
 */
public class Comment {
    public int postId;
    public String mensaje;

    public Comment(int postId, String mensaje) {
        this.postId = postId;
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return mensaje;
    }
    
    
}
