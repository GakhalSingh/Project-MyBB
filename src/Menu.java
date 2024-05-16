import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Bibliotheek bibliotheek;
    private List<Boek> boeken;
    private List<Recensie> recensies;
    private List<Uitlening> uitleningen;
    private Gebruiker gebruiker;

    public Menu(Bibliotheek bibliotheek) {
        this.bibliotheek = bibliotheek;
        this.boeken = new ArrayList<>();
        this.recensies = new ArrayList<>();
        this.uitleningen = new ArrayList<>();
        this.gebruiker = new Gebruiker(1234);
        initBoeken();
        initRecensies();
    }

    public void startMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Hoofdmenu:");
            System.out.println("1. Bibliotheek bezoeken");
            System.out.println("2. Recensies bekijken");
            System.out.println("3. Leningen bekijken");
            System.out.println("4. Boek retourneren");
            System.out.println("5. Exit");
            System.out.print("Keuze: ");

            int keuze = scanner.nextInt();

            switch (keuze) {
                case 1:
                    bibliotheekBezoeken();
                    break;
                case 2:
                    recensiesBekijken();
                    break;
                case 3:
                    leningenBekijken();
                    break;
                case 4:
                    boekRetourneren();
                    break;
                case 5:
                    System.out.println("Tot ziens!");
                    return;
                default:
                    System.out.println("Ongeldige keuze, probeer opnieuw.");
            }
        }
    }

    private void bibliotheekBezoeken() {
        System.out.println("Beschikbare boeken:");

        for (Boek boek : boeken) {
            System.out.println("- " + boek.getTitel() + " (" + (boek.isUitgeleend() ? "Uitgeleend" : "Beschikbaar") + ")");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Wil je meer details zien van een boek? (ja/nee): ");
        String antwoord = scanner.nextLine();

        if (antwoord.equalsIgnoreCase("ja")) {
            System.out.print("Voer de titel van het boek in: ");
            String titel = scanner.nextLine();

            for (Boek boek : boeken) {
                if (boek.getTitel().equalsIgnoreCase(titel)) {
                    System.out.println("Titel: " + boek.getTitel());
                    System.out.println("Auteur: " + boek.getAuteur());
                    System.out.println("Beschrijving: " + boek.getBeschrijving());

                    System.out.print("Wil je dit boek lenen? (ja/nee): ");
                    antwoord = scanner.nextLine();

                    if (antwoord.equalsIgnoreCase("ja")) {
                        System.out.print("Voer je pincode in: ");
                        int pincode = scanner.nextInt();

                        if (gebruiker.pincodeCorrect(pincode)) {
                            boek.lenen();
                            // leningen.add("Geleend: " + boek.getTitel());
                            System.out.println("Boek succesvol geleend.");
                        } else {
                            System.out.println("Ongeldige pincode. Probeer opnieuw.");
                        }
                    }

                    return;
                }
            }

            System.out.println("Boek niet gevonden.");
        }
    }

    private void recensiesBekijken() {
        System.out.println("Recensies:");

        for (Recensie recensie : recensies) {
            System.out.println("- " + recensie.getTekst() + " Rating:" + recensie.getScore());
        }
    }

    private void leningenBekijken() {
        System.out.println("Lijst met leningen:");

        boolean leningenGevonden = false;

        for (Boek boek : boeken) {
            if (boek.isUitgeleend()) {
                leningenGevonden = true;
                System.out.println("- " + boek.getTitel());
            }
        }

        if (!leningenGevonden) {
            System.out.println("Er zijn geen boeken uitgeleend.");
        }
    }


    private void boekRetourneren() {
        System.out.println("Lijst met uitgeleende boeken:");

        boolean uitgeleendGevonden = false;

        for (Boek boek : boeken) {
            if (boek.isUitgeleend()) {
                uitgeleendGevonden = true;
                System.out.println("- " + boek.getTitel());
            }
        }

        if (!uitgeleendGevonden) {
            System.out.println("Er zijn geen boeken uitgeleend.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Voer de titel van het boek in om te retourneren: ");
        String titel = scanner.nextLine();

        for (Boek boek : boeken) {
            if (boek.getTitel().equalsIgnoreCase(titel)) {
                boek.retourneren();
                return;
            }
        }

        System.out.println("Boek niet gevonden in de lijst met uitgeleende boeken.");
    }

    private void initBoeken() {
        boeken.add(new Boek("The Hunger Games", "Suzanne Collins", "Set in a dark vision of the near future, a terrifying reality TV show is taking place. Twelve boys and girls are forced to appear in a live event called The Hunger Games. There is only one rule: kill or be killed. When sixteen-year-old Katniss Everdeen steps forward to take her younger sister's place in the games, she sees it as a death sentence."));
        boeken.add(new Boek("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "Harry Potter has never even heard of Hogwarts when the letters start dropping on the doormat at number four, Privet Drive. Addressed in green ink on yellowish parchment with a purple seal, they are swiftly confiscated by his grisly aunt and uncle. Then, on Harry's eleventh birthday, a great beetle-eyed giant of a man called Rubeus Hagrid bursts in with some astonishing news: Harry Potter is a wizard, and he has a place at Hogwarts School of Witchcraft and Wizardry."));
        boeken.add(new Boek("The Hobbit", "J.R.R. Tolkien", "Bilbo Baggins is a hobbit who enjoys a comfortable, unambitious life, rarely traveling any farther than his pantry or cellar. But his contentment is disturbed when the wizard Gandalf and a company of dwarves arrive on his doorstep one day to whisk him away on an adventure. They have launched a plot to raid the treasure hoard guarded by Smaug the Magnificent, a large and very dangerous dragon."));
        boeken.add(new Boek("To Kill a Mockingbird", "Harper Lee", "The unforgettable novel of a childhood in a sleepy Southern town and the crisis of conscience that rocked it. Taking the advice of a wise but eccentric neighbor, Atticus Finch, a young girl named Scout Finch comes of age in the racially charged atmosphere of the American South in the 1930s."));
        boeken.add(new Boek("1984", "George Orwell", "Winston Smith toes the Party line, rewriting history to satisfy the demands of the Ministry of Truth. With each lie he writes, Winston grows to hate the Party that seeks power for its own sake and persecutes those who dare to commit thoughtcrimes. But as he starts to think for himself, Winston can’t escape the fact that Big Brother is always watching..."));
    }
    private void initRecensies() {
        recensies.add(new Recensie(5, "A gripping and thrilling dystopian adventure."));
        recensies.add(new Recensie(5, "A magical start to an incredible series."));
        recensies.add(new Recensie(5, "A timeless classic that tackles important themes with grace and insight."));
    }
}
