/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia.tg2;

import java.util.Calendar;

/**
 *
 * @author Aula
 */
public class Empleado {
    public static final int VERSION = 9;
    protected int codigo;
    protected String nombre;
    protected double salario;
    protected Calendar contratacion;

    public Empleado(int codigo, String nombre, double salario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.salario = salario;
        contratacion = Calendar.getInstance();
    }

    public int getCodigo() {
        return codigo;
    }
    
    public double pago(){
        return salario - (salario*0.035);
    }
    
    @Override
    public String toString(){
        return codigo+"-"+nombre+" Lps."+salario;
    }
}
