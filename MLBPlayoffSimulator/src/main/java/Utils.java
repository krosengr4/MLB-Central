import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Utils {

    static Scanner myScanner = new Scanner(System.in);

    //region Colors for printing out colored messages
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    //endregion

    //region symbols
    public static String spade = "♠";
    public static String club = "♣";
    public static String heart = "❤";
    public static String diamond = "♢";

    //Emojis
    public static String smileyFace = "\uD83D\uDE00";
    public static String thumbsUp = "\uD83D\uDC4D";
    public static String redHeart = "\u2764\uFE0F";
    public static String cowboy = "\uD83E\uDD20";
    //endregion

    //region prints out designed lines
    public static void designLine(int numberOfLines, boolean isNewLine) {
        StringBuilder underLine = new StringBuilder("=");
        underLine.append("=".repeat(Math.max(0, numberOfLines)));
        if (isNewLine) {
            underLine.append("\n");
        }
        System.out.println(underLine);
    }

    public static void printDivider(String divider, int repeat) {
        System.out.println(divider.repeat(repeat));
    }
    //endregion

    //region changes the color of a string
    public static String makeRed(String message) {
        return (RED + message + RESET);
    }

    public static String makeGreen(String message) {
        return (GREEN + message + RESET);
    }

    public static String makeYellow(String message) {
        return (YELLOW + message + RESET);
    }

    public static String makeBlue(String message) {
        return (BLUE + message + RESET);
    }

    public static String makePurple(String message) {
        return (PURPLE + message + RESET);
    }
    //endregion

    //region UserIO
    //prompt user, then get and return user input
    public static String promptGetUserInput(String message) {
        System.out.println(message);
        return myScanner.nextLine().trim();
    }

    public static int messageAndResponseInt(String message) {
        System.out.print(message);
        return Integer.parseInt(myScanner.nextLine());
    }

    public static double messageAndResponseDouble(String message) {
        System.out.print(message);
        return Double.parseDouble(myScanner.nextLine());
    }

    //Pauses the app until user hits Enter
    public static void pauseApp() {
        System.out.println("\nPress Enter to Continue...");
        myScanner.nextLine();
    }
    //endregion


    //Capitalizes the first letter in every word
    public static String capitalizeWords(String input) {
        String[] words = input.trim().toLowerCase().split(" ");
        StringBuilder capitalized = new StringBuilder();

        for (String word : words) {

            capitalized.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1))
                    .append(" ");
        }
        return capitalized.toString().trim();
    }

    //rounds a double
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
