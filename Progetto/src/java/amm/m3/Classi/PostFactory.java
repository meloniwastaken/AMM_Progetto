package amm.m3.Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostFactory {

    private static PostFactory singleton;
    private String connectionString;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }

    private ArrayList < Post > postList = new ArrayList < Post > ();

    private PostFactory() {
        //Creazione Post

        //Kermit1
        Post post1 = new Post();
        post1.setId(1);
        post1.setCreatorUser(UserFactory.getInstance().getUserById(1)); /*Kermit The Frog: id=1*/
        post1.setDestinationUser(UserFactory.getInstance().getUserById(1)); /*Kermit The Frog: id=1*/
        post1.setText("I just got called from Sony to appear in a brand new videogame: Knack 2.");
        post1.setImage("");

        //Kermit2
        Post post2 = new Post();
        post2.setId(2);
        post2.setCreatorUser(UserFactory.getInstance().getUserById(1)); /*Kermit The Frog: id=1*/
        post2.setDestinationUser(UserFactory.getInstance().getUserById(1)); /*Kermit The Frog: id=1*/
        post2.setText("Let's goooooooooo");
        post2.setImage("img/post_2.gif");

        //Kermit3
        Post post3 = new Post();
        post3.setId(3);
        post3.setCreatorUser(UserFactory.getInstance().getUserById(1)); /*Kermit The Frog: id=1*/
        post3.setDestinationUser(UserFactory.getInstance().getUserById(1)); /*Kermit The Frog: id=1*/
        post3.setText("Yall know this aint tea been on hennessy for the past week");
        post3.setImage("");

        //Kermit4
        Post post4 = new Post();
        post4.setId(4);
        post4.setCreatorUser(UserFactory.getInstance().getUserById(1)); /*Kermit The Frog: id=1*/
        post4.setDestinationUser(UserFactory.getInstance().getUserById(1)); /*Kermit The Frog: id=1*/
        post4.setText("#NONEOFMYBUSINESS");
        post4.setImage("");

        //Robin Williams1
        Post post5 = new Post();
        post5.setId(5);
        post5.setCreatorUser(UserFactory.getInstance().getUserById(3)); /*Robin Williams: id=3*/
        post5.setDestinationUser(UserFactory.getInstance().getUserById(3)); /*Robin Williams: id=3*/
        post5.setText("In the process of looking for comedy, you have to be deeply honest. " +
            "And in doing that, you'll find out here's the other side. You'll be looking under the rock occasionally for the laughter.");
        post5.setImage("");

        //Robin Williams2
        Post post6 = new Post();
        post6.setId(6);
        post6.setCreatorUser(UserFactory.getInstance().getUserById(3)); /*Robin Williams: id=3*/
        post6.setDestinationUser(UserFactory.getInstance().getUserById(3)); /*Robin Williams: id=3*/
        post6.setText("Never pick a fight with an ugly person, they've got nothing to lose.");
        post6.setImage("");

        //Robin Williams3
        Post post7 = new Post();
        post7.setId(7);
        post7.setCreatorUser(UserFactory.getInstance().getUserById(3)); /*Robin Williams: id=3*/
        post7.setDestinationUser(UserFactory.getInstance().getUserById(3)); /*Robin Williams: id=3*/
        post7.setText("Great experience!");
        post7.setImage("img/genie.jpg");

        //Robin Williams4
        Post post8 = new Post();
        post8.setId(8);
        post8.setCreatorUser(UserFactory.getInstance().getUserById(3)); /*Robin Williams: id=3*/
        post8.setDestinationUser(UserFactory.getInstance().getUserById(3)); /*Robin Williams: id=3*/
        post8.setText("That's my daughter");
        post8.setImage("img/zelda.png");

        //Will Smith1
        Post post9 = new Post();
        post9.setId(9);
        post9.setCreatorUser(UserFactory.getInstance().getUserById(2));
        post9.setDestinationUser(UserFactory.getInstance().getUserById(2));
        post9.setText("I want the world to be better because I was here");
        post9.setImage("");

        //Will Smith2
        Post post10 = new Post();
        post10.setId(4);
        post10.setCreatorUser(UserFactory.getInstance().getUserById(2));
        post10.setDestinationUser(UserFactory.getInstance().getUserById(2));
        post10.setText("You can cry, ain't no shame in it");
        post10.setImage("");

        //Will Smith3
        Post post11 = new Post();
        post11.setId(11);
        post11.setCreatorUser(UserFactory.getInstance().getUserById(2));
        post11.setDestinationUser(UserFactory.getInstance().getUserById(2));
        post11.setText("");
        post11.setImage("img/prince.jpg");

        //Will Smith4
        Post post12 = new Post();
        post12.setId(12);
        post12.setCreatorUser(UserFactory.getInstance().getUserById(2));
        post12.setDestinationUser(UserFactory.getInstance().getUserById(2));
        post12.setText("https://www.youtube.com/watch?v=gZnronVFyDE Not half bad!");
        post12.setImage("");

        //Don Cheadle1
        Post post13 = new Post();
        post13.setId(13);
        post13.setCreatorUser(UserFactory.getInstance().getUserById(4));
        post13.setDestinationUser(UserFactory.getInstance().getUserById(4));
        post13.setText("Whoa");
        post13.setImage("img/warmachine.jpg");

        //Don Cheadle2
        Post post14 = new Post();
        post14.setId(14);
        post14.setCreatorUser(UserFactory.getInstance().getUserById(4));
        post14.setDestinationUser(UserFactory.getInstance().getUserById(4));
        post14.setText("I'm very critical of myself. I've yet to see a great performance from this kid. No, it's not comfortable; " +
            "I hate watching myself. You don't like when you hear your voice on your voicemail; imagine having to see yourself 30 feet wide and 30 feet big.");
        post14.setImage("");

        //Don Cheadle3
        Post post15 = new Post();
        post15.setId(15);
        post15.setCreatorUser(UserFactory.getInstance().getUserById(4));
        post15.setDestinationUser(UserFactory.getInstance().getUserById(4));
        post15.setText("[when asked by someone if they should be an actor], I'd say don't do it if you could anything " +
            "else do that and if you can be dissuaded by me saying that you shouldn't be doing this anyway, if you " +
            "want to really go after it your chances of making it are very very poor if you're a white male between " +
            "the ages of twenty to forty you got the best shot and after that it falls off the shelf that being " +
            "said obviously it can be done and many people have done it and you don't have to be good unfortunately " +
            "and we see that too but you have to be tenacious and have a never say die attitude and with all the " +
            "technology that's out now you can make a movie for two grand you can put yourself out there and package " +
            "yourself in the best light you see");
        post15.setImage("");

        //Don Cheadle4
        Post post16 = new Post();
        post16.setId(16);
        post16.setCreatorUser(UserFactory.getInstance().getUserById(4));
        post16.setDestinationUser(UserFactory.getInstance().getUserById(4));
        post16.setText("I've been doing this since I was 10 years old, inhabiting different people " +
            "and playing different roles. Thirty years later, there's still the same sort of " +
            "excitement I get from it. It's still fun to inhabit different characters and play " +
            "different things, so it's all in that panoply of acting.");
        post16.setImage("");

        postList.add(post1);
        postList.add(post2);
        postList.add(post3);
        postList.add(post4);
        postList.add(post5);
        postList.add(post6);
        postList.add(post7);
        postList.add(post8);
        postList.add(post9);
        postList.add(post10);
        postList.add(post11);
        postList.add(post12);
        postList.add(post13);
        postList.add(post14);
        postList.add(post15);
        postList.add(post16);

    }

    public Post getPostById(int id) {

        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                      "select * from post "
                    + "where id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                Post current = new Post();
                current.setId(res.getInt("id"));
                current.setCreatorUser(UserFactory.getInstance().getUserById(res.getInt("creatorId")));
                current.setDestinationUser(UserFactory.getInstance().getUserById(res.getInt("destinationId")));
                current.setText(res.getString("text"));
                current.setImage(res.getString("image"));
                stmt.close();
                conn.close();
                return current;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList < Post > getPostList(User user) {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                "SELECT post.id, post.creatorId, post.destinationId, post.text, post.image FROM post "
                + "INNER JOIN utente ON post.creatorId = utente.id "
                + "WHERE post.destinationId = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, user.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            ArrayList <Post> ret = new ArrayList<>();
            
            // ciclo sulle righe restituite
            while (res.next()) {
                Post current = new Post();
                current.setId(res.getInt("id"));
                current.setCreatorUser(UserFactory.getInstance().getUserById(res.getInt("creatorId")));
                current.setDestinationUser(UserFactory.getInstance().getUserById(res.getInt("destinationId")));
                current.setText(res.getString("text"));
                current.setImage(res.getString("image"));
                ret.add(current);
            }
            
            stmt.close();
            conn.close();
            return ret;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
        public ArrayList < Post > getCreatorPostList(User user) {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                "SELECT post.id, post.creatorId, post.destinationId, post.text, post.image FROM post "
                + "INNER JOIN utente ON post.creatorId = utente.id "
                + "WHERE post.creatorId = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, user.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            ArrayList <Post> ret = new ArrayList<>();
            
            // ciclo sulle righe restituite
            while (res.next()) {
                Post current = new Post();
                current.setId(res.getInt("id"));
                current.setCreatorUser(UserFactory.getInstance().getUserById(res.getInt("creatorId")));
                current.setDestinationUser(UserFactory.getInstance().getUserById(res.getInt("destinationId")));
                current.setText(res.getString("text"));
                current.setImage(res.getString("image"));
                ret.add(current);
            }
            
            stmt.close();
            conn.close();
            return ret;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
    public void insertPost (Post post) {
        {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                "INSERT INTO post (id, creatorId, destinationId, text, image) " +
                "VALUES (default,?,?,?,?) ";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, post.getCreatorUser().getId());
            stmt.setInt(2, post.getDestinationUser().getId());
            stmt.setString(3, post.getText());
            stmt.setString(4, post.getImage());
            
            // Esecuzione query
            stmt.execute();
            
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    }
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
            return this.connectionString;
    }

}