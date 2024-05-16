public class Uitlening {
    private Boek boek;
    private Gebruiker gebruiker;

    public Uitlening(Boek boek, Gebruiker gebruiker) {
        this.boek = boek;
        this.gebruiker = gebruiker;
    }

    public Boek getBoek() {
        return boek;
    }

    public Gebruiker getGebruiker() {
        return gebruiker;
    }
}
