package com.prodemy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/jdbcMaven")
public class JdbcMaven extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static final String url = "jdbc:postgresql://localhost/sriwijayauniversity";
	static final String user = "postgres";
	static final String password = "123";
	
	public static Connection connect() {
		Connection conn = null;
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Koneksi berhasil");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nim = request.getParameter("nim_mhs");
		String nama = request.getParameter("nama_mhs");
		String domisili = request.getParameter("domisili_mhs");
		
		Connection conn = null;
        try {
			//Insert To Database
			String sql = "insert into mahasiswa(nim_mhs, nama_mhs, domisili_mhs) values('"+nim+"','"+nama+"','"+domisili+"')";
			conn = connect();
			Statement stt = conn.createStatement();
			stt.executeUpdate(sql);
			
			//Displays From Database
			request.setAttribute("nim", nim);
			request.setAttribute("nama", nama);
			request.setAttribute("domisili", domisili);
			request.getRequestDispatcher("view.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
