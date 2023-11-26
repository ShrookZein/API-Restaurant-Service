package com.spring.restaurant.service;

import com.spring.restaurant.dao.ClientRepository;
import com.spring.restaurant.dto.PurchaseRequest;
import com.spring.restaurant.dto.PurchaseResponse;
import com.spring.restaurant.model.RequestOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
@Service
public class PurchaseServiceImp implements PurchaseService{
    private ClientRepository clientRepository;

    @Autowired
    public PurchaseServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public PurchaseResponse addRequestOrder(PurchaseRequest purchase) {
        // #1 //
        RequestOrder requestOrder=purchase.getRequestOrder();
        String myCode=getCode();
        requestOrder.setCode(myCode);
        // #2 //
        requestOrder.setItems(purchase.getItems());
        purchase.getItems().forEach(item -> item.setRequestOrder(requestOrder));

        // #3 //
        requestOrder.setFromAddress(purchase.getFromAddress());
        requestOrder.setToAddress(purchase.getToAddress());

        // #4 //
        requestOrder.setClient(purchase.getClient());
        Set<RequestOrder>requestOrders=new HashSet<>() ;
        requestOrders.add(requestOrder);
        purchase.getClient().setRequestOrders(requestOrders);
        clientRepository.save(purchase.getClient());
        return new PurchaseResponse(purchase.getClient().getName(),myCode);
    }
    public String getCode(){
        return UUID.randomUUID().toString();
    }
}
