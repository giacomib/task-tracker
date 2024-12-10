import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner tastiera = new Scanner(System.in);
        FileHandler fileHandler = new FileHandler("taskList.json");
        fileHandler.newID();

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
                break;
            case "list-done":
                break;
            case "list-todo":
                break;
            case "list-in-progress":
                break;
            default:
                System.out.println("operazione non valida");
        }

        tastiera.close();
    }
}
