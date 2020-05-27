package test;

import model.Hall;
import model.Order;
import model.User;
import org.junit.Assert;
import org.junit.Test;

public class OrderTest {
    User simpleUser = new User("Pavlo", "Rolson", "pavlo.rolson@gmail.com", "0991234567");
    User vipUser = new User("Ivan", "Petrenko", "ivan.petrenko@gmail.com", "0971111111");

    Order order = new Order(simpleUser, "2020-05-06", Integer.valueOf(10), "Yes", "Yes", Hall.TERRACE, "no addition");
    Order vipOrder = new Order(vipUser, "2020-05-07", Integer.valueOf(10), "Yes", "Yes", Hall.TERRACE, "no addition");

    @Test
    public void testCalculatePrice() {
        Assert.assertTrue(order.calculatePrice() == 333.2);
        Assert.assertTrue(vipOrder.calculatePrice() == 306.0);
    }

    @Test
    public void testCheckFreeDate() {
        Assert.assertTrue(order.checkFreeDate() == false);
        Assert.assertTrue(vipOrder.checkFreeDate() == true);
    }
}
