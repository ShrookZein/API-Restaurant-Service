package com.spring.restaurant.controller;

import com.spring.restaurant.model.Category;
import com.spring.restaurant.model.Order;
import com.spring.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class OrderController {
    private OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    //    http://localhost:8080/api/allOrder
    @GetMapping("/allOrder")
    public List<Order> allOrder(){
        return orderService.allOrder();
    }

    //    http://localhost:8080/api/category?id=
    @GetMapping("/category")
    public List<Order> getOrdersByCategoryId(@RequestParam Long id){
        return orderService.getOrdersByCategoryId(id);
    }

    //    http://localhost:8080/api/category/5
    @GetMapping("/category/{id}")
    public List<Order> ggetOrdersByCategoryId(@PathVariable Long id){
        return orderService.getOrdersByCategoryId(id);
    }

    //    http://localhost:8080/api/orderkey?name=
    @GetMapping("/orderkey")
    public List<Order> getOrderByKey(@RequestParam String name){
        return orderService.getOrderByNameContaining(name);
    }

    //    http://localhost:8080/api/order?id={value}
    @GetMapping("/order")
    public Order getOrderById(@RequestParam Long id){
        return orderService.getOrderById(id);
    }

    //    http://localhost:8080/api/order/{id}
    @GetMapping("/order/{id}")
    public Order ggetOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }
}
