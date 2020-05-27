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
 * Servlet implementation class Detail
 */
@WebServlet("/Detail")
public class Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Detail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		DetailDao dao = new DetailDao();
		ArrayList<Menu> menuList = dao.getMenu(id);
		ArrayList<Rating> ratingList = dao.getReview(id);
		Restaurant detail = dao.getDetail(id);
		ArrayList<String> imgList = dao.getImage(id);
		ArrayList<Course> courseList = dao.getCourse(id);
		HttpSession session = request.getSession();
		session.setAttribute("menu", menuList);
		session.setAttribute("rating", ratingList);
		session.setAttribute("detail", detail);
		session.setAttribute("image", imgList);
		session.setAttribute("course", courseList);
		session.setAttribute("restaurantId", id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/detail.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
