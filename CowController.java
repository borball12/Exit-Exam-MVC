import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class CowController {
    private CowView view;
    private Map<String, Cow> cowData;

    public CowController(CowView view, Map<String, Cow> cowData) {
        this.view = view;
        this.cowData = cowData;

        // ตรวจสอบรหัสวัวเมื่อกดปุ่ม Milk
        this.view.addMilkButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cowId = view.getCowId();
                if (cowData.containsKey(cowId)) {
                    Cow cow = cowData.get(cowId);
                    String cowInfo = String.format("Cow ID: %s\nBreed: %s\nAge: %d years, %d months", 
                                                    cow.getId(), cow.getBreed(), cow.getAgeYear(), cow.getAgeMonth());
                    view.setCowInfo(cowInfo);

                    // ถ้าเป็นวัวสีขาว ให้แสดงปุ่มป้อนมะนาว
                    if (cow.getBreed().equals("white")) {
                        view.showLemonButton(true);
                    } else {
                        view.showLemonButton(false);
                    }

                    // รีดนมและแสดงผล
                    String result = cow.milkCow();
                    view.setResult(result);

                } else {
                    view.setCowInfo("Error: Cow not found.");
                    view.setResult("");
                    view.showLemonButton(false);
                }
            }
        });

        // ป้อนมะนาวเฉพาะวัวสีขาว
        this.view.addLemonButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cowId = view.getCowId();
                if (cowData.containsKey(cowId)) {
                    Cow cow = cowData.get(cowId);
                    if (cow.getBreed().equals("white")) {
                        cow.setLemon(true);
                        view.setResult("Lemon added to the cow.");
                    }
                }
            }
        });

        // Reset สถานะ BSOD
        this.view.addResetButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Cow cow : cowData.values()) {
                    if (cow.isBSOD()) {
                        cow.reset();
                    }
                }
                view.setResult("All BSOD cows have been reset.");
            }
        });
    }
}
