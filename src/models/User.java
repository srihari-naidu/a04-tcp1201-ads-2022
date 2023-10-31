package models;

/**
 * A superclass data model representing a User (name, quantity, donorID, ngoID).
 */
public class User {
    private String id;
    private String username;
    private String password;
    private String name;
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /** 
     * Constructs a user with datatype's default values.
     */
    public User() {}

    /** 
     * Constructs user with the name, username, password and name.
     *
     * @param id the id of user
     * @param username the username of user 
     * @param password the password of user
     * @param name the name of user
     */
    public User(String id, String username, String password, String name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *  Gets the id of user.
     *  @return id
     */
    public String getID() {
        return id;
    }
    
    /**
     *  Gets the username of user.
     *  @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     *  Gets the password of user.
     *  @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     *  Gets the name of user.
     *  @return name
     */
    public String getName() {
        return name;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
    /**
     *  Sets the id of user .
     *  @param id the id of user
     */
    public void setID(String id) {
        this.id = id;
    }

    /**
     *  Sets the username of user.
     *  @param username the username of user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *  Sets the password of user.
     *  @param password the password of user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *  Sets the name of user.
     *  @param name the name of user
     */
    public void setName(String name) {
        this.name = name;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /** 
     * Returns first name of user where the user's name is split from start to the first occurence of an empty character.
     *
     * @return first name of user
     */ 
    public String getFirstName() {
        if (name.split("\\w+").length > 1)
            return name.substring(0, name.lastIndexOf(' '));
        else 
            return name;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
