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
public class Facebook extends SocialClass implements Comentable {
    private ArrayList<Comment> comments;
    
    public Facebook(String u){
        super(u);
        comments = new ArrayList<>();
    }

    @Override
    public void timeline() {
        System.out.println(username);
        for(int p=0; p < posts.size(); p++){
            System.out.println(posts.get(p));
            for(Comment co : comments){
                if(co.postId == p)
                    System.out.println("\t-"+co);
            }
        }
    }

    @Override
    public boolean addComment(int postId, String msg) {
        if(postId >= 0 && postId < posts.size()){
            comments.add( new Comment(postId, msg) );
            return true;
        }
        return false;
    }
    
    
}
