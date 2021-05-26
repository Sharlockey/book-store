package com.senla.antukhevich.bookstore.service;

import com.senla.antukhevich.bookstore.entity.Order;
import com.senla.antukhevich.bookstore.repository.OrderRepository;
import com.senla.antukhevich.bookstore.status.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    public void addOrder(Order order){
        orderRepository.save(order);
    }

    public void removeOrder(Order order) {
        orderRepository.delete(order);
    }

    public Order findOrderById(Long id) {
       return orderRepository.findById(id).orElse(null);
    }

    public void completeOrder(Order order){
        order.setStatus(OrderStatus.COMPLETED);
        orderRepository.save(order);
    }

    public void cancelOrder(Order order) {
        order.setStatus(OrderStatus.CANCELED);
        orderRepository.save(order);
    }

    public void showOrders(){
        var orders = getOrders();
        for(var order: orders)
            System.out.println(order.getID()  + " " + order.getBook().getName());
    }

    public void showOrderInfo(Order order){
        System.out.println(     order.getID() + " " +
                    order.getBook().getName() + " " +
                             order.getPrice() + " " +
                         order.getOrderDate() + " " +
                                  order.getStatus());
    }

}
