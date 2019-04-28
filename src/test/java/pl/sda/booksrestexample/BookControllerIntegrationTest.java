package pl.sda.booksrestexample;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest     // adnotacja oznacz, że test zarządzany jest przes Springa
@AutoConfigureMockMvc   // konfiguruje nasz obiekt MockMvc dzięki, któremu możmy wykonywac zapytania
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)   //czyści naszą bazę za każdym razem i
                                                                                // uruchamia od nowa (izoluje nasze testy)
public class BookControllerIntegrationTest {

    @Autowired      // wszyknięcie zależności
    private MockMvc mockMvc;

    @DisplayName("gdy wywołanie GET na /books, to zwróć pustą tablicę, " +
            "gdy nie ma żadnych ksiązęk  w bazie danych")
    @Test
    void test1() throws Exception {
        // when
        mockMvc.perform(get("/books"))              // test wykonuje zapytanie GET na adres "/books"

        //then
        .andExpect(status().isOk())                           // sprawdzamy czy status odpowiedzi jest OK czyli równy 200
        .andExpect(content().string("[]"));     // oraz czy zwraca nam pustą tablice
    }
}
