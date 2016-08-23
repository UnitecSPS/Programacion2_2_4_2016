/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exalab1;

/**
 *
 * @author andre
 */
public class InternetService extends Servicio {
    AnchoBanda ancho;

    public InternetService(String n, int c, AnchoBanda a) {
        super(n, c);
        this.ancho = a;
    }

    @Override
    public double getMontoMensual() {
        return ancho.price();
    }

    @Override
    public String toString() {
        return super.toString()+" Ancho de Banda: "+ancho;
    }
    
    
    
}
