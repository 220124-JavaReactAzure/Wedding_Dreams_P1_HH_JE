package weddingDreams.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class WeddingServlet extends HttpServlet {
	ObjectMapper mapper;
	
	public WeddingServlet(ObjectMapper mapper){
		this.mapper = mapper;
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("Welcome to Wedding Dream Planning! Have you already planned what you want to do for the wedding?");
	}

}
