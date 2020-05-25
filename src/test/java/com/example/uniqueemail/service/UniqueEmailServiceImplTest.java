package com.example.uniqueemail.service;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UniqueEmailServiceImplTest {

    private static UniqueEmailCountServiceImpl uniqueEmailService;

    @BeforeAll
    public static void setUp()
    {
        uniqueEmailService = new UniqueEmailCountServiceImpl();
    }

    @Test
    public void UniqueEmailAddressesShouldReturn3()
    {
        List<String> emails = Arrays.asList("test@gmail.com", "test1@gmail.com", "test2@gmail.com");
        assertEquals(3, uniqueEmailService.countUniqueEmail(emails));
    }

    @Test
    public void UniqueEmailAddressesWithDotsShouldReturn1()
    {
        List<String> emails = Arrays.asList("test@gmail.com", "t.est@gmail.com", "te.st@gmail.com", "t.e.st@gmail.com", "t.e..st@gmail.com");
        assertEquals(1, uniqueEmailService.countUniqueEmail(emails));
    }

    @Test
    public void UniqueEmailAddressesWithPlusShouldReturn1()
    {
        List<String> emails = Arrays.asList("test+1@gmail.com", "test+123@gmail.com");
        assertEquals(1, uniqueEmailService.countUniqueEmail(emails));
    }

    @Test
    public void UniqueEmailAddressesWithPlusAndDotsShouldReturn1()
    {
        List<String> emails = Arrays.asList("test+1@gmail.com", "test+123@gmail.com", "tes.t@gmail.com");
        assertEquals(1, uniqueEmailService.countUniqueEmail(emails));
    }

    @Test
    public void CleanEmailTests()
    {
        assertEquals("test@gmail.com", uniqueEmailService.cleanEmail("test+101@gmail.com"));
        assertEquals("test@gmail.com", uniqueEmailService.cleanEmail("te......st@gmail.com"));
        assertEquals("test@gmail.com", uniqueEmailService.cleanEmail("t..es..t+101@gmail.com"));
    }

    @Test
    public void EmaillNullOrEmptyThrowsIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            uniqueEmailService.cleanEmail(null);
        });

        String expectedMessage = "Email should not be null or empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
