/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.binarios;

import java.util.Date;

/**
 *
 * @author jrmartinez
 */
public class Email {
    public long byteInicio;
    public String sender, subject;
    public Date date;
    public boolean leido;

    public Email(long byteInicio, String sender, String subject, long date, boolean leido) {
        this.byteInicio = byteInicio;
        this.sender = sender;
        this.subject = subject;
        this.date = new Date(date);
        this.leido = leido;
    }
    
    @Override
    public String toString(){
        return byteInicio+"-"+date+"-"+sender+"-"+subject
                +(leido ? "-Leido":"-No Leido");
    }
}
