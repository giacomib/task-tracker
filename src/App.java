import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner tastiera = new Scanner(System.in);
        FileHandler fileHandler = new FileHandler("taskList.json");
        
        try {
            switch(args[0]) {
                case "add":
                    fileHandler.addTask(args[1]);
                    break;
                case "update":
                    fileHandler.updateTask(Integer.parseInt(args[1]), args[2]);
                    break;
                case "delete":
                    fileHandler.deleteTask(Integer.parseInt(args[1]));
                    break;
                case "mark-in-progress":
                    fileHandler.markInProgress(Integer.parseInt(args[1]));
                    break;
                case "mark-done":
                    fileHandler.markDone(Integer.parseInt(args[1]));
                    break;
                case "list":
                    fileHandler.list();
                    break;
                case "list-done":
                    fileHandler.listDone();
                    break;
                case "list-todo":
                    fileHandler.listToDo();
                    break;
                case "list-in-progress":
                    fileHandler.listInProgress();
                    break;
                default:
                    System.out.println("command given isn't valid: " + args[0]);
            }
        } catch (Exception e) {
            System.err.println("no command given!");
        }
        tastiera.close();
    }
}
