/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import errores.InvalidAmountException;

/**
 *
 * @author Aula
 */
public class Ficohsa {
    public static void main(String[] args) {
        //upcasting
        CuentaBancaria ca = new CuentaAhorro(1,"Frances","Lps");
        
        try{
            ca.depositar(-50);
            System.out.println(ca);
        }
        catch(InvalidAmountException e){
            System.out.println(e);
        }
        
        if(ca instanceof CuentaAhorro)
            System.out.println("duh! si soy de Ahorro asi me llamo");
        if(ca instanceof CuentaBancaria)
            System.out.println("Ahh si! Es porque heredo de ella");
        
        
        //downcasting indirecto
        CuentaAhorro cah = (CuentaAhorro)ca;
        System.out.println("Esta Activa: "+ cah.isActiva());
        //cah.setTasa(0.09);
        System.out.println(ca);
    }
}
