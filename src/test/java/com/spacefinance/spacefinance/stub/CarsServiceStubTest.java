package com.spacefinance.spacefinance.stub;

import com.spacefinance.spacefinance.model.Car;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarsServiceStubTest {

    @Test
    void getAllIsAccidentalCars() {
        // add stub
        CarRepositoryStub carRepositoryStub = new CarRepositoryStub();
        CarsServiceStub carsServiceStub = new CarsServiceStub(carRepositoryStub);

        //when
        List<Car> carList = carRepositoryStub.getAllCars();
        assertThat(carList,hasSize(3));

    }
}
