package helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * A helper class to aid the operations on a CSV file.
 */
public class CSV {

    /** 
     * Reads data from a given .csv file and adds it to a list to be returned.
     *
     * @param csvFile the name of the .csv file to read
     * @return list of data read from the .csv file
     */ 
    public static ArrayList<String[]> readData(String csvFile) {
        ArrayList<String[]> data = new ArrayList<>();
        
        try {
            List<String> lines = Files.readAllLines(Paths.get(csvFile));
            
            for (int i = 0; i < lines.size(); i++) {
                String[] splLines = lines.get(i).split(",");
                data.add(splLines);
            }
        } catch (IOException e) {
            e.getMessage();
        }

        return data;
    }

    /** 
     * Writes a given data to a given .csv file.
     *
     * @param csvFile the name of the .csv file to write to
     * @param data the string of data to write and save
     */ 
    public static void saveData(String csvFile, StringBuilder data) {
        try {
            Files.write(Paths.get(csvFile), data.toString().getBytes());
        } catch (IOException e) {
            e.getMessage();
        }
    }
    
    /** 
     * Returns the number of lines in a .csv file.
     *
     * @param csvFile the name of the .csv file to count the lines of
     * @return number of lines count in a given .csv file
     */ 
    public static long countLines(String csvFile) {
        try {
            return Files.lines(Paths.get(csvFile)).count();
        }
        catch (IOException e){
            e.getMessage();
        }
        return -1;
    }
}
