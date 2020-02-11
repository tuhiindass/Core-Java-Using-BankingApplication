package abc.com;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		 String custid= request.getParameter("custid");
		 String pwd=request.getParameter("pwd");
		  
		  Model model=new Model();
		  model.setCustid(custid);
		  model.setPwd(pwd);
		  boolean result=model.login();
		  if(result==true){
			 int accno= model.getAccno();
			 HttpSession session=request.getSession(true);
			 session.setAttribute("accno", accno);
			 response.sendRedirect("/BankApp/home.jsp");
		  }
		  else{
			  response.sendRedirect("/BankApp/error.html");
		  }
	  }
	
	
	

}
