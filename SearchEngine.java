package ProjectXI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchEngine {

    static File file = new File("src/ProjectXI/data.txt");
    static Scanner reader;

    // File declarer
    static {
        try {
            reader = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static String[] All_symptoms = new String[lineCount() / 4 + 1],
            DiseaseNames = new String[lineCount() / 4 + 1],
            treatments = new String[lineCount() / 4 + 1];
    static String[][] symptoms = new String[All_symptoms.length][4];

    public static int lineCount() {
        int lineCount = 0;

        // Line Counter
        try (Scanner scanner = new Scanner(new FileReader("src/ProjectXI/data.txt"))) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lineCount++;
            }
        } catch (IOException _) {
        }
        return lineCount;
    }

    public static void putter() {
        String[] list = new String[lineCount()];// All data at once

        // Declarer
        {
            int cnt = 0;
            int cntSymptoms = 0;
            int cntTreatment = 0;
            int cntName = 0;
            while (reader.hasNextLine())
            {
                list[cnt] = reader.nextLine();

                if (list[cnt].startsWith("Symptoms = "))
                {
                    All_symptoms[cntSymptoms] = list[cnt].substring(11);
                    cntSymptoms++;
                }
                else if (list[cnt].startsWith("Treatment = "))
                {
                    treatments[cntTreatment] = list[cnt].substring(12);
                    cntTreatment++;
                }
                else if (list[cnt].startsWith("Name = "))
                {
                    DiseaseNames[cntName] = list[cnt].substring(7);
                    cntName++;
                }
                cnt++;
            }
        }

        // Symptoms Splitter
        for (int i = 0; i < All_symptoms.length; i++)
        {
            if (All_symptoms[i] == null) continue;

            String[] splitSymptoms = All_symptoms[i].split(",");
            for (int j = 0; j < splitSymptoms.length && j < 4; j++)
            {
                symptoms[i][j] = splitSymptoms[j];
            }
        }
    }


    public static void SearchMatcher(String symptom1, String symptom2, String symptom3, String symptom4)
    {
        int symptom1Check = -1, symptom2Check = -1, symptom3Check = -1, symptom4Check = -1;

        for (int i = 0; i < symptoms.length; i++)
        {
            for (int j = 0; j < symptoms[0].length; j++)
            {
                if (symptoms[i][j] != null)
                {
                    if (symptom1.replaceAll(" ","").equalsIgnoreCase(symptoms[i][j].replaceAll(" ","")))
                        symptom1Check = i;
                    if (symptom2.replaceAll(" ","").equalsIgnoreCase(symptoms[i][j].replaceAll(" ","")))
                        symptom2Check = i;
                    if (symptom3.replaceAll(" ","").equalsIgnoreCase(symptoms[i][j].replaceAll(" ","")))
                        symptom3Check = i;
                    if (symptom4.replaceAll(" ","").equalsIgnoreCase(symptoms[i][j].replaceAll(" ","")))
                        symptom4Check = i;
                }
            }
        }
        int max = checkMostRepeated(symptom1Check, symptom2Check, symptom3Check, symptom4Check);
        if (!symptom1.isEmpty() || !symptom2.isEmpty() || !symptom3.isEmpty() || !symptom4.isEmpty())
        {
            if(max!=-1)
            {
                ui.treatment.setText(treatments[max]);
                ui.treatmentLabel.setText(DiseaseNames[max]);
            }
            else
            {
                ui.treatment.setText("No Data Found.\nSorry for the inconvenience caused.");
                ui.treatmentLabel.setText("Error");
            }
        }
        else
        {
            ui.treatmentLabel.setText("Expected Disease and Treatment");
            ui.treatment.setText("Enter Symptoms first.");
        }
    }

    public static int checkMostRepeated(int int1, int int2, int int3, int int4) {

        int[] numbers = {int1, int2, int3, int4};

        int countInt1 = 0, countInt2 = 0, countInt3 = 0, countInt4 = 0;

        for (int number : numbers) {
            if (number == int1)if (int1!=-1)countInt1++;else continue;
            if (number == int2)if (int2!=-1)countInt2++;else continue;
            if (number == int3)if (int3!=-1)countInt3++;else continue;
            if (number == int4)if (int4!=-1)countInt4++;
        }

        // Find the variable with the highest occurrence
        int maxCount = Math.max(Math.max(countInt1, countInt2), Math.max(countInt3, countInt4));

        // Return the variable name that has the highest occurrence
        if (countInt1 == maxCount) {
            return int1;
        } else if (countInt2 == maxCount) {
            return int2;
        } else if (countInt3 == maxCount) {
            return int3;
        } else {
            return int4;
        }
    }

}