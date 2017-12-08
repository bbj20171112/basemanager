package com.bbj.test.base.rtnobj;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration("application.xml")
public class CrudTests {

        @Autowired
        private WebApplicationContext wac;

        private MockMvc mockMvc;

        @Before
        public void setup() {
                this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        }

        @Test
        public void getAccount() throws Exception {
//        	mockMvc = standaloneSetup(new ResponceController())
//                    .defaultRequest(get("/").accept(MediaType.APPLICATION_JSON))
//                    .alwaysExpect(status().isOk())
//                    .alwaysExpect(content().contentType("application/json;charset=UTF-8"))
//                    .build();
                
        }

}
