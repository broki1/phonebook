import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class Contact {

	protected String name;
	protected String phoneNumber;
	protected LocalDateTime createdAt;
	static int idTracker = 1;
	protected int id;

	public Contact(String name, String phoneNumber, LocalDateTime createdAt) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.createdAt = createdAt;
		this.id = idTracker++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public int getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", id=" + id + "]";
	}

}
