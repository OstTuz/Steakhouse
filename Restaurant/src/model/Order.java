package model;

import service.AdditionalInfo;

import java.sql.Date;

public class Order {
    private User user;
    private Date date;
    private int personAmount;
    private boolean specialOccasion;
    private boolean separateRoom;
    private Hall hall;
    private String additionalAdvise;

    public Order(User user, String date, int personAmount, String specialOccasion, String separateRoom, Hall hall, String additionalAdvise) {
        this.user = user;
        this.date = Date.valueOf(date);
        this.personAmount = personAmount;
        this.specialOccasion = (specialOccasion.equals("Yes")) ? true : false;
        this.separateRoom = (separateRoom.equals("Yes")) ? true : false;
        this.hall = hall;
        this.additionalAdvise = additionalAdvise;
    }

    public User getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public int getPersonAmount() {
        return personAmount;
    }

    public boolean isSpecialOccasion() {
        return specialOccasion;
    }

    public boolean isSeparateRoom() {
        return separateRoom;
    }

    public Hall getHall() {
        return hall;
    }

    public String getAdditionalAdvise() {
        return additionalAdvise;
    }

    public boolean checkFreeDate() {
        if (AdditionalInfo.getBusyDates().contains(date)) return false;
        else return true;
    }

    public double calculatePrice() {
        boolean isVipUser = false;
        for (User vipUser : AdditionalInfo.getListOfVipUsers()) {
            if (vipUser.getPhone().equals(user.getPhone())) {
                isVipUser = true;
                break;
            }
        }
        double initialPrice = hall.getPrice();
        if (separateRoom) initialPrice *= 3; //окрема кімната втричі дорожча
        if (personAmount >= 5) initialPrice -= (personAmount / 5) * 10; //за кожного 5-го відвібувача знижка 10$
        if (isVipUser) {
            initialPrice *= 0.9; //vip клієнти мають 10% знижки
        } else {
            if (specialOccasion) initialPrice *= 0.98; //при святі ресторан дарує не vip клієнтам знжку 2%
        }
        return initialPrice;
    }
}
