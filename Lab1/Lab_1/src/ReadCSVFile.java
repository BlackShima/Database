import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVFile {
    public static void main(String[] args) {
        String filename = "2024 QS World University Rankings 1.1 (For qs.com).csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineCount = 1; // to count the number of lines read
            while ((line = br.readLine()) != null) {
               String[] parts = line.split(","); // display each line of the CSV file
                if (parts.length >=5){
                    String rank = parts[0].replace("=", "").trim();
                    String overall = parts[1].trim();
                    String name = parts[2].trim();
                    String countryCode = parts[3].trim();
                    String country = parts[4].trim();

                    System.out.println(lineCount + ". Rank: " + rank + 
                                       " | University: " + name + 
                                       " | Country: " + country);
                }
                lineCount++;
            }
            }catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } 
        }
    }

