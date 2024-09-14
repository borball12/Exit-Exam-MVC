import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CowView extends JFrame {
    private JTextField cowIdField;
    private JLabel cowInfoLabel; // แสดงข้อมูลของวัว
    private JLabel resultLabel; // แสดงผลหลังรีดนม
    private JButton milkButton;
    private JButton resetButton;
    private JButton lemonButton; // ปุ่มป้อนมะนาว (เฉพาะวัวสีขาว)
    
    public CowView() {
        setTitle("Milk Cow System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // ตั้งค่าหน้าจอรับรหัสวัว
        cowIdField = new JTextField(8);
        milkButton = new JButton("Milk the Cow");
        resetButton = new JButton("Reset BSOD");
        lemonButton = new JButton("Add Lemon (White Cow Only)");
        lemonButton.setVisible(false); // ซ่อนไว้ก่อน จะแสดงเฉพาะวัวสีขาว

        cowInfoLabel = new JLabel(); // ไว้แสดงข้อมูลวัว
        resultLabel = new JLabel(); // ไว้แสดงผลจากการรีดนม
        
        JPanel panel = new JPanel(new GridLayout(7, 1));
        panel.add(new JLabel("Enter Cow ID:"));
        panel.add(cowIdField);
        panel.add(milkButton);
        panel.add(lemonButton);
        panel.add(resetButton);
        panel.add(cowInfoLabel);
        panel.add(resultLabel);
        
        this.add(panel);
    }

    public String getCowId() {
        return cowIdField.getText();
    }

    // ฟังก์ชันแสดงข้อมูลวัว
    public void setCowInfo(String info) {
        cowInfoLabel.setText(info);
    }

    // ฟังก์ชันแสดงผลการรีดนม
    public void setResult(String result) {
        resultLabel.setText(result);
    }

    // ควบคุมการแสดงปุ่ม Add Lemon
    public void showLemonButton(boolean show) {
        lemonButton.setVisible(show);
    }

    public void addMilkButtonListener(ActionListener listener) {
        milkButton.addActionListener(listener);
    }

    public void addResetButtonListener(ActionListener listener) {
        resetButton.addActionListener(listener);
    }

    public void addLemonButtonListener(ActionListener listener) {
        lemonButton.addActionListener(listener);
    }
}
