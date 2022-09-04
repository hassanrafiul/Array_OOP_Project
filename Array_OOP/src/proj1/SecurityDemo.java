package proj1;

import java.util.Scanner;
import java.util.ArrayList;

public class SecurityDemo {

    public static void main(String[] args) {
        int x = 1;
        SecuritySystem sS = new SecuritySystem();

        ArrayList<String> namesUSR = new ArrayList<String>();

        namesUSR = sS.userList();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Type One of the Following: ");

        while (x == 1) {

            System.out.println("0 - exit program");
            System.out.println("1 - send a message");
            System.out.println("2 - view inbox");
            System.out.println("3 - view users");
            System.out.println();

            int userInputNumber = scanner.nextInt();
            System.out.println();

            if (userInputNumber == 0) {
                System.out.println("Thanks for using the Secure Messaging Program. Goodbye!");
                x = 0;
            } else if (userInputNumber == 1) {
                System.out.println("Send a message to whom and from whom in the form: ");
                System.out.println("    To From Message : Key");
                System.out.println();

                sS.displayUser();

                scanner.nextLine();

                String sendMessage = scanner.nextLine();
                String[] messageInfo = sendMessage.split(" ");

                int destNum = Integer.parseInt(messageInfo[0]);
                int sourceNum = Integer.parseInt(messageInfo[1]);

                String source = namesUSR.get(sourceNum - 1);
                String dest = namesUSR.get(destNum - 1);
                String message = "";

                for (int i = 2; i < messageInfo.length - 2; i++) {
                    message = message + " " + messageInfo[i];
                }
                String key = messageInfo[messageInfo.length - 1];
                System.out.println();
                System.out.println("Sent message from " + source + " to " + dest + " \"" + message + "\"");
                SecureMessage seMsg = new SecureMessage(message, source, dest, key);
                sS.addMessage(seMsg);
                System.out.println();
            } else if (userInputNumber == 2) {
                System.out.println("View Your Inbox: Who Are You? ");
                System.out.println();

                sS.displayUser();

                int name;
                name = scanner.nextInt();
                String userName = namesUSR.get(name - 1);
                sS.showInbox(userName);
            } else if (userInputNumber == 3) {
                System.out.println("User list:");
                System.out.println();
                sS.displayUser();
            }
            System.out.println();

        }
    }
}
