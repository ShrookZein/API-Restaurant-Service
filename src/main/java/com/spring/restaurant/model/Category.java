package com.spring.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GeneratedColumn;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category extends PublicData{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "categoryId")
//    private Long id;
//    @Column(name = "categoryName")
//    private String categoryName;

    @Column(name="categorylogo")
    private String logo;
    @JsonIgnore
    @OneToMany(mappedBy="category")
    private Set<Order> orders;

}
