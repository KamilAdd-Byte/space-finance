package com.spacefinance.spacefinance.service.impl;

import com.spacefinance.spacefinance.enums.ShopName;
import com.spacefinance.spacefinance.enums.TypeCarExpenses;
import com.spacefinance.spacefinance.model.CarExpenses;
import com.spacefinance.spacefinance.model.Paragon;
import com.spacefinance.spacefinance.repository.CarExpensesDao;
import com.spacefinance.spacefinance.repository.ParagonDao;
import com.spacefinance.spacefinance.service.CarExpensesService;
import com.spacefinance.spacefinance.service.FinanceModel;
import com.spacefinance.spacefinance.service.ParagonService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDate;
import java.time.Month;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FinanceModelReportTest {

    @Autowired
    private ParagonService paragonService;

    @Autowired
    private CarExpensesService carExpensesService;

    @Autowired
    private ParagonDao paragonRepository;

    @Autowired
    private CarExpensesDao carRepository;

    @Autowired
    private FinanceModel financeModel;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    void setUp() {
        paragonRepository.deleteAll();
        carRepository.deleteAll();
    }

    @AfterEach
    void cleanUp() {
        paragonRepository.deleteAll();
        carRepository.deleteAll();
    }

    @Test
    @DisplayName("should size all operations in application added by users")
    void shouldSizeAllOperationForUsers(){
        //given
        Paragon newParagon = createNewParagon();
        paragonService.saveParagon(newParagon);

        CarExpenses newCarExpenses = createNewCarExpenses();
        carExpensesService.addCarsExpenses(newCarExpenses);

        //when
        int sizeListAllOperation = financeModel.sizeListAllOperation();

        //then
        assertThat(sizeListAllOperation).isNotNull();
        assertThat(sizeListAllOperation).isEqualTo(2);
    }

    @Test
    @DisplayName("should size all operations in application added by users with remove one operation")
    void shouldSizeAllOperationsForUsersWithRemoveOneOperation(){
        //given
        Paragon newParagon = createNewParagon();
        paragonService.saveParagon(newParagon);

        CarExpenses newCarExpenses = createNewCarExpenses();
        carExpensesService.addCarsExpenses(newCarExpenses);

        //when
        int sizeListAllOperation = financeModel.sizeListAllOperation();
        String paragonId = newParagon.getId();
        paragonService.removeParagon(paragonId);

        sizeListAllOperation = financeModel.sizeListAllOperation();

        //then
        assertThat(sizeListAllOperation).isEqualTo(1);
    }

    @Test
    @DisplayName("should all expenditure price for all operation couple")
    void shouldAllExpenditurePriceForAllOperationTwoUsers(){
        //given
        Paragon newParagon = createNewParagon();
        paragonService.saveParagon(newParagon);
        CarExpenses newCarExpenses = createNewCarExpenses();
        carExpensesService.addCarsExpenses(newCarExpenses);
        //when
        double allExpenditure = financeModel.allExpenditure();

        //then
        assertThat(allExpenditure).isNotNull();
        assertThat(allExpenditure).as("This price all expenses").isEqualTo(564);
    }

    @Test
    @DisplayName("should total expenses for one user - Kamil")
    void allExpensesUserKamil() {
        //given
        Paragon newParagon = createNewParagon();
        paragonService.saveParagon(newParagon);

        //when
        double allExpensesUserKamil = financeModel.allExpensesUserKamil();

        //then
        assertThat(allExpensesUserKamil).isNotNull();
        assertThat(allExpensesUserKamil).as("Total price for user Kamil").isEqualTo(543.5);
    }

    private CarExpenses createNewCarExpenses() {
        CarExpenses carExpenses = new CarExpenses();
        carExpenses.setTypeCarExpenses(TypeCarExpenses.MECHANIC);
        carExpenses.setUser("Kasia");
        carExpenses.setDate(LocalDate.now());
        carExpenses.setPrice(20.5);
        return carExpenses;
    }

    private Paragon createNewParagon() {
        Paragon newParagon = new Paragon();
        newParagon.setPrice(543.5);
        newParagon.setShopName(ShopName.BIEDRONKA);
        newParagon.setDate(Month.APRIL);
        newParagon.setUser("KAMIL");
        return newParagon;
    }
}
