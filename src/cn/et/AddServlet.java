package cn.et;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object r = request.getAttribute("i");
		if(r==null){
			request.setAttribute("i",100);
		}else{
			request.setAttribute("i",Integer.parseInt(r.toString())+1);
		}
		
		HttpSession session = request.getSession();
		Object s = session.getAttribute("i");
		if(s==null){
			session.setAttribute("i", 200);
		}else{
			session.setAttribute("i",Integer.parseInt(s.toString())+1);
		}
		
		ServletContext context = this.getServletContext();
		Object c = context.getAttribute("i");
		if(c==null){
			context.setAttribute("i", 300);
		}else{
			context.setAttribute("i",Integer.parseInt(c.toString())+1);
		}
		request.getRequestDispatcher("/add.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
