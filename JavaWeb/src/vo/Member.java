package vo;

public class Member {
	
	protected String name;
	protected String email;
	protected String number;
	protected String password;
	
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getNumber() {
		return number;
	}

	public String getPassword() {
		return password;
	}

	public Member setName(String name) {
		this.name = name;
		return this;
	}
	
	public Member setEmail(String email) {
		this.email = email;
		return this;
	}

	public Member setNumber(String number) {
		this.number = number;
		return this;
	}

	public Member setPassword(String password) {
		this.password = password;
		return this;
	}
}
