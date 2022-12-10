package checker;

import java.util.ArrayList;

public class Converter {

    public static ArrayList<Integer> convertStringToArray(String str) {
        ArrayList<Integer> array = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            array.add(Integer.parseInt(String.valueOf(str.charAt(i))));
        }

        return array;
    }

    public static ArrayList<Integer> reverseArray(ArrayList<Integer> arr) {
        ArrayList<Integer> newArr = new ArrayList<>();

        for (int i = arr.size() - 1; i >= 0; i--) {
            newArr.add(arr.get(i));
        }

        return newArr;
    }

    public static ArrayList<Integer> multiplyingAllEvenDigits(ArrayList<Integer> array) {
        ArrayList<Integer> newArr = new ArrayList<>();

        for (int i = 1; i <= array.size(); i++) {
            int num = array.get(i - 1);
            if (i % 2 == 0) newArr.add(num * 2);
            else newArr.add(num);
        }

        return newArr;
    }

    public static ArrayList<Integer> subtract(ArrayList<Integer> array) {
        ArrayList<Integer> newArr = new ArrayList<>();

        for (int num : array) {
            if (num > 9) newArr.add(num - 9);
            else newArr.add(num);
        }

        return newArr;
    }

    public static int getSum(ArrayList<Integer> array) {
        int sum = 0;
        for (int num :
                array) {
            sum += num;
        }

        return sum;
    }

    public static boolean checkSum(int sum, int lastDigit) {
        return sum % 10 == lastDigit || sum % 10 == 0;
    }
}
