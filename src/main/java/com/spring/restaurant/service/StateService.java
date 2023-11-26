package com.spring.restaurant.service;

import com.spring.restaurant.dao.StateRepository;
import com.spring.restaurant.model.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class StateService {
    private StateRepository stateRepository;
    @Autowired
    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }
    public List<State> getAllState(){
        return stateRepository.findAll();
    }
    public List<State> getStateByCountryId(Long id){
        return stateRepository.findByCountryId(id);
    }

//    public List<State> getStateByCountryCode(String code){
//        return stateRepository.findByCountryCode(code);
//    }
}
