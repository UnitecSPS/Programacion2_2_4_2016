/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exa1;

import java.util.Calendar;

/**
 *
 * @author Aula
 */
public class Post {
    private Calendar fecha;
    private String mensaje;

    public Post(String mensaje, Calendar fecha) {
        this.fecha = fecha;
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return mensaje+"-"+fecha.getTime();
    }
    
    
}
