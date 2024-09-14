import java.util.Random;

public class Cow {
    private String id;
    private String breed;
    private int ageYear; // อายุเป็นปี
    private int ageMonth; // อายุเป็นเดือน
    private boolean lemon; // วัวกินมะนาวหรือไม่ (เฉพาะวัวสีขาว)
    private boolean isBSOD; // วัวเกิด BSOD หรือไม่
    private boolean isBlue; // วัวกลายเป็นสีฟ้าหรือไม่

    private static Random rand = new Random();
    
    public Cow(String id, String breed, int ageYear, int ageMonth) {
        this.id = id;
        this.breed = breed;
        this.ageYear = ageYear;
        this.ageMonth = ageMonth;
        this.lemon = false;
        this.isBSOD = false;
        this.isBlue = false;
    }

    public String getId() {
        return id;
    }

    public String getBreed() {
        return breed;
    }

    public int getAgeYear() {
        return ageYear;
    }

    public int getAgeMonth() {
        return ageMonth;
    }

    public void setLemon(boolean lemon) {
        this.lemon = lemon;
    }

    public boolean isBSOD() {
        return isBSOD;
    }

    public boolean isBlue() {
        return isBlue;
    }

    public void reset() {
        this.isBSOD = false;
        this.isBlue = false;
    }

    // ฟังก์ชันการรีดนม
    public String milkCow() {
        // ถ้าวัวเป็น BSOD แล้ว ให้แจ้งว่าผลิตนมไม่ได้
        if (isBSOD) {
            return "This cow is in BSOD state (Blue Cow). You need to reset it.";
        }

        String milkType = "";
        double failureChance = 0;

        // วัวสีขาว
        if (breed.equals("white")) {
            if (lemon) {
                milkType = "sour milk"; // วัวที่กินมะนาวผลิตนมเปรี้ยว
            } else {
                milkType = "plain milk"; // วัวสีขาวธรรมดาผลิตนมจืด

                // คำนวณโอกาสผลิตนมถั่วเหลือง (0.5% x อายุเดือน)
                failureChance = 0.005 * ageMonth;
                if (rand.nextDouble() < failureChance) {
                    milkType = "soy milk"; // ผลิตนมถั่วเหลือง (BSOD)
                    this.isBSOD = true;
                    this.isBlue = true; // กลายเป็นสีฟ้า
                    return "BSOD! The cow produced soy milk. It's unusable and the cow is now in BSOD state.";
                }
            }
        }

        // วัวสีน้ำตาล
        else if (breed.equals("brown")) {
            milkType = "chocolate milk"; // วัวสีน้ำตาลผลิตนมช็อกโกแลต

            // คำนวณโอกาสผลิตนมอัลมอนด์ (1% x อายุปี)
            failureChance = 0.01 * ageYear;
            if (rand.nextDouble() < failureChance) {
                milkType = "almond milk"; // ผลิตนมอัลมอนด์ (BSOD)
                this.isBSOD = true;
                this.isBlue = true; // กลายเป็นสีฟ้า
                return "BSOD! The cow produced almond milk. It's unusable and the cow is now in BSOD state.";
            }
        }

        // ถ้าวัวไม่เกิด BSOD
        return String.format("Successfully milked the cow. It produced %s.", milkType);
    }
}
