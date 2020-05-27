package グル渋;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
				request.setCharacterEncoding("UTF-8");
				String email = request.getParameter("mail");
				String password = request.getParameter("password");

				// ログイン処理
				//LoginFuncs loginFuncs = new LoginFuncs();
				//boolean isLogin = loginFuncs.execute(name, password);
				UserDao dao = new UserDao();
				int id = dao.findAccount(email,password);
				// ログイン成功時の処理
				System.out.println(id);
				if (id!=0) {
//					User user = new User(name, password);
					// ユーザー情報をセッションスコープに保存
					HttpSession session = request.getSession();
					session.setAttribute("loginUser", ""+id);
				}

				// ログイン結果画面にフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher(
						"/loginSuccess.jsp"
						);
				dispatcher.forward(request, response);
	}

}
