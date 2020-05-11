package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class do_redirecter
 */
@WebServlet("/do_redirecter")
public class do_redirecter extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public do_redirecter()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		float days = 0;
		try
		{
			days = Float.parseFloat(request.getParameter("days"));
			if(days != 0 )
			{
				
			}
			else
				days = 0;
		}catch(Exception e)
		{
			days = 0;
		}
		PrintWriter out = response.getWriter();
		String docType = "<!DOCTYPE html> \n";
	    if(session.getAttribute("userName") == null)
	    	out.println
			(
				docType + "<html>\n" + "<head><title>账号不存在</title></head>\n" 
				+ "<body>"
				+ "<script>alert('账号不存在。'); window.location='../index.jsp' </script>"
				+ "</body>"
				+ "</html>"
			);
	    else
	    {
	    	if(days != 0)
	    	{
	    		Cookie userNameCookie = new Cookie("userNameCookie", session.getAttribute("userName").toString());
				Cookie passWordCookie = new Cookie("passWordCookie", session.getAttribute("passWord").toString());
				userNameCookie.setMaxAge((int) (60 * 60 * 24 * days));
				passWordCookie.setMaxAge((int) (60 * 60 * 24 * days));
				userNameCookie.setPath("/");
				passWordCookie.setPath("/");
				response.addCookie(userNameCookie);
				response.addCookie(passWordCookie);
				response.sendRedirect("../main.jsp");
	    	}
	    	else
	    		response.sendRedirect("../main.jsp");
	    }
	}
}
