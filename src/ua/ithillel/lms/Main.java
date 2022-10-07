package ua.ithillel.lms;

import java.util.LinkedHashMap;
import java.util.Map;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task12.coffee.order.CoffeeOrderBoard;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task12.coffee.order.Order;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task12.coffee.order.exception.InvalidOrderNumberException;

public class Main {

  public static void main(String[] args) {
    Map<Integer, Order> orders = new LinkedHashMap<>();
    orders.put(4, new Order(1, "John"));
    orders.put(3, new Order(2, "Peter"));
    orders.put(2, new Order(3, "James"));
    CoffeeOrderBoard cob = new CoffeeOrderBoard(orders);
    cob.add(new Order(4, "Linda"));
    cob.add(new Order(5, "Jane"));
    Order latestOrder = cob.deliver();
    System.out.println(latestOrder.getCustomerName() +
        ", please, come to Order board to take your coffee#" + latestOrder.getId());
    try {
      Order readyOrder = cob.deliver(4);
      System.out.println(readyOrder.getCustomerName() +
          ", please, come to Order board to take your coffee#" + readyOrder.getId());
    } catch (InvalidOrderNumberException e) {
      System.out.println(e.getMessage());
    }
    System.out.println(cob.draw());
  }
}
