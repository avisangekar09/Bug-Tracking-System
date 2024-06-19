public class Bug {
    private String description;
    private String status;
    private String priority;

    public Bug(String description, String status, String priority) {
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getPriority() {
        return priority;
    }
}
