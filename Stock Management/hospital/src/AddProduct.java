

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
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	PreparedStatement pst=null;

    /**
     * Default constructor. 
     */
    public AddProduct() {
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
		
		//response.sendRedirect("bill.jsp?id="+product);
		
		try {
			String q="insert into products(item_code,pro_name,price,stock,re_order_point,description) values('"+procode+"','"+product+"','"+price+"','"+stock+"','"+rpoint+"','"+descrip+"')";
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
		//doGet(request, response);
		
		
		String product=request.getParameter("proname");
		String price=request.getParameter("price");
		String stock=request.getParameter("stock");
		String rpoint=request.getParameter("repoint");
		String descrip=request.getParameter("description");
		
		response.sendRedirect("bill.jsp?id="+product);
		
		/*try {
			String q="insert into test(pro_name,price,stock,re_order_point,description) values('"+product+"','"+price+"','"+stock+"','"+rpoint+"','"+descrip+"')";
			pst=con.prepareStatement(q);
			pst.executeUpdate();
			
			response.sendRedirect("bill.jsp");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("db error"+e);
			
		}finally {
				try {
					pst.close();
				
				}catch(Exception e) {
				
			}
		}
		*/
		
	}

}
