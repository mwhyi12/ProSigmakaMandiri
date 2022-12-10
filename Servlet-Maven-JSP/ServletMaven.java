package com.prodemy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servletMaven")
public class ServletMaven extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletMaven() {
        super();
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("yourName");
		PrintWriter out = resp.getWriter();
		out.print("<h1>Hello "+name+"</h1>");
		out.close();
	}

}
