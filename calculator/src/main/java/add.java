

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class add
 */
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public add() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int op1=((Integer)request.getAttribute("n1")).intValue();
		int op2=((Integer)request.getAttribute("n2")).intValue();
		int result=op1+op2;
		request.setAttribute("operation", "Addition");
		Integer n=Integer.valueOf(result);
		request.setAttribute("result", n);
		RequestDispatcher rd=request.getRequestDispatcher("/resp");
		rd.forward(request, response);
	}

}
