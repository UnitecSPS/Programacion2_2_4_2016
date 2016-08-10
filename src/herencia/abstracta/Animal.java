/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia.abstracta;

/**
 *
 * @author Aula
 */
public abstract class Animal {
    protected int patas;

    public Animal(int patas) {
        this.patas = patas;
    }

    public final int getPatas() {
        return patas;
    }
    
    public abstract void hablar();
    public abstract void comer();
}
