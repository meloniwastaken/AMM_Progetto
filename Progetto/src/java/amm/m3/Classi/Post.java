package amm.m3.Classi;

public class Post {
    private int id;
    private User creatorUser;
    private User destinationUser;
    private String text;
    private String image;

    public Post() {
        this.id = 0;
        this.creatorUser = null;
        this.destinationUser = null;
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
     * @return the creatorUser
     */
    public User getCreatorUser() {
        return creatorUser;
    }

    /**
     * @param creatorUser the creatorUser to set
     */
    public void setCreatorUser(User creatorUser) {
        this.creatorUser = creatorUser;
    }
    
    /**
     * @return the destinationUser
     */
    public User getDestinationUser() {
        return destinationUser;
    }

    /**
     * @param destinationUser the destinationUser to set
     */
    public void setDestinationUser(User destinationUser) {
        this.destinationUser = destinationUser;
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