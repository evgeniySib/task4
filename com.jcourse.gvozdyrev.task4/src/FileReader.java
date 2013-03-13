
import java.io.*;
import java.util.*;

public class FileReader {
    String lines;
    int i = 0;


    public Collection<Word> findRepeat(BufferedReader br) throws IOException {
        double i = 0;
        Map<String, Word> map = new HashMap<String, Word>();
        while (br.ready()) {
            String[] str;
            str = br.readLine().trim().toLowerCase().split(" ");
            for (String s : str) {
                if (s.equals("")) {
                    continue;
                }
                i++;
                Word w = map.get(s);
                if (w == null) {
                    map.put(s, new Word(s));
                } else {
                    w.addFreq();
                }
            }
        }

        List<Word> words = new ArrayList<Word>(map.values());

        for (Word tmp : words) {
            tmp.setFreqPerc((double) tmp.getFreq() / (i / 100));
        }

        Collections.sort(words, new Comparator<Word>() {
            public int compare(Word o1, Word o2) {
                return o2.getFreq().compareTo(o1.getFreq());
            }
        });

        return words;
    }
}
