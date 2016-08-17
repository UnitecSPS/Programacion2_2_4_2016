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
public class TipoCuentaClass {
    public static final TipoCuentaClass AHORRO = new TipoCuentaClass("AHORRO",0,0.02);
    public static final TipoCuentaClass PLAZO = new TipoCuentaClass("PLAZO",1,0.05);
    public static final TipoCuentaClass CHEQUES = new TipoCuentaClass("CHEQUES",2,0);
    
    private String name;
    private int ordinal;
    private double tasa;
    
    public TipoCuentaClass(String n, int o, double t){
        name = n;
        ordinal = o;
        tasa = t;
    }

    public final String name() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    public final int ordinal(){
        return ordinal;
    }
    
    public final double tasa(){
        return tasa;
    }
    
    public static TipoCuentaClass[] values(){
        TipoCuentaClass array[] = { AHORRO, PLAZO, CHEQUES };
        return array;
    }
    
    public static TipoCuentaClass valueOf(String name){
        for(TipoCuentaClass tc : values()){
            if(tc.name.equals(name))
                return tc;
        }
        throw new IllegalArgumentException(name+" es invalido");
    }
}
