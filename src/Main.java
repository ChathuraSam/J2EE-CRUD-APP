import com.chathura.usermanagement.dao.UserDAO;
import com.chathura.usermanagement.model.User;

public class Main {
	
	public Main() {
		//create user
		UserDAO userDAO = new UserDAO();
		User user = new User("Chathura", "chathura@gmail.com", "Sri lanka");
		userDAO.createUser(user);
		System.out.println("user Created");
		
	}

}
