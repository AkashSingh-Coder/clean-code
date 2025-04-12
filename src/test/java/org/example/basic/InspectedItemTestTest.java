package org.example.basic;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class InspectedItemTestTest {

    @Test
    void isEdible() {
        InspectedItemTest itemTest=new InspectedItemTest(LocalDate.now().plusDays(5),true,101);
        assertTrue(itemTest.isEdible());
    }
}