

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospital.dbconnect;

/**
 * Servlet implementation class orderupdate
 */
@WebServlet("/orderupdate")
public class orderupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	PreparedStatement pst=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderupdate() {
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
		String oldstock=request.getParameter("stock");
		String newstock=request.getParameter("newstk");
		String id=request.getParameter("itemid");
		
		int finstock=Integer.parseInt(oldstock)+Integer.parseInt(newstock);
		
		try {
			String q="update products set stock='"+finstock+"' where ID='"+id+"'";
			pst=con.prepareStatement(q);
			pst.executeUpdate();
			
			response.sendRedirect("ordertable.jsp");
			
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
