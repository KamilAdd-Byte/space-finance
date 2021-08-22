package com.spacefinance.spacefinance.service.impl;

import com.spacefinance.spacefinance.enums.TypeCarExpenses;
import com.spacefinance.spacefinance.model.CarExpenses;
import com.spacefinance.spacefinance.repository.CarExpensesDao;
import com.spacefinance.spacefinance.service.CarExpensesService;
import org.junit.jupiter.api.*;
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

    @Test
    @DisplayName("should remove a car expenses")
    void shouldRemoveCarExpensesOnMongoDb(){
        //given
        CarExpenses newCarExpenses = createNewCarExpenses();

        //when
        carExpensesService.addCarsExpenses(newCarExpenses);
        String id = newCarExpenses.getId();
        carExpensesService.removeCarsExpenses(id);

        //then
        Assertions.assertThrows(Exception.class,() -> carExpensesService.removeCarsExpenses(id));
        assertThrows(Exception.class,() -> carExpensesService.removeCarsExpenses(id));
    }

    @Test
    @DisplayName("should added car expenses on Kamil user is true")
    void shouldAddedCarExpensesOnKamilUser(){
        //given
        CarExpenses newCarExpenses = createNewCarExpenses();
        //when
        carExpensesService.addCarsExpenses(newCarExpenses);
        //then
        assertThat(newCarExpenses.getUser()).as("User expected Kamil").isEqualTo("KAMIL");
    }

    @Test
    @DisplayName("should update one car expenses on database mongo")
    void shouldUpdateCarExpenses(){
        //given
        CarExpenses newCarExpenses = createNewCarExpenses();
        carExpensesService.addCarsExpenses(newCarExpenses);

        String newCarExpensesId = newCarExpenses.getId();

        //when
        CarExpenses updateCarExpensesId = carExpensesService.findCarExpensesById(newCarExpensesId);
        updateCarExpensesId.setPrice(10.99);
        updateCarExpensesId.setUser("KASIA");

        //then
        assertThat(newCarExpenses.getId()).isEqualTo(updateCarExpensesId.getId());

        assertEquals(updateCarExpensesId.getUser(),"KASIA");
        assertEquals(10.99,updateCarExpensesId.getPrice());
        assertNotSame(newCarExpenses,updateCarExpensesId);
    }

    private CarExpenses createNewCarExpenses() {
        CarExpenses carExpenses = new CarExpenses();
        carExpenses.setTypeCarExpenses(TypeCarExpenses.MECHANIC);
        carExpenses.setUser("KAMIL");
        carExpenses.setPrice(44);
        carExpenses.setDate(LocalDate.now());
        return carExpenses;
    }
}
