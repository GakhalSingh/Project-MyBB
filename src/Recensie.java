public class Recensie {
    private int score;
    private String tekst;

    public Recensie(int score, String tekst) {
        this.score = score;
        this.tekst = tekst;
    }

    public int getScore() {
        return score;
    }

    public String getTekst() {
        return tekst;
    }
}
