package com.example.biblio;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.example.biblio.entity.Livre;
import com.example.biblio.repository.LivreRepository;

import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc 
@ActiveProfiles("test")
@Transactional
class LivreControllerTest {
    @Autowired MockMvc mvc;
    @Autowired LivreRepository livres;

    @Test
    void listeLesLIvresTriesParTitre() throws Exception {
        livres.save(new Livre("Zola", "A", "1111111111111", 2000));
        livres.save(new Livre("Alpha", "B", "2222222222222", 2001));

        mvc.perform(get("/api/livres"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(2))
            .andExpect(jsonPath("$[0].titre").value("Alpha"));
    }
}
