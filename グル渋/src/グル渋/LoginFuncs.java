package グル渋;

public class LoginFuncs {

	/**
	 * User認証を実行する
	 * @param userName
	 * @param mail
	 * @param password
	 * @return
	 */
	public boolean execute(String mail, String password) {
		var userDao = new UserDao();
		var user = userDao.findUser(mail);

		if (user != null && user.getPassword().equals(password)) {
			return true;
		}

		return false;
	}

}
