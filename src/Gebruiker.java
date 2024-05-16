public class Gebruiker implements Actiebaar {
    private int pincode;

    public Gebruiker(int pincode) {
        this.pincode = pincode;
    }

    @Override
    public void printInfo() {
        System.out.println("De huidige pincode is " + this.pincode + ".");
    }

    public boolean pincodeCorrect(int a) {
        return a == pincode;
    }
}
