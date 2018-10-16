package edu.amazon.models;

public class Account {
	private Integer id;
	private String login;
	private String password;
	private String email;
	
	public Account() {}
	
	public Account(String login, String password, String email) {
		this.login = login;
		this.password = password;
		this.email = email;
	}
	
	public Integer getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Account setId(Integer id) {
		this.id = id;
		return this;
	}

	public Account setLogin(String login) {
		this.login = login;
		return this;
	}
	
	public Account setPassword(String password) {
		this.password = password;
		return this;
	}
	
	public Account setEmail(String email) {
		this.email = email;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [id=");
		builder.append(id);
		builder.append(", login=");
		builder.append(login);
		builder.append(", password=");
		builder.append(password);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}
}	

