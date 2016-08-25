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
public class Bus {
    private boolean asientos[] = {true,false, true, false};
    
    public void vender(int asi){
        if(!asientos[asi])
            asientos[asi] = true;
        else
            throw new AsientoOcupadoException(asi);
    }
}
