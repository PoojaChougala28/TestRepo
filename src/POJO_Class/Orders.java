package POJO_Class;

import java.util.List;

public class Orders {
    public List<Order_details> getOrders() {
        return orders;
    }

    public void setOrders(List<Order_details> orders) {
        this.orders = orders;
    }

    public List<Order_details> orders;

}
