package test;
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 
@SuppressWarnings("serial")
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {  
     response.setContentType("text/html");  
     PrintWriter out=response.getWriter();  
     out.println("<a href='index.html'>Add New Employe1</a>");  
     out.println("<h1>ServletCurd</h1>");  
       
     List<Employe1> list=EmployeDAO.getAllEmployees();  
       
     out.print("<table border='1' width='100%'");  
     out.print
 ("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th> <th>Edit</th><th>Delete</th></tr>");  
     for(Employe1 ep:list){  
    out.print
    ("<tr><td>"+ep.getId()+"</td><td>"+ep.getName()+"</td><td>"+ep.getPassword()
     +"</td><td>"+ep.getEmail()+"</td><td>"+ep.getCountry()
    		+"</td><td><a href='EditServlet?id="+ep.getId()+"'>edit</a>"
    + "</td><td><a href='DeleteServlet?id="+ep.getId()+"'>delete</a></td></tr>");  
     
     }  
     out.print("</table>");  
       
     out.close();  
 }  
}
