package models;

import java.util.ArrayList;

import helpers.CSV;
import helpers.Datas;

/**
 * A subclass data model inheriting User representing an NGO.
 */
public class NGO extends User {
    private final static String ngoCSV = Datas.NGO;

    private int manpower;

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /** 
     * Constructs an NGO with datatype's default values.
     */
    public NGO() {}

    /** 
     * Constructs a donor with the id, username, paswword, name and phone.
     *
     * @param id the id of NGO
     * @param username the username of NGO 
     * @param password the password of NGO
     * @param name the name of NGO
     * @param manpower the manpower count of NGO
     */
    public NGO(String id, String username, String password, String name, int manpower) {
        super(id, username, password, name);
        this.manpower = manpower;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     *  Gets he manpower count of NGO.
     *  @return manpower
     */
    public int getManpower() {
        return manpower;
    }

    /**
     *  Sets the manpower count of NGO.
     *  @param manpower
     */
    public void setManpowerCount(int manpower) {
        this.manpower = manpower;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *  Returns a string representation of an NGO in space-separated-values.
     *  @return id username password name manpower
     */
    @Override
    public String toString() {
        return super.getID() + " " + super.getUsername() + " " + super.getPassword() + " " + super.getName() + getManpower();
    }

    /**
     *  Returns a string representation of an NGO in comma-separated-values.
     *  @return id,username,password,name,manpower
     */
    public String toCSVString() {
        return super.getID() + "," + super.getUsername() + "," + super.getPassword() + "," + super.getName() + "," + getManpower();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /** 
     * Generates a unique id for an NGO.
     * Adds a character denoting an NGO to the number of existing NGOs.
     *
     * @return unique id generated for NGO
     */  
    public static String genID() {
        return "N" + (CSV.countLines(ngoCSV) + 1);
    }

    /** 
     * Returns an ArrayList of NGO objects where NGOs are existing users who registered as NGOs.
     *
     * @return list of NGOs
     */   
    public static ArrayList<NGO> getNGOs() {
        ArrayList<NGO> ngos = new ArrayList<>();
        ArrayList<String[]> ngoData = CSV.readData(ngoCSV);

        for (String[] ngoSpl : ngoData) {
            ngos.add(new NGO(
                ngoSpl[0], 
                ngoSpl[1],
                ngoSpl[2], 
                ngoSpl[3], 
                Integer.parseInt(ngoSpl[4])
                )
            );
        }

        return ngos;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /** 
     * Saves the NGO data in its .csv datafile.
     *
     * @param ngos the list of NGOs to save
     */ 
    public static void saveNGOs(ArrayList<NGO> ngos) {
        StringBuilder ngoData = new StringBuilder();

        for (int i = 0; i < ngos.size(); i++)
            ngoData.append(ngos.get(i).toCSVString() + "\n");
        
        CSV.saveData(ngoCSV, ngoData);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /** 
     * Returns a NGO object where the NGO has the specified id.
     *
     * @param ngoID the id of NGO to get
     * @return NGO object of given id
     */ 
    public static NGO get(String ngoID) {
        for (NGO ngo : NGO.getNGOs()) {
            if (ngo.getID().equals(ngoID)) {
                return ngo;
            }
        }
        return new NGO();
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}