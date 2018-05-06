package Projekt2.Projekt2;

public class Client extends Identity {
	private String Name;
	private String SurName;
	private String email;

	public Client(int id, String Name, String SurName, String email) {
		this.id = id;
		this.Name = Name;
		this.SurName = SurName;
		this.email = email;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getSurName() {
		return SurName;
	}

	public void setSurName(String SurName) {
		this.SurName = SurName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
