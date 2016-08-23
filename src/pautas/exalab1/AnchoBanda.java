/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exalab1;

/**
 *
 * @author andre
 */
public enum AnchoBanda {
    V256(15),V512(25),V1(35),V2(45),V5(55);
    private int price;

    private AnchoBanda(int price) {
        this.price = price;
    }

    public int price() {
        return price;
    }
    
    
    
}
