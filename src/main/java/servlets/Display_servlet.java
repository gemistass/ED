package servlets;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import task_1.User;
import task_1.User_address;
public class Display_servlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter out = res.getWriter();
		
		
		SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(User_address.class)
					.addAnnotatedClass(User.class)
					.buildSessionFactory();
		Session session = factory.getCurrentSession() ;
				
		session.beginTransaction();
		List<User> l1 = session.createQuery("from User").list();
//		List<User_address> l2 = session.createQuery("from User_address").list();
		session.close();
		out.println();
//		RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
//		rd.include(req, res);
		
		//add users for presentation
		out.println("\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<style>\r\n" + 
				"body {\r\n" + 
				"	background-size : cover;\r\n" + 
				"	background-image:url('https://i.ytimg.com/vi/vZF1ye0c4P4/maxresdefault.jpg');\r\n" + 
				"	\r\n" + 
				"}\r\n" + 
				"div{\r\n" + 
				"background-color:white;\r\n" + 
				"width:200px;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<div>\r\n" + 
				"<h3>Display Users</h3>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"  <a href=\"http://localhost:8080/proj_1/index.jsp\">Home</a><br><br>	");
		for (User u : l1) {
			out.print("  <a href= \"http://localhost:8080/proj_1/view_user?id="+u.getId()+"  \" target=\"_blank\">  ");
			out.print(u.getFname()+" "+u.getSname());
			out.print(" </a>  <br>");

		}	
		out.println(
				"</div>\r\n" + 
				"</body>\r\n" + 
				"</html>");
		
//		
	};
}
