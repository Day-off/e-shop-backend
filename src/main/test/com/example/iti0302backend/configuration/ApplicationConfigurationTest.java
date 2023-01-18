package com.example.iti0302backend.configuration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ApplicationConfigurationTest {

    @InjectMocks
    private ApplicationConfiguration applicationConfiguration;

    @Test
    void restTemplate_alwaysReturnsNew() {
        var result = applicationConfiguration.restTemplate();
        var result1 = applicationConfiguration.restTemplate();
        assertNotEquals(result, result1);
    }
}
