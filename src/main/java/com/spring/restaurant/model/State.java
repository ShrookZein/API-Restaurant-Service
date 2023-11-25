package com.spring.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "state")
public class State extends PublicData{
    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonIgnore
    private Country  country;
}
