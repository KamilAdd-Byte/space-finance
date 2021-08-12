package com.spacefinance.spacefinance.service.impl;

import com.spacefinance.spacefinance.enums.ShopName;
import com.spacefinance.spacefinance.model.Paragon;
import com.spacefinance.spacefinance.service.ParagonService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.Month;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParagonServiceImplTest {

    @Autowired
    private ParagonService paragonService;

    @BeforeEach
    void setUp() {

    }

    @AfterAll
    static void afterAll() {

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
        assertThat(newParagon.getPrice()).as("Price").isEqualTo(22.2);

    }

    private Paragon createNewParagon() {
        Paragon newParagon = new Paragon();
        newParagon.setPrice(22.2);
        newParagon.setShopName(ShopName.BIEDRONKA);
        newParagon.setUser("KASIA");
        newParagon.setDate(Month.APRIL);
        newParagon.setId("Id-object-22233432");
        return newParagon;
    }

    @Test
    void removeParagon() {
    }

    @Test
    void findById() {
    }

    @Test
    void updateParagon() {
    }

    @Test
    void sizeParagon() {
    }

    @Test
    void getSumAllParagon() {
    }
}
