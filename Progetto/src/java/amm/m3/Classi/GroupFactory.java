package amm.m3.Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GroupFactory {

    private static GroupFactory singleton;
    private String connectionString;

    public static GroupFactory getInstance() {
        if (singleton == null) {
            singleton = new GroupFactory();
        }
        return singleton;
    }

    private ArrayList < Group > groupList = new ArrayList < Group > ();

    private GroupFactory() {
        //Creazione gruppi

        //Hollywood
        ArrayList < Integer > aux = new ArrayList < Integer > ();
        Group gruppo1 = new Group();
        gruppo1.setId(-1);
        aux.add(2);
        aux.add(3);
        aux.add(4);
        gruppo1.setUserList(aux);
        gruppo1.setNome("Hollywood");
        gruppo1.setURLimmagine("img/grouppic1.jpg");

        //Puppets
        aux = new ArrayList < Integer > ();
        Group gruppo2 = new Group();
        gruppo2.setId(-2);
        aux.add(1);
        gruppo2.setUserList(aux);
        gruppo2.setNome("Puppets");
        gruppo2.setURLimmagine("img/grouppic2.jpg");

        groupList.add(gruppo1);
        groupList.add(gruppo2);
    }

    public Group getGroupById(int id) {

        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                      "select * from gruppo "
                    + "where id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                Group current = new Group();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setURLimmagine(res.getString("urlImmagine"));
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

    public ArrayList < Group > getGroupList(User user) {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                "SELECT gruppo.id, gruppo.nome, gruppo.urlImmagine FROM gruppo "
                + "INNER JOIN followgruppo ON gruppo.id = followgruppo.followed "
                + "WHERE followgruppo.follower = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, user.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            ArrayList <Group> ret = new ArrayList<>();
            
            // ciclo sulle righe restituite
            while (res.next()) {
                Group current = new Group();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setURLimmagine(res.getString("urlImmagine"));
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
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
            return this.connectionString;
    }
}