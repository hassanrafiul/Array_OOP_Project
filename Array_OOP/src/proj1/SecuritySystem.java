package proj1;

import java.util.ArrayList;
import java.util.Scanner;

public class SecuritySystem {

    ArrayList<String> namesUSR = new ArrayList<String>();

    String max = "Max";
    String ksenia = "Ksenia";
    String sally = "Sally";
    String ali = "Ali";
    String tyrone = "Tyrone";

    ArrayList<SecureMessage> secureMessagesUSR = new ArrayList<SecureMessage>();

    public void showInbox(String destinationName) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<SecureMessage> messagesRecieved = new ArrayList<SecureMessage>();
        for (int i = 0; i < secureMessagesUSR.size(); i++) {

            if (destinationName.equals(secureMessagesUSR.get(i).getDestName())) {
                messagesRecieved.add(secureMessagesUSR.get(i));
            }
        }
        System.out.println("Hello " + destinationName + ", you have " + messagesRecieved.size()
                + " message waiting for you. which do you want to read?");
        System.out.println("Type 0 to go back to main menu");
        System.out.println();
        System.out.println("(Type the number of the message)");

        for (int i = 0; i < messagesRecieved.size(); i++) {
            System.out.println((i + 1) + " - " + messagesRecieved.get(i).getSourceName());
        }
        System.out.println();
        int mssgNum = scanner.nextInt();

        while (mssgNum != 0) {

            if (mssgNum <= messagesRecieved.size() && mssgNum > 0) {
                System.out.println("What is the key to read your message?");
                scanner.nextLine();
                String mssgKey = scanner.nextLine();
                System.out.println(messagesRecieved.get(mssgNum - 1).getMessage(mssgKey));

            } else if (mssgNum == 0) {
                break;
            }
            System.out.println("Hello " + destinationName + ", you have " + messagesRecieved.size()
                    + " message waiting for you. Which do you want to read?");
            System.out.println("Type 0 to go back to main menu");
            System.out.println();
            System.out.println("(Type the number of the messages)");

            for (int i = 0; i < messagesRecieved.size(); i++) {
                System.out.println((i + 1) + " - " + messagesRecieved.get(i).getSourceName());
            }
            System.out.println();
            mssgNum = scanner.nextInt();

        }

    }

    public void addMessage(SecureMessage messageList) {
        secureMessagesUSR.add(messageList);
    }

    public ArrayList<String> userList() {

        namesUSR.add(max);
        namesUSR.add(ksenia);
        namesUSR.add(sally);
        namesUSR.add(ali);
        namesUSR.add(tyrone);

        return (namesUSR);
    }

    public void displayUser() {
        for (int i = 0; i < namesUSR.size(); i++) {
            System.out.println((i + 1) + " - " + namesUSR.get(i));
        }
    }
}
