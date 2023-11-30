package DActividad6;
import java.io.*;

public class SearchFriend {
    public static void search(String name) {
        try {
            File file = new File("friendsContact.txt");

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.startsWith(name + "!")) {
                    System.out.println("Contact found: " + currentLine);
                    return;
                }
            }
            System.out.println("Contact not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
