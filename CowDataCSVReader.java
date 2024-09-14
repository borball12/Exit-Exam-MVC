import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CowDataCSVReader {

    public static Map<String, Cow> readCowDataFromCSV(String filePath) {
        Map<String, Cow> cowData = new HashMap<>();
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // อ่านบรรทัดแรกที่เป็น header
            br.readLine();

            // อ่านข้อมูลวัวจากไฟล์ CSV
            while ((line = br.readLine()) != null) {
                String[] cowInfo = line.split(csvSplitBy);

                // สร้าง Cow object จากข้อมูลใน CSV
                String id = cowInfo[0];
                String color = cowInfo[1];
                int ageYear = Integer.parseInt(cowInfo[2]);
                int ageMonth = Integer.parseInt(cowInfo[3]);

                Cow cow = new Cow(id, color, ageYear, ageMonth);
                cowData.put(id, cow);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cowData;
    }
}
