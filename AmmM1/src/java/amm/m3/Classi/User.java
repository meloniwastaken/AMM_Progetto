package amm.m3.Classi;

public class User {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private String URLimmagine;
    private String frase;
    private String data;
    private String password;
    
    public User() {
        this.id = 0;
        this.nome = "";
        this.cognome = "";
        this.email = "";
        this.URLimmagine = "";
        this.frase = "";
        this.data = "";
        this.password = "";
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the URLimmagine
     */
    public String getURLimmagine() {
        return URLimmagine;
    }

    /**
     * @param URLimmagine the URLimmagine to set
     */
    public void setURLimmagine(String URLimmagine) {
        this.URLimmagine = URLimmagine;
    }

    /**
     * @return the frase
     */
    public String getFrase() {
        return frase;
    }

    /**
     * @param frase the frase to set
     */
    public void setFrase(String frase) {
        this.frase = frase;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public boolean equals(Object otherUser) {
        if (otherUser instanceof User)
            if (this.getId() == ((User)otherUser).getId()) return true;
        return false;
    }
}
