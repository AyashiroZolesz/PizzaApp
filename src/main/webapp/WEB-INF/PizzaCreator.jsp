<%@ page import="java.util.ArrayList" %>
<%@ page import="org.example.pizzaapp.model.Topping" %>
<%@ page import="org.example.pizzaapp.model.Pizza" %><%--
  Created by IntelliJ IDEA.
  User: Zoltán
  Date: 2024. 11. 12.
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pizza Creator</title>
</head>
<body>
<h1>Choose your toppings!</h1>
<%
    ArrayList<Topping> toppings = (ArrayList<Topping>)application.getAttribute("availableToppings");
    Pizza pizza = (Pizza)session.getAttribute("pizza");
%>
<p>Available Toppings</p>
<table border="1">
    <% for (Topping topping : toppings) {%>
    <tr>
        <td><%=topping.getName()%></td>
        <td><%=topping.getPrice()%></td>
        <td> <a href="ManageToppings?add=<%=topping.getName()%>">Add></a> </td>
    </tr>
    <% } %>
</table>
<%
    if (request.getAttribute("message")!=null) {
%>
<p style="font-weight: bold"><%=request.getAttribute("message")%></p>
<% }  %>
<p>Selected Toppings</p>
<table border="1">
    <% for (Topping topping : pizza.getToppings()) { %>
    <tr>
        <td><%=topping.getName() %></td>
        <td><%=topping.getPrice() %> HUF</td>
        <td><a href="ManageToppings?remove=<%=topping.getName()%>">Remove</a></td>
    </tr>
    <% } %>
    <p>Total Price: <%=pizza.totalPrice() %> HUF</p>
    <h2>Finalize your order</h2>
    <form action="Summary.jsp" method="post">
        Name: <input type="text" name="name"><br/>
        Address: <input type="text" name="address"><br/>
        <input type="submit" value="Order"/>
    </form>
</table>
</body>
</html>
