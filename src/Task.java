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

        switch (status) {
            case "todo":
                this.status = statusEnum.TO_DO;
                break;
            case "in-progress":
                this.status = statusEnum.IN_PROGRESS;
                break;
            case "done":
                this.status = statusEnum.DONE;
                break;
        
            default:
                System.err.println("errore: wrong status format");
                break;
        }

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

    public statusEnum getStatus() {
        return this.status;
    }

    public void setStatus(statusEnum status) {
        this.status = status;
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
                "status: " + this.status.toString() + " " +
                "created at: " + this.createdAt().toString() + " " +
                "updated at: " + this.updatedAt().toString();
    }
}
