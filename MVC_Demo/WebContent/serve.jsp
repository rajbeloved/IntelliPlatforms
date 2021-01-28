<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ page import="com.hotel.model.Order"%>
</head>
<body>

	<h1>Your Order</h1>
	<%
		if (request.getAttribute("yourOrder") != null) {
			Order order = (Order) request.getAttribute("yourOrder");
		
	%>
	<div>
		<label>Item Name:</label><%= order.getItemName() %>
		<label>Order Status:</label><%= order.getOrderStatus() %>	
	</div>
	<%
		} else{
	%>
	<h1> We Can't Serve You Sorry</h1>
	<%
		}
	%>
</body>
</html>