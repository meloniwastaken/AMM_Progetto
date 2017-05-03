package amm.m3.Classi;

public class Post {
    private int id;
    private int creatorId; /*Se è >0 allora è di un utente, se è <0 allora è di un gruppo, se è 0 è stato solamente instanziato*/
    private String text;
    private String image;

    public Post() {
        this.id = 0;
        this.creatorId = 0;
        this.text = "";
        this.image = "";
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
     * @return the creatorId
     */
    public int getCreatorId() {
        return creatorId;
    }

    /**
     * @param creatorId the creatorId to set
     */
    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }




}