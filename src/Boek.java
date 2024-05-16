import java.util.ArrayList;
import java.util.List;

public class Boek implements Actiebaar {
    private String titel;
    private String auteur;
    private String beschrijving;
    private boolean uitgeleend;


    public Boek(String titel, String auteur, String beschrijving) {
        this.titel = titel;
        this.auteur = auteur;
        this.beschrijving = beschrijving;
        this.uitgeleend = false;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public boolean isUitgeleend() {
        return uitgeleend;
    }

    public void retourneren() {
        if (this.uitgeleend) {
            this.uitgeleend = false;
            System.out.println("Je hebt het boek '" + this.titel + "' succesvol geretourneerd.");
        } else {
            System.out.println("Dit boek is niet uitgeleend.");
        }
    }

    public void lenen() {
        if (!this.uitgeleend) {
            this.uitgeleend = true;
            System.out.println("Je hebt het boek '" + this.titel + "' succesvol geleend.");
        } else {
            System.out.println("Dit boek is al uitgeleend.");
        }
    }

    @Override
    public void printInfo() {
        System.out.println(titel + " door: " + auteur + " beschrijving: " + beschrijving + " status: " + uitgeleend + ".");
    }
}
