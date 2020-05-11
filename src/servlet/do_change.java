package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Ephemeral.bean.dao.impl.DatabaseManageImpl;
import com.Ephemeral.entity.Stuc;
import com.Ephemeral.entity.User;

/**
 * Servlet implementation class do_changePw
 */
@WebServlet("/do_changePw")
public class do_change extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public do_change()
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
		DatabaseManageImpl manage = new DatabaseManageImpl();
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String docType = "<!DOCTYPE html> \n";
		String userName= (String)session.getAttribute("userName");
		Stuc stuc = new Stuc();
		int changeId = Integer.valueOf((String)session.getAttribute("changeById"));
		stuc.setID(Integer.valueOf(request.getParameter("newcID")));
		stuc.setcNo(request.getParameter("newcNo"));
		stuc.setcName(request.getParameter("newcName"));
		stuc.setcTeac(request.getParameter("newcTeac"));
		stuc.setcDep(request.getParameter("newcDep"));
		stuc.setIsOnline(request.getParameter("newisOnline"));
		stuc.setcPf(request.getParameter("newcPf"));
		stuc.setcMethod(request.getParameter("newcMethod"));
		try
		{
			manage.change(changeId, stuc);
			out.println(
					docType + "<html>\n" + "<head><title>执行修改--by:王泽洋</title></head>\n" 
					+ "<body>"
					+ "<script>alert('完成了。'); window.parent.document.getElementById(\"float-cover-change\").style.display=\"none\"; parent.window.location.href=\"../main.jsp\";</script>"
					+ "</body>"
					+ "</html>"
				);
		} catch (SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
