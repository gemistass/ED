package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import task_1.User;
import task_1.User_address;
public class View_user_servlet extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;




	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String id = req.getParameter("id");
		Integer uid = Integer.parseInt(id);
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(User_address.class)
				.addAnnotatedClass(User.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
	
		//create queries
		session.beginTransaction();
		Query info = session.createQuery("from User where id=:uid ");
		Query addr = session.createQuery("from User_address where uid=:uid");
		info.setParameter("uid",uid);
		addr.setParameter("uid", uid);
		
		//attempt to retrive single query result
		User inf=null;
		User_address ad=null;
		try {
			inf =  (User) info.getSingleResult();
			ad = (User_address) addr.getSingleResult();
			System.out.println(inf.getFname());
			System.out.println(ad.getHome_addr());
		}
			catch(NoResultException e) {
		}
		session.close();
		
		//present query results
		print_user(res, inf, ad);

	}
	
	
	

	private void print_user(HttpServletResponse res, User inf, User_address ad) throws IOException {
		PrintWriter out = res.getWriter();
		out.println("Name: "+inf.getFname()
				+"\nSurname: "+inf.getSname()
				+"\nGender : "+inf.getGender()
				+"\nBirth: "+inf.getBirth());
		if (ad != null) {
			if (ad.getHome_addr() != null) out.println("Home address: "+ad.getHome_addr());
			if (ad.getWork_addr() != null) out.println("Work address: "+ad.getWork_addr());
		}
	}
	
}
