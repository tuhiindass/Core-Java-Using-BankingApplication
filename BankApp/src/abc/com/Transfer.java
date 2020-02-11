package abc.com;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Transfer
 */
public class Transfer extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		int accno = (int) session.getAttribute("accno");
		String amt=request.getParameter("amt");
		String  raccno=request.getParameter("raccno");
		
		int theAmt=Integer.parseInt(amt);
		int theRaccno=Integer.parseInt(raccno);
		
		Model model=new Model();
		model.setAccno(accno);
		model.setBalance(theAmt);
		model.setRaccno(theRaccno);
		
		boolean result=model.transfer();
		
		if(result)
		   response.sendRedirect("/BankApp/transferSuccess.jsp");
		else
			response.sendRedirect("/BankApp/transferFail.html");
		
	}
}
