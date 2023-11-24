package com.spring.restaurant.service;

import com.spring.restaurant.dao.OrderRepository;
import com.spring.restaurant.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> allOrder (){
        return orderRepository.findAll();
    }

    public Order getOrderById (Long id){
        return orderRepository.findById(id).get();
    }
    public List<Order> getOrdersByCategoryId (Long id){
        return orderRepository.findByCategoryId(id);
    }
    public List<Order> getOrderByNameContaining (String name){
        return orderRepository.findByNameContaining(name);
    }

}
