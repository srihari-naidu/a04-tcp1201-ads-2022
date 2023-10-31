package models;

import java.util.ArrayList;
import java.util.HashSet;

import helpers.CSV;
import helpers.Datas;

/**
 * A data model representing an Aid.
 */
public class Aid {
    private final static String aidCSV = Datas.AID;
    
    private String name;
    private int quantity;
    private String donorID;
    private String ngoID;
    private String status;

    private String donorName;
    private String donorPhone;
    private String ngoName;
    private int ngoManpower;
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /** 
     * Constructs an aid with datatype's default values.
     */
    public Aid() {}
    
    /** 
     * Constructs an aid with the specified name, quantity, donorID and ngoID.
     *
     * @param name the name of aid
     * @param quantity the quantity of aid 
     * @param donorID the id of the aid's donor 
     * @param ngoID the id of the aid's recipient NGO 
     */
    public Aid(String name, int quantity, String donorID, String ngoID) {
        this.name = name;
        this.quantity = quantity;
        this.donorID = donorID;
        this.ngoID = ngoID;
    }   

    /** 
     * Constructs an aid with the specified name, quantity, donorID, ngoID and status.
     *
     * @param name the name of aid
     * @param quantity the quantity of aid 
     * @param donorID the id of the aid's donor 
     * @param ngoID the id of the aid's recipient NGO 
     * @param status the status of the aid
     */
    public Aid(String name, int quantity, String donorID, String ngoID, String status) {
        this.name = name;
        this.quantity = quantity;
        this.donorID = donorID;
        this.ngoID = ngoID;
        this.status = status;
    }    

    /** 
     * Constructs an aid in a Distribution Center TableView structure.
     *
     * @param donorName the name of aid's donor
     * @param donorPhone the phone number of aid's donor
     * @param name the name of aid
     * @param quantity the quantity of aid 
     * @param ngoName the name of aid's recipient NGO
     * @param ngoManpower the manpower count of aid's recipient NGO
     * @param status the status of the aid
     */
    public Aid(String donorName, String donorPhone, String name, int quantity, String ngoName, int ngoManpower, String status) {
        this.donorName = donorName; 
        this.donorPhone = donorPhone; 
        this.name = name;
        this.quantity = quantity;
        this.ngoName = ngoName;
        this.ngoManpower = ngoManpower;
        this.status = status;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *  Gets the name of aid.
     *  @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     *  Gets the quantity of aid.
     *  @return quantity
     */
    public int getQuantity() {
        return quantity;
    }
    
    /**
     *  Gets the id of aid's donor.
     *  @return donorID
     */
    public String getDonorID() {
        return donorID;
    }

    /**
     *  Gets the id of aid's recipient NGO.
     *  @return ngoID
     */
    public String getNgoID() {
        return ngoID;
    }

    /**
     *  Gets the status of aid.
     *  @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     *  Sets the name of aid.
     *  @param name the name of aid
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *  Sets the quantity of aid.
     *  @param quantity the quantity of aid
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    /**
     *  Sets the id of aid's donor.
     *  @param donorID the id of aid's donor
     */
    public void setDonorID(String donorID) {
        this.donorID = donorID;
    }

    /**
     *  Sets the id of aid's recipient NGO.
     *  @param ngoID the id of aid's recipient NGO
     */
    public void setNgoID(String ngoID) {
        this.ngoID = ngoID;
    }

    /**
     *  Sets the id of aid's recipient NGO.
     *  @param ngoID the id of aid's recipient NGO
     */
    public void setStatus(String status) {
        this.status = status;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     *  Gets the name of aid'sdonor.
     *  @return donorName
     */
    public String getDonorName() {
        return donorName;
    }

    /**
     *  Gets the phone number of aid's donor.
     *  @return donorPhone
     */
    public String getDonorPhone() {
        return donorPhone;
    }

    /**
     *  Gets the name of aid's recipient NGO.
     *  @return ngoName
     */
    public String getNgoName() {
        return ngoName;
    }

    /**
     *  Gets the manpower count of aid's recipient NGO.
     *  @return ngoManpower
     */
    public int getNgoManpower() {
        return ngoManpower;
    }

    /**
     *  Sets the name of aid'sdonor.
     *  @param donorName
     */
    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    /**
     *  Sets the phone number of aid's donor.
     *  @param donorPhone
     */
    public void setDonorPhone(String donorPhone) {
        this.donorName = donorPhone;
    }

    /**
     *  Sets the name of aid's recipient NGO.
     *  @param ngoName
     */
    public void setNgoName(String ngoName) {
        this.ngoName = ngoName;
    }

    /**
     *  Sets the manpower count of aid's recipient NGO.
     *  @param ngoManpower
     */
    public void setNgoManpower(int ngoManpower) {
        this.ngoManpower = ngoManpower;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *  Returns a string representation of an aid in space-separated-values.
     *  @return name quantity donorID ngoID
     */
    @Override
    public String toString() {
        return name + " " + quantity + " " + donorID + " " + ngoID + " " + status;
    }

    /**
     *  Returns a string representation of an aid in comma-separated-values.
     *  @return name,quantity,donorID,ngoID
     */
    public String toCSVString() {
        return name + "," + quantity + "," + donorID + "," + ngoID + "," + status;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /** 
     * Compares the equality of an object with this object.
     *
     * @param o an object being tested for equality
     * @return true if object is equal to this aid
     */   
    @Override
    public boolean equals(Object o) {
 
        if (o == this) {
            return true;
        }
        if (!(o instanceof Aid)) {
            return false;
        }
        Aid c = (Aid) o;
    
        return name.equals(c.name) 
                && donorID.equals(c.donorID)
                    && ngoID.equals(c.ngoID);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /** 
     * Returns an ArrayList of Aid objects where aid is donated or requested.
     *
     * @return list of donated and requested aids
     */   
    public static ArrayList<Aid> getAids() {
        ArrayList<Aid> aids = new ArrayList<>();
        ArrayList<String[]> aidData = CSV.readData(aidCSV);

        for (String[] aidSpl : aidData) {
            aids.add(new Aid(
                aidSpl[0], 
                Integer.parseInt(aidSpl[1]),
                aidSpl[2], 
                aidSpl[3],
                aidSpl[4]
                )
            );
        }

        return aids;
    }

    /** 
     * Returns an ArrayList of Aid objects where aid is in TableView structure.
     *
     *  @return list of aids in TableView structure
     */   
    public static ArrayList<Aid> getTableViewAids() {
        ArrayList<Aid> aids = new ArrayList<>();
        ArrayList<String[]> aidData = CSV.readData(aidCSV);

        for (String[] aidSpl : aidData) {
            aids.add(new Aid( 
                Donor.get(aidSpl[2]).getName(), 
                Donor.get(aidSpl[2]).getPhone(), 
                aidSpl[0], 
                Integer.parseInt(aidSpl[1]),
                NGO.get(aidSpl[3]).getName(), 
                NGO.get(aidSpl[3]).getManpower(),
                aidSpl[4]
                )
            );
        }

        return aids;
    }

    /** 
     * Returns an ArrayList of Aid objects where aid is matched from a donor to donee.
     *
     * @return list of matched aids
     */   
    public static ArrayList<Aid> getMatchedAids() {
        ArrayList<Aid> aids = new ArrayList<>();
        ArrayList<String[]> aidData = CSV.readData(aidCSV);

        for (String[] aidSpl : aidData) {
            if (!aidSpl[2].equals("-") && !aidSpl[3].equals("-")) {
                aids.add(new Aid(
                    aidSpl[0], 
                    Integer.parseInt(aidSpl[1]),
                    aidSpl[2], 
                    aidSpl[3], 
                    aidSpl[4] 
                    )
                );
            }
        }
        
        return aids;
    }

    /** 
     * Returns an ArrayList of Aid objects where aid is donated.
     *
     * @return list of donated aids
     */   
    public static ArrayList<Aid> getDonatedAids() {
        ArrayList<Aid> aids = new ArrayList<>();
        ArrayList<String[]> aidData = CSV.readData(aidCSV);

        for (String[] aidSpl : aidData) {
            if (aidSpl[3].equals("-")) {
                aids.add(new Aid(
                    aidSpl[0], 
                    Integer.parseInt(aidSpl[1]),
                    aidSpl[2], 
                    aidSpl[3] 
                    )
                );
            }
        }

        return aids;
    }
    
    /** 
     * Returns an ArrayList of Aid objects where aid is requested.
     *
     * @return list of requested aids
     */ 
    public static ArrayList<Aid> getRequestedAids() {
        ArrayList<Aid> aids = new ArrayList<>();
        ArrayList<String[]> aidData = CSV.readData(aidCSV);

        for (String[] aidSpl : aidData) {
            if (aidSpl[2].equals("-")) {
                aids.add(new Aid(
                    aidSpl[0], 
                    Integer.parseInt(aidSpl[1]),
                    aidSpl[2], 
                    aidSpl[3] 
                    )
                );
            }
        }

        return aids;
    }
    
    /** 
     * Returns an ArrayList of Aid objects where aid is reserved for an NGO.
     *
     * @return list of reserved aids
     */   
    public static ArrayList<Aid> getReservedAids() {
        ArrayList<Aid> aids = new ArrayList<>();
        ArrayList<String[]> aidData = CSV.readData(aidCSV);

        for (String[] aidSpl : aidData) {
            if (aidSpl[4].equals("Reserved")) {
                aids.add(new Aid(
                    aidSpl[0], 
                    Integer.parseInt(aidSpl[1]),
                    aidSpl[2], 
                    aidSpl[3], 
                    aidSpl[4] 
                    )
                );
            }
        }
        
        return aids;
    }

    /** 
     * Returns an ArrayList of Aid objects where aid is requested.
     *
     * @return list of requested aids
     */ 
    public static void updateAidStatus(ArrayList<Aid> aidsToUpdate) {
        for (Aid aid : aidsToUpdate) {
            if (!aid.getDonorID().equals("-") && !aid.getNgoID().equals("-")) {
                aid.setStatus("Reserved");
            }
            else if (!aid.getDonorID().equals("-") && aid.getNgoID().equals("-")) {
                aid.setStatus("Available");
            }
            else if (aid.getDonorID().equals("-") && !aid.getNgoID().equals("-")) {
                aid.setStatus("Requested");
            }
        }
    }

    /** 
     * Returns an ArrayList of Aid objects where aid is donated by a specific donor.
     *
     * @param id the id of the donor
     * @return list of donor's donated aids
     */ 
    public static ArrayList<Aid> getDonatedAidsOf(String id) {
        ArrayList<Aid> aids = new ArrayList<>();
        ArrayList<String[]> aidData = CSV.readData(aidCSV);

        for (String[] aidSpl : aidData) {
            if (aidSpl[2].equals(id) && aidSpl[3].equals("-")) {
                aids.add(new Aid(
                    aidSpl[0], 
                    Integer.parseInt(aidSpl[1]),
                    aidSpl[2], 
                    aidSpl[3] 
                    )
                );
            }
        }

        return aids;
    }

    /** 
     * Returns an ArrayList of Aid objects where aid is requsted by a specific NGO.
     *
     * @param id the id of the NGO
     * @return list of NGO's requested aids
     */ 
    public static ArrayList<Aid> getRequestedAidsOf(String id) {
        ArrayList<Aid> aids = new ArrayList<>();
        ArrayList<String[]> aidData = CSV.readData(aidCSV);

        for (String[] aidSpl : aidData) {
            if (aidSpl[3].equals(id) && aidSpl[2].equals("-")) {
                aids.add(new Aid(
                    aidSpl[0], 
                    Integer.parseInt(aidSpl[1]),
                    aidSpl[2], 
                    aidSpl[3] 
                    )
                );
            }
        }

        return aids;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /** 
     * Saves the aid data in its .csv datafile.
     *
     * @param aids the list of aids to save
     */ 
    public static void saveAids(ArrayList<Aid> aids){
        StringBuilder aidData = new StringBuilder();

        for (int d = 0; d < aids.size(); d++)
            aidData.append(aids.get(d).toCSVString() + "\n");
        
        CSV.saveData(aidCSV, aidData);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /** 
     * Returns an ArrayList of Aid objects where aid is matched from one donor to one NGO (1-to-1)
     *
     * @return list of aids matched one to one
     */ 
    public static ArrayList<Aid> getMatchOneToOne() {
        ArrayList<Aid> donatedAids = Aid.getDonatedAids();
        ArrayList<Aid> requestedAids = Aid.getRequestedAids();
        ArrayList<Aid> oneToOneAids = new ArrayList<Aid>();
        
        for (int d = 0; d < donatedAids.size(); d++) {
            for (int r = 0; r < requestedAids.size(); r++) {
                if (donatedAids.get(d).getName().equals(requestedAids.get(r).getName()) &&
                    donatedAids.get(d).getQuantity() == requestedAids.get(r).getQuantity()) {
                    Aid dAid = donatedAids.get(d);
                    Aid rAid = requestedAids.get(r);
                    
                    dAid.setNgoID(rAid.getNgoID());
                    oneToOneAids.add(dAid);

                    donatedAids.remove(d);
                    d--;
                    requestedAids.remove(r);
                    r--;
                    
                    break;   
                }
            }
        }
        for (Aid dAid : donatedAids) {
            oneToOneAids.add(dAid);
        }
        for (Aid rAid : requestedAids) {
            oneToOneAids.add(rAid);
        }

        updateAidStatus(oneToOneAids);
        return oneToOneAids;
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /** 
     * Validates the potential of a given donor to donate to many (>1) NGOs
     * Validation is done based on the sufficiency of aids donated and number of NGOs donatable to.
     *
     * @param donorID the donor to be validated of their potential
     * @param requestedAids the current list of aids requested
     * @return true if given donor can donate to many (>1) NGOs
     */ 
    public static boolean potentialOneToManyDonor(String donorID, ArrayList<Aid> requestedAids) {
        for (Aid dAid : Aid.getDonatedAidsOf(donorID)) {
            HashSet<String> potentialNGOs = new HashSet<String>();

            for (Aid rAid : requestedAids) {
                if (dAid.getName().equals(rAid.getName()) &&
                    dAid.getQuantity() >= rAid.getQuantity()) {
                        dAid.setQuantity(dAid.getQuantity() - rAid.getQuantity());
                        potentialNGOs.add(rAid.getNgoID());
                }
            }
            if (potentialNGOs.size() > 1)
                return true;
        }
        return false;
    }

    /** 
     * Returns an ArrayList of Aid objects where aid is matched from one donor to many NGOs (one-to-many)
     *
     * @return list of aids matched one-to-many
     */ 
    public static ArrayList<Aid> getMatchOneToMany() {
        ArrayList<Aid> donatedAids = Aid.getDonatedAids();
        ArrayList<Aid> requestedAids = Aid.getRequestedAids();
        ArrayList<Aid> oneToManyAids = new ArrayList<Aid>();
        
        for (int d = 0; d < donatedAids.size(); d++) {
            if (potentialOneToManyDonor(donatedAids.get(d).getDonorID(), requestedAids)) {
                for (int r = 0; r < requestedAids.size(); r++) {
                    if (donatedAids.get(d).getName().equals(requestedAids.get(r).getName()) && 
                        donatedAids.get(d).getQuantity() >= requestedAids.get(r).getQuantity()) {
                        Aid dAid = donatedAids.get(d);
                        Aid rAid = requestedAids.get(r);
                        
                        if (dAid.getQuantity() - rAid.getQuantity() == 0) {
                            dAid.setNgoID(rAid.getNgoID());
                            oneToManyAids.add(dAid);

                            donatedAids.remove(d);
                            d--;   
                            requestedAids.remove(r);
                            r--;
                            
                            break;
                        }
                        else {
                            dAid.setQuantity(dAid.getQuantity() - rAid.getQuantity());                    
                        }
                        
                        oneToManyAids.add(new Aid(
                            dAid.getName(), 
                            rAid.getQuantity(), 
                            dAid.getDonorID(), 
                            rAid.getNgoID())
                        );

                        requestedAids.remove(r);
                        r--;
                    }
                }
            }
        }
        for (Aid dAid : donatedAids) {
            oneToManyAids.add(dAid);
        }
        for (Aid rAid : requestedAids) {
            oneToManyAids.add(rAid);
        }

        updateAidStatus(oneToManyAids);
        return oneToManyAids;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
    /** 
     * Validates the potential of a given NGO to receive donation from many (>1) donors.
     * Validation is done based on the adequacy of aids requested and number of donors receivable from.
     *
     * @param ngoID the NGO to be validated of their potential
     * @param donatedAids the current list of aids donated
     * @param potentialManyToOneAid the set of names of aids that can be matched many-to-one
     * @return true if given NGO can receive donations from many (>1) donors
     */ 
    public static boolean potentialManyToOneNGO(String ngoID, ArrayList<Aid> donatedAids, HashSet<String> potentialManyToOneAid) {
        for (Aid rAid : Aid.getRequestedAidsOf(ngoID)) {
            HashSet<String> potentiaDonors = new HashSet<String>();
            
            for (Aid dAid : donatedAids) {
                if (rAid.getName().equals(dAid.getName())) {
                    if (rAid.getQuantity() >= dAid.getQuantity()) {
                        rAid.setQuantity(rAid.getQuantity() - dAid.getQuantity());
                        potentiaDonors.add(dAid.getDonorID());
                        potentialManyToOneAid.add(dAid.getName());
                    }
                    else if (potentiaDonors.size() >= 1 &&
                             rAid.getQuantity() <= dAid.getQuantity()) {
                        rAid.setQuantity(0);
                        potentiaDonors.add(dAid.getDonorID());
                        potentialManyToOneAid.add(dAid.getName());
                    }
                } 
            }
            if (potentiaDonors.size() > 1)
                return true;
        }
        return false;
    }

    /** 
     * Returns an ArrayList of Aid objects where aid is matched from many donors to one NGO (many-to-one)
     *
     * @return list of aids matched one-to-many
     */ 
    public static ArrayList<Aid> getMatchManyToOne() {
        ArrayList<Aid> donatedAids = Aid.getDonatedAids();
        ArrayList<Aid> requestedAids = Aid.getRequestedAids();
        ArrayList<Aid> manyToOneAids = new ArrayList<Aid>();
        
        for (int r = 0; r < requestedAids.size(); r++) {
            HashSet<String> potentialManyToOneAid = new HashSet<String>();
            
            if (potentialManyToOneNGO(requestedAids.get(r).getNgoID(), donatedAids, potentialManyToOneAid)) {
                for (int d = 0; d < donatedAids.size(); d++) {
                    if (potentialManyToOneAid.contains(requestedAids.get(r).getName())) {
                        if (requestedAids.get(r).getName().equals(donatedAids.get(d).getName()) && 
                            requestedAids.get(r).getQuantity() >= donatedAids.get(d).getQuantity()) {
                            Aid rAid = requestedAids.get(r);
                            Aid dAid = donatedAids.get(d);
                            
                            if (rAid.getQuantity() - dAid.getQuantity() == 0) {
                                rAid.setDonorID(dAid.getDonorID());
                                manyToOneAids.add(rAid);
    
                                donatedAids.remove(d);
                                d--;   
                                requestedAids.remove(r);
                                r--;
                                
                                break;
                            }
                            else {                
                                rAid.setQuantity(rAid.getQuantity() - dAid.getQuantity());                    
                            }
                            
                            manyToOneAids.add(new Aid(
                                rAid.getName(), 
                                dAid.getQuantity(), 
                                dAid.getDonorID(), 
                                rAid.getNgoID())
                            );
                            
                            donatedAids.remove(d);
                            d--;    
                        }
                        else if (requestedAids.get(r).getName().equals(donatedAids.get(d).getName()) &&
                                 requestedAids.get(r).getQuantity() <= donatedAids.get(d).getQuantity()) {
                            Aid dAid = donatedAids.get(d);
                            Aid rAid = requestedAids.get(r);
                            
                            if (dAid.getQuantity() - rAid.getQuantity() == 0) {
                                donatedAids.remove(d);
                                d--;
                            }
                            else {
                                dAid.setQuantity(dAid.getQuantity() - rAid.getQuantity());                    
                            }
                            
                            manyToOneAids.add(new Aid(
                                dAid.getName(), 
                                rAid.getQuantity(), 
                                dAid.getDonorID(), 
                                rAid.getNgoID())
                            );

                            requestedAids.remove(r);
                            r--;

                            break;
                        }
                    }
                }
            }
        }
        for (Aid dAid : donatedAids) {
            manyToOneAids.add(dAid);
        }
        for (Aid rAid : requestedAids) {
            manyToOneAids.add(rAid);
        }

        updateAidStatus(manyToOneAids);
        return manyToOneAids;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /** 
     * Returns an ArrayList of Aid objects where aid is matched from many donors to many NGOs (many-to-many)
     *
     * @return list of aids matched many-to-many
     */ 
    public static ArrayList<Aid> getMatchManyToMany() {
        ArrayList<Aid> donatedAids = Aid.getDonatedAids();
        ArrayList<Aid> requestedAids = Aid.getRequestedAids();
        ArrayList<Aid> manyToManyAids = new ArrayList<Aid>();

        for (int r = 0; r < requestedAids.size(); r++) {
            for (int d = 0; d < donatedAids.size(); d++) {
                if (requestedAids.get(r).getName().equals(donatedAids.get(d).getName())) {
                    if (requestedAids.get(r).getQuantity() >= donatedAids.get(d).getQuantity()) {
                        Aid rAid = requestedAids.get(r);
                        Aid dAid = donatedAids.get(d);
                        
                        if (rAid.getQuantity() - dAid.getQuantity() == 0) {
                            rAid.setDonorID(dAid.getDonorID());
                            manyToManyAids.add(rAid);

                            donatedAids.remove(d);
                            d--;   
                            requestedAids.remove(r);
                            r--;
                            
                            break;
                        }
                        else {                
                            rAid.setQuantity(rAid.getQuantity() - dAid.getQuantity());                    
                        }
                        
                        manyToManyAids.add(new Aid(
                            rAid.getName(), 
                            dAid.getQuantity(), 
                            dAid.getDonorID(), 
                            rAid.getNgoID())
                        );

                        donatedAids.remove(d);
                        d--;    
                    }
                    else if (requestedAids.get(r).getQuantity() <= donatedAids.get(d).getQuantity()) {
                        Aid dAid = donatedAids.get(d);
                        Aid rAid = requestedAids.get(r);
                        
                        if (dAid.getQuantity() - rAid.getQuantity() == 0) {
                            donatedAids.remove(d);
                            d--;
                        }
                        else {
                            dAid.setQuantity(dAid.getQuantity() - rAid.getQuantity());
                            d--;
                        }
                        
                        manyToManyAids.add(new Aid(
                            dAid.getName(), 
                            rAid.getQuantity(), 
                            dAid.getDonorID(), 
                            rAid.getNgoID())
                        );
                        
                        requestedAids.remove(r);
                        r--;

                        break;
                    }
                }
            }
        }    
        for (Aid dAid : donatedAids) {
            manyToManyAids.add(dAid);
        }
        for (Aid rAid : requestedAids) {
            manyToManyAids.add(rAid);
        }

        updateAidStatus(manyToManyAids);
        return manyToManyAids;
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
