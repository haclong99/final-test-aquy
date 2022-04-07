package vn.fis.finaltestaquy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import vn.fis.finaltestaquy.entity.Customer;
import vn.fis.finaltestaquy.service.CustomerService;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CustomerService customerService;

    @Test
    public void testCreateCustomers() throws JsonProcessingException, Exception {
        Customer newCustomer = new Customer("Dung");
        Customer saveCustomer = new Customer("Dung");

        Mockito.when(customerService.createCustomer(newCustomer)).thenReturn(saveCustomer);
        String url = "/api/v1/customer";
        mockMvc.perform(
                post(url).contentType("application/json")
                .content(objectMapper.writeValueAsString(newCustomer))
                .with(csrf())
        ).andExpect(status().isOk())
        .andExpect(content().string("1"));
    }
}
