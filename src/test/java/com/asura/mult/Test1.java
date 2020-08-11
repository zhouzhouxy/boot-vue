package com.asura.mult;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author asura
 * @version 1.0.0
 * @date 2020/8/9/009 14:29
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Test1 {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;
}
