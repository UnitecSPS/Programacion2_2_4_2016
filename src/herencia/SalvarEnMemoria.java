/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.util.ArrayList;

/**
 *
 * @author Aula
 */
public class SalvarEnMemoria implements SalvablePlus {
    ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
    
    @Override
    public void salvar(CuentaBancaria cb) {
        cuentas.add(cb);
    }

    @Override
    public CuentaBancaria getCuenta(int cod) {
        for(CuentaBancaria cb : cuentas){
            if(cb.getNumero() == cod)
                return cb;
        }
        return null;
    }
    
}
