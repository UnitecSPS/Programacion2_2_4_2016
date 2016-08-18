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
    
    /**
     * Deposita un monto a una cuenta existente
     * @param nume
     * @param monto 
     */
    public void depositar(int num, double monto){
        
    }
    
    /**
     * Retira de una cuenta existente
     * @param num Numero de Cuenta
     * @param monto Monto a Retirar
     * @return True si pudo retirar o False si no
     */
    public boolean retirar(int num, double monto){
        return false;
    }
    
    /**
     * Recorre todas las cuentas guardadas para
     * registrarle los intereses
     */
    public void registrarIntereses(){
        
    }
    
    /**
     * Busca una cuenta de Plazo Fijo, si existe
     * se actualiza su plazo
     * @param num Numero de Cuenta
     * @param y Año
     * @param m Mes (1-12)
     * @param d dia
     */
    public void setPlazoDeCuentaFija(int num, int y, int m, int d){
        
    }
}
