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
 * Servlet implementation class Review
 */
@WebServlet("/Review")
public class Review extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Review() {
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
		int rating = Integer.parseInt(request.getParameter("rating"));
		HttpSession session = request.getSession();
		int restaurantId = (int) session.getAttribute("restaurantId");///////あとで書く
		String user = (String) session.getAttribute("loginUser");
		int userId = Integer.parseInt(user);
		HTMLescape xss = new HTMLescape();
		String text = xss.escapeHTML(request.getParameter("text"));
		ReviewDao dao = new ReviewDao();
		dao.setReview(rating,text,restaurantId,userId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/detail.jsp");
		dispatcher.forward(request, response);
	}

}
