package com.prodemy.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jdbc")
public class Jdbc extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String nim = request.getParameter("nim_mhs");
		String nama = request.getParameter("nama_mhs");
		String domisili = request.getParameter("domisili_mhs");
		
		String DB_URL = "jdbc:postgresql://localhost/sriwijayauniversity";
		String USER = "postgres";
		String PASS = "123";
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		
		out.println("<html>");
		out.println("<body>");
        out.println("<h3>Data Mahasiswa</h3>");
        out.println("<table border=1><tr><td><b>NIM</b></td><td><b>Nama</b></td><td><b>Domisili</b></td></tr>");
		
        try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stt = conn.createStatement();
			
			//Insert To Database
			String inputDataSQL = "insert into mahasiswa(nim_mhs, nama_mhs, domisili_mhs) values('"+nim+"','"+nama+"','"+domisili+"')";
			System.out.println(inputDataSQL);
			stt.execute(inputDataSQL);
			System.out.println("inserted record into table");
			
			//Displays From Database
			String outputDataSQL = "select * from public.mahasiswa;";
			ResultSet output = stt.executeQuery(outputDataSQL);
			
			while(output.next()) {
				String nim1 = output.getString("nim_mhs");
				String nama1 = output.getString("nama_mhs");
				String domisili1 = output.getString("domisili_mhs");
				out.println("<tr><td>"+nim1+"</td><td>"+nama1+"</td><td>"+domisili1+"</td></tr>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
        
        out.println("</table></body></html>");
	}

}
