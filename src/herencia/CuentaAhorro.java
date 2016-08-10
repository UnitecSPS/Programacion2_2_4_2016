/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.util.Calendar;

/**
 *
 * @author Aula
 */
public final class CuentaAhorro extends CuentaBancaria {
    private Calendar ultimoUso;
    
    public CuentaAhorro(int n, String c, String t){
        super(n,c,t);
        tasa = 0.05;
        refreshUltimoUso();
    }
    
    private void refreshUltimoUso(){
       ultimoUso = Calendar.getInstance(); 
    }
    
    public boolean isActiva(){
        Calendar hace6 = Calendar.getInstance();
        hace6.add(Calendar.MONTH, -6);
        return ultimoUso.after(hace6);
    }
    
    @Override
    public void quienSoy(){
        System.out.println("CuentaAhorro Hija");
    }
    
    @Override
    public String toString(){
        return super.toString()+", activa="+isActiva()+
                ", tasa="+tasa;
    }

    @Override
    public void depositar(double m) {
        if(isActiva()){
            super.depositar(m);
            refreshUltimoUso();
        }
    }

    @Override
    public boolean retirar(double m) {
        if(isActiva()){
            refreshUltimoUso();
            return super.retirar(m);
        }
        return false;
    }
    
    
    
    
}
