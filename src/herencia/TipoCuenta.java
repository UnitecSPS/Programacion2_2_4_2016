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
public enum TipoCuenta {
    AHORRO(0.02), PLAZO(0.05), CHEQUES(0);
    
    private double tasa;
    
    private TipoCuenta(double t){
        tasa = t;
    }
    
    public final double tasa(){
        return tasa;
    }
}
