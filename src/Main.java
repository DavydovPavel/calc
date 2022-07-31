import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static class MyException extends Exception {
        public MyException(String message) {
            super(message);
        }
    }

    static int mineMethod(int a, String b, int c) throws MyException {
        var res = 0;
        switch (b) {
            case "+":
                res = a + c;
                break;
            case "-":
                res = a - c;
                break;
            case "*":
                res = a * c;
                break;
            case "/":
                res = a / c;
                break;
            default:
                throw new MyException("it's not a math sign");
        }
        return res;
    }

    public static String calc(String input) throws MyException {
        try {
            String[] romeNumbs = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII",
                    "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII",
                    "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII",
                    "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                    "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C",
            };
            String[] shortRome = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            String[] arabNumbs = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            String[] lastInp = input.split(" ");
            if (lastInp.length != 3) throw new MyException("Too much");
                else if (Arrays.asList(arabNumbs).contains(lastInp[0]) && Arrays.asList(arabNumbs).contains(lastInp[2])) {
                    int a1 = new Integer(lastInp[0]);
                    int b1 = new Integer(lastInp[2]);
                    return Integer.toString(mineMethod(a1, lastInp[1], b1));
                }
                else if (Arrays.asList(shortRome).contains(lastInp[0]) && Arrays.asList(shortRome).contains(lastInp[2])) {
                    int v = Arrays.asList(romeNumbs).indexOf(lastInp[0]);
                    int v1 = Arrays.asList(romeNumbs).indexOf(lastInp[2]);
                    if (mineMethod(v, lastInp[1], v1) < 0) throw new MyException("negative romeNum");
                    {
                        int result = mineMethod(v, lastInp[1], v1);
                        return romeNumbs[result];
                    }
                }
                else if((!(Arrays.asList(arabNumbs).contains(lastInp[0]) && Arrays.asList(arabNumbs).contains(lastInp[2]))) |
                        (!(Arrays.asList(shortRome).contains(lastInp[0]) && Arrays.asList(shortRome).contains(lastInp[2]))))
                            throw new MyException("Diff oper`s");
        }
        catch (MyException e) {
            throw new MyException(e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) throws MyException {
        try {
            while (true) {
                Scanner num = new Scanner(System.in);
                System.out.println(calc(num.nextLine()));
            }
        } catch (MyException e) {
            throw new MyException(e.getMessage());
        }
    }
}