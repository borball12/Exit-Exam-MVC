import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // โหลดข้อมูลวัวจากไฟล์ CSV
        String csvFilePath = "Cows.csv";
        Map<String, Cow> cowData = CowDataCSVReader.readCowDataFromCSV(csvFilePath);

        // สร้าง View และ Controller
        CowView view = new CowView();
        CowController controller = new CowController(view, cowData);
        
        // แสดง GUI
        view.setVisible(true);
    }
}
