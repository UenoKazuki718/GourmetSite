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
 * Servlet implementation class Book
 */
@WebServlet("/Book")
public class Book extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Book() {
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
		int userId = 1;////////
		int restaurantId = (int) session.getAttribute("restaurantId");///////あとで書く
		String name = request.getParameter("name");
		String date = request.getParameter("date");
		int num = Integer.parseInt(request.getParameter("num"));
		int course = Integer.parseInt(request.getParameter("course"));
		String tel = request.getParameter("tel");
		BookDao dao = new BookDao();
		dao.setBook(userId,restaurantId,date,num,course,tel,name);
		//サーバーに保存
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/detail.jsp");
		dispatcher.forward(request, response);
	}

}
