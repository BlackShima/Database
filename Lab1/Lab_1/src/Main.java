import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args){
        ArrayList<String> head = new ArrayList<>();
        ArrayList<ArrayList<String>> arr = new ArrayList<>();
        String new_data = "526=,601-650,Chiang Mai University,TH,Thailand,XL,FC,HI,4,A,48.8,256,30.4,466,16.4,701+,3.9,701+,8.8,701+,8.7,701+,20.9,65.8,28.7,495,67.6,252=,30.9";
        int cmu_rank = -1;

        try{
            File myfile = new File("2024 QS World University Rankings 1.1 (For qs.com).csv");
            Scanner read = new Scanner(myfile);

            for(int x = 0; x < 2; x++){
                if(read.hasNextLine()){
                    head.add(read.nextLine());
                }
            }

            while(read.hasNextLine()){
                String data = read.nextLine();
                String[] column = data.split(",");
                ArrayList<String> row = new ArrayList<>(Arrays.asList(column));
                arr.add(row);
            }
            read.close();

            // หา "Chiang Mai University"
            for(int i = 0 ; i < arr.size() ; i++){
                if(arr.get(i).contains("Chiang Mai University")){
                    cmu_rank = i;
                    break;
                }
            }

            if (cmu_rank != -1) {
                System.out.println("Chiang Mai University found at row index: " + cmu_rank);
            } else {
                System.out.println("Chiang Mai University not found in the original data.");
            }

            // เพิ่มข้อมูลใหม่
            String[] c = new_data.split(",");
            ArrayList<String> r = new ArrayList<>(Arrays.asList(c));
            arr.add(r); // เพิ่มที่ท้าย

            // เขียนกลับไฟล์
            FileWriter file = new FileWriter("2024 QS World University Rankings 1.1 (For qs.com).csv");

            for (String line : head) {
                file.write(line + "\n");
            }

            for (ArrayList<String> row : arr) {
                file.write(String.join(",", row) + "\n");
            }

            file.close();
            System.out.println("New data appended and file saved successfully.");

        } catch(IOException e){
            System.out.println("File not found or cannot be read/written.");
        }
    }
}
