import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

public class FileHandler {

    private File myFile;
    private ArrayList<Task> taskList;

    public FileHandler(String filePath) {
        myFile = new File(filePath);
        taskList = new ArrayList<Task>();
        // createFile();
        // setupFile();
        importFileData();
    }
    
    private void createFile() {
        if(!myFile.exists()) {
            try {
                myFile.createNewFile();
            } catch (Exception e) {
                System.out.println("error while creating the file");
                e.printStackTrace();
            }
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

    private void importFileData() {
        boolean preambleFinished = false;
        try {
            Scanner scanner = new Scanner(myFile);
            while(!preambleFinished) {
                String currentLine = scanner.nextLine();
                if(currentLine.contains("tasks")) {
                    System.out.println("testing nextLine data:");
                    System.out.println(currentLine);
                    preambleFinished = true;
                }
            }

            while(scanner.hasNextLine()) {
                String currentLine = scanner.nextLine();
                if(currentLine.compareTo("    ]") == 0) {
                    System.out.println("finished");
                    break;
                }
                else{
                    System.out.println("test da importare");
                    System.out.println(currentLine);
                    // meccanismo per importare dati
                    int id;
                    String description;
                    // add other attributes
                }
            }



            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public boolean addTask(String description) {
        Task newTask = new Task(newID(), description);
        try {
            FileWriter fileWriter = new FileWriter(myFile);
            fileWriter.write('{' +
                            "\"ID\"" + ':' + '"' + newID() + '"' + ", " +
                            "\"description\"" + ':' + '"' + description + '"' + ", " +
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

    public void list() {

    }

    public int newID() {
        try {
            //int currentID;
            Scanner scanner = new Scanner(myFile);
            // System.out.println("testing nextLine: " + scanner.hasNextLine());
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
