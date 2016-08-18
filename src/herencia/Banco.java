/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 *
 * @author Aula
 */
public class Banco {
    //atributo Salvable instanciado con Salvar en memoria
    private Salvable manager;
    
    public Banco(){
        manager = new SalvarEnMemoria();
    }
    
    /**
     * Agregar una cuenta, validando que el num
     * sea unico
     * @param num Numero
     * @param cli Cliente
     * @param mo    Moneda
     * @param tipo Tipo Cuenta
     */
    public void addCuenta(int num, String cli, String mo, TipoCuenta tipo){
        
    }
}
