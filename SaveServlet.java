package test;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/server")  
public class SaveServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	         throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        int id = Integer.parseInt(request.getParameter("id"));
	        String name=request.getParameter("name");  
	        String password=request.getParameter("password");  
	        String email=request.getParameter("email");  
	        String country=request.getParameter("country");  
	          
	        Employe1 ep=new Employe1(); 
	        ep.setId(id);
	        ep.setName(name);  
	        ep.setPassword(password);  
	        ep.setEmail(email);  
	        ep.setCountry(country);  
	          
	        int status=EmployeDAO.Save(ep); 
	        if(status>0){  
	            out.print("<p>Record saved successfully!</p>");  
	            request.getRequestDispatcher("index.html").include(request, response);  
	        }else{  
	            out.println("Sorry! unable to save record");  
	        }  
	          
	        out.close();  
	    }  
	  
	}  

