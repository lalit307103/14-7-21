 package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.jdbc.pool.OracleDataSource;
 
/**
 * Servlet implementation class webpractice
 */
@WebServlet(description = "my first web", urlPatterns = {"/webpractice" })
public class webpractice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public webpractice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//capture the values entered by the user
		
	String studid = request.getParameter("studentid");
	String studname = request.getParameter("studentname");
	String studgender = request.getParameter("r1");
	String stunsub = request.getParameter("r2");
	
	  /*  //displaying the values
		out.println("student_id,student_name,stud_gender,stud_sub   "+"=="+studid+"    "+studname+"   "+studgender+"   "+stunsub+"");
		out.println("<table><table Border =1><tr><td>"+ studid+" </td> <td> "+studname+"</td></tr><tr><td>"+studgender+"</td><td>"+stunsub+" </td></tr></table>");
	*/	Connection con;
		PreparedStatement prp;
		OracleDataSource ods;
			String qry="insert into student values(?,?,?,?)";
		try {
			//create an object for ODS
			ods=new OracleDataSource();
			//injecting the appropriate values
			ods.setUser("system");
			ods.setPassword("test");
			ods.setPortNumber(1521);
			ods.setDriverType("thin");
			ods.setServerName("localhost");
			ods.setDatabaseName("xe");
			con=ods.getConnection(); //get the connection
			prp=con.prepareStatement(qry);
			//setting the IN parameters
			prp.setInt(1,Integer.parseInt(studid));
			prp.setString(2, studname);
			prp.setString(3, studgender);
			prp.setString(4, stunsub);
			
			
			int row=prp.executeUpdate();  //executing query
			     if(row>0)
			    out.println("    :Student Record Save Sucessfully ");
		}
		catch(Exception e) {
			e.printStackTrace();
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
