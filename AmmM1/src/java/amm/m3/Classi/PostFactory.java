package amm.m3.Classi;

import java.util.ArrayList;

public class PostFactory {
    
    private static PostFactory singleton;
    
    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }
    
    private ArrayList<Post> postList = new ArrayList<Post>();
    
    private PostFactory() {
        //Creazione Post
        
        //Kermit1
        Post post1 = new Post();
        post1.setId(1);
        post1.setCreatorId(1); /*Kermit The Frog: id=1*/
        post1.setText("I just got called from Sony to appear in a brand new videogame: Knack 2.");
        post1.setImage("");
        
        //Kermit2
        Post post2 = new Post();
        post2.setId(2);
        post2.setCreatorId(1); /*Kermit The Frog: id=1*/
        post2.setText("Let's goooooooooo");
        post2.setImage("img/post_2.gif");
        
        //Hollywood1
        Post post3 = new Post();
        post3.setId(3);
        post3.setCreatorId(-1); /*Group Hollywood: id=-1*/
        post3.setText("");
        post3.setImage("img/hollywood.jpg");

        //Robin Williams
        Post post4 = new Post();
        post4.setId(2);
        post4.setCreatorId(3); /*Robin Williams: id=3*/
        post4.setText("Great experience!");
        post4.setImage("img/genie.jpg");
        
    }
    
    Post getPostById(int id) {
        for (Post post : this.postList) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }
    
    ArrayList<Post> getPostList (User usr) {       
        int id = usr.getId();
        ArrayList<Post> returnlist = new ArrayList<>();
        for(Post post : this.postList) {
                if(post.getCreatorId() == usr.getId())
                    returnlist.add(post);
            }
        return returnlist;
    }
    
    ArrayList<Post> getPostList (Group gruppo) {       
        int id = gruppo.getId();
        ArrayList<Post> returnlist = new ArrayList<>();
        for(Post post : this.postList) {
                if(post.getCreatorId() == gruppo.getId())
                    returnlist.add(post);
            }
        return returnlist;
    }
    
}