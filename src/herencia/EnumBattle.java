/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class EnumBattle {
    public static void main(String[] args) {
        TipoCuenta tipo = TipoCuenta.CHEQUES;
        TipoCuentaClass tipo2 = TipoCuentaClass.CHEQUES;
        
        //compararlo
        if(tipo == TipoCuenta.CHEQUES)
            System.out.println("Si tipo es de Cheques");
        
        if(tipo2 == TipoCuentaClass.CHEQUES)
            System.out.println("Si es de Cheques");
        
        //name
        System.out.println("Tipo: "+tipo+" name: "+tipo.name());
        System.out.println("Tipo2: "+tipo2+" name: "+tipo2.name());
        
        //ordinal
        System.out.println("Ordinal del tipo: "+tipo.ordinal());
        System.out.println("Ordinal del tipo2: "+tipo2.ordinal());
        
        //values
        System.out.println("Values de TipoCuenta: ");
        for(TipoCuenta tc : TipoCuenta.values())
            System.out.println("\t-"+tc);
        System.out.println("Values de TipoCuentaClass: ");
        for(TipoCuentaClass tc : TipoCuentaClass.values())
            System.out.println("\t-"+tc);
        
        //Ingresar del teclado
        Scanner lea =new Scanner(System.in);
        tipo = TipoCuenta.valueOf(lea.next());
        System.out.println("Tipo Ingresado: "+tipo+" name: "+tipo.name());
        tipo2 = TipoCuentaClass.valueOf(lea.next());
        System.out.println("Tipo2 Ingresado: "+tipo2+" name: "+tipo2.name());
        
        //atributos extras
        System.out.println("Tasa del tipo: " + tipo.tasa());
        System.out.println("Tasa del tipo2: " + tipo2.tasa());
    }
}
