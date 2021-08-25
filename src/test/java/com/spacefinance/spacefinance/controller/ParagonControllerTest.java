package com.spacefinance.spacefinance.controller;

import com.spacefinance.spacefinance.enums.ShopName;
import com.spacefinance.spacefinance.model.Paragon;
import com.spacefinance.spacefinance.repository.ParagonDao;
import com.spacefinance.spacefinance.service.ParagonService;
import com.spacefinance.spacefinance.service.impl.ParagonServiceImpl;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
