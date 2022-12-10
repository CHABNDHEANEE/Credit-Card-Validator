package checker;

import java.util.ArrayList;

public class Checker {
    private boolean isRight = true;
    private int length;
    private String cardNum;

    public String check(String number) {
        setCardNum(number);
        setLength();
        checkNumberValidity();

        if (isRight) {
            return getCardIssuer();
        } else {
            return "The card number is wrong, pls, try again";
        }
    }

    private void setLength() {
        length = cardNum.length();
    }

    private void setCardNum(String num) {
        this.cardNum = num;
    }

    private void checkNumberValidity() {
        ArrayList<Integer> numArray = Converter.convertStringToArray(cardNum);
        int lastNum = numArray.get(numArray.size() - 1);

        numArray = Converter.reverseArray(numArray);
        numArray = Converter.multiplyingAllEvenDigits(numArray);
        numArray = Converter.subtract(numArray);
        int sum = Converter.getSum(numArray);

        if (!Converter.checkSum(sum, lastNum)) {
            System.out.println("Неверный номер карты!");
            isRight = false;
        }
    }

    private String getCardIssuer() {
        if (cardNum.matches("3[47].{13}")) return CardIssuer.AMEX.toString();
        else if ((cardNum.startsWith("5018") || cardNum.startsWith("5020") || cardNum.startsWith("5038") ||
                cardNum.startsWith("5893") || cardNum.startsWith("6304") || cardNum.startsWith("6759") ||
                cardNum.startsWith("6761") || cardNum.startsWith("6762") || cardNum.startsWith("6763")) &&
        length > 15 && length < 20) {
            return CardIssuer.MAESTRO.toString();
        } else if ((cardNum.matches("5[1-5].*") ||
                (Integer.parseInt(cardNum.substring(0, 4)) > 222100 &&
                        Integer.parseInt(cardNum.substring(0, 4)) < 272099)) && length == 16) {
            return CardIssuer.MASTERCARD.toString();
        } else if (cardNum.startsWith("4") && (length == 13 || length == 16 || length == 19)) {
            return CardIssuer.VISA.toString();
        } else {
            return "Unsupported card issuer. Please, use another card";
        }
    }
}
