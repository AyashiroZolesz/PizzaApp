package org.example.pizzaapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.pizzaapp.model.Pizza;
import org.example.pizzaapp.model.Topping;

import java.io.IOException;
import java.util.ArrayList;

public class ManageToppings extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // If available toppings are not set yet in the application scope then do it now
        if (getServletContext().getAttribute("availableToppings") == null) {
            ArrayList<Topping> toppings = new ArrayList<>();
            toppings.add(new Topping("mushrooms", 100));
            toppings.add(new Topping("tomatoes", 150));
            toppings.add(new Topping("beans", 150));
            toppings.add(new Topping("broccoli", 200));
            toppings.add(new Topping("corn", 100));
            toppings.add(new Topping("cheddar cheese", 300));
            toppings.add(new Topping("mozzarella cheese", 200));
            toppings.add(new Topping("parmesan cheese", 300));

            getServletContext().setAttribute("availableToppings", toppings);
        }

        Pizza pizza = (Pizza)request.getSession().getAttribute("pizza");
        ArrayList<Topping> toppings = (ArrayList<Topping>)getServletContext().getAttribute("availableToppings");
        // A topping has to be added to the pizza
        if (request.getParameter("add") != null) {
            Topping t = toppings.stream()
                    .filter(topping -> topping.getName().equals(request.getParameter("add")))
                    .findFirst().orElse(null);
            if (t != null) {
                pizza.addTopping(t);
                request.setAttribute("message", "Topping added.");
            }
        }
        // A topping has to be removed from the pizza
        if (request.getParameter("remove") != null) {
            Topping t = toppings.stream()
                    .filter(topping -> topping.getName().equals(request.getParameter("remove")))
                    .findFirst().orElse(null);
            if (t != null) {
                pizza.removeTopping(t);
                request.setAttribute("message", "Topping removed.");
            }
        }
        // Forward to the creator page
        request.getRequestDispatcher("PizzaCreator.jsp").forward(request,response);
    }

}
