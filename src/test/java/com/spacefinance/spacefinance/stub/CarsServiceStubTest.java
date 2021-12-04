package com.spacefinance.spacefinance.stub;

import com.spacefinance.spacefinance.carspace.cars.Car;
import com.spacefinance.spacefinance.carspace.cars.repository.stub.CarsServiceStub;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

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
