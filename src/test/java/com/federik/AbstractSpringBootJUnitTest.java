package com.federik;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
@ActiveProfiles("test")
@WebAppConfiguration
@TestPropertySource({
        "classpath:/application.properties",
        "classpath:/application.yml",
        "classpath:/application-dev.yml"
})
public class AbstractSpringBootJUnitTest {

    @Test
    public void test(){
        System.out.println("dadsada");
    }
}
