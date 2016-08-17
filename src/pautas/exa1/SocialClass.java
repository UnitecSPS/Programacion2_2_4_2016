/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exa1;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Aula
 */
public abstract class SocialClass {
    protected ArrayList<String> friends;
    protected ArrayList<Post> posts;
    protected String username;
    
    public SocialClass(String u){
        username = u;
        friends = new ArrayList<>();
        posts = new ArrayList<>();
    }
    
    public boolean addFriend(String u){
        if(!friends.contains(u) && !u.equals(username)){
            friends.add(u);
            return true;
        }
        return false;
    }
    
    public void addPost(String msg){
        posts.add(new Post(msg, Calendar.getInstance()));
    }
    
    public abstract void timeline();
}
