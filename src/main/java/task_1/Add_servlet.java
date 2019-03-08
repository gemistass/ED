package task_1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Add_servlet extends HttpServlet{
												
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
		//		service
		int i =Integer.parseInt(req.getParameter("num1"));
		int j =Integer.parseInt(req.getParameter("num2"));
		int k = i+j;
		System.out.println(k);
		PrintWriter res_prw = res.getWriter();
		res_prw.println("To apotelesma tis prosthesis einai :"+k);
		
		
		
	}
	
}