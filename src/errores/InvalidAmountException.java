/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errores;

/**
 *
 * @author Aula
 */
public class InvalidAmountException extends Exception {
    
    public InvalidAmountException(double m){
        super(m+" no es valido.");
    }
}
