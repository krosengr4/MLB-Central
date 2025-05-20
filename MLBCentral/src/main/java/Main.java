public class Main {

    public static void main(String[] args) {

        System.out.println("\n\t\t-----WELCOME TO MLB CENTRAL-----");
        Utils.printDivider(Utils.baseball, 28);

        UserInterface userInterface = new UserInterface();
        userInterface.processMainMenu();

        System.out.println(Utils.baseball + "Thank you for using the MLB Playoff Simulator Application!" + Utils.baseball);
        System.out.println(Utils.baseball + "Tip your umpires and we'll see you soon!" +Utils.baseball);
    }

}
