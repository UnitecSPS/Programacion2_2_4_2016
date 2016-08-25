/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import errores.InvalidAmountException;
import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author Aula
 */
public final class CuentaAhorro extends CuentaBancaria implements Serializable {
    private Calendar ultimoUso;
    
    public CuentaAhorro(int n, String c, String t){
        super(n,c,t);
        tipo = TipoCuenta.AHORRO;
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
                ", tasa="+tipo.tasa();
    }

    @Override
    public void depositar(double m)throws InvalidAmountException {
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

    @Override
    public void registrarIntereses() {
        if(isActiva())
            super.registrarIntereses();
        else{
            double bajar = saldo>100 ? 100 : saldo;
            saldo -= bajar;
        }
    }
    
    
    
    
}
