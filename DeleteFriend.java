package DActividad6;

import java.io.*;

public class DeleteFriend {
    public static void delete(String name) {
        try {
            File file = new File("friendsContact.txt");
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                if (trimmedLine.startsWith(name + "!")) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();

            boolean successful = tempFile.renameTo(file);
            System.out.println(successful ? "Contact deleted." : "Contact not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
