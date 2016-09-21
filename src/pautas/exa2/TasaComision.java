/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exa2;

/**
 *
 * @author Aula
 */
public enum TasaComision {
    NORMAL(0.03), TEMPORAL(0.01), VIP(0.05);
    
    double tasa;
    
    private TasaComision(double t){
        tasa = t;
    }
}
