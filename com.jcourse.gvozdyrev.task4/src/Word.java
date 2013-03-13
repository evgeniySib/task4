
public class Word {
    private int freq = 1;
    private String word;
    private double freqPerc;

    public Word(String word) {
        this.word = word;
    }

    public Word(String word, int freq) {
        this.word = word;
        this.freq = freq;
    }

    public String getWord() {
        return word;
    }

    public Integer getFreq() {
        return freq;
    }

    public Double getFreqPerc() {
        return freqPerc;
    }

    public void addFreq() {
        freq++;
    }

    public void setFreqPerc(double perc) {
        freqPerc = perc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word w = (Word) o;

        if (!word.equals(w.word)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }
}
