package org.example.adoptionsb.Controller;

import org.example.adoptionsb.Classes.Adopter;
import org.example.adoptionsb.Service.AdoptionRepoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@Transactional
@Tag("mvc")
class AdopterControllerTest {

    @Autowired
    @Qualifier("adoptionRepoService")
    private AdoptionRepoService studentService;
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .build();
    }

    @Test
    void addAdopter() throws Exception {
        Adopter adopter = new Adopter();
        adopter.setAdopterName("Angel Test");
        adopter.setAdopterPhoneNumber("8492561485");
        adopter.setAdoptionDate(null);
        ResultActions actions = mockMvc
                .perform(post("/adopter", adopter)
                        .accept(MediaType.APPLICATION_JSON));
        actions = actions.andExpect(status().is(400));

        MvcResult mvcr = actions.andReturn();

        String reo = (String) mvcr.getResponse().getContentAsString();
        System.out.println(reo);
    }

    @Test
    void deleteAdopter() throws Exception {
        int id = 1;
        ResultActions actions = mockMvc
                .perform(post("/adopter/{studentId}", id)
                        .accept(MediaType.APPLICATION_JSON));

        actions = actions.andExpect(status().is(405));

        MvcResult mvcr = actions.andReturn();

        String reo = (String) mvcr.getResponse().getContentAsString();
    }

    @Test
    void updateAdopter() throws Exception {
        Adopter newAdopter = new Adopter();
        newAdopter.setIdAdopter(1);
        newAdopter.setAdopterName("Angel");
        ResultActions actions = mockMvc
                .perform(put("/adopter", newAdopter)
                        .accept(MediaType.APPLICATION_JSON));

        actions = actions.andExpect(status().is(400));

        MvcResult mvcr = actions.andReturn();

        String reo = (String) mvcr.getResponse().getContentAsString();
    }

    @Test
    void findById() throws Exception {
        ResultActions actions = mockMvc
                .perform(get("/adopter/1").accept(MediaType.APPLICATION_JSON));

        actions = actions.andExpect(content().contentType(MediaType.APPLICATION_JSON));

        actions = actions.andExpect(status().isOk());

        MvcResult mvcr = actions.andReturn();
        String reo = (String) mvcr.getResponse().getContentAsString();
        System.out.println("Adopter is " + reo);
    }

    @Test
    void getAllAdopters() throws Exception {
        ResultActions actions = mockMvc
                .perform(get("/adopter").accept(MediaType.APPLICATION_JSON));

        actions = actions.andExpect(content().contentType(MediaType.APPLICATION_JSON));

        actions = actions.andExpect(status().isOk());

        MvcResult mvcr = actions.andReturn();
        String reo = (String) mvcr.getResponse().getContentAsString();
        System.out.println("Adopters " + reo);
    }

    @Test
    void getAdoptersByName() throws Exception {
        ResultActions actions = mockMvc
                .perform(get("/adopter/byname/Angel").accept(MediaType.APPLICATION_JSON));

        actions = actions.andExpect(content().contentType(MediaType.APPLICATION_JSON));

        actions = actions.andExpect(status().isOk());

        MvcResult mvcr = actions.andReturn();
        String reo = (String) mvcr.getResponse().getContentAsString();
        System.out.println("Adopter is " + reo);
    }
}