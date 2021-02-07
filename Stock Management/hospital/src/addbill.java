

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
 * Servlet implementation class addbill
 */
@WebServlet("/addbill")
public class addbill extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	PreparedStatement pst=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addbill() {
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
		//response.sendRedirect("newbill.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String items=request.getParameter("item");
		String invno=request.getParameter("invno");
		String qty=request.getParameter("qty");
		String date=request.getParameter("date");
		
		String[] selitem=items.split("-");
		
		if(Integer.parseInt(selitem[3])>=Integer.parseInt(qty)) 
		{
		
		float subtot=Float.parseFloat(selitem[2])*Float.parseFloat(qty);
		
		int newstock=Integer.parseInt(selitem[3])-Integer.parseInt(qty);
		
		try {
			String q="insert into invoice(inv_no,pro_code,pro_des,price,qty,subtot) values('"+invno+"','"+selitem[0]+"','"+selitem[1]+"','"+selitem[2]+"','"+qty+"','"+subtot+"')";
			pst=con.prepareStatement(q);
			pst.executeUpdate();
			
			String q1="update products set stock='"+newstock+"' where item_code='"+selitem[0]+"'";
			pst=con.prepareStatement(q1);
			pst.executeUpdate();
			
			response.sendRedirect("bill.jsp?invno="+invno);
			
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
		else 
		{
			response.sendRedirect("stockerror.jsp");
			//System.out.print("The Quantity You have Enters is not Available");
		}
	
	}

}
