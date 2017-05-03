package amm.m3.Classi;

import java.util.ArrayList;

public class Group {
    private int id;
    private ArrayList < Integer > userList;
    private String nome;
    private String URLimmagine;

    public Group() {
        this.id = 0;
        this.userList = null;
        this.nome = "";
        this.URLimmagine = "";
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
     * @return the userList
     */
    public ArrayList < Integer > getUserList() {
        return userList;
    }

    /**
     * @param userList the userList to set
     */
    public void setUserList(ArrayList < Integer > userList) {
        this.userList = userList;
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


}