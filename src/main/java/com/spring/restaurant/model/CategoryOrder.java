package com.spring.restaurant.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class CategoryOrder extends PublicData{

    @Column(name = "data_create")
    @CreationTimestamp
    private Date dataCreate;
    @Column(name = "data_update")
    @UpdateTimestamp
    private Date dataUpdate;
}
