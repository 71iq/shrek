package shrek.rest.shrek;
import java.util.ArrayList;
public class User {
	private final String password, userName;
	static ArrayList<User> users = new ArrayList<>();
	User(String u, String p) {
		this.userName = u;
		this.password = p;
	}

	public void add(){
		users.add(new User(this.userName, this.password));
	}

	@Override
	public String toString() {
		return "User{" + "password='" + password + '\'' + ", userName='" + userName + '\'' + '}';
	}

	public static ArrayList<User> getUsers() {
		return users;
	}

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}
}