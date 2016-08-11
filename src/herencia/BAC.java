/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Aula
 */
public class BAC {
    public static void main(String[] args) {
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
        
        //upcasting
        cuentas.add(new CuentaBancaria(1, "Jose", "LPS"));
        cuentas.add(new CuentaAhorro(2, "Mae", "LPS"));
        cuentas.add(new CuentaCheques(3, "Frances", "LPS"));
        cuentas.add(new CuentaPlazoFijo(4, "Boris", "LPS"));
        
        //imprimirlos
        for(CuentaBancaria cb : cuentas){
            
            if(cb instanceof CuentaPlazoFijo){
                ((CuentaPlazoFijo)cb).setPlazo(2020,10,10);
            }
            
            System.out.print("-"+cb+" ");
            cb.quienSoy();
            
            if(cb instanceof Serializable)
                System.out.println("Desmenuzando..."+cb.numero);
        }
    }
}
