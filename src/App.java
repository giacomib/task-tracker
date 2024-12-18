import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner tastiera = new Scanner(System.in);
        FileHandler fileHandler = new FileHandler("taskList.json");

        switch(args[0]) {
            case "add":
                fileHandler.addTask(args[1]);
                break;
            case "update":
                break;
            case "delete":
                break;
            case "mark-in-progress":
                break;
            case "mark-done":
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
                System.out.println("operazione non valida");
        }

        tastiera.close();
    }
}
