package Backend.JavaSourceCode.model;

public class Task {
	private Long id;
	private String title;
	private String priority;
	private boolean completed;

	public Task() {}

	public Task(Long id, String title, String priority, boolean completed) {
		this.id = id;
		this.title = title;
		this.priority = priority;
		this.completed = completed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
}
