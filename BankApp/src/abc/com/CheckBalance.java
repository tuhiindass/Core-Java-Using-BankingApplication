package abc.com;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckBalance
 */
public class CheckBalance extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session=request.getSession();
	int accno=(int) session.getAttribute("accno");
	
	Model model=new Model();
	model.setAccno(accno);
	boolean result=model.checkBalance();
	
	if(result==true){
		int balance= model.getBalance();
		session.setAttribute("balance", balance);
		response.sendRedirect("/BankApp/checkBalanceSuccess.jsp");
	}
	else{
		response.sendRedirect("/BankApp/checkBalanceError.html");
	}
			
	
	
	
	}

}
