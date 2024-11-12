package org.example.pizzaapp.controller;
import org.example.pizzaapp.model.Pizza;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class NewOrder {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Create the pizza and add it to the session scope
        int size = Integer.parseInt(request.getParameter("size"));
        Pizza newpizza = new Pizza(size);
        request.getSession().setAttribute("pizza", newpizza);

        // Forward the request to the toppings manager (in case available toppings list is not created yet)
        request.getRequestDispatcher("ManageToppings").forward(request, response);
    }

}
