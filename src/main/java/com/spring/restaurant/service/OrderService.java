package com.spring.restaurant.service;

import com.spring.restaurant.dao.OrderRepository;
import com.spring.restaurant.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> allOrder ( int page, int size){
        Pageable pageable= PageRequest.of(page,size);
        return orderRepository.findAll(pageable).getContent();
    }

    public Order getOrderById (Long id){
        return orderRepository.findById(id).get();
    }
    public List<Order> getOrdersByCategoryId (Long id, int page, int size){
        Pageable pageable= PageRequest.of(page,size);
        return orderRepository.findByCategoryId(id,pageable).getContent();
    }
    public List<Order> getOrderByNameContaining (String name, int page, int size){
        Pageable pageable= PageRequest.of(page,size);
        return orderRepository.findByNameContaining(name,pageable);
    }
    public long getAllOrderSize(){
//        return orderRepository.findAll().size(); //int
        return orderRepository.count();            //Long
    }
    public int getSizeOfOrdersByCategoryId(Long id){
//        return orderRepository.findAll().size(); //int
        return orderRepository.findByCategoryId(id).size();            //Long
    }
    public long getOrderLengthByCategoryId(Long id){
        return orderRepository.getOrderLengthByCategoryId(id);            //Long
    }

    public long getOrderSizeByKey(String name){
        return orderRepository.getOrderSizeByKey(name);            //Long
    }
}
