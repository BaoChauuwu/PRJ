package controller;

import model.Order;
import service.OrderService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "OrderController",urlPatterns = "/orderpage")
public class OrderController extends HttpServlet {
    private OrderService OrderService = new OrderService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders = OrderService.getAll();

        // Thêm danh sách bookId vào request
        Map<Integer, Integer> bookIds = new HashMap<>(); // orderId -> bookId
        for (Order order : orders) {
            if (order.getBook() != null) {
                bookIds.put(order.getId(), order.getBook().getId());
            }
        }

        request.setAttribute("orders", orders);
        request.setAttribute("bookIds", bookIds);
        request.getRequestDispatcher("/view/order/orderpage.jsp").forward(request, response);
    }

}