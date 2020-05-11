package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Ephemeral.bean.dao.impl.DatabaseManageImpl;
import com.Ephemeral.entity.User;

/**
 * Servlet implementation class do_register
 */
@WebServlet("/do_register")
public class do_register extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public do_register()
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
		String docType = "<!DOCTYPE html> \n";
		PrintWriter out = response.getWriter();
		out.println
		(
			docType + "<html>\n" + "<head><title>不要打破第四面墙</title></head>\n" 
			+ "<body>"
			+ "<script>alert('为防止暴力破解，get提交被禁止。'); window.location='../index.jsp' </script>"
			+ "</body>"
			+ "</html>"
		);
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
		ResultSet rs = null;
		User user = new User();
		boolean flag_exist = false;
		String docType = "<!DOCTYPE html> \n";
		PrintWriter out = response.getWriter();
		int nowUserType = 3;
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		String confirm_password = request.getParameter("confirm_password");
		String verifyInput = null;
		String verifyCode = null;
		verifyInput = request.getParameter("checkcode");
		verifyCode = (String) session.getAttribute("verificationCode");
		int verify_flag = 0;
		int verify = 1;
		verify = Integer.valueOf(session.getAttribute("verify").toString());
		try
		{
			nowUserType = Integer.valueOf(session.getAttribute("type").toString());
		}catch(NullPointerException e)
		{
			nowUserType = 3;
		}
		try
		{
			if(verifyInput.equalsIgnoreCase(verifyCode))
				verify_flag = 1;
			else
				verify_flag = 0;
		}catch(NullPointerException e)
		{
			verify_flag = 0;
		}
		if((nowUserType != 1 && verify == 1) || (nowUserType == 1 && verify == 0))
		{
			if(verify_flag == 1 || verify == 0)
			{
				if(userName.equals("") && verify == 1)
				{
					out.println
					(
						docType + "<html>\n" + "<head><title>用户名不能为空</title></head>\n" 
						+ "<body>"
						+ "<script>alert('用户名不能为空。'); window.location='../register.jsp' </script>"
						+ "</body>"
						+ "</html>"
					);
				}
				else if(passWord.equals("") && verify == 1)
				{
					out.println
					(
						docType + "<html>\n" + "<head><title>密码不能为空</title></head>\n" 
						+ "<body>"
						+ "<script>alert('密码不能为空。'); window.location='../register.jsp' </script>"
						+ "</body>"
						+ "</html>"
					);
				}
				else if(passWord.equals("") && verify == 0)
				{
					out.println
					(
						docType + "<html>\n" + "<head><title>密码不能为空</title></head>\n" 
						+ "<body>"
						+ "<script>alert('密码不能为空。'); window.parent.document.getElementById(\"float-cover-change\").style.display=\"none\"; parent.window.location.href=\"../main.jsp\";</script>"
						+ "</body>"
						+ "</html>"
					);
				}
				else if(passWord.equals("") && verify == 0)
				{
					out.println
					(
						docType + "<html>\n" + "<head><title>密码不能为空</title></head>\n" 
						+ "<body>"
						+ "<script>alert('密码不能为空。'); window.parent.document.getElementById(\"float-cover-change\").style.display=\"none\"; parent.window.location.href=\"../main.jsp\";</script>"
						+ "</body>"
						+ "</html>"
					);
				}
				if(passWord.equals(confirm_password))
				{
					user.setUsername(request.getParameter("username"));
					user.setPassword(request.getParameter("password"));
					user.setType(Integer.valueOf(session.getAttribute("newType").toString()));
					try
					{
						ArrayList <User>list = manage.getAllUser();
						for(User userList:list)
						{
							if(userList.getUsername().equals(user.getUsername()))
							{
								flag_exist = true;
								break;
							}
						}
						if(!flag_exist)
						{
							manage.newUser(user);
							if(verify == 0)
							{
								out.println(
										docType + "<html>\n" + "<head><title>完成了--by:王泽洋</title></head>\n" 
										+ "<body>"
										+ "<script>alert('管理员账号注册完成了。'); window.parent.document.getElementById(\"float-cover-change\").style.display=\"none\"; parent.window.location.href=\"../main.jsp\";</script>"
										+ "</body>"
										+ "</html>"
									);
							}
							else
							{
								out.println
								(
									docType + "<html>\n" + "<head><title>完成了--by:王泽洋</title></head>\n" 
									+ "<body>"
									+ "<script>alert('用户账号注册完成了。'); window.location='../index.jsp' </script>"
									+ "</body>"
									+ "</html>"
								);
							}
						}
						else
						{
							if(verify == 0)
							{
								out.println(
										docType + "<html>\n" + "<head><title>用户名已经存在--by:王泽洋</title></head>\n" 
										+ "<body>"
										+ "<script>alert('这个用户名已经存在了。'); window.parent.document.getElementById(\"float-cover-change\").style.display=\"none\"; parent.window.location.href=\"../main.jsp\";</script>"
										+ "</body>"
										+ "</html>"
									);
							}
							else
							{
								out.println
								(
									docType + "<html>\n" + "<head><title>用户名已经存在--by:王泽洋</title></head>\n" 
									+ "<body>"
									+ "<script>alert('这个用户名已经存在了。'); window.location='../register.jsp' </script>"
									+ "</body>"
									+ "</html>"
								);
							}
						}
					} catch (SQLException | ClassNotFoundException e)
					{
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
				else
				{
					if(verify == 0)
					{
						out.println(
								docType + "<html>\n" + "<head><title>两次输入的密码不一致--by:王泽洋</title></head>\n" 
								+ "<body>"
								+ "<script>alert('两次输入的密码不一致。'); window.parent.document.getElementById(\"float-cover-change\").style.display=\"none\"; parent.window.location.href=\"../main.jsp\";</script>"
								+ "</body>"
								+ "</html>"
							);
					}
					else
					{
						out.println
						(
							docType + "<html>\n" + "<head><title>两次输入的密码不一致--by:王泽洋</title></head>\n" 
							+ "<body>"
							+ "<script>alert('两次输入的密码不一致。'); window.location='../register.jsp' </script>"
							+ "</body>"
							+ "</html>"
						);
					}
				}
			}
			else
			{
				out.println
				(
					docType + "<html>\n" + "<head><title>验证码错误--by:王泽洋</title></head>\n" 
					+ "<body>"
					+ "<script>alert('验证码输入错误。'); window.location='../register.jsp' </script>"
					+ "</body>"
					+ "</html>"
				);
			}
		}
		else
		{
			out.println("<script>alert('不要打破第四面墙!');window.parent.document.getElementById(\"float-cover-change\").style.display=\"none\"; parent.window.location.href=\"../main.jsp\"</script>");
		}
	}
}
