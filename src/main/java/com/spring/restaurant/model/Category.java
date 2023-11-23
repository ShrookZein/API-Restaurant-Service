package com.spring.restaurant.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GeneratedColumn;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category extends CategoryOrder{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "categoryId")
//    private Long id;
//    @Column(name = "categoryName")
//    private String categoryName;

    @OneToMany(mappedBy="category")
    private List<Order> orders=new ArrayList<>();

}
