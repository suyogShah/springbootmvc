package com.example.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;

import EmployeeResponse.response;
import controller.EmployeeInterface;
import controller.EmployeeService;
import model.Employee;

@SpringBootTest
class CoronavirusApplicationTests {
	
	
	
	private static final String TRUE = null;

    @Autowired
	private MockMvc mvc;
    
    
   @MockBean
   EmployeeInterface intr;
   
   @MockBean
   EmployeeService service;
    
   
  
	      
    
    @BeforeEach                           
    void setUp() {                               
                      
    	
 
    }


	@Test
	public void GetEmployeeTest() throws Exception
	{
		List<Employee> ALL_CATEGORIES = Arrays.asList(
                new Employee(1, "Funny","wo"),
                new Employee(2, "JoyFul","wo")
        );
		
		Mockito.when(intr.getallemployee()).thenReturn((response) ALL_CATEGORIES);

        mvc.perform(get("api/v1/customer"))
                //.andExpect((MockMvcResultMatchers.model()).attribute("categories",ALL_CATEGORIES));
                .andExpect(MockMvcResultMatchers.view().name("employees"));
		

		
		

		
		
	}
}
