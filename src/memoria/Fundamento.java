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
public class Fundamento {
    public static void main(String[] args) {
        int x = 5;
        int y = x;
        y = 6;
        System.out.println(x+"-"+y);
        
        Nodo a = new Nodo(1,"Carlos");
        Nodo b = a;
        
        b.nombre = "Jose";
        
        System.out.println(a);
        System.out.println(b);
        
        if( a == b )
            System.out.println("SI LO SON");
        
        String c1 = "hola";
        String c2 = "hola";
        
        if( c1 == c2 )
            System.out.println("SON IGUALES");
        else
            System.out.println("NO SON IGUALES");
    }
}
