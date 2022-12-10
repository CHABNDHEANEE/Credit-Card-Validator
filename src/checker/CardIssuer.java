package checker;

public enum CardIssuer {
    VISA,
    MASTERCARD,
    AMEX,
    MAESTRO;


    @Override
    public String toString() {
        if (super.name().equals("AMEX")) return "American Express";
        return super.toString().charAt(0) + super.toString().substring(1).toLowerCase();
    }
}
