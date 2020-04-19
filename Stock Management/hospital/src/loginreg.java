

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import hospital.dbconnect;

/**
 * Servlet implementation class loginreg
 */
@WebServlet("/loginreg")
public class loginreg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
    PreparedStatement pst=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginreg() {
        super();
        // TODO Auto-generated constructor stub
        con=dbconnect.connect();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String name=request.getParameter("user");
		String email=request.getParameter("mail");
		String phone=request.getParameter("phone");
		String password=request.getParameter("pass");
		
		
		if(request.getParameter("confirmpass").equals(password)) {
		
		try {
			String q="insert into register(name,phone,email,password) values('"+name+"','"+phone+"','"+email+"','"+password+"') ";
			pst=con.prepareStatement(q);
			pst.execute();
			
			response.sendRedirect("loginform.jsp");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("db error"+e);
			
		}finally {
				try {
					pst.close();
				
				}catch(Exception e) {
				
			}
		}

		
		
		}
		else {
			
			JOptionPane.showMessageDialog(null,"please enter the correct value");
			
		}
	}
	
	

}
