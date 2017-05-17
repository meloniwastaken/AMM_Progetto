package amm.m3.Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserFactory {

    private static UserFactory singleton;
    private String connectionString;

    public static UserFactory getInstance() {
        if (singleton == null) {
            singleton = new UserFactory();
        }
        return singleton;
    }

    private ArrayList < User > userList = new ArrayList < User > ();

    private UserFactory() {
        //Creazione users

        //Kermit the frog
        User user1 = new User();
        user1.setId(1);
        user1.setNome("Kermit");
        user1.setCognome("The Frog");
        user1.setEmail("kermitthefrog@gmail.com");
        user1.setURLimmagine("img/propic1.jpg");
        user1.setFrase("Just because you haven't found your talent yet, doesn't mean you don't have one.");
        user1.setData("21/02/1955");
        user1.setPassword("kermitvomit");

        //Will Smith
        User user2 = new User();
        user2.setId(2);
        user2.setNome("Will");
        user2.setCognome("Smith");
        user2.setEmail("willwillsmiff@outlook.com");
        user2.setURLimmagine("img/propic2.jpg");
        user2.setFrase("The first step is you have to say that you can.");
        user2.setData("25/09/1968");
        user2.setPassword("willyprince");

        //Robin Williams
        User user3 = new User();
        user3.setId(3);
        user3.setNome("Robin");
        user3.setCognome("Williams");
        user3.setEmail("robingenie@gmail.com");
        user3.setURLimmagine("img/propic3.jpg");
        user3.setFrase("No matter what people tell you, words and ideas can change the world");
        user3.setData("21/07/1951");
        user3.setPassword("robingenie");

        //Don Cheadle
        User user4 = new User();
        user4.setId(4);
        user4.setNome("Don");
        user4.setCognome("Cheadle");
        user4.setEmail("donaldcheadle@gmail.com");
        user4.setURLimmagine("img/propic4.jpg");
        user4.setFrase("I want to be a part of great things.");
        user4.setData("29/10/1964");
        user4.setPassword("craash");

        //Missingno (prova user incompleto)
        User user5 = new User();
        user5.setId(5);
        user5.setNome("Missingno");
        //Cognome stringa vuota
        user5.setEmail("missingno@gmail.com");
        user5.setURLimmagine("img/propic5.jpg");
        user5.setFrase("I bug your Pokèmon ROM");
        user5.setData("01/01/1900");
        user5.setPassword("missingno");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);

    }

    public User getUserById(int id) {

        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                      "select * from utente "
                    + "where id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                User current = new User();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setEmail(res.getString("email"));
                current.setPassword(res.getString("password"));
                current.setURLimmagine(res.getString("urlImmagine"));
                current.setFrase(res.getString("frase"));
                current.setData(res.getString("data"));
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

    public int getIdByEmailAndPassword(String email, String password) {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                      "select id from utente "
                    + "where email = ? and password = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, email);
            stmt.setString(2, password);
            
            System.out.println(stmt);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                int id = res.getInt("id");
                stmt.close();
                conn.close();
                return id;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
        
    }
    
    public ArrayList < User > getFriendsByUser(User user) {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                "SELECT utente.id, utente.nome, utente.cognome, utente.email, utente.password, utente.urlImmagine, utente.frase, utente.data FROM utente "
                + "INNER JOIN followutente ON utente.id = followutente.followed "
                + "WHERE followutente.follower = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, user.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            ArrayList <User> ret = new ArrayList<>();
            
            // ciclo sulle righe restituite
            while (res.next()) {
                User current = new User();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setEmail(res.getString("email"));
                current.setPassword(res.getString("password"));
                current.setURLimmagine(res.getString("urlImmagine"));
                current.setFrase(res.getString("frase"));
                current.setData(res.getString("data"));
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
    
    public ArrayList<User> getUserList() {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                "SELECT * FROM utente";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            ArrayList <User> ret = new ArrayList<>();
            
            // ciclo sulle righe restituite
            while (res.next()) {
                User current = new User();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setEmail(res.getString("email"));
                current.setPassword(res.getString("password"));
                current.setURLimmagine(res.getString("urlImmagine"));
                current.setFrase(res.getString("frase"));
                current.setData(res.getString("data"));
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
    
    public void updateUser(int id, String nome, String cognome, String email, String profile_imm, String frase, String data, String password) {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                "UPDATE utente "
                    + "SET nome = ?, "
                    + "cognome = ?, "
                    + "email = ?, "
                    + "urlImmagine = ?, "
                    + "frase = ?, "
                    + "data = ?, "
                    + "password = ? "
                    + "WHERE id = ? ";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setString(3, email);
            stmt.setString(4, profile_imm);
            stmt.setString(5, frase);
            stmt.setString(6, data);
            stmt.setString(7, password);
            stmt.setInt(8, id);
            
            // Esecuzione query
            stmt.execute();
            
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
        public void deleteUser(int id) {
            try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = "DELETE FROM utente WHERE id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1,id);
            
            // Esecuzione query
            stmt.execute();
            
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
    	return this.connectionString;
    }
}