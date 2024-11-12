<%@ page import="org.example.pizzaapp.model.Pizza" %>
<%@ page import="org.example.pizzaapp.model.Topping" %><%--
  Created by IntelliJ IDEA.
  User: Zoltán
  Date: 2024. 11. 12.
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pizza order Summary</title>
</head>
<body>
<h1>Your order</h1>
<%
    request.setCharacterEncoding("UTF-8");
    Pizza pizza = (Pizza) session.getAttribute("pizza");
    String name = request.getParameter("name");
    String address = request.getParameter("address");
%>

<table border="1">
    <tr><td colspan="2" style="font-weight: bold">Order details</td></tr>
    <tr><td>Name:</td><td><%= name %></td></tr>
    <tr><td>Address:</td><td><%= address %></td></tr>
    <tr><td>Total:</td><td><%= pizza.totalPrice() %> HUF</td></tr>

    <tr><td colspan="2" style="font-weight: bold">Selected toppings</td></tr>
    <% for (Topping topping : pizza.getToppings()) { %>
    <tr><td><%= topping.getName() %></td><td><%= topping.getPrice() %> HUF</td></tr>
    <% } %>
</table>
</body>
</html>
