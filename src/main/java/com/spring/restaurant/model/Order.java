package com.spring.restaurant.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends CategoryOrder {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "orderId")
//    private Long id;
//    @Column(name = "orderName")
//    private String orderName;

    @Column(name = "price")
    private String orderPrice;
    @Column(name = "image")
    private String img;
    @Column(name = "description")
//    @Lob()
    private String description;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;
}
