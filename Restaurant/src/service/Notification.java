package service;

import model.Hall;
import model.Order;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/notification")
public class Notification extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String date = request.getParameter("date");
        String personAmount = request.getParameter("person_amount");
        String specialOccasion = ("Special occasion".equals(request.getParameter("special_occasion"))) ? "Yes" : "No";
        String separateRoom = ("Separate room".equals(request.getParameter("separate_room"))) ? "Yes" : "No";
        String hall = request.getParameter("hall");
        String message = request.getParameter("message");

        User user = new User(name, surname, email, phone);
        Order order = new Order(user, date, Integer.valueOf(personAmount), specialOccasion, separateRoom, Hall.valueOf(hall.toUpperCase()), message);

        PrintWriter writer = response.getWriter();

        if (order.checkFreeDate()) {
            Mail.sendMail(order);
            writer.println(AdditionalInfo.getSuccessResponse(order));
        } else {
            writer.println(AdditionalInfo.getFailureResponse());
        }
    }
}
