package com.spacefinance.spacefinance.service.impl;

import com.spacefinance.spacefinance.shopspace.type.ShopName;
import com.spacefinance.spacefinance.shopspace.Paragon;
import com.spacefinance.spacefinance.shopspace.repository.ParagonDao;
import com.spacefinance.spacefinance.shopspace.service.ParagonService;
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
    private ParagonDao paragonRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    void setUp() {
        paragonRepository.deleteAll();
    }

    @AfterEach
    void cleanUp() {
        paragonRepository.deleteAll();
    }

    @Test
    @DisplayName("should add paragon and check price and shop type model")
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
    @DisplayName("should remove one paragon on database mongo")
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

    @Test
    @DisplayName("should update one paragon on database mongo")
    void shouldUpdateParagon(){
        //given
        Paragon newParagon = createNewParagon();
        paragonService.saveParagon(newParagon);
        String newParagonId = newParagon.getId();

        //when
        Paragon updateParagon = paragonService.updateParagon(newParagonId);
        updateParagon.setUser("KASIA");
        updateParagon.setShopName(ShopName.INNY);
        updateParagon.setPrice(40.9);

        //then
        assertThat(newParagon.getId()).isEqualTo(updateParagon.getId());

        assertEquals(updateParagon.getUser(),"KASIA");
        assertEquals(40.9,updateParagon.getPrice());
        assertNotSame(newParagon,updateParagon);
    }
}
