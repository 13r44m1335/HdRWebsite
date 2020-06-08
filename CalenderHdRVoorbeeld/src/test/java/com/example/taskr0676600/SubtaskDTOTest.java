package com.example.taskr0676600;

import com.example.taskr0676600.domain.model.Subtask;
import com.example.taskr0676600.dto.SubtaskDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class SubtaskDTOTest {
    @Test
    void testSubTaskDTOSetters(){
        SubtaskDTO s = new SubtaskDTO();
        s.setTitle("test");
        s.setDescription("test");
        s.setId(6);


        assertNotNull(s);
        assertEquals("test",s.getTitle());
        assertEquals("test",s.getDescription());
        assertEquals(6,s.getId());

    }

}
