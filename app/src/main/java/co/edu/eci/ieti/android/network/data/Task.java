package co.edu.eci.ieti.android.network.data;

public class Task {
    private int id;
    private String title;
    private String status;
    private String dueDate;
    private String responsable;

    public Task() {
    }

    public Task(int id, String title, String status, String dueDate, String responsable) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.dueDate = dueDate;
        this.responsable = responsable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
}
