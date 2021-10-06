
import java.io.*;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class validationServlet
 */
public class validationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public validationServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			Integer i1=Integer.valueOf(request.getParameter("op1"));
			Integer i2=Integer.valueOf(request.getParameter("op2"));
			request.setAttribute("n1", i1);
			request.setAttribute("n2", i2);
		}
		catch(Exception e) {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("value should be number");
			RequestDispatcher rd=request.getRequestDispatcher("/view.html");
			rd.include(request, response);
			return;
			
		}
		String action=request.getParameter("action");
		RequestDispatcher rd=null;
		if(action.equals("Add"))
			rd=request.getRequestDispatcher("/add");
		else if(action.equals("Sub"))
			rd=request.getRequestDispatcher("/Sub");
		else if(action.equals("Multi"))
			rd=request.getRequestDispatcher("/mulp");
		else
			rd=request.getRequestDispatcher("/divp");
		rd.forward(request, response);	
		
	}

}
