package com.example.iti0302backend.dto;

import org.junit.jupiter.api.Test;
import java.util.Date;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class ActivitySuggestionsDTOTest {

    @Test
    void getActivity_correctActivity() {
        ActivitySuggestionsDTO dto = new ActivitySuggestionsDTO();
        dto.setActivity("buy");
        var result = dto.getActivity();
        assertEquals("buy", result);
    }
}
