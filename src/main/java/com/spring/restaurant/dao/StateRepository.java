package com.spring.restaurant.dao;

import com.spring.restaurant.model.State;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State,Long> {
    public List<State>findByCountryId(Long id);
//    @Query("select * from State where country.code= EG")
//    @Query("select * from State where country.code = ?1")
//    public List<State> findByCountryCode(String Code);

}
