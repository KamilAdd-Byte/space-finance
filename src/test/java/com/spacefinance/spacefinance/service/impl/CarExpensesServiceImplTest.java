package com.spacefinance.spacefinance.service.impl;

import com.spacefinance.spacefinance.enums.TypeCarExpenses;
import com.spacefinance.spacefinance.model.CarExpenses;
import com.spacefinance.spacefinance.repository.CarExpensesDao;
import com.spacefinance.spacefinance.service.CarExpensesService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import java.time.LocalDate;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarExpensesServiceImplTest {

    @Autowired
    private CarExpensesService carExpensesService;

    @Autowired
    private CarExpensesDao carRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    void setUp() {
        carRepository.deleteAll();
    }

    @AfterEach
    void cleanUp() {
        carRepository.deleteAll();
    }
    @Test
    @DisplayName("should add new car expenses for user Kamil")
    void shouldSaveNewCarExpensesOnMongoDBForUserKamil() {
        //given
        CarExpenses newCarExpenses = createNewCarExpenses();

        //when
        carExpensesService.addCarsExpenses(newCarExpenses);

        //then
        assertNotNull(newCarExpenses);
        assertThat(newCarExpenses.getTypeCarExpenses()).isEqualTo(TypeCarExpenses.MECHANIC);
        assertThat(newCarExpenses.getUser()).isEqualTo("KAMIL");
        assertThat(newCarExpenses.getPrice()).as("Price").isEqualTo(44);
    }

    private CarExpenses createNewCarExpenses() {
        CarExpenses carExpenses = new CarExpenses();
        carExpenses.setTypeCarExpenses(TypeCarExpenses.MECHANIC);
        carExpenses.setUser("KAMIL");
        carExpenses.setPrice(44);
        carExpenses.setDate(LocalDate.now());
        return carExpenses;
    }

    // TODO: 14.08.2021 Create more test! 
}
