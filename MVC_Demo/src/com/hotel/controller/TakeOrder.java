package com.hotel.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.service.Chef;

@WebServlet("/takeOrder")
public class TakeOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private Chef chef = new Chef();
    public TakeOrder() {
        super();
        
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	Integer itemId = Integer.valueOf(request.getParameter("order"));
    	if(Objects.nonNull(itemId)) {
    		request.setAttribute("yourOrder",chef.serveTheOrder(itemId));
    	}
    	
    	RequestDispatcher rd = request.getRequestDispatcher("serve.jsp");
    	rd.forward(request, response);
    	
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}

}
