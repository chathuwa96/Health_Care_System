

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospital.dbconnect;

/**
 * Servlet implementation class deletebill
 */
@WebServlet("/deletebill")
public class deletebill extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	PreparedStatement pst=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletebill() {
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
		 String id=request.getParameter("itemID");
		 String code=request.getParameter("itemcode");
		 String invid=request.getParameter("inv");
		 
		 String id0=id.substring(0,id.length()-1);
		 String code0=code.substring(0,code.length()-1);
		 
		 int stock=0;
		 int qty=0;
		 int newstk=0;
		 
			try {
				
				String q1="select * from invoice where ID='"+id0+"'";
				pst=con.prepareStatement(q1);
				ResultSet rs1=pst.executeQuery();
				if(rs1.next())
				{
					 qty=Integer.parseInt(rs1.getString("qty"));
				}
				
				
				String q2="select * from products where item_code='"+code0+"'";
				pst=con.prepareStatement(q2);
				ResultSet rs2=pst.executeQuery();
				if(rs2.next())
				{
					 stock=Integer.parseInt(rs2.getString("stock"));
					 newstk=qty+stock;
				}

				String q="update products set stock='"+newstk+"' where item_code='"+code0+"'";
				pst=con.prepareStatement(q);
				pst.executeUpdate();
				
				
				String q4="Delete from invoice where ID='"+id+"' ";
				pst=con.prepareStatement(q4);
				pst.execute();

				response.sendRedirect("bill.jsp?invno="+invid);
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("delete error "+e);
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
