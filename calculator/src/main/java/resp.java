

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class resp
 */
public class resp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public resp() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
				Integer result=(Integer)request.getAttribute("result");
				RequestDispatcher rd=request.getRequestDispatcher("/view.html");
				if(result==null) {
					rd.forward(request, response);
					return;
				}
				
				try {
					response.setContentType("text/html");
					PrintWriter out=response.getWriter();
					String op=(String)request.getAttribute("operation");
					out.println(op+"Result: <b>"+result.intValue()+"<b>,<br/>");
					rd.include(request, response);
				}
				catch(Exception e) {};
			}

		}

