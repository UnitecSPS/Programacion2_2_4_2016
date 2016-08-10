/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.util.Calendar;

/**
 *
 * @author Mae Lindell
 */
public final class CuentaPlazoFijo extends CuentaBancaria {
     private Calendar findePlazo;
     private double intereses;
    
    public CuentaPlazoFijo(int n,String c,String t){
        super(n,c,t);
        intereses = 0;
        findePlazo = Calendar.getInstance();
    }
    
    public void setPlazo(int y, int m, int d) {
        findePlazo.set(y,m-1,d);
    }
    
    @Override
    public void quienSoy(){
        System.out.println("CuentaPlazoFijo Hija");
    }

    @Override
    public String toString() {
        return super.toString()+", finPlazo"+findePlazo.getTime();
    }

    @Override
    public boolean retirar(double m) {
         if(m < intereses){
            intereses -= m;
            return true;
        }
        return false; 
    }
    
    
}
