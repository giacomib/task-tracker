import java.time.LocalDateTime;
import java.time.ZoneId;

public class Task {
    private Integer id;
    private String description;
    private enum statusEnum {
        TO_DO,
        IN_PROGRESS,
        DONE
    }
    private statusEnum status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // use this constructor when you need to
    // add a totally new task 
    Task(int id, String description){
        this.id = id;
        this.description = description;
        this.status = statusEnum.TO_DO;
        this.createdAt = LocalDateTime.now(ZoneId.of("Europe/Rome"));
        this.updatedAt = LocalDateTime.now(ZoneId.of("Europe/Rome"));
    }

    // sort of copy constructor, use this when you
    // need to import data already existing in the file
    Task(int id, String description, String status, String createdAt, String updatedAt){
        this.id = id;
        this.description = description;
        this.status = fromStringToStatus(status);
        this.createdAt = LocalDateTime.parse(createdAt);
        this.updatedAt = LocalDateTime.parse(updatedAt);
    }

    public int getid(){
        return this.id;
    }

    public String getDescription() {
        String result = this.description;
        return result;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
        this.updatedAt = LocalDateTime.now(ZoneId.of("Europe/Rome"));
    }

    public String getStatus() {
        return fromStatusToString(this.status);
    }

    private String fromStatusToString(statusEnum status) {
        String result;
        switch (status) {
            case TO_DO:
                result = "todo";
                break;
            case IN_PROGRESS:
                result = "in-progress";
                break;
            case DONE:
                result = "done";
                break;
        
            default:
                result = "";
                System.err.println("errore while converting from status to string");
                break;
        }
        return result;
    }

    private statusEnum fromStringToStatus(String statusString) {
        switch (statusString) {
            case "todo":
                return statusEnum.TO_DO;
            case "in-progress":
                return statusEnum.IN_PROGRESS;
            case "done":
                return statusEnum.DONE;
            default:
                System.err.println("errorwhile convertin from String to status");
                return statusEnum.TO_DO;
        }
    }

    public void setStatus(String status) {
        this.status = fromStringToStatus(status);
        this.updatedAt = LocalDateTime.now(ZoneId.of("Europe/Rome"));
    }

    public String createdAt() {
        return this.createdAt.toString();
    }

    public String updatedAt() {
        return this.updatedAt.toString();
    }

    @Override
    public String toString() {
        return "ID: " + this.id.toString() + " " +
                "decription: " + this.description.toString() + " " +
                "status: " + fromStatusToString(this.status) + " " +
                "created at: " + this.createdAt().toString() + " " +
                "updated at: " + this.updatedAt().toString();
    }

    public String toWriteFile() {
        return "        {" +
                "\"ID\"" + ':' + this.id + ", " +
                "\"description\"" + ':' + '"' + this.description + '"' + ", " +
                "\"status\"" + ':' + '"' + fromStatusToString(this.status) + '"' + ", " +
                "\"createdAt\"" + ':' + '"' + this.createdAt() + '"' + ", " +
                "\"updatedAt\"" + ':' + '"' + this.updatedAt() + '"'
                + '}';
    }
}