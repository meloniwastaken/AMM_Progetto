package amm.m3.Classi;

import java.util.ArrayList;

public class UserFactory {
    
    private static UserFactory singleton;
    
    public static UserFactory getInstance() {
        if (singleton == null) {
            singleton = new UserFactory();
        }
        return singleton;
    }
    
    private ArrayList<User> userList = new ArrayList<User>();
    
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
        for (User utente : this.userList) {
            if (utente.getId() == id) {
                return utente;
            }
        }
        return null;
    }
    
    public int getIdByEmailAndPassword(String email, String password){
        for(User utente : this.userList){
            if(utente.getEmail().equals(email) && utente.getPassword().equals(password)){
                return utente.getId();
            }
        }
        return -1;
    }
    
    public ArrayList<User> getFriendsByUser(User user) {
        ArrayList<User> returnlist = new ArrayList<>();
        for(User utente : this.userList) {
            if(!(utente.getId() == user.getId())) {
                returnlist.add(utente);
            }
        }
        return returnlist;
    }
    
    public User getUserByName (String name) {
        for(User utente : this.userList) {
            if(utente.getNome().equals(name))
                return utente;
        }
        return null;
    }
    
}
