/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

/**
 *
 * @author Aula
 */
public class TestLista {
    public static void main(String[] args) {
        Lista list = new Lista();
        
        list.add(new Nodo(1,"Carlos"));
        list.add(new Nodo(2,"Jose"));
        list.add(new Nodo(3,"Alejandro"));
        list.add(new Nodo(4,"Boris"));
        list.print();
        
        if(list.contains(4))
            System.out.println("\nEncontre 4: "+list.get(4));
        System.out.println("Encontre 8?: "+list.contains(8));
        
        list.remove(1);
        list.remove(3);
        list.remove(8);
        System.out.println("\nDespues de los borrados:\n---------");
        list.print();
        
        list.add(0, new Nodo(5,"Frances"));
        list.add(2, new Nodo(6,"Celeste"));
        list.add(4, new Nodo(7,"Owen"));
        System.out.println("\nDespues de los agregados:\n---------");
        list.print();
        
        list.add(6,new Nodo(8,"NOO"));
        
    }
}
