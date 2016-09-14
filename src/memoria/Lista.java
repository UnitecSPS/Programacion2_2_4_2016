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
public class Lista {
    private Nodo inicio = null;
    private int size = 0;
    
    public boolean isEmpty(){
        return inicio == null;
    }
    
    /**
     * Agrega un objeto Nodo al final de la lista
     * @param obj El objeto a agregar
     */
    public void add(Nodo obj){
        if(obj == null)
            return;
        
        if(isEmpty()){
            inicio = obj;
        }
        else{
            Nodo tmp = inicio;
            
            while(tmp.siguiente != null){
                tmp = tmp.siguiente;
            }
            
            tmp.siguiente = obj;
        }
        size++;
    }
    
    public void print(){
        Nodo tmp = inicio;
        while(tmp != null){
            System.out.println(tmp);
            tmp = tmp.siguiente;
        }
    }
    
    /**
     * Retorno el objeto Nodo que coincida con el codigo que
     * se recibe
     * @param codigo
     * @return El objeto encontrado o null si no.
     */
    public Nodo get(int codigo){
        Nodo tmp = inicio;
        while(tmp != null){
            if(tmp.codigo == codigo)
                return tmp;
            tmp = tmp.siguiente;
        }
        return null;
    }
    
    /**
     * Se apoya del get para saber si el Nodo con ese codigo
     * existe o no.
     * @param codigo
     * @return True si el Nodo existe o false si no.
     */
    public boolean contains(int codigo){
        return get(codigo) != null;
    }
    
    /**
     * Remueve los elementos Nodo de la lista cuyo codigo se
     * igual al que se recibe
     * @param codigo
     * @return True si lo pudo borrar o false si no.
     */
    public boolean remove(int codigo){
        if(!isEmpty()){
            if(inicio.codigo == codigo){
                inicio = inicio.siguiente;
                size--;
                return true;
            }
            else{
                Nodo tmp = inicio;
                while(tmp.siguiente != null){
                    if(tmp.siguiente.codigo == codigo){
                        tmp.siguiente = tmp.siguiente.siguiente;
                        size--;
                        return true;
                    }
                    tmp = tmp.siguiente;
                }
            }
        }
        return false;
    }
    
    /**
     * Retorna la cantidad de Nodos que tiene la lista
     * @return 
     */
    public int size(){
        return size;
    }
    
    /**
     * Agrega un nuevo nodo en la posicion que se recibe, los
     * demas nodos se corren. 
     * @param index Posicion a agregar
     * @param obj Nodo a agregar
     * @throws IndexOutOfBoundsException Si el index es 
     *   > size de la lista
     */
    public void add(int index, Nodo obj){
        if(obj == null)
            return;
        
        if(index > size){
            throw new IndexOutOfBoundsException("Posicion "+
                    index+" invalida");
        }
        
        if(index == 0){
            obj.siguiente = inicio;
            inicio = obj;
            size++;
        }
        else{
            int pos=0;
            Nodo tmp = inicio;
            while(pos < index-1){
                tmp = tmp.siguiente;
                pos++;
            }
            
            obj.siguiente = tmp.siguiente;
            tmp.siguiente = obj;
            size++;
        }
    } 
}
