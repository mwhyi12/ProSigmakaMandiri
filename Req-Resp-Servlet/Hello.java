package com.prodemy.reqresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String nama = req.getParameter("nama");
		String asal = req.getParameter("asal");
		String gender = req.getParameter("gender");
		String tgllhr = req.getParameter("tgllhr");
		
		out.print("<html>");
		out.print("<body>");
		out.print("<h1><center>Hello Servlet</center></h1>");
		
		out.print("<h3>Bilangan Fibonacci</h3>");
		int num1=0, num2=1, n=10, num3, i ;
		out.print(num1+" "+num2);
		for(i=2;i<n;++i) {
			num3=num1+num2;
			out.print(" "+num3);
			num1=num2;
			num2=num3;
		}
		out.print("<br><br><hr><br>");
		out.print("<h3>Biodata</h3>");
		out.print("Nama Lengkap : "+nama);
		out.print("<br>");
		out.print("Domisili : "+asal);
		out.print("<br>");
		out.print("Gender : "+gender);
		out.print("<br>");
		out.print("Tanggal Lahir : "+tgllhr);
		out.print("</body>");
		out.print("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
