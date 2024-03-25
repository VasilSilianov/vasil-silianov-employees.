package generate_data;

import java.util.ArrayList;
import java.util.Random;

public class GenerateRandomData {

    public static void generatedRandomNumberAndCreateRow() {
        Random generator = new Random();
        int empID, projectID, year, month, month2, day, day2, yearsPlus;
        for (int i = 0; i < 1000; i++) {

            empID = generator.nextInt(899) + 100;
            projectID = generator.nextInt(19) + 1;
            year = generator.nextInt(24) + 2000;
            month = (generator.nextInt(11) + 12) % 12 + 1;
            month2 = (generator.nextInt(11) + 12) % 12 + 1;
            day = generator.nextInt(30) + 1;
            day2 = (generator.nextInt(30) + 1) % 27 + 1;
            yearsPlus = generator.nextInt(5);
            System.out.println(empID + ", " + projectID + ", " + year + "-" + month + "-" + day + ", " + (year + yearsPlus) + "-" + month2 + "-" + day2);
        }
    }


    public static void main(String[] args) {
        generatedRandomNumberAndCreateRow();
    }
}
