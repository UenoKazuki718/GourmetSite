package グル渋;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditUser
 */
@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUser() {
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
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("loginUser");
		int id = Integer.parseInt(user);
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        // アカウントをDBに登録
        EditUserDao eud = new EditUserDao();
        int ret = eud.EditUser(id,name,email,password);
     // セッションにアカウント情報を保存
        String url;
        if(ret==0) {
	        BookDao bd = new BookDao();
			ArrayList<BookDetails> bookList = bd.getBook(id);
			session.setAttribute("bookList", bookList);
			session.setAttribute("success", "success"); 
			url = "/WEB-INF/myPage.jsp";
        }else {
            session.setAttribute("error", "error"); 
            url = "/WEB-INF/editAccount.jsp";
            }
         RequestDispatcher rd = request.getRequestDispatcher(url);
         rd.forward(request, response);
	}

}
