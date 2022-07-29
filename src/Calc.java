import java.util.Arrays;
import java.util.Scanner;

public class Calc {
    static int mineMethod(int a, String b, int c) {
        int res = 0;
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
                System.out.println("Its not ooprers");
        }
        return res;
    }

    public static void main(String[] args) throws NumberFormatException {
        String[] rome_numbs = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII",
                "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII",
                "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII",
                "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C",
        }; // "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] short_rome = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] arab_numbs = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};// , "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        Scanner newInput = new Scanner(System.in);
        String s = newInput.nextLine();
        String[] lastInp = s.split(" ");
        if (lastInp.length == 3) {
            if (Arrays.asList(arab_numbs).contains(lastInp[0]) && Arrays.asList(arab_numbs).contains(lastInp[2])) {
                int a1 = new Integer(lastInp[0]);
                int b1 = new Integer(lastInp[2]);
                System.out.println(mineMethod(a1, lastInp[1], b1));
            } else if (Arrays.asList(short_rome).contains(lastInp[0]) && Arrays.asList(short_rome).contains(lastInp[2])) {
                int v = Arrays.asList(rome_numbs).indexOf(lastInp[0]);
                int v1 = Arrays.asList(rome_numbs).indexOf(lastInp[2]);
                if (mineMethod(v, lastInp[1], v1) > 0) {
                    int result = mineMethod(v, lastInp[1], v1);
                    System.out.println(rome_numbs[result]);

                } /*else if (lastInp.length != 3) {
                    System.out.println("so mach ops!!!");

                }*/
            }
            else {
                    System.out.println("это не знак вычисления");
                }

            }
        else {
            System.out.println("слишком много операндов");
        }
        newInput.close();
        }
    }

