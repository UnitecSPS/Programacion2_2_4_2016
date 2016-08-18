/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.util.Calendar;

/**
 *
 * @author Aula
 */
public class CuentaBancaria {
    protected int numero;
    protected double saldo;
    protected TipoCuenta tipo;
    protected String cliente, moneda;
    protected Calendar apertura;
    
    public CuentaBancaria(int n, String c, String m){
        System.out.println("Llamaste al papa vea?");
        numero = n;
        cliente = c;
        moneda = m;
        saldo = 0;
        apertura = Calendar.getInstance();
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }


    public String getCliente() {
        return cliente;
    }

    public final String getTipo() {
        return moneda;
    }

    public final Calendar getApertura() {
        return apertura;
    }

    public void depositar(double m){
        saldo += m;
    }
    
    public boolean retirar(double m){
        if(m < saldo){
            saldo -= m;
            return true;
        }
        return false; 
    }
    
    public void quienSoy(){
        System.out.println("CuentaBancaria Padre");
    }

    @Override
    public String toString() {
        return "numero=" + numero + ", cliente=" + cliente +
                ", saldo= Lps." + saldo + ", tipo=" + tipo;
    }
    
    public void registrarIntereses(){
        //1- Saca el monto de interes para sumarlo al saldo
        //  - Monto = tasa de intereses * el saldo
    }
}
