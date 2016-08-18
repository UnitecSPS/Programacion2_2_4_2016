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
public interface Salvable {
    int VERSION = 1;
    void salvar(CuentaBancaria cb);
    CuentaBancaria getCuenta(int cod);
    CuentaBancaria[] cuentas();
}
