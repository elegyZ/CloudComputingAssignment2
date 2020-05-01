package assignment2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WolfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String question = request.getParameter("question");
		String answer = WolframAlpha2.query(question);
		Wolf wolf = new Wolf();
		wolf.initWolf(question, answer);
		request.setAttribute("wolf", wolf);
		request.getRequestDispatcher("answer.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doGet(request, response);
	}
}
