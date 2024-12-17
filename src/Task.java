import java.time.LocalDateTime;
import java.time.ZoneId;

public class Task {
    private int id;
    private String description;
    private enum statusEnum {
        TO_DO,
        IN_PROGRESS,
        DONE
    }
    private statusEnum status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    Task(int id, String description){
        this.id = id;
        this.description = description;
        this.status = statusEnum.TO_DO;
        this.createdAt = LocalDateTime.now(ZoneId.of("Europe/Rome"));
        this.updatedAt = LocalDateTime.now(ZoneId.of("Europe/Rome"));
    }

    Task(int id, String description, statusEnum status, String createdAt, String updatedAt){
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = LocalDateTime.now(ZoneId.of("Europe/Rome"));
        this.updatedAt = LocalDateTime.now(ZoneId.of("Europe/Rome"));
        //continue from here
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
}
