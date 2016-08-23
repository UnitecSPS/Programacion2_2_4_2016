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
public abstract class Servicio {
    protected String nombre;
    protected int codigo;

    public Servicio(String n, int c) {
        this.nombre = n;
        this.codigo = c;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+" Codigo: "+codigo;
    }
    
    public abstract double getMontoMensual();

    public final String getNombre() {
        return nombre;
    }

    public final int getCodigo() {
        return codigo;
    }
    
    
}
