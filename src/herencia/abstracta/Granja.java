/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia.abstracta;

import java.util.ArrayList;

/**
 *
 * @author Aula
 */
public class Granja {
    public static void main(String[] args) {
        ArrayList<Animal> animales = new ArrayList<>();
        
        animales.add(new Perro());
        animales.add(new Gato());
        animales.add(new Gallo());
        animales.add(new Pollito());
        animales.add(new Colibri());
        
        Animal am = new Animal(8){
            public void invento(){
                System.out.println("Guiri Guiri Guiri");
            }
            
            @Override
            public void hablar(){
                invento();
            }
            
            @Override
            public void comer(){
                System.out.println("Galletas");
            }
        };
        animales.add(am);

        Animal am2 = new Animal(5) {

            @Override
            public void hablar() {
                System.out.println("Hyui Hyui Hyui");
            }

            @Override
            public void comer() {
                System.out.println("Carne y Leche");
            }
        };
        animales.add(am2);
        
        //agreguen un tercer animal
        Perro perruno = new Perro(){
            @Override
            public void hablar(){
                System.out.println("Woof Woof");
            }
        };
        animales.add(perruno);
        
        for(Animal ani : animales){
            System.out.println("----------");
            ani.hablar();
            System.out.print("Que comes?: ");
            ani.comer();
        }
    }
}
