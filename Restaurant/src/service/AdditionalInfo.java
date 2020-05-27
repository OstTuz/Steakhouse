package service;

import model.Order;
import model.User;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public final class AdditionalInfo {
    private static List<User> vipUsers = new ArrayList<>() {
        {
            this.add(new User("Ivan", "Petrenko", "ivan.petrenko@gmail.com", "0971111111"));
            this.add(new User("Petro", "Ivanenko", "petro.ivanenko@gmail.com", "0972222222"));
            this.add(new User("Roman", "Doriv", "roman.doriv@gmail.com", "0973333333"));
            this.add(new User("David", "Russo", "david.russo@gmail.com", "0974444444"));
        }
    };

    private static List<Date> busyDates = new ArrayList<>() {
        {
            this.add(Date.valueOf("2020-05-06"));
            this.add(Date.valueOf("2020-05-09"));
            this.add(Date.valueOf("2020-05-21"));
            this.add(Date.valueOf("2020-05-17"));
        }
    };

    public static List<User> getListOfVipUsers() {
        return vipUsers;
    }

    public static List<Date> getBusyDates() {
        return busyDates;
    }

    public static String getSuccessResponse(Order order) {
        String specialOccasion = (order.isSpecialOccasion()) ? "Yes" : "No";
        String seperateRoom = (order.isSeparateRoom()) ? "Yes" : "No";
        String vip = getListOfVipUsers().contains(order.getUser()) ? "You are VIP client, you have discount 10%" : "You are not a VIP client," +
                " please buy a gold card to become VIP.<br/>VIP clients have discount 10%";
        return "<html> <body style=\"background-image: url(photos/registr_bg1.jpg); " +
                "  background-repeat: no-repeat;\n" +
                "  background-size: 1350px 1000px;\n" +
                "  background-blend-mode:soft-light;\n" +
                "  background-attachment:scroll;\">" +
                "<h2 style=\"color: white; text-align: center; font-size: 30pt;\">Success reservation</h2>" +
                "<h4 style=\"color: white; padding-top:10px;\">Your name is: " + order.getUser().getName() + "<br/>" +
                "Your surname is: " + order.getUser().getSurname() + "<br/>" +
                "Your email is: " + order.getUser().getEmail() + "<br/>" +
                "Your phone is: " + order.getUser().getPhone() + "<br/>" +
                "Date of reservation: " + order.getDate() + "<br/>" +
                "Hall: " + order.getHall().name() + " - " + order.getHall().getPrice() + "$<br/>" +
                "Amount of people: " + order.getPersonAmount() + " (Every 5th has discount 10$)<br/>" +
                "Special occasion: " + specialOccasion + " (Discount at special occasion 2%, NOT VIP)<br/>" +
                "Separate room: " + seperateRoom + " (Separate room is more expensive in 3 times)<br/>" +
                "Additional advise: " + order.getAdditionalAdvise() + "<br/>" +
                vip + "<br></h4>" +
                "<h4 style=\"color: white; padding-top:10px;\">" +
                "--------------------------------------------------<br/>" +
                "Your price = " + order.calculatePrice() + "$<br/></h4>" +
                "<a href=\"index.html\" style=\"color: white; text-align: center; font-size: 20pt; text-decoration: none;\">Go to main</a>" +
                "</body></html>";
    }

    public static String getFailureResponse() {
        String busyDate = "";
        for (Date date : busyDates) {
            busyDate += date + "; ";
        }
        return "<html> <body style=\"background-image: url(photos/registr_bg1.jpg); " +
                "  background-repeat: no-repeat;\n" +
                "  background-size: 1350px 1000px;\n" +
                "  background-blend-mode:soft-light;\n" +
                "  background-attachment:scroll;\">" +
                "<h2 style=\"color: white; text-align: center; font-size: 30pt;\">Failure at reservation</h2>" +
                "<h4 style=\"color: white; padding-top:10px;\">We are so sorry, but this date is reserved, please choose any date except: <br/>" +
                busyDate + "</h4>" +
                "<a href=\"index.html\" style=\"color: white; text-align: center; font-size: 20pt; text-decoration: none;\">Go to main</a>" +
                "</body></html>";
    }
}
