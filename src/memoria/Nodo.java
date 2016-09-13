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
public class Nodo {
    public int codigo;
    public String nombre;
    public Nodo siguiente;

    public Nodo(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        siguiente = null;
    }

    @Override
    public String toString() {
        return "Nodo{" + "codigo=" + codigo + ", nombre=" + nombre + '}';
    }
    
    
}
