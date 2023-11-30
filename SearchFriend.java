package DActividad6;
import java.io.*;

public class SearchFriend {
    public static String search(String name) {
        try {
            File file = new File("friendsContact.txt");

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.startsWith(name + "!")) {
                    String[] parts = currentLine.split("!");
                    return "Contact found:\nName: " + parts[0] + "\nNumber: " + parts[1];
                }
            }
            return "Contact not found.";
        } catch (IOException e) {
            e.printStackTrace();
            return "An error occurred while searching for the contact.";
        }
    }
}
