import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class FileHandler {

    private File myFile;
    private ArrayList<Task> taskList;

    public FileHandler(String filePath) {
        myFile = new File(filePath);
        taskList = new ArrayList<Task>();
        if(!myFile.exists()) {
            createFile();
            setupFile();
        }
        importFileData();
    }
    
    private void createFile() {
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
            fileWriter.write('{' + "\n" + "    \"tasks\":[" + "\n" + "    ]" + "\n" + '}');
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
                    preambleFinished = true;
                }
            }
            while(scanner.hasNextLine()) {
                String currentLine = scanner.nextLine();
                if(currentLine.compareTo("    ]") == 0) {
                    break;
                }
                else{
                    int id = Integer.parseInt(currentLine.substring(currentLine.indexOf(':') + 1, currentLine.indexOf(',')));

                    currentLine = currentLine.substring(currentLine.indexOf(',') + 1, currentLine.length());
                    String description = currentLine.substring(currentLine.indexOf(':') + 2, currentLine.indexOf(',') - 1);

                    currentLine = currentLine.substring(currentLine.indexOf(',') + 1, currentLine.length());
                    String status = currentLine.substring(currentLine.indexOf(':') + 2, currentLine.indexOf(',') - 1);

                    currentLine = currentLine.substring(currentLine.indexOf(',') + 1, currentLine.length());
                    String createdAt = currentLine.substring(currentLine.indexOf(':') + 2, currentLine.indexOf(',') - 1);

                    currentLine = currentLine.substring(currentLine.indexOf(',') + 1, currentLine.length());
                    String updatedAt = currentLine.substring(currentLine.indexOf(':') + 2, currentLine.indexOf('}') - 1);

                    taskList.add(new Task(id, description, status, createdAt, updatedAt));
                }
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public void list() {
        for(Task actualTask : taskList)
            System.out.println(actualTask.toString());
    }

    public void listToDo() {
        for(Task actualTask : taskList)
            if(actualTask.getStatus() == "todo")
            System.out.println(actualTask.toString());
    }

    public void listInProgress() {
        for(Task actualTask : taskList)
            if(actualTask.getStatus() == "in-progress")
            System.out.println(actualTask.toString());
    }

    public void listDone() {
        for(Task actualTask : taskList)
            if(actualTask.getStatus() == "done")
            System.out.println(actualTask.toString());
    }

    private int newID() {
        int max = 0;
        for(Task actualTask : taskList) {
            if(actualTask.getid() > max)
                max = actualTask.getid();
        }
        return max + 1;
    }

    private boolean updateFile() {

        try {
            FileWriter fileWriter = new FileWriter(myFile);
            fileWriter.write('{' + "\n" + "    \"tasks\":[" + "\n");

            for(int i = 0; i < taskList.size(); i++) {
                if(i == taskList.size() - 1)
                    fileWriter.write(taskList.get(i).toWriteFile() + "\n");
                else
                    fileWriter.write(taskList.get(i).toWriteFile() + ",\n");
            }

            fileWriter.write("    ]" + "\n" + '}');
            fileWriter.close();
            return true;
        } catch (Exception e) {
            System.out.println("error occured during file writing");
            e.printStackTrace();
            return false;
        }
    }

    public boolean addTask(String description) {
        taskList.add(new Task(newID(), description));
        return updateFile();
    }

}
