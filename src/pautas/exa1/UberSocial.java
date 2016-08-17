/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exa1;

import java.util.ArrayList;

/**
 *
 * @author Aula
 */
public class UberSocial {
    private ArrayList<SocialClass> cuentas = new ArrayList<>();
    
    public SocialClass buscar(String u){
        return buscar(u,0);
    }

    private SocialClass buscar(String u, int pos) {
        if(pos < cuentas.size()){
            SocialClass sc = cuentas.get(pos);
            if(sc.username.equals(u))
                return sc;
            return buscar(u,pos+1);
        }
        return null;
    }
    
    public void agregarCuenta(String user, TipoSocial tipo){
        if(buscar(user) == null){
            if(tipo == TipoSocial.FACEBOOK)
                cuentas.add( new Facebook(user) );
            else
                cuentas.add( new Twitter(user) );
        }
    }
    
    public void agregarAmigo(String u1, String u2){
        SocialClass user1 = buscar(u1);
        SocialClass user2 = buscar(u2);
        
        if(user1 != null && user2 != null){
            if(user1 instanceof Facebook && user2 instanceof Facebook){
                user1.addFriend(u2);
                user2.addFriend(u1);
            }
            else if(user1 instanceof Twitter && user2 instanceof Twitter){
                user1.addFriend(u2);
            }
        }
    }
    
    public void agregarComment(String user, int postId, String comm){
        SocialClass sc = buscar(user);
        if(sc instanceof Facebook){
            ((Facebook)sc).addComment(postId, comm);
        }
    }
    
    public void agregarPost(String u, String post){
        SocialClass sc = buscar(u);
        if(sc != null)
            sc.addPost(post);
    }
}
