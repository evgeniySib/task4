import java.io.*;
import java.util.Collection;
import java.lang.*;

public class Main {

    public static void main(String[] args) {
        BufferedReader br;
        FileReader fr = new FileReader();
        Collection<Word> words;

        String filePath = "";
        try {
            filePath = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Отсутсвует аргумент");
        }
        if (!filePath.equals("")) {
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
                words = fr.findRepeat(br);
                br.close();
                generateCsv("D:\\text.csv", words);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private static void generateCsv(String file, Collection<Word> words) {
        try {
            FileWriter writer = new FileWriter(file);
            StringBuilder s = new StringBuilder();
            s.append("Word");
            s.append(';');
            s.append("Frequency");
            s.append(';');
            s.append("Frequency %");
            s.append('\n');

            for (Word o : words) {
                s.append(o.getWord());
                s.append(';');
                s.append(o.getFreq());
                s.append(';');
                s.append(Math.rint(o.getFreqPerc() * 100) / 100);
                s.append('\n');
            }
            writer.append(s);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}