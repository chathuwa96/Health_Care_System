

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hospital.dbconnect;

/**
 * Servlet implementation class loginsign
 */
@WebServlet("/loginsign")
public class loginsign extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
    
	String mail1,pass1;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginsign() {
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
		String mail=request.getParameter("mail");
		String password=request.getParameter("pass");	
		
		
		try {
			String sq="select * from register where email='"+mail+"' ";
			pst=con.prepareStatement(sq);
			rs=pst.executeQuery();
			
			if(rs.next()) {
				mail1=rs.getString("email");
				pass1=rs.getString("password");
			}
		}
		catch(Exception e) {
			System.out.println("values get db connection error"+e);
			
		}finally {
			try {
				pst.close();
				
			}catch(Exception e) {
				
			}
		}

		
		
		
		
		if(mail.equals(mail1)&&password.equals(pass1)) {
			
			HttpSession session=request.getSession(true);
			session.setAttribute("user", mail);
			response.sendRedirect("ordertable.jsp");
			
		}
		else {
			response.sendRedirect("loginerror.jsp");
			//System.out.println(" invalid username Password");
		}
	}

}
