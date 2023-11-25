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
    //    http://localhost:8080/api/allOrder?page={value}&size={value}
    @GetMapping("/allOrder")
    public List<Order> allOrder(@RequestParam int page,@RequestParam int size){

        return orderService.allOrder(page,size);
    }

    //    http://localhost:8080/api/category?id={value}&page={value}&size={value}
    @GetMapping("/category")
    public List<Order> getOrdersByCategoryId(@RequestParam Long id,@RequestParam int page,@RequestParam int size){
        return orderService.getOrdersByCategoryId(id,page,size);
    }

    //    http://localhost:8080/api/category/5?page={value}&size={value}
    @GetMapping("/category/{id}")
    public List<Order> ggetOrdersByCategoryId(@PathVariable Long id,@RequestParam int page,@RequestParam int size){
        return orderService.getOrdersByCategoryId(id,page,size);
    }

    //    http://localhost:8080/api/orderkey?name={value}&page={value}&size={value}
    @GetMapping("/orderkey")
    public List<Order> getOrderByKey(@RequestParam String name,@RequestParam int page,@RequestParam int size){
        return orderService.getOrderByNameContaining(name,page,size);
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

    //    http://localhost:8080/api/orderSize
    @GetMapping("/orderSize")
    public long getAllOrderSize(){
        return orderService.getAllOrderSize();
    }

    //    http://localhost:8080/api/orderSizeByCatId/{id}
    @GetMapping("/orderSizeByCatId/{id}")
    public int getSizeOfOrdersByCategoryId(@PathVariable Long id){
        return orderService.getSizeOfOrdersByCategoryId(id);
    }

    //    http://localhost:8080/api/categoryidsize?id={value}
    @GetMapping("/categoryidsize")
    public long getOrderLengthByCategoryId(@RequestParam Long id){
        return orderService.getOrderLengthByCategoryId(id);
    }

    //    http://localhost:8080/api/keysize?key={value}
    @GetMapping("/keysize")
    public long getOrderSizeByKey(@RequestParam String key){
        return orderService.getOrderSizeByKey(key);
    }
}
