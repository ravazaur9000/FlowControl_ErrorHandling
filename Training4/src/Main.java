import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Exercise 1:");
        System.out.println(monkeyTrouble(true, true));
        System.out.println(monkeyTrouble(false, false));
        System.out.println(monkeyTrouble(true, false));

        System.out.println("Exercise 2:");
        System.out.println(parrotTrouble(true, 6));
        System.out.println(parrotTrouble(true, 7));
        System.out.println(parrotTrouble(false, 6));

        System.out.println("Exercise 3:");
        System.out.println(posNeg(1, -1, false));
        System.out.println(posNeg(-1, 1, false));
        System.out.println(posNeg(-4, -5, true));

        System.out.println("Exercise 4:");
        System.out.println(backAround("cat"));
        System.out.println(backAround("Hello"));
        System.out.println(backAround("a"));

        System.out.println("Exercise 5:");
        System.out.println(everyNth("Miracle", 2));
        System.out.println(everyNth("abcdefg", 2));
        System.out.println(everyNth("abcdefg", 3));

        System.out.println("Exercise 6:");
        System.out.println(scoresIncreasing(new int[]{1, 3, 4}));
        System.out.println(scoresIncreasing(new int[]{1, 3, 2}));
        System.out.println(scoresIncreasing(new int[]{1, 1, 4}));

        System.out.println("Exercise 7:");
        System.out.println(sumHeights(new int[]{5, 3, 6, 7, 2}, 2, 4));
        System.out.println(sumHeights(new int[]{5, 3, 6, 7, 2}, 0, 1));
        System.out.println(sumHeights(new int[]{5, 3, 6, 7, 2}, 0, 4));

        System.out.println("Exercise 8:");
        outofMem();
        stackOverflow();

        System.out.println("Exercise 9:");
        Calculator c = new Calculator();
        System.out.println(c.add(2147483647, 1));
        System.out.println(c.add(-2147483648, -1));
        List<Integer> lst = new ArrayList<Integer>();
        lst.add(5);
        lst.add(5);
        lst.add(5);
        System.out.println(c.average(lst));

        System.out.println("Exercise 10:");
        demonstration();
    }

    public static boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        return (!aSmile && !bSmile) || (aSmile && bSmile);
    }

    public static boolean parrotTrouble(boolean talking, int hour) {
        return talking && (hour < 7 || hour > 20);
    }

    public static boolean posNeg(int a, int b, boolean negative) {
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            return true;
        }
        return negative && a < 0 && b < 0;
    }

    public static String backAround(String str) {
        return str.charAt(str.length() - 1) + str + str.charAt(str.length() - 1);
    }

    public static String everyNth(String str, int n) {
        String returnString = "";
        for (int i = 0; i < str.length(); i++) {
            if (i % n == 0) {
                returnString += str.charAt(i);
            }
        }
        return returnString;
    }

    public static boolean scoresIncreasing(int[] scores) {
        for (int i = 0; i < scores.length - 1; i++) {
            if (scores[i] > scores[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int sumHeights(int[] heights, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += Math.abs(heights[i] - heights[i + 1]);
        }
        return sum;
    }

    public static void stackOverflow() throws StackOverflowError {
        try {
            stackOverflow();
        } catch (StackOverflowError st) {
            System.out.println("StackOverflowError catched ");
        }
    }

    public static void outofMem() throws OutOfMemoryError {
        try {
            int[] i = new int[2 * 6541024 * 1024];
        } catch (OutOfMemoryError er) {
            System.out.println("OutOfMemoryError");
        }
    }

    public static boolean demonstration() {
        try {
            System.out.println("Try block");
            throw new UnderflowException();
        } catch (UnderflowException e) {
            System.out.println("Catch block");
            return false;
        } finally {
            System.out.println("Finally block execution after return in try and catch");
            return false;
        }
    }

}

class Calculator {
    public Integer add(Integer a, Integer b) {
        try {
            if (b > 0 && (a > (Integer.MAX_VALUE - b))) {
                throw new OverflowException();
            } else if (b < 0 && (a < (Integer.MIN_VALUE - b))) {
                throw new UnderflowException();
            }
        } catch (OverflowException e) {

        } catch (UnderflowException e) {

        } finally {
            return a + b;
        }
    }

    public Integer divide(Integer a, Integer b) {
        return a / b;
    }

    public Integer average(List<Integer> lst) {
        Integer sum = 0;
        for (Integer i : lst) {
            sum = add(sum, i);
        }
        return divide(sum, lst.size());
    }
}

class OverflowException extends Exception {
    public OverflowException() {
        System.out.println("OverflowException");
    }
}

class UnderflowException extends Exception {
    public UnderflowException() {
        System.out.println("UnderflowException");
    }
}

