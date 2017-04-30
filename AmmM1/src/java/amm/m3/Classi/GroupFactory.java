package amm.m3.Classi;

import java.util.ArrayList;

public class GroupFactory {
    
    private static GroupFactory singleton;
    
    public static GroupFactory getInstance() {
        if (singleton == null) {
            singleton = new GroupFactory();
        }
        return singleton;
    }
    
    private ArrayList<Group> groupList = new ArrayList<Group>();
    
    private GroupFactory() {
        //Creazione gruppi
        
        //Hollywood
        ArrayList<Integer> aux = new ArrayList<Integer>();
        Group gruppo1 = new Group();
        gruppo1.setId(-1);
        aux.add(2);
        aux.add(3);
        aux.add(4);
        gruppo1.setUserList(aux);
        gruppo1.setNome("Hollywood");
        gruppo1.setURLimmagine("img/grouppic1");
        
        //Puppets
        aux = new ArrayList<Integer>();
        Group gruppo2 = new Group();
        gruppo2.setId(-2);
        aux.add(1);
        gruppo2.setUserList(aux);
        gruppo2.setNome("Puppets");
        gruppo2.setURLimmagine("img/grouppic2");
        
        groupList.add(gruppo1);
        groupList.add(gruppo2);
    }
    
    Group getGroupById(int id) {
        for (Group gruppo : this.groupList) {
            if (gruppo.getId() == id) {
                return gruppo;
            }
        }
        return null;
    }
    
    ArrayList<Group> getGroupList(User usr) {
        
        int id = usr.getId();
        ArrayList<Group> returnlist = new ArrayList<>();
        for(Group gruppo : this.groupList) {
            for(int auxid : gruppo.getUserList()) {
                if (id == auxid) {
                    returnlist.add(gruppo);
                }
            }
        }
        return returnlist;
    }
}
    
