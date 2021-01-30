import java.util.Scanner;

public class UserUIControl {

    public void startUI() {

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        UserManagement userManagement = new UserManagement();
        do {
            System.out.println("\ns(how), c(hange), q(uit)");

            char c = scanner.nextLine().charAt(0);
            switch (c) {
                case 'q':
                    isRunning = false;
                    break;

                case 's':
                    System.out.println(userManagement.getUserNames());
                    break;

                case 'c':
                    System.out.print("Enter new user name: ");
                    String newName = scanner.nextLine();
                    userManagement.addUser(newName);
                    break;
                default:
                    System.out.print("?");
            }

        } while (isRunning);
    }
}