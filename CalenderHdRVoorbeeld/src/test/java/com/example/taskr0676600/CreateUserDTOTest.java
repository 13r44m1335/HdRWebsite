package com.example.taskr0676600;

import com.example.taskr0676600.dto.CreateUserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CreateUserDTOTest {
    @Test
    void testSubTaskDTOSetters(){
        CreateUserDTO s = new CreateUserDTO();
        s.setUserRole("Admin");
        s.setPassword("test");
        s.setUsername("a");


        assertNotNull(s);
        assertEquals("Admin",s.getUserRole());
        assertEquals("test",s.getPassword());
        assertEquals("a",s.getUsername());

    }
}
