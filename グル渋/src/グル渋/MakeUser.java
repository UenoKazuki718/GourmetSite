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
 * Servlet implementation class AccountRegister
 */
@WebServlet("/MakeUser")
public class MakeUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeUser() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");


        // makeAccout.jspから受け取った値をビーンズにセット


        // アカウントをDBに登録
        MakeUserDAO mud = new MakeUserDAO();
        mud.MakeUserDAO(name,email,password);
        // セッションにアカウント情報を保存
        HttpSession session = request.getSession();
        session.setAttribute("user", mud);

        RequestDispatcher rd = request.getRequestDispatcher("makeUserSuccess.jsp");
        rd.forward(request, response);

    }

}