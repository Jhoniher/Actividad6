package DActividad6;

import java.io.*;

public class UpdateFriend {
    public static void update(String oldName, String newName, long newNumber) {
        try {
            File file = new File("friendsContact.txt");
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                if (trimmedLine.startsWith(oldName + "!")) {
                    writer.write(newName + "!" + newNumber + System.getProperty("line.separator"));
                } else {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
            writer.close();
            reader.close();

            boolean successful = tempFile.renameTo(file);
            System.out.println(successful ? "Contact updated." : "Contact not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
