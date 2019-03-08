package servlets;


import java.util.Date ;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

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


public class Register_servlet extends HttpServlet {
	
		
		
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			String fname,sname,gender,birth,work_addr,home_addr;
			Date dbirth;


			System.out.println("Getting user's information from: 	"+req.getRequestURL());
			Map<String, String> map = req.getParameterMap();	//TODO probable runtime error 
			get_params(req, map);
			
			//get inputs
			fname = req.getParameter("fname");
			sname = req.getParameter("sname");
			gender = req.getParameter("gender");
			birth = req.getParameter("birth");
			dbirth = birth_to_date(birth);
			
			work_addr = req.getParameter("work_addr");
			home_addr = req.getParameter("home_addr");
			if (work_addr.isEmpty()) work_addr = null;
			if (home_addr.isEmpty()) home_addr = null;
			
			SessionFactory factory = new 	Configuration().
											configure("hibernate.cfg.xml").
											addAnnotatedClass(User.class).
											addAnnotatedClass(User_address.class).
											buildSessionFactory();
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			//save user to mysql
			User user = new User(fname, sname, gender, dbirth);
			System.out.println( "User: "+user.toString());
			session.save(user);//TODO month bug
			
			if(!(work_addr == null) || !(home_addr == null)) {
				int uid = user.getId();
				User_address user_ad = new User_address(work_addr,home_addr,uid); 
				System.out.println( "User_add: "+user_ad.toString());
				session.save(user_ad);
			}
			
			
			session.getTransaction().commit();
			
			//success message and link to home
			PrintWriter out = res.getWriter();
			out.println("<html>\r\n" + 
					"<body>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"<h3>Done!</h3>"
					+ "<div>\r\n" + 
					"  <a href=\"http://localhost:8080/proj_1/index.jsp\">Home</a>"
					+ "\r\n" + 
					"</div>\r\n" + 
					"</body>\r\n" + 
					"</html>\r\n" + 
					"");
	}
		//convert String to Date object
	private Date birth_to_date(String birth) {

		SimpleDateFormat a = new SimpleDateFormat("yyyy-mm-dd");
		Date dbirth = new Date(0);
									try {
		dbirth = a.parse(birth);
		System.out.println("Date object "+dbirth);	}catch (ParseException e) { e.printStackTrace();}
									return  dbirth;
	}
	
	private void get_params(HttpServletRequest req, Map<String, String> map) {
		for (Map.Entry<String, String> pair : map.entrySet()){
			String K = pair.getKey();
			String V = req.getParameter(K);
			System.out.println(K+ " : "+V);

		}
	}

}
