package com.example.iti0302backend.dto;

import lombok.Data;

@Data
public class ActivitySuggestionsDTO {
    private String activity;
    private String type;
    private int participants;
    private int price;
    private String link;
    private String key;
    private int accessibility;
}
