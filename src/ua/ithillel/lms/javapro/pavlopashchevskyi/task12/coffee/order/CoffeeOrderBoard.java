package ua.ithillel.lms.javapro.pavlopashchevskyi.task12.coffee.order;

import java.util.Collections;
import java.util.Map;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task12.coffee.order.exception.InvalidOrderNumberException;

public class CoffeeOrderBoard {

  private final Map<Integer, Order> orders;

  private static int latestOrderNumber = 0;

  public CoffeeOrderBoard(Map<Integer, Order> orders) {
    this.orders = orders;
    latestOrderNumber = Collections.max(orders.keySet());
  }

  public int add(Order order) {
    if (order != null) {
      latestOrderNumber++;
      orders.put(latestOrderNumber, order);
    }
    return latestOrderNumber;
  }

  public Order deliver() {
    Order latestOrder = orders.remove(latestOrderNumber);
    latestOrderNumber--;
    return latestOrder;
  }

  public Order deliver(int orderNumber) throws InvalidOrderNumberException {
    if (orderNumber <= 0 || orderNumber > latestOrderNumber || !(orders.containsKey(orderNumber))) {
      throw new InvalidOrderNumberException("Invalid order number " + orderNumber +
          ". The latest order number is " + latestOrderNumber);
    }
    Order latestOrder = orders.remove(orderNumber);
    if (orderNumber == latestOrderNumber) {
      latestOrderNumber--;
    }
    return latestOrder;
  }

  public String draw() {
    StringBuilder result = new StringBuilder("=============\nNum  |  Name\n");
    for (Integer key : orders.keySet()) {
      result.append(key);
      result.append("  |  ");
      result.append(orders.get(key).getCustomerName());
      result.append("\n");
    }
    return result.toString();
  }
}
