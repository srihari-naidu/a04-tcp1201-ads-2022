package models;

import java.util.ArrayList;

import helpers.CSV;
import helpers.Datas;

/**
 * A subclass data model inheriting User representing a Donor.
 */
public class Donor extends User {
    private final static String donorCSV = Datas.DONOR;

    private String phone;

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /** 
     * Constructs a donor with datatype's default values.
     */
    public Donor() {}

    /** 
     * Constructs a donor with the id, username, paswword, name and phone.
     *
     * @param id the id of donor
     * @param username the username of donor 
     * @param password the password of donor
     * @param name the name of donor
     * @param phone the phone number of donor
     */
    public Donor(String id, String username, String password, String name, String phone) {
        super(id, username, password, name);
        this.phone = phone;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 
    /**
     *  Gets the phone of donor.
     *  @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     *  Sets the phone number of user.
     *  @param phone the phone number of donor
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *  Returns a string representation of a donor in space-separated-values.
     *  @return id username password name phone
     */
    @Override
    public String toString() {
        return super.getID() + " " + 
               super.getUsername() + " " + 
               super.getPassword() + " " + 
               super.getName() + 
               getPhone();
    }

    /**
     *  Returns a string representation of a donor in comma-separated-values.
     *  @return id,username,password,name,phone
     */
    public String toCSVString() {
        return super.getID() + "," + 
               super.getUsername() + "," + 
               super.getPassword() + "," + 
               super.getName() + "," + 
               getPhone();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /** 
     * Generates a unique id for a donor.
     * Adds a character denoting a donor to the number of existing donors.
     *
     * @return unique id generated for donor
     */  
    public static String genID() {
        return "D" + (CSV.countLines(donorCSV) + 1);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
    /** 
     * Returns an ArrayList of Donor objects where donors are existing users who registered as donors.
     *
     * @return list of donors
     */   
    public static ArrayList<Donor> getDonors() {
        ArrayList<Donor> donors = new ArrayList<>();
        ArrayList<String[]> donorData = CSV.readData(donorCSV);

        for (String[] donorSpl : donorData) {
            donors.add(new Donor(
                donorSpl[0],
                donorSpl[1],
                donorSpl[2],
                donorSpl[3],
                donorSpl[4]
                )
            );
        }

        return donors;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
    /** 
     * Saves the donor data in its .csv datafile.
     *
     * @param donors the list of donors to save
     */ 
    public static void saveDonors(ArrayList<Donor> donors) {
        StringBuilder donorData = new StringBuilder();

        for (int i = 0; i < donors.size(); i++)
            donorData.append(donors.get(i).toCSVString() + "\n");
        
        CSV.saveData(donorCSV, donorData);
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
    /** 
     * Returns a Donor object where the donor has the specified id.
     *
     * @param donorID the id of donor to get
     * @return Donor object of given id
     */ 
    public static Donor get(String donorID) {
        for (Donor donor : Donor.getDonors()) {
            if (donor.getID().equals(donorID)) {
                return donor;
            }
        }
        return new Donor();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}