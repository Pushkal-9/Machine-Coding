package Daos;

import Models.Order;

import java.util.HashMap;

public class OrderDao {
    HashMap<String, Order> orderMap;

    public OrderDao() {
        this.orderMap = new HashMap<>();
    }

    public void createOrder(Order order){
        if(orderMap.containsKey(order.getCustomerId())){
            throw new RuntimeException("Order with this id already exists");
        }
        orderMap.put(order.getCustomerId(),order);
    }

    public Order getOrder(String id){
        if(orderMap.get(id)==null){
            throw new RuntimeException("No team with the name exists");
        }
        return orderMap.get(id);
    }
}
