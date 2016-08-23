/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exalab1;

import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class TVService extends Servicio {
    private ArrayList<String> ca;
    private boolean isDigital;

    public TVService(String n, int c,boolean t) {
        super(n, c);
        ca = new ArrayList<>();
        isDigital = t;
    }

    @Override
    public double getMontoMensual() {
        return ca.size() * (isDigital ? 8 : 5);
    }
    
    public boolean agregarCanal(String canal){
        if(!ca.contains(canal)){
            ca.add(canal);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if(isDigital)
            return super.toString()+" el cable es digital";
        return super.toString()+" el cable no es digital ";
    }
    
    public void imprimir(){
        imprimir(0);
    }
    
    public void imprimir(int pos){
        if(pos < ca.size()){
            System.out.println("-"+ca.get(pos));
            imprimir(pos+1);
        }
    }
    
    
}
