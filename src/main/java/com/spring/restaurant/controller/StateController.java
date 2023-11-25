package com.spring.restaurant.controller;

import com.spring.restaurant.model.State;
import com.spring.restaurant.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class StateController {
    private StateService stateService;
    @Autowired
    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

//    http://localhost:8080/api/states
    @GetMapping("/states")
    public List<State> getAllState(){
        return stateService.getAllState();
    }

    //    http://localhost:8080/api/statescode?id={value}
    @GetMapping("/statescode")
    public List<State> getStateByCountryId(@RequestParam Long id){
        return stateService.getStateByCountryId(id);
    }

//    //    http://localhost:8080/api/statescodee?code={value}
//    @GetMapping("/statescodee")
//    public Collection<State> getStateByCountryCode(@RequestParam String code){
//        return stateService.getStateByCountryCode(code);
//    }
}
