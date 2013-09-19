<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="com.learning.domain.Apartment" import="java.util.*" import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>	Apartment Listings</title>
<%
	List<Apartment> apartments = (List<Apartment>)(request.getAttribute("apartmentListings"));

%>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Apartment Number</th>
				<th>Room</th>
				<th>Bedrooms</th>
				<th>Rent</th>
				<th>Availability</th>
			</tr>
		</thead>
		<tbody>
			<% for(Apartment apartment : apartments){ %>
			<tr>
				<td><%= apartment.getApartmentNumber() %>
				<td><%= apartment.getRoomNumber() %></td>
				<td><%= apartment.getNumberOfBedRooms() %></td>
				<td><%= apartment.getRent() %></td>
				<td><%= apartment.isAvailable() %></td>
			</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>