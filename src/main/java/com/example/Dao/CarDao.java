package com.example.Dao;


import com.example.model.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Component
@RequiredArgsConstructor

public class CarDao {


    private final JdbcTemplate jdbcTemplate;


    private List<Car> allCars() {

        String sql = "Select * from car";

        return (List<Car>) jdbcTemplate.query(sql, (resulset, row) ->
                Car.builder()
                        .id(resulset.getInt(1))
                        .name(resulset.getString(2))
                        .brand_id(Integer.valueOf(resulset.getString(3)))
                        .build());
    }
}


