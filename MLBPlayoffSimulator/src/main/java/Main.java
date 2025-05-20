public class Main {

    public static void main(String[] args) {

        System.out.println("\n\t\t-----WELCOME TO MLB PLAYOFF SIMULATOR-----");
        Utils.printDivider(Utils.baseball, 28);

        UserInterface userInterface = new UserInterface();
        userInterface.processMainMenu();

    }

}
