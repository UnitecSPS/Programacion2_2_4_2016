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
public class Bancatlan {
    public static void main(String[] args) {
        Salvable salva = new SalvarEnArchivo();
        
        salva.salvar(new CuentaAhorro(2, "Mae", "LPS"));
        salva.salvar(new CuentaPlazoFijo(3, "Monique", "LPS"));
        
        if(salva.getCuenta(3)!=null)
            System.out.println("Encontre la cuenta!");
    }
}
