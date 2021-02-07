

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
 * Servlet implementation class proupdate
 */
@WebServlet("/proupdate")
public class proupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	PreparedStatement pst=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public proupdate() {
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
		String product=request.getParameter("proname");
		String procode=request.getParameter("itemcode");
		String price=request.getParameter("price");
		String stock=request.getParameter("stock");
		String rpoint=request.getParameter("repoint");
		String descrip=request.getParameter("description");
		String id=request.getParameter("itemid");
		
		//response.sendRedirect("bill.jsp?id="+product);
		
		try {
			String q="update products set pro_name='"+product+"',price='"+price+"',stock='"+stock+"',re_order_point='"+rpoint+"',description='"+descrip+"' where ID='"+id+"'";
			pst=con.prepareStatement(q);
			pst.executeUpdate();
			
			response.sendRedirect("dash.jsp");
			
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
