/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 *
 * @author Mae Lindell
 */
public final class CuentaCheques extends CuentaBancaria {
    public CuentaCheques(int n,String c,String t){
        super(n,c,t);
        tipo = TipoCuenta.CHEQUES;
    }
    
    @Override
    public void quienSoy(){
        System.out.println("CuentaCheques Hija");
    }

    @Override
    public String toString() {
        return super.toString()+", chhequera # 1"; 
    }
    
    
}
