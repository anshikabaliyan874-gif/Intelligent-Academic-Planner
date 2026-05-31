package Backend.JavaSourceCode.model;

public class Activity {

    private String title;
    private String description;
    private String timeAgo;

    public Activity() {
    }

    public Activity(String title, String description, String timeAgo) {
        this.title = title;
        this.description = description;
        this.timeAgo = timeAgo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimeAgo() {
        return timeAgo;
    }

    public void setTimeAgo(String timeAgo) {
        this.timeAgo = timeAgo;
    }

}
