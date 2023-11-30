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
            boolean contactFound = false; // Flag para verificar si se encontró el contacto

            while ((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                if (trimmedLine.startsWith(name + "!")) {
                    contactFound = true;
                    continue; // Saltar la escritura de este contacto al archivo temporal
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();

            if (contactFound) {
                // Sugerir a la JVM que ejecute el recolector de basura
                System.gc();

                // Eliminar el archivo original
                if (!file.delete()) {
                    System.out.println("Failed to delete the original file.");
                    return;
                }

                // Renombrar el archivo temporal al archivo original
                if (!tempFile.renameTo(file)) {
                    System.out.println("Failed to rename the temporary file.");
                    return;
                }
                System.out.println("Contact deleted.");
            } else {
                System.out.println("Contact not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
