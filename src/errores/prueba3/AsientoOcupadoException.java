/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errores.prueba3;

/**
 *
 * @author Aula
 */
public class AsientoOcupadoException extends RuntimeException {
    public AsientoOcupadoException(int asi){
        super("Asiento "+asi+" ya esta ocupado");
    }
}
