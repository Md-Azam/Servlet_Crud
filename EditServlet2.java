package test;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/EditServlet2") 
public class EditServlet2 extends HttpServlet{
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	          throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	          
	        String sid=request.getParameter("id");  
	        int id=Integer.parseInt(sid);  
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
	          
	        int status=EmployeDAO.update(ep);  
	        if(status>0){  
	            response.sendRedirect("ViewServlet");  
	        }else{  
	            out.println("Sorry! unable to update record");  
	        }  
	          
	        out.close();  
	    }  
	  
	}  

