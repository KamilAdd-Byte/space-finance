package com.spacefinance.spacefinance.service.impl;

import com.spacefinance.spacefinance.enums.ShopName;
import com.spacefinance.spacefinance.model.Paragon;
import com.spacefinance.spacefinance.service.FinanceModel;
import com.spacefinance.spacefinance.service.ParagonService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalTime;
import java.time.Month;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParagonServiceImplTest {

    @Autowired
    private ParagonService paragonService;

    @Autowired
    private FinanceModel financeModel;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void afterAll() {

    }

    @Test
    @DisplayName("should add paragon")
    void shouldSaveNewParagonOnMongoDB() {
        //given
        Paragon newParagon = createNewParagon();

        //when
        paragonService.saveParagon(newParagon);

        //then
        assertNotNull(newParagon);
        assertThat(newParagon.getShopName()).isEqualTo(ShopName.BIEDRONKA);
        assertThat(newParagon.getShopName()).isNotEqualTo(ShopName.AUCHAN);
        assertThat(newParagon.getPrice()).as("Price").isEqualTo(24.2);
    }

    private Paragon createNewParagon() {
        Paragon newParagon = new Paragon();
        newParagon.setPrice(24.2);
        newParagon.setShopName(ShopName.BIEDRONKA);
        newParagon.setUser("KASIA");
        newParagon.setDate(Month.APRIL);
        newParagon.setTime(LocalTime.now());
        return newParagon;
    }

    @Test
    @DisplayName("should remove one paragon on data base mongo")
    void shouldRemoveOneParagon() {
        //given
        Paragon newParagon = createNewParagon();

        //when
        paragonService.saveParagon(newParagon);
        String newParagonId = newParagon.getId();

        paragonService.removeParagon(newParagonId);

        //then
        Assertions.assertThrows(Exception.class,()-> paragonService.removeParagon(newParagonId));
    }

}
