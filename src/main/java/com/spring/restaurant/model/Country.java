package com.spring.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "country")
public class Country extends PublicData {
    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private List<State>states;
}
