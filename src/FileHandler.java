import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class FileHandler {

    private File myFile;

    public FileHandler(String filePath) {
        myFile = new File(filePath);
        createFile();
        setupFile();
    }
    
    private void createFile() {
        if(!myFile.exists())
            try {
                myFile.createNewFile();
            } catch (Exception e) {
                System.out.println("error while creating the file");
                e.printStackTrace();
            }  
    }

    private void setupFile() {
        try {
            FileWriter fileWriter = new FileWriter(myFile);
            fileWriter.write('[' + "\n" + ']');
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("error occured during file writing");
            e.printStackTrace();
        }
    }

    public boolean addTask(String newTask) {
        try {
            FileWriter fileWriter = new FileWriter(myFile);
            fileWriter.write('{' +
                            "\"ID\"" + ':' + '"' + newID() + '"' + ", " +
                            "\"description\"" + ':' + '"' + newTask + '"' + ", " +
                            "\"status\"" + ':' + "\"to-do\"" + ", " +
                            "\"createdAt\"" + ':' + '"' + LocalDateTime.now(ZoneId.of("Europe/Rome")) + '"' + ", " +
                            "\"updatedAt\"" + ':' + '"' + LocalDateTime.now(ZoneId.of("Europe/Rome")) + '"'
                            + '}' + "\n");
            System.out.println("new task will be added with id: " + newID());
            fileWriter.close();
            return true;
        } catch (Exception e) {
            System.out.println("error occured during file writing");
            e.printStackTrace();
            return false;
        }
    }

    private void read() {
        try {
            Scanner scanner = new Scanner(myFile);
            scanner.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public int newID() {
        try {
            //int currentID;
            Scanner scanner = new Scanner(myFile);
            System.out.println("testing nextLine: " + scanner.hasNextLine());
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                //System.out.println("testing nextLine");
                System.out.println(data);
            }
            scanner.close();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

}
