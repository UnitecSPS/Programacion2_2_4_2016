/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.io.Serializable;

/**
 *
 * @author Aula
 */
public class SalvarEnArchivo implements SalvablePlus {

    @Override
    public void salvar(CuentaBancaria cb) {
        System.out.println(cb+" Salvada en archivo");
    }

    @Override
    public CuentaBancaria getCuenta(int cod) {
        System.out.println("Buscando en el archivo....");
        return null;
    }

    @Override
    public CuentaBancaria[] cuentas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
