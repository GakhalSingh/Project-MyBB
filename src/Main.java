public class Main {
    public static void main(String[] args) {
        Bibliotheek bibliotheek = new Bibliotheek();
        Menu menu = new Menu(bibliotheek);
        menu.startMenu();
    }
}

// Dit is soort van een eigen aantal soorts test of de functies goed werken
//        Boek boek1 = new Boek("Harry Potter", "J.K. Rowling", "Fantasy");
//        Gebruiker gebruiker1 = new Gebruiker(1234);
//        Recensie recensie1 = new Recensie(5, "Geweldig boek!");
//
//        Bibliotheek bibliotheek = new Bibliotheek();
//        bibliotheek.voegBoekToe(boek1);
//        bibliotheek.leenUit(boek1, gebruiker1);
//        boek1.voegRecensieToe(recensie1);
//
//        System.out.println("Boek: " + boek1.getTitel());
//        System.out.println("Uitgeleend: " + boek1.isUitgeleend());
//        System.out.println("Recensies: ");
//        for (Recensie recensie : boek1.getRecensies()) {
//            System.out.println("- Score: " + recensie.getScore() + ", Tekst: " + recensie.getTekst());
//        }