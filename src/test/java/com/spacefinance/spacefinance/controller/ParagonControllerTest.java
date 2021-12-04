package com.spacefinance.spacefinance.controller;

import com.spacefinance.spacefinance.shopspace.service.ParagonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.mock;

@SpringBootTest
@AutoConfigureMockMvc
class ParagonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ParagonService paragonService;

//    @Test
//    void shouldGetSingleParagonObject() throws Exception {
//
//        //given
//        Paragon paragon = new Paragon();
//        paragon.setPrice(22.3);
//        paragon.setUser("KAMIL");
//        paragon.setShopName(ShopName.GROSZEK);
//        paragon.setDate(Month.APRIL);
//
//        paragonService.saveParagon(paragon);
//        String id = paragon.getId();
//
//
//        //when
//        mockMvc.perform(get("/paragon/1"))
//                .andDo(print())
//                .andExpect(status().is(302));
//
//    }
//    @Test
//    void getAllParagonData(){
//        //given
//
//        ParagonDao paragonRepository = mock(ParagonDao.class);
//        ParagonServiceImpl paragonService = new ParagonServiceImpl(paragonRepository)
//    }

}
